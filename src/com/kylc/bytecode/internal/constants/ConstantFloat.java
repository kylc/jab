package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantFloat extends Constant {
	private float bytes;
	
	public ConstantFloat(float bytes) {
		this.bytes = bytes;
	}
	
	public float getBytes() {
		return bytes;
	}
	
	public static ConstantFloat parse(DataInputStream input) throws IOException {
		float bytes = input.readFloat();
		
		return new ConstantFloat(bytes);
	}
}
