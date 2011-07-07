package com.kylc.bytecode;

import com.kylc.bytecode.internal.constants.Constant;
import com.kylc.bytecode.internal.constants.ConstantClass;
import com.kylc.bytecode.internal.constants.ConstantDouble;
import com.kylc.bytecode.internal.constants.ConstantFieldRef;
import com.kylc.bytecode.internal.constants.ConstantFloat;
import com.kylc.bytecode.internal.constants.ConstantInteger;
import com.kylc.bytecode.internal.constants.ConstantInterfaceMethodRef;
import com.kylc.bytecode.internal.constants.ConstantLong;
import com.kylc.bytecode.internal.constants.ConstantMethodRef;
import com.kylc.bytecode.internal.constants.ConstantNameAndType;
import com.kylc.bytecode.internal.constants.ConstantString;
import com.kylc.bytecode.internal.constants.ConstantUtf8;

public class ConstantPool {
	private final Constant[] constantPool;
	
	public ConstantPool(Constant[] constantPool) {
		this.constantPool = constantPool;
	}
	
	public Constant get(int index) {
		return constantPool[index];
	}
	
	public ConstantClass getConstantClass(int index) {
		return (ConstantClass) get(index);
	}
	
	public ConstantDouble getConstantDouble(int index) {
		return (ConstantDouble) get(index);
	}
	
	public ConstantFieldRef getConstantFieldRef(int index) {
		return (ConstantFieldRef) get(index);
	}
	
	public ConstantFloat getConstantFloat(int index) {
		return (ConstantFloat) get(index);
	}
	
	public ConstantInteger getConstantInteger(int index) {
		return (ConstantInteger) get(index);
	}
	
	public ConstantInterfaceMethodRef getConstantInterfaceMethodRef(int index) {
		return (ConstantInterfaceMethodRef) get(index);
	}
	
	public ConstantLong getConstantLong(int index) {
		return (ConstantLong) get(index);
	}
	
	public ConstantMethodRef getConstantMethodRef(int index) {
		return (ConstantMethodRef) get(index);
	}
	
	public ConstantNameAndType getConstantNameAndType(int index) {
		return (ConstantNameAndType) get(index);
	}
	
	public ConstantString getConstantString(int index) {
		return (ConstantString) get(index);
	}
	
	public ConstantUtf8 getConstantUtf8(int index) {
		return (ConstantUtf8) get(index);
	}
}
