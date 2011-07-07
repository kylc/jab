package com.kylc.bytecode.internal.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import com.kylc.bytecode.internal.constants.Constant;

public class InnerClassAttribute extends AttributeInfo {
	private final int numberOfClasses;
	private final InnerClassEntry[] classes;
	
	public InnerClassAttribute(int nameIndex, int length, String name, int numberOfClasses,
			InnerClassEntry[] classes) {
		super(nameIndex, length, name);
		this.numberOfClasses = numberOfClasses;
		this.classes = classes;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public InnerClassEntry[] getClasses() {
		return classes;
	}

	public static InnerClassAttribute parse(DataInputStream input, Constant[] constantPool, int nameIndex, int length,
			String name) throws IOException {
		int numberOfClasses = input.readShort();
		InnerClassEntry[] classes = new InnerClassEntry[numberOfClasses];
		
		for(int i = 0; i < numberOfClasses; i++) {
			int innerClassInfoIndex = input.readShort();
			int outerClassInfoIndex = input.readShort();
			int innerNameIndex = input.readShort();
			int innerClassAccessFlags = input.readShort();
			
			classes[i] = new InnerClassEntry(innerClassInfoIndex, outerClassInfoIndex, innerNameIndex,
					innerClassAccessFlags);
		}
		
		return new InnerClassAttribute(nameIndex, length, name, numberOfClasses, classes);
	}
	
	public static class InnerClassEntry {
		private final int innerClassInfoIndex;
		private final int outerClassInfoIndex;
		private final int innerNameIndex;
		private final int innerClassAccessFlags;
		
		public InnerClassEntry(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex,
				int innerClassAccessFlags) {
			this.innerClassInfoIndex = innerClassInfoIndex;
			this.outerClassInfoIndex = outerClassInfoIndex;
			this.innerNameIndex = innerNameIndex;
			this.innerClassAccessFlags = innerClassAccessFlags;
		}

		public int getInnerClassInfoIndex() {
			return innerClassInfoIndex;
		}

		public int getOuterClassInfoIndex() {
			return outerClassInfoIndex;
		}

		public int getInnerNameIndex() {
			return innerNameIndex;
		}

		public int getInnerClassAccessFlags() {
			return innerClassAccessFlags;
		}
	}
}