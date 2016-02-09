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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.colors.themes.service.http.ColorsServiceSoap}.
 *
 * @author user
 * @see com.colors.themes.service.http.ColorsServiceSoap
 * @generated
 */
public class ColorsSoap implements Serializable {
	public static ColorsSoap toSoapModel(Colors model) {
		ColorsSoap soapModel = new ColorsSoap();

		soapModel.setColorId(model.getColorId());
		soapModel.setColorName(model.getColorName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ColorsSoap[] toSoapModels(Colors[] models) {
		ColorsSoap[] soapModels = new ColorsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ColorsSoap[][] toSoapModels(Colors[][] models) {
		ColorsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ColorsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ColorsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ColorsSoap[] toSoapModels(List<Colors> models) {
		List<ColorsSoap> soapModels = new ArrayList<ColorsSoap>(models.size());

		for (Colors model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ColorsSoap[soapModels.size()]);
	}

	public ColorsSoap() {
	}

	public long getPrimaryKey() {
		return _colorId;
	}

	public void setPrimaryKey(long pk) {
		setColorId(pk);
	}

	public long getColorId() {
		return _colorId;
	}

	public void setColorId(long colorId) {
		_colorId = colorId;
	}

	public String getColorName() {
		return _colorName;
	}

	public void setColorName(String colorName) {
		_colorName = colorName;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	private long _colorId;
	private String _colorName;
	private boolean _status;
}