package com.lyle.lambda.stream.reduce;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: TestReduce
 * @Description: reduce
 * @author: Lyle
 * @date: 2018年7月16日 上午9:54:36
 */
public class TestReduce {

	public static void main(String[] args) {
		// 初始化
		List<Person> persons = Arrays.asList(new Person("Max", 28), new Person("Peter", 23), new Person("Pamela", 24),
				new Person("David", 12));
		System.out.println("===========一参");
		oneParams(persons);
		System.out.println("===========二参");
		twoParams(persons);
		System.out.println("===========三参");
		threeParams(persons);
		/**
		 * 顺序流中，组合操作不会执行的
		 */
		System.out.println("==================serialize_debug");
		serializeDebugThreeParams(persons);
		System.out.println("==================parallel_debug");
		parallelDebugThreeParams(persons);
	}

	/**
	 * @Title: oneParams
	 * @Description: 一个参数的reduce
	 * @param persons
	 * @return: void
	 */
	private static void oneParams(List<Person> persons) {
		/**
		 * 第一种能从stream元素序列中提取一个特定的元素<br>
		 * <code>Optional<T> reduce(BinaryOperator<T> accumulator);</code>
		 */
		persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2).ifPresent(System.out::println);
	}

	/**
	 * @Title: twoParams
	 * @Description: 两个参数的reduce
	 * @param persons
	 * @return: void
	 */
	private static void twoParams(List<Person> persons) {
		/**
		 * 第二种reduce操作接收一个标识值和一个二元操作累加器作为参数<br>
		 * <code>T reduce(T identity, BinaryOperator<T> accumulator);</code>
		 */
		Person result = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
			p1.age += p2.age;
			p1.name += p2.name;
			return p1;
		});
		System.out.println(result);
	}

	/**
	 * @Title: threeParams
	 * @Description: 三个参数的reduce
	 * @param persons
	 * @return: void
	 */
	private static void threeParams(List<Person> persons) {
		/**
		 * 第三种reduce方法，接收三个参数：一个标示值（identity value），一个二元操作累加器（BiFunction accumulator），一个二元组合方法<br>
		 * BinaryOperator<T> extends BiFunction<T,T,T><br>
		 * <code><U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);</code>
		 */
		Integer ageSum = persons.stream().reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
		System.out.println("threeParams: " + ageSum);
	}

	private static void serializeDebugThreeParams(List<Person> persons) {
		persons.stream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			return sum += p.age;
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});
	}

	private static void parallelDebugThreeParams(List<Person> persons) {
		persons.parallelStream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			return sum += p.age;
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});
	}
}

class Person {

	String name;

	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
