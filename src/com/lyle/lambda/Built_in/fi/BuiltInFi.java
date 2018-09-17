package com.lyle.lambda.Built_in.fi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * @ClassName: BuiltInFi
 * @Description: 内置接口
 * @author: Lyle
 * @date: 2018年9月17日 下午3:31:28
 */
public class BuiltInFi {

	// 需求：将满足条件的字符串，放入集合中
	private List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> strList = new ArrayList<>();
		for (String str : list) {
			if (pre.test(str)) {
				strList.add(str);
			}
		}
		return strList;
	}

	/**
	 * <code>
	 * Predicate<T>:断言型接口
	 * 		boolean test(T t);
	 * </code>
	 */
	@Test
	public void testPredicate() {
		List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
		List<String> strList = filterStr(list, (s) -> s.length() > 3);
		for (String str : strList) {
			System.out.println(str);
		}
	}

	// ===============================================
	// 需求：用于处理字符串
	private String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}

	/**
	 * <code>
	 * Function<T,R>:函数型接口
	 * 		R apply(T t);
	 * </code>
	 */
	@Test
	public void testFunction() {
		String newStr = strHandler("\t\t\t 论吹牛逼那家强   ", (str) -> str.trim());
		System.out.println(newStr);
		String subStr = strHandler("论吹牛逼哪家强", (str) -> str.substring(2, 5));
		System.out.println(subStr);
	}

	// ================================================
	// 需求：产生指定个数的整数，并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}

	/**
	 * <code>
	 * Supplier<T>:供给型接口
	 * 		T get();
	 * </code>
	 */
	@Test
	public void testSupplier() {
		List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer num : numList) {
			System.out.println(num);
		}
	}

	// ===================================================
	/**
	 * <code>
	 * Consumer<T>:消费型接口
	 * 		void accept(T t);
	 * </code>
	 */
	@Test
	public void test1() {
		happy(10000, (m) -> System.out.println("买电视：" + m + "元"));
	}

	private void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
}
