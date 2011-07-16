package com.kylc.bytecode.internal.code;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;

/**
 * Represents a zero operand instruction.
 */
public class Instruction implements InstructionConstants {
	private final int opcode;

	public Instruction(int opcode) {
		this.opcode = opcode;
	}

	public int getOpcode() {
		return opcode;
	}

	public static Instruction parse(DataInputStream input, ConstantPool constantPool) throws IOException {
		int opcode = input.readUnsignedByte();

		switch(opcode) {
		case GETSTATIC:
		case PUTSTATIC:
		case GETFIELD:
		case PUTFIELD:
			return FieldInstruction.parse(input, constantPool, opcode);
		case INVOKEINTERFACE:
		case INVOKESPECIAL:
		case INVOKESTATIC:
		case INVOKEVIRTUAL:
			return MethodInstruction.parse(input, constantPool, opcode);
		}

		return new Instruction(opcode);
	}
}
