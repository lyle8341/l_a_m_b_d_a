package com.lyle.lambda.stream;

import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName: ParallelStreamTest
 * @Description: TODO
 * @author: Lyle
 * @date: 2018年7月16日 下午2:19:32
 */
public class ParallelStreamTest {

	/**
	 * @Title: main
	 * @Description: 为了提高大量输入时的执行效率，stream可以采用并行的放行执行。并行流（Parallel
	 *               Streams）通过ForkJoinPool.commonPool()
	 *               方法获取一个可用的ForkJoinPool。这个ForkJoinPool使用5个线程（实际上是由底层可用的物理cpu核数决定的）。
	 *               -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());
	}
}
