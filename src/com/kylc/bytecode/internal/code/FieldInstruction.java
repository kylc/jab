package com.kylc.bytecode.internal.code;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.ConstantPool;
import com.kylc.bytecode.internal.constants.ConstantFieldRef;

public class FieldInstruction extends Instruction {
	private final ConstantFieldRef reference;

	public FieldInstruction(int opcode, ConstantFieldRef reference) {
		super(opcode);
		this.reference = reference;
	}

	public ConstantFieldRef getReference() {
		return reference;
	}

	public static FieldInstruction parse(DataInputStream input, ConstantPool constantPool, int opcode)
			throws IOException {
		ConstantFieldRef reference = constantPool.getConstantFieldRef(input.readShort());

		return new FieldInstruction(opcode, reference);
	}
}
