package com.lyle.lambda.method.reference;

/**
 * @ClassName: Supplier
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年7月15日 下午12:50:01
 */
@FunctionalInterface
public interface CustomSupplier<T> {

	T get();
}
