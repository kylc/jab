package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantDouble extends Constant {
	private double bytes;

	public ConstantDouble(double bytes) {
		this.bytes = bytes;
	}

	public double getBytes() {
		return bytes;
	}

	public static ConstantDouble parse(DataInputStream input) throws IOException {
		double bytes = input.readLong();

		return new ConstantDouble(bytes);
	}
}
