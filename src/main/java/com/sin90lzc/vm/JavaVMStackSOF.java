package com.sin90lzc.vm;

/**
 * 测试单线程虚拟机栈溢出
 * 如果是由于单个线程在申请栈帧造成的栈溢出，都是报java.lang.StackOverflowError
 * 
 * VM args:-Xss128k
 * @author Tim
 *
 */
public class JavaVMStackSOF {
	private int stackLength=1;
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack length:"+ oom.stackLength);
			throw e;
		}
	}
}
