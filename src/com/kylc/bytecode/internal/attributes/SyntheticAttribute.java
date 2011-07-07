package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class SyntheticAttribute extends AttributeInfo {
	public SyntheticAttribute(int nameIndex, int length, String name) {
		super(nameIndex, length, name);
	}

	public static SyntheticAttribute parse(DataInputStream input,
			Constant[] constantPool, int nameIndex, int length, String name) throws IOException {
		return new SyntheticAttribute(nameIndex, length, name);
	}
}
