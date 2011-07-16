package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class ConstantUtf8 extends Constant {
	private int length;
	private String bytes;

	public ConstantUtf8(int length, String bytes) {
		this.length = length;
		this.bytes = bytes;
	}

	public int getLength() {
		return length;
	}

	public String getBytes() {
		return bytes;
	}

	public static ConstantUtf8 parse(DataInputStream input) throws IOException {
		int length = input.readShort();
		byte[] bytes = new byte[length];

		input.read(bytes);

		return new ConstantUtf8(length, new String(bytes, Charset.forName("UTF-8")));
	}
}
