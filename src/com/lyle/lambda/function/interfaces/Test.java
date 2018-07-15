package com.lyle.lambda.function.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName: Test
 * @Description: Predicate<T>的使用
 * @author: Lyle
 * @date: 2018年7月15日 下午1:53:54
 */
public class Test {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		/**
		 * n是一个参数，传递到Predicate接口的test方法<br>
		 * n如果存在，则test方法返回true
		 */
		Predicate<Integer> predicate = n -> true;
		// 传递参数n
		eval(list, predicate);
		/**
		 * n是一个参数 ，传递到Predicate接口的test方法<br>
		 * 如果n%2为0,则test方法返回true
		 */
		System.out.println("输出所有的偶数：");
		eval(list, n -> n % 2 == 0);
		/**
		 * 如果n大于3，test方法返回true
		 */
		System.out.println("输出大于3的数字：");
		eval(list, n -> n > 3);
	}

	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		list.forEach(p -> {
			if (predicate.test(p)) {
				System.out.println(p + " ");
			}
		});
	}
}
