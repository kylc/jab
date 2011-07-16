package com.kylc.bytecode;

import com.kylc.bytecode.internal.MemberInfo;

public class MemberNode {
	private final int access;
	private final String name;
	private final String descriptor;

	private final AttributePool attributePool;

	public MemberNode(MemberInfo member, ConstantPool constantPool, AttributePool attributePool) {
		this.access = member.getAccessFlags();
		this.name = constantPool.getConstantUtf8(member.getNameIndex()).getBytes();
		this.descriptor = constantPool.getConstantUtf8(member.getDescriptorIndex()).getBytes();

		this.attributePool = attributePool;
	}

	public int getAccess() {
		return access;
	}

	public String getName() {
		return name;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public AttributePool getAttributePool() {
		return attributePool;
	}

	@Override
	public String toString() {
		return "MemberNode [access=" + access + ", name=" + name + ", descriptor=" + descriptor + "]";
	}
}
