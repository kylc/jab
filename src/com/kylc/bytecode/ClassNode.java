package com.kylc.bytecode;

import java.util.ArrayList;
import java.util.List;

import com.kylc.bytecode.internal.ClassFile;
import com.kylc.bytecode.internal.FieldInfo;
import com.kylc.bytecode.internal.MethodInfo;
import com.kylc.bytecode.internal.attributes.InnerClassAttribute;
import com.kylc.bytecode.internal.attributes.SourceFileAttribute;
import com.kylc.bytecode.internal.constants.ConstantClass;

public class ClassNode {
	private final int version;
	private final int access;

	private final String name;
	private final String signature;
	private final String superName;

	public final List<String> interfaces;

	private final String sourceFile;
	private final String sourceDebug;
	private final String outerClass;
	private final String outerMethod;
	private final String outerMethodDesc;

	private final List<InnerClassNode> innerClasses;
	private final List<FieldNode> fields;
	private final List<MethodNode> methods;

	private final ConstantPool constantPool;
	private final AttributePool attributePool;

	public ClassNode(ClassFile file) {
		this.constantPool = new ConstantPool(file.getConstantPool());
		this.attributePool = new AttributePool(file.getAttributes());

		this.version = file.getMajorVersion() + file.getMinorVersion();
		this.access = file.getAccessFlags();

		ConstantClass thisClass = constantPool.getConstantClass(file.getThisClass());
		ConstantClass superClass = constantPool.getConstantClass(file.getSuperClass());
		this.name = constantPool.getConstantUtf8(thisClass.getNameIndex()).getBytes();
		this.signature = null; // TODO: implement this
		this.superName = constantPool.getConstantUtf8(superClass.getNameIndex()).getBytes();

		this.interfaces = new ArrayList<String>();
		for (int i = 0; i < file.getInterfaces().length; i++) {
			ConstantClass iface = constantPool.getConstantClass(file.getInterfaces()[i]);
			interfaces.add(constantPool.getConstantUtf8(iface.getNameIndex()).getBytes());
		}

		SourceFileAttribute sourceFileAttribute = attributePool.getFirstAttributeByClass(SourceFileAttribute.class);
		this.sourceFile = constantPool.getConstantUtf8(sourceFileAttribute.getSourceFileIndex()).getBytes();
		this.sourceDebug = null; // TODO: implement this

		this.outerClass = null; // TODO: implement this
		this.outerMethod = null; // TODO: implement this
		this.outerMethodDesc = null; // TODO: implement this

		this.innerClasses = new ArrayList<InnerClassNode>();
		InnerClassAttribute innerClassAttribute = attributePool.getFirstAttributeByClass(InnerClassAttribute.class);
		if(innerClassAttribute != null) {
			for(int i = 0; i < innerClassAttribute.getAttributeLength(); i++) {
				innerClasses.add(new InnerClassNode(innerClassAttribute.getClasses()[i], constantPool));
			}
		}

		this.fields = new ArrayList<FieldNode>();
		for (int i = 0; i < file.getFields().length; i++) {
			FieldInfo field = file.getFields()[i];
			fields.add(new FieldNode(field, constantPool, new AttributePool(field.getAttributes())));
		}

		this.methods = new ArrayList<MethodNode>();
		for (int i = 0; i < file.getFields().length; i++) {
			MethodInfo method = file.getMethods()[i];
			methods.add(new MethodNode(method, constantPool, new AttributePool(method.getAttributes())));
		}
	}

	public int getVersion() {
		return version;
	}

	public int getAccess() {
		return access;
	}

	public String getName() {
		return name;
	}

	public String getSignature() {
		return signature;
	}

	public String getSuperName() {
		return superName;
	}

	public List<String> getInterfaces() {
		return interfaces;
	}

	public String getSourceFile() {
		return sourceFile;
	}

	public String getSourceDebug() {
		return sourceDebug;
	}

	public String getOuterClass() {
		return outerClass;
	}

	public String getOuterMethod() {
		return outerMethod;
	}

	public String getOuterMethodDesc() {
		return outerMethodDesc;
	}

	public List<InnerClassNode> getInnerClasses() {
		return innerClasses;
	}

	public List<FieldNode> getFields() {
		return fields;
	}

	public List<MethodNode> getMethods() {
		return methods;
	}

	public ConstantPool getConstantPool() {
		return constantPool;
	}

	public AttributePool getAttributePool() {
		return attributePool;
	}

	@Override
	public String toString() {
		return "ClassNode [version=" + version + ", access=" + access + ", name=" + name + ", signature=" + signature
				+ ", superName=" + superName + ", interfaces=" + interfaces + ", sourceFile=" + sourceFile
				+ ", sourceDebug=" + sourceDebug + ", outerClass=" + outerClass + ", outerMethod=" + outerMethod
				+ ", outerMethodDesc=" + outerMethodDesc + ", innerClasses=" + innerClasses + ", fields=" + fields
				+ ", methods=" + methods + "]";
	}
}
