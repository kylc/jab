package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantNameAndType extends Constant {
	private final int nameIndex;
	private final int descriptorIndex;

	public ConstantNameAndType(int nameIndex, int descriptorIndex) {
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}

	public int getNameIndex() {
		return nameIndex;
	}
	
	public int getDescriptorIndex() {
		return descriptorIndex;
	}
	
	public static ConstantNameAndType parse(DataInputStream input) throws IOException {
		int nameIndex = input.readShort();
		int descriptorIndex = input.readShort();
		
		return new ConstantNameAndType(nameIndex, descriptorIndex);
	}
}
