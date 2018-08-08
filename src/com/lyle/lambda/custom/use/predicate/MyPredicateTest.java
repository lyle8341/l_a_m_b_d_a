package com.lyle.lambda.custom.use.predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Main
 * @Description:
 * @author: Lyle
 * @date: 2018年8月2日 上午10:40:33
 */
public class MyPredicateTest {

	// http://www.hao124.net/article/91
	// http://ifeve.com/jjava-util-function-java8/
	public static void main(String[] args) {
		List<String> listOfStrings = new ArrayList<>();
		listOfStrings.add("one");
		listOfStrings.add("two");
		listOfStrings.add("");
		List<String> nonEmpty = filter(listOfStrings, s -> !s.isEmpty());
		System.out.println(nonEmpty);
	}

	/**
	 * @Title: filter
	 * @Description: Predicate
	 * @param list
	 * @param p
	 * @return
	 * @return: List<T>
	 */
	public static <T> List<T> filter(List<T> list, MyPredicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				result.add(s);
			}
		}
		return result;
	}
}
