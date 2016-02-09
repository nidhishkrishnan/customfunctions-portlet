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

package com.colors.themes.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ColorsLocalService}.
 *
 * @author user
 * @see ColorsLocalService
 * @generated
 */
public class ColorsLocalServiceWrapper implements ColorsLocalService,
	ServiceWrapper<ColorsLocalService> {
	public ColorsLocalServiceWrapper(ColorsLocalService colorsLocalService) {
		_colorsLocalService = colorsLocalService;
	}

	/**
	* Adds the colors to the database. Also notifies the appropriate model listeners.
	*
	* @param colors the colors
	* @return the colors that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.colors.themes.model.Colors addColors(
		com.colors.themes.model.Colors colors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.addColors(colors);
	}

	/**
	* Creates a new colors with the primary key. Does not add the colors to the database.
	*
	* @param colorId the primary key for the new colors
	* @return the new colors
	*/
	@Override
	public com.colors.themes.model.Colors createColors(long colorId) {
		return _colorsLocalService.createColors(colorId);
	}

	/**
	* Deletes the colors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param colorId the primary key of the colors
	* @return the colors that was removed
	* @throws PortalException if a colors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.colors.themes.model.Colors deleteColors(long colorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.deleteColors(colorId);
	}

	/**
	* Deletes the colors from the database. Also notifies the appropriate model listeners.
	*
	* @param colors the colors
	* @return the colors that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.colors.themes.model.Colors deleteColors(
		com.colors.themes.model.Colors colors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.deleteColors(colors);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _colorsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.colors.themes.model.impl.ColorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.colors.themes.model.impl.ColorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.colors.themes.model.Colors fetchColors(long colorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.fetchColors(colorId);
	}

	/**
	* Returns the colors with the primary key.
	*
	* @param colorId the primary key of the colors
	* @return the colors
	* @throws PortalException if a colors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.colors.themes.model.Colors getColors(long colorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.getColors(colorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.colors.themes.model.Colors> getColorses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.getColorses(start, end);
	}

	/**
	* Returns the number of colorses.
	*
	* @return the number of colorses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getColorsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.getColorsesCount();
	}

	/**
	* Updates the colors in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param colors the colors
	* @return the colors that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.colors.themes.model.Colors updateColors(
		com.colors.themes.model.Colors colors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _colorsLocalService.updateColors(colors);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _colorsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_colorsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _colorsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ColorsLocalService getWrappedColorsLocalService() {
		return _colorsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedColorsLocalService(
		ColorsLocalService colorsLocalService) {
		_colorsLocalService = colorsLocalService;
	}

	@Override
	public ColorsLocalService getWrappedService() {
		return _colorsLocalService;
	}

	@Override
	public void setWrappedService(ColorsLocalService colorsLocalService) {
		_colorsLocalService = colorsLocalService;
	}

	private ColorsLocalService _colorsLocalService;
}