package com.kylc.bytecode;

import com.kylc.bytecode.internal.MemberInfo;

public class MemberNode {
	private final int access;
	private final String name;
	private final String descriptor;
	
	public MemberNode(MemberInfo member, ConstantPool constantPool) {
		this.access = member.getAccessFlags();
		this.name = constantPool.getConstantUtf8(member.getNameIndex()).getBytes();
		this.descriptor = constantPool.getConstantUtf8(member.getDescriptorIndex()).getBytes();
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

	@Override
	public String toString() {
		return "MemberNode [access=" + access + ", name=" + name + ", descriptor=" + descriptor + "]";
	}
}
