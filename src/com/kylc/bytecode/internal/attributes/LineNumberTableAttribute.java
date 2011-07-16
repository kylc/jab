package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class LineNumberTableAttribute extends AttributeInfo {
	private final int lineNumberTableLength;
	private final LineNumberTableEntry[] lineNumberTable;

	public LineNumberTableAttribute(int nameIndex, int length, String name,
			int lineNumberTableLength,
			LineNumberTableEntry[] lineNumberTable) {
		super(nameIndex, length, name);
		this.lineNumberTableLength = lineNumberTableLength;
		this.lineNumberTable = lineNumberTable;
	}

	public int getLineNumberTableLength() {
		return lineNumberTableLength;
	}

	public LineNumberTableEntry[] getLineNumberTable() {
		return lineNumberTable;
	}

	public static LineNumberTableAttribute parse(DataInputStream input,
			Constant[] constantPool, int nameIndex, int length, String name) throws IOException {
		int lineNumberTableLength = input.readShort();
		LineNumberTableEntry[] lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];

		for(int i = 0; i < lineNumberTable.length; i++) {
			int startPc = input.readShort();
			int lineNumber = input.readShort();
			lineNumberTable[i] = new LineNumberTableEntry(startPc, lineNumber);
		}

		return new LineNumberTableAttribute(nameIndex, length, name, lineNumberTableLength, lineNumberTable);
	}

	public static class LineNumberTableEntry {
		private final int startPc;
		private final int lineNumber;

		public LineNumberTableEntry(int startPc, int lineNumber) {
			this.startPc = startPc;
			this.lineNumber = lineNumber;
		}

		public int getStartPc() {
			return startPc;
		}

		public int getLineNumber() {
			return lineNumber;
		}
	}
}