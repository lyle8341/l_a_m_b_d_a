package com.lyle.lambda.anonymous.innerClass.no_param;

/**
 * @ClassName: InvokeAnonymousInnerClass
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年7月10日 上午12:01:35
 */
public class InvokeAnonymousInnerClass implements AnonymousInnerClass {

	private AnonymousInnerClass innerclass;

	public InvokeAnonymousInnerClass(AnonymousInnerClass innerclass) {
		this.innerclass = innerclass;
	}

	@Override
	public void run() {
		innerclass.run();
	}
}
