package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;

public class ConstantClass extends Constant {
	private final int nameIndex;

	public ConstantClass(int nameIndex) {
		this.nameIndex = nameIndex;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public ConstantUtf8 getNameReference(ConstantPool constantPool) {
		return constantPool.getConstantUtf8(getNameIndex());
	}

	public static ConstantClass parse(DataInputStream input) throws IOException {
		int nameIndex = input.readShort();

		return new ConstantClass(nameIndex);
	}
}
