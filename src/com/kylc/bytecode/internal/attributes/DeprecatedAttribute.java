package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class DeprecatedAttribute extends AttributeInfo {
	public DeprecatedAttribute(int nameIndex, int length, String name) {
		super(nameIndex, length, name);
	}

	public static DeprecatedAttribute parse(DataInputStream input, Constant[] constantPool, int nameIndex,
			int length, String name) throws IOException {
		return new DeprecatedAttribute(nameIndex, length, name);
	}
}
