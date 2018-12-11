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
		// 在MethodHandle出现之前，如果想要只改变Son类的代码从而访问GrandFather类中的thinking方法
		// 几乎是不可能的，但是在MethodHandle出现之后，我们就能做到访问GrandFather中的方法
		void thinking() {
			try {
				MethodType mt = MethodType.methodType(void.class);// 表示要分派方法的返回类型，参数
			
				//第一个参数表示方法的接收者， 第二个参数表示方法名， 第三个参数表示方法的返回类型，及方法参数，
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
