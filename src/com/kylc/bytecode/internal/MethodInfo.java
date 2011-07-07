package com.kylc.bytecode.internal;

import com.kylc.bytecode.internal.attributes.AttributeInfo;

public class MethodInfo extends MemberInfo {
	public MethodInfo(int accessFlags, int nameIndex, int descriptorIndex,
			AttributeInfo[] attributes) {
		super(accessFlags, nameIndex, descriptorIndex, attributes);
	}
}
