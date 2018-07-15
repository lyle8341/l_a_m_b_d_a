package com.lyle.lambda.method.reference;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Phone
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年7月15日 下午12:50:35
 */
public class Car {

	public static Car make(final CustomSupplier<Car> customSupplier) {
		return customSupplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collide " + car.toString());
	}

	public void follow(final Car car) {
		System.out.println("Following the " + car.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}

	public static void main(String[] args) {
		/**
		 * 1.【构造器引用】<b>这个构造器没有参数</b> <br>
		 * 语法：Class::new或者Class<T>::new
		 */
		Car car = Car.make(Car::new);
		List<Car> cars = Arrays.asList(car);
		/**
		 * 2.【静态方法引用】<b>这个方法接受一个Car类型的参数</b><br>
		 * 语法：Class::static_method
		 */
		cars.forEach(Car::collide);
		/**
		 * 3.【类的成员方法的引用】<b>这个方法没有定义入参</b><br>
		 * 语法：Class::method
		 */
		cars.forEach(Car::repair);
		/**
		 * 4.【实例对象的成员方法的引用】<b>这个方法接受一个Car类型的参数</b><br>
		 * 语法：instance::method
		 */
		Car police = Car.make(Car::new);
		cars.forEach(police::follow);
	}
}
