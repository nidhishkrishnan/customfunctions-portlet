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

package com.colors.themes.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Colors}.
 * </p>
 *
 * @author user
 * @see Colors
 * @generated
 */
public class ColorsWrapper implements Colors, ModelWrapper<Colors> {
	public ColorsWrapper(Colors colors) {
		_colors = colors;
	}

	@Override
	public Class<?> getModelClass() {
		return Colors.class;
	}

	@Override
	public String getModelClassName() {
		return Colors.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("colorId", getColorId());
		attributes.put("colorName", getColorName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long colorId = (Long)attributes.get("colorId");

		if (colorId != null) {
			setColorId(colorId);
		}

		String colorName = (String)attributes.get("colorName");

		if (colorName != null) {
			setColorName(colorName);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this colors.
	*
	* @return the primary key of this colors
	*/
	@Override
	public long getPrimaryKey() {
		return _colors.getPrimaryKey();
	}

	/**
	* Sets the primary key of this colors.
	*
	* @param primaryKey the primary key of this colors
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_colors.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the color ID of this colors.
	*
	* @return the color ID of this colors
	*/
	@Override
	public long getColorId() {
		return _colors.getColorId();
	}

	/**
	* Sets the color ID of this colors.
	*
	* @param colorId the color ID of this colors
	*/
	@Override
	public void setColorId(long colorId) {
		_colors.setColorId(colorId);
	}

	/**
	* Returns the color name of this colors.
	*
	* @return the color name of this colors
	*/
	@Override
	public java.lang.String getColorName() {
		return _colors.getColorName();
	}

	/**
	* Sets the color name of this colors.
	*
	* @param colorName the color name of this colors
	*/
	@Override
	public void setColorName(java.lang.String colorName) {
		_colors.setColorName(colorName);
	}

	/**
	* Returns the status of this colors.
	*
	* @return the status of this colors
	*/
	@Override
	public boolean getStatus() {
		return _colors.getStatus();
	}

	/**
	* Returns <code>true</code> if this colors is status.
	*
	* @return <code>true</code> if this colors is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _colors.isStatus();
	}

	/**
	* Sets whether this colors is status.
	*
	* @param status the status of this colors
	*/
	@Override
	public void setStatus(boolean status) {
		_colors.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _colors.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_colors.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _colors.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_colors.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _colors.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _colors.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_colors.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _colors.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_colors.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_colors.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_colors.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ColorsWrapper((Colors)_colors.clone());
	}

	@Override
	public int compareTo(com.colors.themes.model.Colors colors) {
		return _colors.compareTo(colors);
	}

	@Override
	public int hashCode() {
		return _colors.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.colors.themes.model.Colors> toCacheModel() {
		return _colors.toCacheModel();
	}

	@Override
	public com.colors.themes.model.Colors toEscapedModel() {
		return new ColorsWrapper(_colors.toEscapedModel());
	}

	@Override
	public com.colors.themes.model.Colors toUnescapedModel() {
		return new ColorsWrapper(_colors.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _colors.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _colors.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_colors.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ColorsWrapper)) {
			return false;
		}

		ColorsWrapper colorsWrapper = (ColorsWrapper)obj;

		if (Validator.equals(_colors, colorsWrapper._colors)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Colors getWrappedColors() {
		return _colors;
	}

	@Override
	public Colors getWrappedModel() {
		return _colors;
	}

	@Override
	public void resetOriginalValues() {
		_colors.resetOriginalValues();
	}

	private Colors _colors;
}