package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;

public class ConstantInterfaceMethodRef extends Constant {
	private final int classIndex;
	private final int nameAndTypeIndex;

	public ConstantInterfaceMethodRef(int classIndex, int nameAndTypeIndex) {
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	public int getClassIndex() {
		return classIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	public ConstantClass getClassReference(ConstantPool constantPool) {
		return constantPool.getConstantClass(getClassIndex());
	}

	public ConstantNameAndType getNameAndType(ConstantPool constantPool) {
		return constantPool.getConstantNameAndType(getNameAndTypeIndex());
	}

	public static ConstantInterfaceMethodRef parse(DataInputStream input) throws IOException {
		int classIndex = input.readShort();
		int nameAndTypeIndex = input.readShort();

		return new ConstantInterfaceMethodRef(classIndex, nameAndTypeIndex);
	}
}
