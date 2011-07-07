package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantInterfaceMethodRef extends Constant {
	private final int classIndex;
	private final int nameAndTypeIndex;
	
	public ConstantInterfaceMethodRef(int classIndex, int nameAndTypeIndex) {
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	public int getClassIndex() {
		return classIndex;
	}
	
	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}
	public static ConstantInterfaceMethodRef parse(DataInputStream input) throws IOException {
		int classIndex = input.readShort();
		int nameAndTypeIndex = input.readShort();
		
		return new ConstantInterfaceMethodRef(classIndex, nameAndTypeIndex);
	}
}
