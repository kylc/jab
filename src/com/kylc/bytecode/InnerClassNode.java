package com.kylc.bytecode;

import com.kylc.bytecode.internal.attributes.InnerClassAttribute;
import com.kylc.bytecode.internal.constants.ConstantClass;

public class InnerClassNode {
	private final int access;
	private final String innerName;
	private final String name;
	private final String outerName;

	public InnerClassNode(InnerClassAttribute.InnerClassEntry entry, ConstantPool constantPool) {
		this.access = entry.getInnerClassAccessFlags();
		this.name = constantPool.getConstantUtf8(entry.getInnerNameIndex()).getBytes();

		ConstantClass thisInnerClass = constantPool.getConstantClass(entry.getInnerClassInfoIndex());
		this.innerName = constantPool.getConstantUtf8(thisInnerClass.getNameIndex()).getBytes();

		ConstantClass outerClass = constantPool.getConstantClass(entry.getInnerClassInfoIndex());
		this.outerName = constantPool.getConstantUtf8(outerClass.getNameIndex()).getBytes();
	}

	public int getAccess() {
		return access;
	}

	public String getInnerName() {
		return innerName;
	}

	public String getName() {
		return name;
	}

	public String getOuterName() {
		return outerName;
	}

	@Override
	public String toString() {
		return "InnerClassNode [access=" + access + ", innerName=" + innerName + ", name=" + name + ", outerName="
				+ outerName + "]";
	}
}
