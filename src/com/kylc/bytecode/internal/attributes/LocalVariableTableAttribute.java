package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class LocalVariableTableAttribute extends AttributeInfo {
	private final int localVariableTableLength;
	private final LocalVariableTableEntry[] localVariableTable;

	public LocalVariableTableAttribute(int nameIndex, int length, String name, int localVariableTableLength,
			LocalVariableTableEntry[] localVariableTable) {
		super(nameIndex, length, name);
		this.localVariableTableLength = localVariableTableLength;
		this.localVariableTable = localVariableTable;
	}

	public static LocalVariableTableAttribute parse(DataInputStream input,
			Constant[] constantPool, int nameIndex, int length, String name) throws IOException {
		int localVariableTableLength = input.readShort();
		LocalVariableTableEntry[] localVariableTable = new LocalVariableTableEntry[localVariableTableLength];

		for(int i = 0; i < localVariableTable.length; i++) {
			int startPc = input.readShort();
			int entryLength = input.readShort();
			int entryNameIndex = input.readShort();
			int descriptorIndex = input.readShort();
			int index = input.readShort();

			localVariableTable[i] = new LocalVariableTableEntry(startPc, entryLength, entryNameIndex, descriptorIndex,
					index);
		}

		return new LocalVariableTableAttribute(nameIndex, length, name, localVariableTableLength, localVariableTable);
	}

	public int getLocalVariableTableLength() {
		return localVariableTableLength;
	}

	public LocalVariableTableEntry[] getLocalVariableTable() {
		return localVariableTable;
	}
}

class LocalVariableTableEntry {
	private final int startPc;
	private final int length;
	private final int nameIndex;
	private final int descriptorIndex;
	private final int index;

	public LocalVariableTableEntry(int startPc, int length, int nameIndex,
			int descriptorIndex, int index) {
		this.startPc = startPc;
		this.length = length;
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
		this.index = index;
	}

	public int getStartPc() {
		return startPc;
	}

	public int getLength() {
		return length;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	public int getIndex() {
		return index;
	}
}