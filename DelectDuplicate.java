package lecture4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * �������Ԫ��ȥ�ص����⣬һ����5�ַ�����
 * ���룺s=[7,9,3,9,2,1,7,2]
 * �����ans=[7,9,3,2,1]
 * @author Kevin
 *
 */
public class DelectDuplicate {
	/**
	 * �Լ��ϵĹ۵㴦��������⣬���ǿ���ʹ��һ��������������洢���ظ���Ԫ�ء�
	 * ʱ�临�Ӷ�O(n^2)
	 * @param s ��������
	 * @return ans ���в��ظ���Ԫ������
	 */
	public int[] solution_one(int[] s) {
		if(s.length==0) return null;
		int[] ans = new int[s.length];
		int key = 0; // ���ڴ洢��ǰ�����Ԫ��
		int k=0; // ���ڱ�ʾ���ظ�Ԫ�صĸ���
		int flag; // ���ڱ�ʾ��ǰ�������Ԫ���Ƿ��ظ����ֹ���1��ʾ�ظ����֣�0��ʾδ�ظ����֡�
		for(int i=0; i<s.length; i++) {
			key = s[i];
			flag=0;
			for(int j=0; j<k; j++) {
				if(ans[j]==key) {
					flag = 1; // ��Ԫ���Լ����ֹ�
					break;
				}
				
			}
			if(flag==0) {
				ans[k] = key; // ��ĩβ���δ�ظ���Ԫ��
				k++;
			}
		}
		
		return ans;
	}
	
	/**
	 * ��Ȼ���Լ��ϵĹ۵㴦�����ǿ���ʹ��һ��������������洢���ظ���Ԫ�أ��൱�ڽ��в�������
	 * ʱ�临�Ӷ�O(n^2)
	 * @param s ��������
	 * @return ans ���в��ظ���Ԫ������
	 */
//	public int[] solution_two(int[] s) {
//		if(s.length==0) return null;
//		int[] ans = new int[s.length];
//		int key=0;
//		int k=2; // ���ڱ�ʾ���ظ�Ԫ�صĸ���
//		int flag; // ���ڱ�ʾ��ǰ�������Ԫ���Ƿ��ظ����ֹ���1��ʾ�ظ����֣�0��ʾδ�ظ����֡�
//		ans[0] = s[0];
//		
//		for(int i=1; i<s.length; i++) {
//			key = s[i];
//			flag = 0; 
//			for(int j=1; j<k; j++) {
//				if(ans[j]==key) {
//					flag = 1; // ��Ԫ���Լ����ֹ�
//					break;
//				}
//				if(ans[j]>key) {
//					flag=0;
//				}
//				if(flag==0&&k<s.length) { // ��Ԫ��δ���ֹ�
//					int m = j-1; // j���һ��λ�õ�����
//					while(ans[m]>key) {
//						ans[m+1] = ans[m];
//						if((m--)==0) break;
//					}
//					ans[m+1]=key;
//				}
//			}
//			
//		}
//		
//		
//		return ans;
//	}
	
	
	/**
	 * ��Ȼ���Լ��ϵĹ۵㴦�����ǿ���ʹ�ú������Ϊ���ݽṹ��
	 * ʱ�临�Ӷ�O(nlogn)
	 * @param s ��������
	 * @return ans ���в��ظ���Ԫ������
	 */
	public int[] solution_three(int[] s) {
		return null;
	}
	
	/**
	 * ��Ȼ���Լ��ϵĹ۵㴦�����ǿ���ʹ��ɢ�б���Ϊ���ݽṹ��
	 * ���ʱ�临�Ӷ�O(nlogn)
	 * �ռ临�Ӷ�O(n)
	 * �ʱ�临�Ӷ�O(n^2)
	 * �ռ临�Ӷ�O(n)
	 * @param s ��������
	 * @return ans ���в��ظ���Ԫ������
	 */
	public int[] solution_four(int[] s) {
		return null;
	}
	
	
	/**
	 * ���ȶ��������ݽ�������Ԥ����Ȼ����ʹ����߽硢�ұ߽���п��ƣ�������ظ�Ԫ�ؼ������
	 * ����ʹ�õ�����߽���ƣ�����߽�Ϊl,�ұ߽�Ϊr
	 * ��ʼ��l=0,r=l+1
	 * ���s[r]==s[l]����r++
	 * ���s[r]!=s[l]����l=r����������ظ�Ԫ�ؼ������
	 * ʱ�临�Ӷ�O(nlogn)
	 * �ռ临�Ӷ�O(1)
	 * @param s ��������
	 */
	public void solution_five_one(int[] s) {
		Arrays.sort(s); //��������Ԥ����ʱ�临�Ӷ�ΪO(nlogn)
		int[] ans = new int[s.length];
		int l,r;
		// ʱ�临�Ӷ�ΪO(n)
		for(l=0; l<s.length; l=r) {
			for(r=l+1; r<s.length; r++) 
				if(s[r]!=s[l]) break;
			
			System.out.println(s[l]+" "+(r-l));
		}
		
		
		
	}
	
	
	/**
	 * ���ȶ��������ݽ�������Ԥ����Ȼ����ʹ����߽硢�ұ߽���п��ƣ�������ظ�Ԫ�ؼ������
	 * ����ʹ�õ����ұ߽���ƣ�����߽�Ϊl,�ұ߽�Ϊr
	 * ��ʼ��l=0,r=l+1
	 * ���s[r]==s[l]����r++
	 * ���s[r]!=s[l]����l=r����������ظ�Ԫ�ؼ������
	 * ʱ�临�Ӷ�O(nlogn)
	 * �ռ临�Ӷ�O(1)
	 * @param s ��������
	 */
	public void solution_five_two(int[] s) {
		Arrays.sort(s); //��������Ԥ����ʱ�临�Ӷ�ΪO(nlogn)
		int l,r;
		for(l=0,r=0; r<s.length; r++) {
			if(s[r]!=s[l]) {
				System.out.println(s[l]+" "+(r-l));
				l=r;
			}
		}
		System.out.println(s[l]+" "+(r-l)); // �������ظ�Ԫ��
	}
	
	

	
	
	
    public int[] twoSum(int[] nums, int target) {
    	// ʹ��HashMap��Ϊ���ݽṹ��
    	//����˼���ǣ��������������Ϊvalue�������ֵ��Ϊkey��
    	//Ȼ���������б��������ڵ�ǰ�����ĳ��Ԫ�أ������map�д���ʹ���뵱ǰ����Ԫ��֮��Ϊtarget�ģ�
    	//����map��value�Լ���ǰԪ�ص����������򽫵�ǰԪ�ؼ��뵽map��
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
        	int component = target - nums[i];
        	if(map.containsKey(component))
        		return new int[] {map.get(component),i};
        	map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	
	
	
	public static void main(String[] args) {
		DelectDuplicate dd = new DelectDuplicate();
		int[] s = new int[] {7,9,3,9,2,1,7,2};
		
		
		long starTime1=System.currentTimeMillis();
		System.out.println(dd.solution_one(s).toString());
		long endTime1=System.currentTimeMillis();
		long Time1=endTime1-starTime1;
		System.out.println("solution_one cost time: "+Time1+" ms");
		
//		long starTime2=System.currentTimeMillis();
//		System.out.println(dd.solution_two(s).toString());
//		long endTime2=System.currentTimeMillis();
//		long Time2=endTime2-starTime2;
//		System.out.println("solution_two cost time: "+Time2+" ms");
		
		long starTime5=System.currentTimeMillis();
		dd.solution_five_one(s);
		long endTime5=System.currentTimeMillis();
		long Time5=endTime5-starTime5;
		System.out.println("solution_five_one cost time: "+Time5+" ms");
		
		long starTime6=System.currentTimeMillis();
		dd.solution_five_two(s);
		long endTime6=System.currentTimeMillis();
		long Time6=endTime6-starTime6;
		System.out.println("solution_five_one cost time: "+Time6+" ms");
		
		
	}

}
