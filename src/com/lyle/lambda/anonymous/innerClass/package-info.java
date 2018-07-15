/**
 * @ClassName: package-info
 * @Description: 1.函数接口，是指内部只有一个抽象方法的接口<br>
 *               2.函数接口上的@FunctionalInterface是可选的，但加上该标注编译器会帮你检查接口是否符合函数接口规范。就像加入@Override标注会检查是否重载了函数一样<br>
 *               3.函数式接口非常脆弱：只要某个开发者在该接口中添加一个函数，则该接口就不再是函数式接口进而导致编译失败。为了克服这种代码层面的脆弱性，并显式说明某个接口是函数式接口，Java8提供了一个特殊的注解@FunctionalInterface（Java库中的所有相关接口都已经带有这个注解了）<br>
 *               4.<b>默认方法和静态方法不会破坏函数式接口的定义</b>
 * @author: Lyle
 * @date: 2018年7月10日 上午12:32:10
 */
package com.lyle.lambda.anonymous.innerClass;
