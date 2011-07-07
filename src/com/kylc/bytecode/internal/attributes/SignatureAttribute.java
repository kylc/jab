package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class SignatureAttribute extends AttributeInfo {
	private final int signatureIndex;
	
	public SignatureAttribute(int nameIndex, int length, String name, int signatureIndex) {
		super(nameIndex, length, name);
		this.signatureIndex = signatureIndex;
	}
	
	public static SignatureAttribute parse(DataInputStream input,
			Constant[] constantPool, int nameIndex, int length, String name) throws IOException {
		int signatureIndex = input.readShort();
		System.out.println(constantPool[signatureIndex]);
		
		return new SignatureAttribute(nameIndex, length, name, signatureIndex);
	}

	public int getSignatureIndex() {
		return signatureIndex;
	}
}
