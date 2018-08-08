package com.lyle.lambda.custom.use.predicate;

/**
 * @ClassName: MyPredicate
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年8月3日 下午11:35:37
 */
@FunctionalInterface
public interface MyPredicate<T> {

	/**
	 * 只能有一个接口
	 * @Title: test
	 * @Description:
	 * @param t
	 * @return: boolean
	 */
	boolean test(T t);
}
