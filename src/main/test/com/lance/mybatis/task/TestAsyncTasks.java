package com.lance.mybatis.task;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lance.mybatis.Application;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestAsyncTasks {

	// @Autowired
	// private AsyncTasks1 task1;

	@Autowired
	private AsyncTasks2 task2;

	@Test
	public void test() throws Exception {

		// task1.doTaskOne();
		// task1.doTaskTwo();
		// task1.doTaskThree();

		long start = System.currentTimeMillis();

		Future<String> task_1 = task2.doTaskOne();
		Future<String> task_2 = task2.doTaskTwo();
		Future<String> task_3 = task2.doTaskThree();

		while (true) {
			if (task_1.isDone() && task_2.isDone() && task_3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}

}
