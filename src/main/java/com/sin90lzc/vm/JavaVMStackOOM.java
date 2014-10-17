package com.sin90lzc.vm;

/**
 * 测试线程过多造成的内存溢出
 * 每个线程在申请虚拟机栈时，都会分配一个虚拟机栈，如果线程数过多，造成内存耗尽，会报java.lang.OutOfMemoryError:unable to create native thread
 * VM Args:-Xss2M
 * @author Tim
 *
 */
public class JavaVMStackOOM {
	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread=new Thread(new Runnable(){
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom=new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
