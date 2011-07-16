package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;

public class ConstantNameAndType extends Constant {
	private final int nameIndex;
	private final int descriptorIndex;

	public ConstantNameAndType(int nameIndex, int descriptorIndex) {
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	public ConstantUtf8 getClassReference(ConstantPool constantPool) {
		return constantPool.getConstantUtf8(getNameIndex());
	}

	public ConstantUtf8 getNameAndType(ConstantPool constantPool) {
		return constantPool.getConstantUtf8(getDescriptorIndex());
	}

	public static ConstantNameAndType parse(DataInputStream input) throws IOException {
		int nameIndex = input.readShort();
		int descriptorIndex = input.readShort();

		return new ConstantNameAndType(nameIndex, descriptorIndex);
	}
}
