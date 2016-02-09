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
import com.colors.themes.service.ColorsLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author user
 * @generated
 */
public abstract class ColorsActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ColorsActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ColorsLocalServiceUtil.getService());
		setClass(Colors.class);

		setClassLoader(com.colors.themes.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("colorId");
	}
}