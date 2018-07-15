package com.lyle.lambda.variable;

import java.util.Arrays;

/**
 * @ClassName: FinalVariable
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年7月15日 上午9:50:12
 */
public class FinalVariable {

	public static void main(String[] args) {
		Arrays.asList(1l, 2l, 3l).forEach(p -> System.out.println(p));
		/**
		 * 参数p的类型是由编译器推理得出的，你也可以显式指定该参数的类型，例如：
		 */
		// ===>
		Arrays.asList(1l, 2l, 3l).forEach((Long p) -> System.out.println(p));
		// ===>
		Arrays.asList(1l, 2l, 3l).forEach(System.out::println);
		/**
		 * 如果Lambda表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来
		 */
		Arrays.asList(1l, 2l, 3l).forEach(p -> {
			System.out.println(p);
			System.out.println(p + "");
		});
		/**
		 * Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的）
		 */
		String emptyStr = "";// ====>final String emptyStr = "";
		Arrays.asList(1l, 2l, 3l).forEach(p -> {
			System.out.println(p + emptyStr);
		});
		/**
		 * Lambda表达式有返回值，返回值的类型也由编译器推理得出。如果Lambda表达式中的语句块只有一行，则可以不用使用return语句
		 */
		Arrays.asList(1l, 2l, 3l, 0l).sort((e1, e2) -> {
			return e1.compareTo(e2);
		});
		// ====>
		Arrays.asList(1l, 2l, 3l, 0l).sort((e1, e2) -> e1.compareTo(e2));
	}
}
