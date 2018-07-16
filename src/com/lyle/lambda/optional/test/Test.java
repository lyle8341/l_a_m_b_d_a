package com.lyle.lambda.optional.test;

import java.util.Optional;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年7月15日 下午2:17:33
 */
public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		Integer v1 = null;
		Integer v2 = new Integer(22);
		/**
		 * 允许传递为null参数
		 */
		Optional<Integer> o1 = Optional.ofNullable(v1);
		/**
		 * 如果传递的参数为null，抛出空指针异常
		 */
		Optional<Integer> o2 = Optional.of(v2);
		System.out.println(t.sum(o1, o2));
	}

	public Integer sum(Optional<Integer> o1, Optional<Integer> o2) {
		// isPresent 判断值是否存在
		System.out.println("第一个参数值存在： " + o1.isPresent());
		System.out.println("第二个参数值存在： " + o2.isPresent());
		// orElse 如果值存在返回它，否则返回默认值
		Integer value1 = o1.orElse(new Integer(110));
		Integer value2 = o2.get();
		return value1 + value2;
	}
}
