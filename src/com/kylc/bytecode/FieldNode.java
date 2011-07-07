package com.kylc.bytecode;

import com.kylc.bytecode.internal.MemberInfo;

public class FieldNode extends MemberNode {
	public FieldNode(MemberInfo member, ConstantPool constantPool) {
		super(member, constantPool);
	}
}
