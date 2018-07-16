package com.lyle.lambda.base64;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @ClassName: Base64Test
 * @Description: Base64
 * @author: Lyle
 * @date: 2018年7月15日 下午2:33:13
 */
public class Base64Test {

	public static void main(String[] args) {
		//
		String result = Base64.getEncoder()
				.encodeToString("https://www.siknut.com/God_bless_you".getBytes(Charset.forName("UTF-8")));
		System.out.println("编码结果[基本]：" + result);
		byte[] decode = Base64.getDecoder().decode(result);
		System.out.println("解码还原：" + new String(decode, Charset.forName("UTF-8")));
		String resultUrl = Base64.getUrlEncoder()
				.encodeToString("https://www.siknut.com/God_bless_you".getBytes(Charset.forName("UTF-8")));
		System.out.println("编码结果[url]：" + resultUrl);
		String resultMIME = Base64.getMimeEncoder()
				.encodeToString("https://www.siknut.com/God_bless_you".getBytes(Charset.forName("UTF-8")));
		System.out.println("编码结果[MIME]:" + resultMIME);
	}
}
