package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantLong extends Constant {
	private long bytes;

	public ConstantLong(long bytes) {
		this.bytes = bytes;
	}

	public long getBytes() {
		return bytes;
	}

	public static ConstantLong parse(DataInputStream input) throws IOException {
		long bytes = input.readLong();

		return new ConstantLong(bytes);
	}
}
