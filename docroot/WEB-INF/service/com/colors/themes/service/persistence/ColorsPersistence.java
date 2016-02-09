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

import com.colors.themes.model.Colors;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the colors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author user
 * @see ColorsPersistenceImpl
 * @see ColorsUtil
 * @generated
 */
public interface ColorsPersistence extends BasePersistence<Colors> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ColorsUtil} to access the colors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

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
	public com.colors.themes.model.Colors findBycolor(long colorId,
		java.lang.String colorName, boolean status)
		throws com.colors.themes.NoSuchColorsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the colors where colorId = &#63; and colorName = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param colorId the color ID
	* @param colorName the color name
	* @param status the status
	* @return the matching colors, or <code>null</code> if a matching colors could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.colors.themes.model.Colors fetchBycolor(long colorId,
		java.lang.String colorName, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.colors.themes.model.Colors fetchBycolor(long colorId,
		java.lang.String colorName, boolean status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the colors where colorId = &#63; and colorName = &#63; and status = &#63; from the database.
	*
	* @param colorId the color ID
	* @param colorName the color name
	* @param status the status
	* @return the colors that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.colors.themes.model.Colors removeBycolor(long colorId,
		java.lang.String colorName, boolean status)
		throws com.colors.themes.NoSuchColorsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of colorses where colorId = &#63; and colorName = &#63; and status = &#63;.
	*
	* @param colorId the color ID
	* @param colorName the color name
	* @param status the status
	* @return the number of matching colorses
	* @throws SystemException if a system exception occurred
	*/
	public int countBycolor(long colorId, java.lang.String colorName,
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the colors in the entity cache if it is enabled.
	*
	* @param colors the colors
	*/
	public void cacheResult(com.colors.themes.model.Colors colors);

	/**
	* Caches the colorses in the entity cache if it is enabled.
	*
	* @param colorses the colorses
	*/
	public void cacheResult(
		java.util.List<com.colors.themes.model.Colors> colorses);

	/**
	* Creates a new colors with the primary key. Does not add the colors to the database.
	*
	* @param colorId the primary key for the new colors
	* @return the new colors
	*/
	public com.colors.themes.model.Colors create(long colorId);

	/**
	* Removes the colors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param colorId the primary key of the colors
	* @return the colors that was removed
	* @throws com.colors.themes.NoSuchColorsException if a colors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.colors.themes.model.Colors remove(long colorId)
		throws com.colors.themes.NoSuchColorsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.colors.themes.model.Colors updateImpl(
		com.colors.themes.model.Colors colors)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the colors with the primary key or throws a {@link com.colors.themes.NoSuchColorsException} if it could not be found.
	*
	* @param colorId the primary key of the colors
	* @return the colors
	* @throws com.colors.themes.NoSuchColorsException if a colors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.colors.themes.model.Colors findByPrimaryKey(long colorId)
		throws com.colors.themes.NoSuchColorsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the colors with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param colorId the primary key of the colors
	* @return the colors, or <code>null</code> if a colors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.colors.themes.model.Colors fetchByPrimaryKey(long colorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the colorses.
	*
	* @return the colorses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.colors.themes.model.Colors> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.colors.themes.model.Colors> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.colors.themes.model.Colors> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the colorses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of colorses.
	*
	* @return the number of colorses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}