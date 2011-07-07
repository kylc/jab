package com.kylc.bytecode;

import java.util.ArrayList;
import java.util.List;

import com.kylc.bytecode.internal.attributes.AttributeInfo;

public class AttributePool {
	private final AttributeInfo[] attributes;
	
	public AttributePool(AttributeInfo[] attributes) {
		this.attributes = attributes;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getAttributesByClass(Class<T> clazz) {
		List<T> filtered = new ArrayList<T>();
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i].getClass().equals(clazz)) {
				filtered.add((T) attributes[i]);
			}
		}
		return filtered;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getFirstAttributeByClass(Class<T> clazz) {
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i].getClass().equals(clazz)) {
				return (T) attributes[i];
			}
		}
		return null;
	}
}
