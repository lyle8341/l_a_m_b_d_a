package com.lyle.lambda.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年7月16日 上午9:06:37
 */
public class Test {

	public static void main(String[] args) {
		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		}).map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
			// parallelStream.sorted 待排序数组的长度决定了排序操作是顺序执行还是并行执行,长度>8*1024时候使用并行
		}).sorted((s1, s2) -> {
			System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
			return s1.compareTo(s2);
		}).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
		System.out.println("============================================");
		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().sorted((s1, s2) -> {
			System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
			return s1.compareTo(s2);
		}).collect(Collectors.toList()).forEach(System.out::println);
		;
		;
	}
}
