package com.sin90lzc.vm;

/**
 * �����̹߳�����ɵ��ڴ����
 * ÿ���߳������������ջʱ���������һ�������ջ������߳������࣬����ڴ�ľ����ᱨjava.lang.OutOfMemoryError:unable to create native thread
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
