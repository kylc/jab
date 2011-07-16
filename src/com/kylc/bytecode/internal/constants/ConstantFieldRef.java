package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;

public class ConstantFieldRef extends Constant {
	private final int classIndex;
	private final int nameAndTypeIndex;

	public ConstantFieldRef(int classIndex, int nameAndTypeIndex) {
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

	public ConstantNameAndType getNameAndTypeReference(ConstantPool constantPool) {
		return constantPool.getConstantNameAndType(getNameAndTypeIndex());
	}

	public static ConstantFieldRef parse(DataInputStream input) throws IOException {
		int classIndex = input.readShort();
		int nameAndTypeIndex = input.readShort();

		return new ConstantFieldRef(classIndex, nameAndTypeIndex);
	}
}
