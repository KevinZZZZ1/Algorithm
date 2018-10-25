package test;

import java.util.Stack;

/**
 * �ڲ�ʹ���������ݽṹ�Ļ����ϣ���ʹ��ջ�͵ݹ�ʵ�ֶ�ջ��Ԫ�ص�����
 * Ϊ�˽���������������Ҫ����������
 * 	E getAndRemoveLastElement(Stack<E> s):��������ǻ�ò��Ƴ�ջ�׵�Ԫ�أ�
 * 	void reverse(Stack<E> s):������������ջ��Ԫ������Ĺ��ܣ�
 * @author Kevin
 *
 */
public class StackReverse {

	private static int getAndRemoveElement(Stack<Integer> s) {
		int result = s.pop();
		if(s.isEmpty()) return result; // �������һ��Ԫ�غ�ջΪ�յĻ���˵��������Ԫ�ؾ���ջ��Ԫ��
		else {
			int last = getAndRemoveElement(s); // ���ڼ�¼ջ��Ԫ��
			s.push(result); // ����ջ��Ԫ������ѹ��ջ
			return last;
		}
		
	}
	
	public static void reverse(Stack<Integer> s) {
		if(s.isEmpty())
			return;
		int i = getAndRemoveElement(s); // ���ջ��Ԫ��
		reverse(s); // �ݹ���ã�ʹ��ԭ����ջ�к���ֵ�Ԫ�أ��ȱ�ѹ��ջ��
		s.push(i); // ������ֵ�Ԫ����ѹ��ջ��ʵ��ջԪ�ص�����
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
