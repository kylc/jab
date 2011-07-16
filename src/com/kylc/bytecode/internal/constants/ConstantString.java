package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;

public class ConstantString extends Constant {
	private final int stringIndex;

	public ConstantString(int stringIndex) {
		this.stringIndex = stringIndex;
	}

	public int getStringIndex() {
		return stringIndex;
	}

	public ConstantUtf8 getString(ConstantPool constantPool) {
		return constantPool.getConstantUtf8(getStringIndex());
	}

	public static ConstantString parse(DataInputStream input) throws IOException {
		int stringIndex = input.readShort();

		return new ConstantString(stringIndex);
	}
}
