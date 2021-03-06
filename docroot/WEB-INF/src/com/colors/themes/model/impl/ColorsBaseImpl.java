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

package com.colors.themes.model.impl;

import com.colors.themes.model.Colors;
import com.colors.themes.service.ColorsLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Colors service. Represents a row in the &quot;theme_Colors&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ColorsImpl}.
 * </p>
 *
 * @author user
 * @see ColorsImpl
 * @see com.colors.themes.model.Colors
 * @generated
 */
public abstract class ColorsBaseImpl extends ColorsModelImpl implements Colors {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a colors model instance should use the {@link Colors} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ColorsLocalServiceUtil.addColors(this);
		}
		else {
			ColorsLocalServiceUtil.updateColors(this);
		}
	}
}