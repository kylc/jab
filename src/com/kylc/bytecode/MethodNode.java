package com.kylc.bytecode;

import com.kylc.bytecode.internal.MemberInfo;

public class MethodNode extends MemberNode {
	public MethodNode(MemberInfo member, ConstantPool constantPool) {
		super(member, constantPool);
	}
}
