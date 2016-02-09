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

import com.colors.themes.service.ClpSerializer;
import com.colors.themes.service.ColorsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author user
 */
public class ColorsClp extends BaseModelImpl<Colors> implements Colors {
	public ColorsClp() {
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
	public long getPrimaryKey() {
		return _colorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setColorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _colorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getColorId() {
		return _colorId;
	}

	@Override
	public void setColorId(long colorId) {
		_colorId = colorId;

		if (_colorsRemoteModel != null) {
			try {
				Class<?> clazz = _colorsRemoteModel.getClass();

				Method method = clazz.getMethod("setColorId", long.class);

				method.invoke(_colorsRemoteModel, colorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColorName() {
		return _colorName;
	}

	@Override
	public void setColorName(String colorName) {
		_colorName = colorName;

		if (_colorsRemoteModel != null) {
			try {
				Class<?> clazz = _colorsRemoteModel.getClass();

				Method method = clazz.getMethod("setColorName", String.class);

				method.invoke(_colorsRemoteModel, colorName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_colorsRemoteModel != null) {
			try {
				Class<?> clazz = _colorsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_colorsRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getColorsRemoteModel() {
		return _colorsRemoteModel;
	}

	public void setColorsRemoteModel(BaseModel<?> colorsRemoteModel) {
		_colorsRemoteModel = colorsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _colorsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_colorsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ColorsLocalServiceUtil.addColors(this);
		}
		else {
			ColorsLocalServiceUtil.updateColors(this);
		}
	}

	@Override
	public Colors toEscapedModel() {
		return (Colors)ProxyUtil.newProxyInstance(Colors.class.getClassLoader(),
			new Class[] { Colors.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ColorsClp clone = new ColorsClp();

		clone.setColorId(getColorId());
		clone.setColorName(getColorName());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(Colors colors) {
		long primaryKey = colors.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ColorsClp)) {
			return false;
		}

		ColorsClp colors = (ColorsClp)obj;

		long primaryKey = colors.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{colorId=");
		sb.append(getColorId());
		sb.append(", colorName=");
		sb.append(getColorName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.colors.themes.model.Colors");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>colorId</column-name><column-value><![CDATA[");
		sb.append(getColorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>colorName</column-name><column-value><![CDATA[");
		sb.append(getColorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _colorId;
	private String _colorName;
	private boolean _status;
	private BaseModel<?> _colorsRemoteModel;
}