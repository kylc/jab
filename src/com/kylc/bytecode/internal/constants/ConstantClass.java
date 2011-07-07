package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantClass extends Constant {
	private final int nameIndex;

	public ConstantClass(int nameIndex) {
		this.nameIndex = nameIndex;
	}

	public int getNameIndex() {
		return nameIndex;
	}	
	
	public static ConstantClass parse(DataInputStream input) throws IOException {
		int nameIndex = input.readShort();
		
		return new ConstantClass(nameIndex);
	}
}
