package com.lyle.lambda.map.doubleColon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * @ClassName: Main
 * @Description:
 * @author: Lyle
 * @date: 2018年8月1日 下午11:26:33
 */
public class Main {

	public static void main(String[] args) {
		List<User> list = initUser();
		double_colon_new(list);
	}

	/**
	 * @Title: double_colon_new
	 * @Description: 测试Class[]::new
	 * @param list
	 * @return: void
	 */
	private static void double_colon_new(List<User> list) {
		List<String> collect = list.stream().map(user -> user.getName()).collect(Collectors.toList());
		System.out.println("user->user.getName: " + collect);
		List<String> collect2 = list.stream().map(User::getName).collect(Collectors.toList());
		System.out.println("User::getName: " + collect2 + "\r\n" + "\r\n");
		String[] array2 = list.stream().map(User::getName).toArray(String[]::new);
		System.out.println("1.String[]::new ====>");
		throughArray(array2);
		// =======================等同
		String[] array = list.stream().map(User::getName).toArray(size -> new String[size]);
		System.out.println("2.size->new String[size] ====> ");
		throughArray(array);
		System.out.println("3.new IntFunction<String[]>() {} ====> ");
		String[] array3 = list.stream().map(User::getName).toArray(new IntFunction<String[]>() {

			@Override
			public String[] apply(int size) {
				return new String[size];
			}
		});
		throughArray(array3);
		System.out.println("4.function() ====> ");
		String[] array4 = list.stream().map(User::getName).toArray(function());
		throughArray(array4);
	}

	private static IntFunction<String[]> function() {
		return new IntFunction<String[]>() {

			@Override
			public String[] apply(int value) {
				return new String[value];
			}
		};
	}

	/**
	 * @Title: throughArray
	 * @Description: 遍历数组
	 * @param array3
	 * @return: void
	 */
	private static void throughArray(String[] array3) {
		for (String s : array3) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

	/**
	 * @Title: initUser
	 * @Description: 初始化集合
	 * @return: List<User>
	 */
	private static List<User> initUser() {
		User u1 = new User();
		u1.setAge(10);
		u1.setName("红孩儿");
		u1.setSex("男");
		User u2 = new User();
		u2.setAge(30);
		u2.setName("唐僧");
		u2.setSex("男");
		User u3 = new User();
		u3.setAge(15);
		u3.setName("白骨精");
		u3.setSex("女");
		User u4 = new User();
		u4.setAge(60);
		u4.setName("东海龙王");
		u4.setSex("男");
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		return list;
	}
}
