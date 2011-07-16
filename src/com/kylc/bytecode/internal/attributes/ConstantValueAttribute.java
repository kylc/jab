package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class ConstantValueAttribute extends AttributeInfo {
	private final int constantValueIndex;

	public ConstantValueAttribute(int nameIndex, int length, String name, int constantValueIndex) {
		super(nameIndex, length, name);
		this.constantValueIndex = constantValueIndex;
	}

	public int getConstantValueIndex() {
		return constantValueIndex;
	}

	public static ConstantValueAttribute parse(DataInputStream input, Constant[] constantPool, int nameIndex,
			int length, String name) throws IOException {
		int constantValueIndex = input.readShort();

		return new ConstantValueAttribute(nameIndex, length, name, constantValueIndex);
	}
}
