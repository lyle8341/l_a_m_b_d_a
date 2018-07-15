package com.lyle.lambda.type.deduce;

/**
 * @ClassName: Value
 * @Description: 更好的类型推断
 * @author: Lyle
 * @date: 2018年7月15日 下午1:35:25
 */
public class Value<T> {

	public static <T> T defaultValue() {
		return null;
	}

	public T getOrDefault(T value, T defaultValue) {
		return (value != null) ? value : defaultValue;
	}

	public static void main(String[] args) {
		Value<String> value = new Value<>();
		// jdk8
		value.getOrDefault("xx", Value.defaultValue());
		// ====>jdk7
		value.getOrDefault("YY", Value.<String> defaultValue());
	}
}
