package test;

import java.util.Stack;

/**
 * 在不使用其他数据结构的基础上，仅使用栈和递归实现对栈中元素的逆序
 * 为了解决这个问题我们需要两个函数：
 * 	E getAndRemoveLastElement(Stack<E> s):这个函数是获得并移除栈底的元素；
 * 	void reverse(Stack<E> s):这个函数是完成栈中元素逆序的功能；
 * @author Kevin
 *
 */
public class StackReverse {

	private static int getAndRemoveElement(Stack<Integer> s) {
		int result = s.pop();
		if(s.isEmpty()) return result; // 如果弹出一个元素后，栈为空的话，说明弹出的元素就是栈底元素
		else {
			int last = getAndRemoveElement(s); // 用于纪录栈底元素
			s.push(result); // 将非栈底元素重新压入栈
			return last;
		}
		
	}
	
	public static void reverse(Stack<Integer> s) {
		if(s.isEmpty())
			return;
		int i = getAndRemoveElement(s); // 获得栈底元素
		reverse(s); // 递归调用，使得原先在栈中后出现的元素，先被压入栈中
		s.push(i); // 将后出现的元素先压入栈，实现栈元素的逆序
	}
	
	
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		reverse(s);
		for(int a: s)
			System.out.println(a);
		
		
	}
	
	
}
