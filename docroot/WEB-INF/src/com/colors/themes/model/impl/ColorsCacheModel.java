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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Colors in entity cache.
 *
 * @author user
 * @see Colors
 * @generated
 */
public class ColorsCacheModel implements CacheModel<Colors>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{colorId=");
		sb.append(colorId);
		sb.append(", colorName=");
		sb.append(colorName);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Colors toEntityModel() {
		ColorsImpl colorsImpl = new ColorsImpl();

		colorsImpl.setColorId(colorId);

		if (colorName == null) {
			colorsImpl.setColorName(StringPool.BLANK);
		}
		else {
			colorsImpl.setColorName(colorName);
		}

		colorsImpl.setStatus(status);

		colorsImpl.resetOriginalValues();

		return colorsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		colorId = objectInput.readLong();
		colorName = objectInput.readUTF();
		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(colorId);

		if (colorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(colorName);
		}

		objectOutput.writeBoolean(status);
	}

	public long colorId;
	public String colorName;
	public boolean status;
}