package com.kylc.bytecode.internal;

import com.kylc.bytecode.internal.attributes.AttributeInfo;

public class MemberInfo {
	private final int accessFlags;
	private final int nameIndex;
	private final int descriptorIndex;
	private final AttributeInfo[] attributes;

	public MemberInfo(int accessFlags, int nameIndex, int descriptorIndex,
			AttributeInfo[] attributes) {
		this.accessFlags = accessFlags;
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
		this.attributes = attributes;
	}

	public int getAccessFlags() {
		return accessFlags;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	public AttributeInfo[] getAttributes() {
		return attributes;
	}
}
