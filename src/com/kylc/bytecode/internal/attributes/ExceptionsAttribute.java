package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class ExceptionsAttribute extends AttributeInfo {
	private final int numberOfExceptions;
	private final int[] exceptionIndexTable;

	public ExceptionsAttribute(int nameIndex, int length, String name, int numberOfExceptions,
			int[] exceptionIndexTable) {
		super(nameIndex, length, name);
		this.numberOfExceptions = numberOfExceptions;
		this.exceptionIndexTable = exceptionIndexTable;
	}

	public int getNumberOfExceptions() {
		return numberOfExceptions;
	}

	public int[] getExceptionIndexTable() {
		return exceptionIndexTable;
	}

	public static ExceptionsAttribute parse(DataInputStream input, Constant[] constantPool, int nameIndex, int length,
			String name) throws IOException {
		int numberOfExceptions = input.readShort();
		int[] exceptionIndexTable = new int[numberOfExceptions];

		for(int i = 0; i < exceptionIndexTable.length; i++) {
			exceptionIndexTable[i] = input.readShort();
		}

		return new ExceptionsAttribute(nameIndex, length, name, numberOfExceptions, exceptionIndexTable);
	}
}
