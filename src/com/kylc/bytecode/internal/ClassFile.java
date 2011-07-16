package com.kylc.bytecode.internal;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import com.kylc.bytecode.internal.attributes.AttributeInfo;
import com.kylc.bytecode.internal.constants.Constant;

public class ClassFile {
	private final int magic;
	private final int minorVersion;
	private final int majorVersion;

	private final Constant[] constantPool;

	private final int accessFlags;
	private final int thisClass;
	private final int superClass;

	private final int[] interfaces;
	private final FieldInfo[] fields;
	private final MethodInfo[] methods;
	private final AttributeInfo[] attributes;

	public ClassFile(int magic, int minorVersion, int majorVersion, Constant[] constantPool, int accessFlags,
			int thisClass, int superClass, int[] interfaces, FieldInfo[] fields, MethodInfo[] methods,
			AttributeInfo[] attributes) {
		this.magic = magic;
		this.minorVersion = minorVersion;
		this.majorVersion = majorVersion;
		this.constantPool = constantPool;
		this.accessFlags = accessFlags;
		this.thisClass = thisClass;
		this.superClass = superClass;
		this.interfaces = interfaces;
		this.fields = fields;
		this.methods = methods;
		this.attributes = attributes;
	}

	public int getMagic() {
		return magic;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public Constant[] getConstantPool() {
		return constantPool;
	}

	public int getAccessFlags() {
		return accessFlags;
	}

	public int getThisClass() {
		return thisClass;
	}

	public int getSuperClass() {
		return superClass;
	}

	public int[] getInterfaces() {
		return interfaces;
	}

	public FieldInfo[] getFields() {
		return fields;
	}

	public MethodInfo[] getMethods() {
		return methods;
	}

	public AttributeInfo[] getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClassFile [magic=").append(magic).append(", minorVersion=").append(minorVersion)
		.append(", majorVersion=").append(majorVersion).append(", constantPool=")
		.append(Arrays.toString(constantPool)).append(", accessFlags=").append(accessFlags)
		.append(", thisClass=").append(thisClass).append(", superClass=").append(superClass)
		.append(", interfaces=").append(Arrays.toString(interfaces)).append(", fields=")
		.append(Arrays.toString(fields)).append(", methods=").append(Arrays.toString(methods))
		.append(", attributes=").append(Arrays.toString(attributes)).append("]");
		return builder.toString();
	}

	public static ClassFile parse(InputStream _input) throws IOException {
		DataInputStream input = new DataInputStream(_input);

		int magic = input.readInt();
		int minorVersion = input.readShort();
		int majorVersion = input.readShort();

		Constant[] constantPool = parseConstantPool(input);

		int accessFlags = input.readShort();
		int thisClass = input.readShort();
		int superClass = input.readShort();

		int[] interfaces = parseInterfaces(input);

		FieldInfo[] fields = parseFields(input, constantPool);
		MethodInfo[] methods = parseMethods(input, constantPool);
		AttributeInfo[] attributes = parseAttributes(input, constantPool);

		return new ClassFile(magic, minorVersion, majorVersion, constantPool,
				accessFlags, thisClass, superClass, interfaces, fields,
				methods, attributes);
	}

	private static Constant[] parseConstantPool(DataInputStream input) throws IOException {
		int constantPoolCount = input.readShort();
		Constant[] constantPool = new Constant[constantPoolCount];

		for(int i = 1; i < constantPool.length; i++) {
			constantPool[i] = Constant.parse(input);
		}

		return constantPool;
	}

	private static int[] parseInterfaces(DataInputStream input) throws IOException {
		int interfacesCount = input.readShort();
		int[] interfaces = new int[interfacesCount];

		for(int i = 0; i < interfaces.length; i++) {
			interfaces[i] = input.readShort();
		}

		return interfaces;
	}

	private static FieldInfo[] parseFields(DataInputStream input, Constant[] constantPool) throws IOException {
		int fieldsCount = input.readShort();
		FieldInfo[] fields = new FieldInfo[fieldsCount];

		for(int i = 0; i < fields.length; i++) {
			int accessFlags = input.readShort();
			int nameIndex = input.readShort();
			int descriptorIndex = input.readShort();
			AttributeInfo[] attributes = parseAttributes(input, constantPool);

			fields[i] = new FieldInfo(accessFlags, nameIndex, descriptorIndex, attributes);
		}

		return fields;
	}

	private static MethodInfo[] parseMethods(DataInputStream input, Constant[] constantPool) throws IOException {
		int methodsCount = input.readShort();
		MethodInfo[] methods = new MethodInfo[methodsCount];

		for(int i = 0; i < methods.length; i++) {
			int accessFlags = input.readShort();
			int nameIndex = input.readShort();
			int descriptorIndex = input.readShort();
			AttributeInfo[] attributes = parseAttributes(input, constantPool);

			methods[i] = new MethodInfo(accessFlags, nameIndex, descriptorIndex, attributes);
		}

		return methods;
	}

	private static AttributeInfo[] parseAttributes(DataInputStream input, Constant[] constantPool) throws IOException {
		int attributesCount = input.readShort();
		AttributeInfo[] attributes = new AttributeInfo[attributesCount];

		for(int i = 0; i < attributes.length; i++) {
			attributes[i] = AttributeInfo.parse(input, constantPool);
		}

		return attributes;
	}
}
