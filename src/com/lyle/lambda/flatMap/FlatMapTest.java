package com.lyle.lambda.flatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: FlatMapTest
 * @Description: 把几个小的list转换到一个大的list。
 * @author: Lyle
 * @date: 2018年7月16日 下午2:38:30
 */
public class FlatMapTest {

	public static void main(String[] args) {
		List<String> 秦 = Arrays.asList("秦穆公", "秦孝公", "秦始皇", "秦二世");
		List<String> 汉 = Arrays.asList("刘邦", "刘彻");
		List<String> 唐 = Arrays.asList("李渊", "李世民");
		List<String> 宋 = Arrays.asList("赵匡胤", "赵匡义");
		List<String> 元 = Arrays.asList("成吉思汗", "忽必烈");
		List<String> 明 = Arrays.asList("朱元璋", "朱棣");
		List<List<String>> 中国皇帝 = new ArrayList<>();
		中国皇帝.add(秦);
		中国皇帝.add(汉);
		中国皇帝.add(唐);
		中国皇帝.add(宋);
		中国皇帝.add(元);
		中国皇帝.add(明);
		//
		中国皇帝.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList()).forEach(System.out::println);
	}
}
