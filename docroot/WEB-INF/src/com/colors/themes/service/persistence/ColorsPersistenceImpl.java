/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.colors.themes.service.persistence;

import com.colors.themes.NoSuchColorsException;
import com.colors.themes.model.Colors;
import com.colors.themes.model.impl.ColorsImpl;
import com.colors.themes.model.impl.ColorsModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the colors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author user
 * @see ColorsPersistence
 * @see ColorsUtil
 * @generated
 */
public class ColorsPersistenceImpl extends BasePersistenceImpl<Colors>
	implements ColorsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ColorsUtil} to access the colors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ColorsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsModelImpl.FINDER_CACHE_ENABLED, ColorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsModelImpl.FINDER_CACHE_ENABLED, ColorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COLOR = new FinderPath(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsModelImpl.FINDER_CACHE_ENABLED, ColorsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBycolor",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			ColorsModelImpl.COLORID_COLUMN_BITMASK |
			ColorsModelImpl.COLORNAME_COLUMN_BITMASK |
			ColorsModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLOR = new FinderPath(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycolor",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the colors where colorId = &#63; and colorName = &#63; and status = &#63; or throws a {@link com.colors.themes.NoSuchColorsException} if it could not be found.
	 *
	 * @param colorId the color ID
	 * @param colorName the color name
	 * @param status the status
	 * @return the matching colors
	 * @throws com.colors.themes.NoSuchColorsException if a matching colors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors findBycolor(long colorId, String colorName, boolean status)
		throws NoSuchColorsException, SystemException {
		Colors colors = fetchBycolor(colorId, colorName, status);

		if (colors == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("colorId=");
			msg.append(colorId);

			msg.append(", colorName=");
			msg.append(colorName);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchColorsException(msg.toString());
		}

		return colors;
	}

	/**
	 * Returns the colors where colorId = &#63; and colorName = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param colorId the color ID
	 * @param colorName the color name
	 * @param status the status
	 * @return the matching colors, or <code>null</code> if a matching colors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors fetchBycolor(long colorId, String colorName, boolean status)
		throws SystemException {
		return fetchBycolor(colorId, colorName, status, true);
	}

	/**
	 * Returns the colors where colorId = &#63; and colorName = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param colorId the color ID
	 * @param colorName the color name
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching colors, or <code>null</code> if a matching colors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors fetchBycolor(long colorId, String colorName, boolean status,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { colorId, colorName, status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COLOR,
					finderArgs, this);
		}

		if (result instanceof Colors) {
			Colors colors = (Colors)result;

			if ((colorId != colors.getColorId()) ||
					!Validator.equals(colorName, colors.getColorName()) ||
					(status != colors.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_COLORS_WHERE);

			query.append(_FINDER_COLUMN_COLOR_COLORID_2);

			boolean bindColorName = false;

			if (colorName == null) {
				query.append(_FINDER_COLUMN_COLOR_COLORNAME_1);
			}
			else if (colorName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLOR_COLORNAME_3);
			}
			else {
				bindColorName = true;

				query.append(_FINDER_COLUMN_COLOR_COLORNAME_2);
			}

			query.append(_FINDER_COLUMN_COLOR_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(colorId);

				if (bindColorName) {
					qPos.add(colorName);
				}

				qPos.add(status);

				List<Colors> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLOR,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ColorsPersistenceImpl.fetchBycolor(long, String, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Colors colors = list.get(0);

					result = colors;

					cacheResult(colors);

					if ((colors.getColorId() != colorId) ||
							(colors.getColorName() == null) ||
							!colors.getColorName().equals(colorName) ||
							(colors.getStatus() != status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLOR,
							finderArgs, colors);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLOR,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Colors)result;
		}
	}

	/**
	 * Removes the colors where colorId = &#63; and colorName = &#63; and status = &#63; from the database.
	 *
	 * @param colorId the color ID
	 * @param colorName the color name
	 * @param status the status
	 * @return the colors that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors removeBycolor(long colorId, String colorName, boolean status)
		throws NoSuchColorsException, SystemException {
		Colors colors = findBycolor(colorId, colorName, status);

		return remove(colors);
	}

	/**
	 * Returns the number of colorses where colorId = &#63; and colorName = &#63; and status = &#63;.
	 *
	 * @param colorId the color ID
	 * @param colorName the color name
	 * @param status the status
	 * @return the number of matching colorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycolor(long colorId, String colorName, boolean status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLOR;

		Object[] finderArgs = new Object[] { colorId, colorName, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COLORS_WHERE);

			query.append(_FINDER_COLUMN_COLOR_COLORID_2);

			boolean bindColorName = false;

			if (colorName == null) {
				query.append(_FINDER_COLUMN_COLOR_COLORNAME_1);
			}
			else if (colorName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLOR_COLORNAME_3);
			}
			else {
				bindColorName = true;

				query.append(_FINDER_COLUMN_COLOR_COLORNAME_2);
			}

			query.append(_FINDER_COLUMN_COLOR_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(colorId);

				if (bindColorName) {
					qPos.add(colorName);
				}

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COLOR_COLORID_2 = "colors.colorId = ? AND ";
	private static final String _FINDER_COLUMN_COLOR_COLORNAME_1 = "colors.colorName IS NULL AND ";
	private static final String _FINDER_COLUMN_COLOR_COLORNAME_2 = "colors.colorName = ? AND ";
	private static final String _FINDER_COLUMN_COLOR_COLORNAME_3 = "(colors.colorName IS NULL OR colors.colorName = '') AND ";
	private static final String _FINDER_COLUMN_COLOR_STATUS_2 = "colors.status = ?";

	public ColorsPersistenceImpl() {
		setModelClass(Colors.class);
	}

	/**
	 * Caches the colors in the entity cache if it is enabled.
	 *
	 * @param colors the colors
	 */
	@Override
	public void cacheResult(Colors colors) {
		EntityCacheUtil.putResult(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsImpl.class, colors.getPrimaryKey(), colors);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLOR,
			new Object[] {
				colors.getColorId(), colors.getColorName(), colors.getStatus()
			}, colors);

		colors.resetOriginalValues();
	}

	/**
	 * Caches the colorses in the entity cache if it is enabled.
	 *
	 * @param colorses the colorses
	 */
	@Override
	public void cacheResult(List<Colors> colorses) {
		for (Colors colors : colorses) {
			if (EntityCacheUtil.getResult(
						ColorsModelImpl.ENTITY_CACHE_ENABLED, ColorsImpl.class,
						colors.getPrimaryKey()) == null) {
				cacheResult(colors);
			}
			else {
				colors.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all colorses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ColorsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ColorsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the colors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Colors colors) {
		EntityCacheUtil.removeResult(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsImpl.class, colors.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(colors);
	}

	@Override
	public void clearCache(List<Colors> colorses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Colors colors : colorses) {
			EntityCacheUtil.removeResult(ColorsModelImpl.ENTITY_CACHE_ENABLED,
				ColorsImpl.class, colors.getPrimaryKey());

			clearUniqueFindersCache(colors);
		}
	}

	protected void cacheUniqueFindersCache(Colors colors) {
		if (colors.isNew()) {
			Object[] args = new Object[] {
					colors.getColorId(), colors.getColorName(),
					colors.getStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLOR, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLOR, args, colors);
		}
		else {
			ColorsModelImpl colorsModelImpl = (ColorsModelImpl)colors;

			if ((colorsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COLOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						colors.getColorId(), colors.getColorName(),
						colors.getStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLOR, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLOR, args,
					colors);
			}
		}
	}

	protected void clearUniqueFindersCache(Colors colors) {
		ColorsModelImpl colorsModelImpl = (ColorsModelImpl)colors;

		Object[] args = new Object[] {
				colors.getColorId(), colors.getColorName(), colors.getStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLOR, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLOR, args);

		if ((colorsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COLOR.getColumnBitmask()) != 0) {
			args = new Object[] {
					colorsModelImpl.getOriginalColorId(),
					colorsModelImpl.getOriginalColorName(),
					colorsModelImpl.getOriginalStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLOR, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLOR, args);
		}
	}

	/**
	 * Creates a new colors with the primary key. Does not add the colors to the database.
	 *
	 * @param colorId the primary key for the new colors
	 * @return the new colors
	 */
	@Override
	public Colors create(long colorId) {
		Colors colors = new ColorsImpl();

		colors.setNew(true);
		colors.setPrimaryKey(colorId);

		return colors;
	}

	/**
	 * Removes the colors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param colorId the primary key of the colors
	 * @return the colors that was removed
	 * @throws com.colors.themes.NoSuchColorsException if a colors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors remove(long colorId)
		throws NoSuchColorsException, SystemException {
		return remove((Serializable)colorId);
	}

	/**
	 * Removes the colors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the colors
	 * @return the colors that was removed
	 * @throws com.colors.themes.NoSuchColorsException if a colors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors remove(Serializable primaryKey)
		throws NoSuchColorsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Colors colors = (Colors)session.get(ColorsImpl.class, primaryKey);

			if (colors == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchColorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(colors);
		}
		catch (NoSuchColorsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Colors removeImpl(Colors colors) throws SystemException {
		colors = toUnwrappedModel(colors);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(colors)) {
				colors = (Colors)session.get(ColorsImpl.class,
						colors.getPrimaryKeyObj());
			}

			if (colors != null) {
				session.delete(colors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (colors != null) {
			clearCache(colors);
		}

		return colors;
	}

	@Override
	public Colors updateImpl(com.colors.themes.model.Colors colors)
		throws SystemException {
		colors = toUnwrappedModel(colors);

		boolean isNew = colors.isNew();

		Session session = null;

		try {
			session = openSession();

			if (colors.isNew()) {
				session.save(colors);

				colors.setNew(false);
			}
			else {
				session.merge(colors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ColorsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ColorsModelImpl.ENTITY_CACHE_ENABLED,
			ColorsImpl.class, colors.getPrimaryKey(), colors);

		clearUniqueFindersCache(colors);
		cacheUniqueFindersCache(colors);

		return colors;
	}

	protected Colors toUnwrappedModel(Colors colors) {
		if (colors instanceof ColorsImpl) {
			return colors;
		}

		ColorsImpl colorsImpl = new ColorsImpl();

		colorsImpl.setNew(colors.isNew());
		colorsImpl.setPrimaryKey(colors.getPrimaryKey());

		colorsImpl.setColorId(colors.getColorId());
		colorsImpl.setColorName(colors.getColorName());
		colorsImpl.setStatus(colors.isStatus());

		return colorsImpl;
	}

	/**
	 * Returns the colors with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the colors
	 * @return the colors
	 * @throws com.colors.themes.NoSuchColorsException if a colors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors findByPrimaryKey(Serializable primaryKey)
		throws NoSuchColorsException, SystemException {
		Colors colors = fetchByPrimaryKey(primaryKey);

		if (colors == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchColorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return colors;
	}

	/**
	 * Returns the colors with the primary key or throws a {@link com.colors.themes.NoSuchColorsException} if it could not be found.
	 *
	 * @param colorId the primary key of the colors
	 * @return the colors
	 * @throws com.colors.themes.NoSuchColorsException if a colors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors findByPrimaryKey(long colorId)
		throws NoSuchColorsException, SystemException {
		return findByPrimaryKey((Serializable)colorId);
	}

	/**
	 * Returns the colors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the colors
	 * @return the colors, or <code>null</code> if a colors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Colors colors = (Colors)EntityCacheUtil.getResult(ColorsModelImpl.ENTITY_CACHE_ENABLED,
				ColorsImpl.class, primaryKey);

		if (colors == _nullColors) {
			return null;
		}

		if (colors == null) {
			Session session = null;

			try {
				session = openSession();

				colors = (Colors)session.get(ColorsImpl.class, primaryKey);

				if (colors != null) {
					cacheResult(colors);
				}
				else {
					EntityCacheUtil.putResult(ColorsModelImpl.ENTITY_CACHE_ENABLED,
						ColorsImpl.class, primaryKey, _nullColors);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ColorsModelImpl.ENTITY_CACHE_ENABLED,
					ColorsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return colors;
	}

	/**
	 * Returns the colors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param colorId the primary key of the colors
	 * @return the colors, or <code>null</code> if a colors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Colors fetchByPrimaryKey(long colorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)colorId);
	}

	/**
	 * Returns all the colorses.
	 *
	 * @return the colorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Colors> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the colorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.colors.themes.model.impl.ColorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of colorses
	 * @param end the upper bound of the range of colorses (not inclusive)
	 * @return the range of colorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Colors> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the colorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.colors.themes.model.impl.ColorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of colorses
	 * @param end the upper bound of the range of colorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of colorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Colors> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Colors> list = (List<Colors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COLORS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COLORS;

				if (pagination) {
					sql = sql.concat(ColorsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Colors>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Colors>(list);
				}
				else {
					list = (List<Colors>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the colorses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Colors colors : findAll()) {
			remove(colors);
		}
	}

	/**
	 * Returns the number of colorses.
	 *
	 * @return the number of colorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COLORS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the colors persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.colors.themes.model.Colors")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Colors>> listenersList = new ArrayList<ModelListener<Colors>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Colors>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ColorsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COLORS = "SELECT colors FROM Colors colors";
	private static final String _SQL_SELECT_COLORS_WHERE = "SELECT colors FROM Colors colors WHERE ";
	private static final String _SQL_COUNT_COLORS = "SELECT COUNT(colors) FROM Colors colors";
	private static final String _SQL_COUNT_COLORS_WHERE = "SELECT COUNT(colors) FROM Colors colors WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "colors.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Colors exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Colors exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ColorsPersistenceImpl.class);
	private static Colors _nullColors = new ColorsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Colors> toCacheModel() {
				return _nullColorsCacheModel;
			}
		};

	private static CacheModel<Colors> _nullColorsCacheModel = new CacheModel<Colors>() {
			@Override
			public Colors toEntityModel() {
				return _nullColors;
			}
		};
}