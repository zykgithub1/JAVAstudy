package com.sxt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//模拟龟兔赛跑
public class Racer2 implements Callable<Integer>{
	private String winner;

	@Override
	public Integer call() throws Exception{
		for(int steps=1;steps<=100;steps++) {
			if(Thread.currentThread().getName().equals("pool-1-thread-1")&&steps%10==0) {
				Thread.sleep(100);
			}
			System.out.println(Thread.currentThread().getName()+"---->"+steps);
			boolean flag=gameOver(steps);
			if(flag) {
				return steps;
			}
		}
		return null;
	}
	private boolean gameOver(int steps) {
		if(winner!=null) {
			return true;
		}else {
			if(steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("胜利者是-----》"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Racer2 racer=new Racer2();
		ExecutorService ser=Executors.newFixedThreadPool(2);
		Future<Integer> results1=ser.submit(racer);
		Future<Integer> results2=ser.submit(racer);
		Integer r1=results1.get();
		Integer r2=results2.get();
		System.out.println(r1+"--->"+r2);
		ser.shutdown();
	}

}
