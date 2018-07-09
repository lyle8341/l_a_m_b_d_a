package com.lyle.lambda.anonymous.innerClass.has_param;

/**
 * @ClassName: Test
 * @Description:
 * @author: Lyle
 * @date: 2018年7月9日 下午11:59:40
 */
public class Test {

	public static void main(String[] args) {
		// 第一种
		new InvokeAnonymousInnerClass(new AnonymousInnerClass() {

			@Override
			public void run(String name) {
				System.out.println(name);
			}
		}).run("川普老中医");
		// 第二种 接口只能有一个方法
		new InvokeAnonymousInnerClass((name) -> {
			System.out.println(name);
		}).run("专治吹牛逼");
	}
}
