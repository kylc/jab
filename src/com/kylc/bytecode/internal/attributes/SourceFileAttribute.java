package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class SourceFileAttribute extends AttributeInfo {
	private final int sourceFileIndex;

	public SourceFileAttribute(int nameIndex, int length, String name, int sourceFileIndex) {
		super(nameIndex, length, name);
		this.sourceFileIndex = sourceFileIndex;
	}

	public static SourceFileAttribute parse(DataInputStream input,
			Constant[] constantPool, int nameIndex, int length, String name) throws IOException {
		int sourceFileIndex = input.readShort();

		return new SourceFileAttribute(nameIndex, length, name, sourceFileIndex);
	}

	public int getSourceFileIndex() {
		return sourceFileIndex;
	}
}
