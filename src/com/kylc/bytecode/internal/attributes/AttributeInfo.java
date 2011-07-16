package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;
import com.kylc.bytecode.internal.constants.ConstantUtf8;

public class AttributeInfo {
	private final int nameIndex;
	private final int length;
	private final String name;

	public AttributeInfo(int nameIndex, int length, String name) {
		this.nameIndex = nameIndex;
		this.length = length;
		this.name = name;
	}

	public int getAttributeNameIndex() {
		return nameIndex;
	}

	public int getAttributeLength() {
		return length;
	}

	public String getAttributeName() {
		return name;
	}

	public static AttributeInfo parse(DataInputStream input, Constant[] constantPool) throws IOException {
		int nameIndex = input.readShort();
		int length = input.readInt();

		String name = ((ConstantUtf8) constantPool[nameIndex]).getBytes();

		if(name.equals("ConstantValue")) return ConstantValueAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("Code")) return CodeAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("Exceptions")) return ExceptionsAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("InnerClass")) return InnerClassAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("Synthetic")) return SyntheticAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("SourceFile")) return SourceFileAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("LineNumberTable")) return LineNumberTableAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("LocalVariableTable")) return LocalVariableTableAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("StackMapTable")) return StackMapTableAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("Deprecated")) return DeprecatedAttribute.parse(input, constantPool, nameIndex, length, name);
		else if(name.equals("Signature")) return SignatureAttribute.parse(input, constantPool, nameIndex, length, name);

		return null;
	}
}
