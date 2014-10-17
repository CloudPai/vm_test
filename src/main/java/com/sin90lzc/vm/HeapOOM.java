package com.sin90lzc.vm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ����java���ڴ����
 * ͨ���۲�JvisualVM�����Է�����������Eden�ﵽһ����ֵʱ��������������գ�
 * ���Ѵ���������survior0��survior1�������ڶ�Σ�������vm����-XX:MaxTenuringThreshold������
 * ���պ󣬻�Ѵ�������������������������һ����ֵʱ�������һ��full gc��
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author Tim
 *
 */
public class HeapOOM {
	static class OOMObject{
		private long a=new Long(200);

		public long getA() {
			return a;
		}

		public void setA(long a) {
			this.a = a;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		List<OOMObject> list=new ArrayList<OOMObject>();
		int count=0;
		while(count<100000){
			list.add(new OOMObject());
			TimeUnit.MILLISECONDS.sleep(10);
		}
		System.out.println(list.size());
	}
}
