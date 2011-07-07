package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantInteger extends Constant {
	private int bytes;
	
	public ConstantInteger(int bytes) {
		this.bytes = bytes;
	}
	
	public int getBytes() {
		return bytes;
	}
	
	public static ConstantInteger parse(DataInputStream input) throws IOException {
		int bytes = input.readShort();
		
		return new ConstantInteger(bytes);
	}
}
