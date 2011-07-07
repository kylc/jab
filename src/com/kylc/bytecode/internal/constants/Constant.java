package com.kylc.bytecode.internal.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class Constant {
	public static Constant parse(DataInputStream input) throws IOException {
		int tag = input.readByte();
		
		switch(tag) {
		case 1: return ConstantUtf8.parse(input);
		case 3: return ConstantInteger.parse(input);
		case 4: return ConstantFloat.parse(input);
		case 5: return ConstantLong.parse(input);
		case 6: return ConstantDouble.parse(input);
		case 7: return ConstantClass.parse(input);
		case 8: return ConstantString.parse(input);
		case 9: return ConstantFieldRef.parse(input);
		case 10: return ConstantMethodRef.parse(input);
		case 11: return ConstantInterfaceMethodRef.parse(input);
		case 12: return ConstantNameAndType.parse(input);
		}
		
		return null;
	}
}
