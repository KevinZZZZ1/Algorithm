package chapter8;

import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
	
	
	class GrandFather{
		void thinking() {
			System.out.println("i am grandfather");
		}
	}
	
	class Father extends GrandFather{
		void thinking() {
			System.out.println("i am father");
		}
	}
	
	class Son extends Father{
		// ��MethodHandle����֮ǰ�������Ҫֻ�ı�Son��Ĵ���Ӷ�����GrandFather���е�thinking����
		// �����ǲ����ܵģ�������MethodHandle����֮�����Ǿ�����������GrandFather�еķ���
		void thinking() {
			try {
				MethodType mt = MethodType.methodType(void.class);// ��ʾҪ���ɷ����ķ������ͣ�����
			
				//��һ��������ʾ�����Ľ����ߣ� �ڶ���������ʾ�������� ������������ʾ�����ķ������ͣ�������������
				MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
				mh.invoke(this);
			}catch(Throwable e) {
				
			}
		}
	}

	public static void main(String[] args) {
		(new MethodHandleTest().new Son()).thinking();
	}
	
	
}
