package com.kylc.bytecode.internal;

import com.kylc.bytecode.internal.attributes.AttributeInfo;

public class FieldInfo extends MemberInfo {
	public FieldInfo(int accessFlags, int nameIndex, int descriptorIndex,
			AttributeInfo[] attributes) {
		super(accessFlags, nameIndex, descriptorIndex, attributes);
	}
}
