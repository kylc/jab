package com.kylc.bytecode.internal.code;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;
import com.kylc.bytecode.internal.constants.ConstantMethodRef;

public class MethodInstruction extends Instruction {
	private final ConstantMethodRef reference;

	public MethodInstruction(int opcode, ConstantMethodRef reference) {
		super(opcode);
		this.reference = reference;
	}

	public ConstantMethodRef getReference() {
		return reference;
	}

	public static MethodInstruction parse(DataInputStream input, ConstantPool constantPool, int opcode)
			throws IOException {
		ConstantMethodRef reference = constantPool.getConstantMethodRef(input.readShort());

		return new MethodInstruction(opcode, reference);
	}
}
