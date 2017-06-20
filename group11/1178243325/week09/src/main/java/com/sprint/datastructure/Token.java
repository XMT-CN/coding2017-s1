package com.sprint.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
class Token {
	public static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");
	private static final Map<String, Integer> priorities = new HashMap<>();
	
	static {
		priorities.put("+", 1);
		priorities.put("-", 1);
		priorities.put("*", 2);
		priorities.put("/", 2);
	}	

	static final int OPERATOR = 1;
	static final int NUMBER = 2;

	String value;
	int type;

	public Token(int type, String value) {
		this.type = type;
		this.value = value;
	}

	public boolean isNumber() {
		return type == NUMBER;
	}

	public boolean isOperator() {
		return type == OPERATOR;
	}

	public int getIntValue() {
		return Integer.valueOf(value).intValue();
	}

	@Override
	public String toString() {
		return value;
	}

	public boolean hasHigherPriority(Token t) {
		if (!this.isOperator() && !t.isOperator()) {
			throw new RuntimeException("number can't compare priority");
		}	
		return priorities.get(this.value) - priorities.get(t.value) > 0;
	}

}
