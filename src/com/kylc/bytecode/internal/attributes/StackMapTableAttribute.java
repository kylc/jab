package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class StackMapTableAttribute extends AttributeInfo {
	public StackMapTableAttribute(int nameIndex, int length, String name) {
		super(nameIndex, length, name);
	}
	
	public static StackMapTableAttribute parse(DataInputStream input, Constant[] constantPool, int nameIndex, int length,
			String name) throws IOException {
		// TODO: implement this
		input.skip(length);
		
		return new StackMapTableAttribute(nameIndex, length, name);
	}
}
