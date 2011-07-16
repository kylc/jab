package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class CodeAttribute extends AttributeInfo {
	private final int maxStacks;
	private final int maxLocals;
	private final int codeLength;
	private final byte[] code;
	private final int exceptionTableLength;
	private final ExceptionTableEntry[] exceptionTable;
	private final int attributesCount;
	private final AttributeInfo[] attributes;

	public CodeAttribute(int nameIndex, int length, String name, int maxStacks, int maxLocals, int codeLength,
			byte[] code, int exceptionTableLength, ExceptionTableEntry[] exceptionTable, int attributesCount,
			AttributeInfo[] attributes) {
		super(nameIndex, length, name);
		this.maxStacks = maxStacks;
		this.maxLocals = maxLocals;
		this.codeLength = codeLength;
		this.code = code;
		this.exceptionTableLength = exceptionTableLength;
		this.exceptionTable = exceptionTable;
		this.attributesCount = attributesCount;
		this.attributes = attributes;
	}

	public int getMaxStacks() {
		return maxStacks;
	}

	public int getMaxLocals() {
		return maxLocals;
	}

	public int getCodeLength() {
		return codeLength;
	}

	public byte[] getCode() {
		return code;
	}

	public int getExceptionTableLength() {
		return exceptionTableLength;
	}

	public ExceptionTableEntry[] getExceptionTable() {
		return exceptionTable;
	}

	public int getAttributesCount() {
		return attributesCount;
	}

	public AttributeInfo[] getAttributes() {
		return attributes;
	}

	public static CodeAttribute parse(DataInputStream input, Constant[] constantPool, int nameIndex, int length,
			String name) throws IOException {
		int maxStacks = input.readShort();
		int maxLocals = input.readShort();
		int codeLength = input.readInt();

		byte[] code = new byte[codeLength];
		input.read(code);

		int exceptionTableLength = input.readShort();
		ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[exceptionTableLength];

		for(int i = 0; i < exceptionTable.length; i++) {
			int startPc = input.readShort();
			int endPc = input.readShort();
			int handlerPc = input.readShort();
			int catchType = input.readShort();

			exceptionTable[i] = new ExceptionTableEntry(startPc, endPc, handlerPc, catchType);
		}

		int attributesCount = input.readShort();
		AttributeInfo[] attributes = new AttributeInfo[attributesCount];

		for(int i = 0; i < attributes.length; i++) {
			attributes[i] = AttributeInfo.parse(input, constantPool);
		}

		return new CodeAttribute(nameIndex, length, name, maxStacks, maxLocals, codeLength, code, exceptionTableLength,
				exceptionTable, attributesCount, attributes);
	}

	public static class ExceptionTableEntry {
		private final int startPc;
		private final int endPc;
		private final int handlerPc;
		private final int catchType;

		public ExceptionTableEntry(int startPc, int endPc, int handlerPc, int catchType) {
			this.startPc = startPc;
			this.endPc = endPc;
			this.handlerPc = handlerPc;
			this.catchType = catchType;
		}

		public int getStartPc() {
			return startPc;
		}

		public int getEndPc() {
			return endPc;
		}

		public int getHandlerPc() {
			return handlerPc;
		}

		public int getCatchType() {
			return catchType;
		}
	}
}