package algorithmspace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * �������Ѱ��һ�������й����������⣬����������ָ��Ԫ�س��ֵĴ����������鳤�ȵ�һ�룩
 * ��������˼·�������������
 * 1.�ȶ�Ԫ�ؽ��������ٽ�����һ������
 * 2.ͨ��ֽ��������ɳ�һ�����ɣ���һ�������У�������ǹ�����Ԫ�غ͹�����Ԫ���������Ҳ����
 * �ǹ���Ԫ�غ͹���Ԫ��ͬʱȥ��һ��������ô����Ӱ�������й�����Ԫ�ص�ѡ��
 * ����������ǹ��������������ô������Ӱ�������й�������ѡ��
 * @author kevin
 *
 */
public class MajorityProblem {
	
	
	/**
	 * 
	 * @param input ��������
	 * @return HashMap<Ԫ��ֵ, ���ִ���>
	 */
	private HashMap<Integer, Integer> findDuplicate(int[] input){
		// ��һ��hashmap���洢Ԫ���Լ�����ֵĴ���
		HashMap<Integer, Integer> map = new HashMap<>();
		int l,r;
		for(l=0; l<input.length; l=r){
			for(r=l+1; r<input.length; r++){
				if(input[r]!=input[l]) break; 
			}
			map.put(input[l], r-l);
		}
		
		return map;
	}
	
	/**
	 * ��һ�ַ����ǣ��ȶ��������������ʹ��������Ԫ��ȥ�صİ취�������
	 * ������˵���ǣ����ÿ��Ԫ�س��ֵĴ������Ƚ����Ƿ�������鳤�ȵ�һ��
	 * @param input 
	 * @return ����input�Ĺ������������Integer.MIN_VALUE��ʾ������
	 */
	public int findMajority_one(int[] input){
		Arrays.sort(input); // �������������
		
		HashMap<Integer, Integer> findDuplicate = findDuplicate(input);
		int standard = input.length/2;
		int ans = Integer.MIN_VALUE;
		for(Map.Entry<Integer, Integer> entry:findDuplicate.entrySet()){
			if(entry.getValue()>standard) {
				ans = entry.getKey();
				break;
			}
		}
		
		return ans;
	}
	
	/**
	 * ����һ�ַ����ǣ��ȶ���������������򣬸��ݹ����������ʿ�֪������Ϊn��������м�λ�ã�
	 * ��input[n/2]һ�����ڹ�������ɵ�������ġ��������ǿ�������������ʣ����м�λ����
	 * ����Ԫ��ֵ�Ƿ���ͬ����������չ�����ж��������Ĵ�С
	 * @param input
	 * @return ����input�Ĺ������������Integer.MIN_VALUE��ʾ������
	 */
	public int findMajority_two(int[] input){
		int ans = Integer.MIN_VALUE;
		Arrays.sort(input);
		int standard = input.length/2;
		int mid = input[standard];
		// �������ҿ��������ʽ
		int i=standard, j=standard;
		while(i>=0&&j<input.length){
			if(input[i]==mid) i--;
			if(input[j]==mid) j++;
			
		}
		//ans = j-i-1// ����
		if(j-i-1>standard)
			ans = input[i+1];
		return ans;
	}
	
	
	/**
	 * �ڶ��ַ����ǣ�����һ��������������еĹ����������������е�ÿ��Ԫ����˵��
	 * �����ǰ����Ԫ�غ������е�Ԫ��ֵ��ͬ���򽫸�Ԫ�ط��������У���������Ԫ�ظ�����1
	 * �����ǰ����Ԫ�غ������е�Ԫ��ֵ��ͬ�����������ȡ��һ������������������ǰ�����Ԫ�أ�����������Ԫ������1
	 * @param input
	 * @return ����input�Ĺ������������Integer.MIN_VALUE��ʾ������
	 * ʱ�临�Ӷ�ΪO(n)
	 */
	public int findMajority_three(int[] input){
		int ans = Integer.MIN_VALUE;
		int standard = input.length/2;
		int count = 0, i=0;
		int majority = Integer.MIN_VALUE;
		// ��������
		for(;i<input.length;i++){
			// ������û��Ԫ��
			if(count==0){ 
				majority=input[i];
				count++;
			}
			else if(majority==input[i]) count++;
			else count--; // ��������
		}
		
		if(count==0) 
			return ans;
		else{
			count = 0;
			for(int a:input)
				if(majority==a) count++;
			if(count>standard) // �ж��Ƿ����������������
				ans = majority;
			return ans;
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		MajorityProblem m = new MajorityProblem();
		int[] a = new int[]{1,4,4,4,2,3,4};
		int findMajority = m.findMajority_three(a);
		System.out.println(findMajority);
	}

}
