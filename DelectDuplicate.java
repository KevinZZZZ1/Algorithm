package lecture4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 解决的是元素去重的问题，一共有5种方法。
 * 输入：s=[7,9,3,9,2,1,7,2]
 * 输出：ans=[7,9,3,2,1]
 * @author Kevin
 *
 */
public class DelectDuplicate {
	/**
	 * 以集合的观点处理这个问题，我们可以使用一个无序的数组来存储不重复的元素。
	 * 时间复杂度O(n^2)
	 * @param s 输入数组
	 * @return ans 所有不重复的元素数组
	 */
	public int[] solution_one(int[] s) {
		if(s.length==0) return null;
		int[] ans = new int[s.length];
		int key = 0; // 用于存储当前处理的元素
		int k=0; // 用于表示不重复元素的个数
		int flag; // 用于表示当前所处理的元素是否重复出现过：1表示重复出现；0表示未重复出现。
		for(int i=0; i<s.length; i++) {
			key = s[i];
			flag=0;
			for(int j=0; j<k; j++) {
				if(ans[j]==key) {
					flag = 1; // 该元素以及出现过
					break;
				}
				
			}
			if(flag==0) {
				ans[k] = key; // 在末尾添加未重复的元素
				k++;
			}
		}
		
		return ans;
	}
	
	/**
	 * 任然是以集合的观点处理，我们可以使用一个有序的数组来存储不重复的元素，相当于进行插入排序。
	 * 时间复杂度O(n^2)
	 * @param s 输入数组
	 * @return ans 所有不重复的元素数组
	 */
//	public int[] solution_two(int[] s) {
//		if(s.length==0) return null;
//		int[] ans = new int[s.length];
//		int key=0;
//		int k=2; // 用于表示不重复元素的个数
//		int flag; // 用于表示当前所处理的元素是否重复出现过：1表示重复出现；0表示未重复出现。
//		ans[0] = s[0];
//		
//		for(int i=1; i<s.length; i++) {
//			key = s[i];
//			flag = 0; 
//			for(int j=1; j<k; j++) {
//				if(ans[j]==key) {
//					flag = 1; // 该元素以及出现过
//					break;
//				}
//				if(ans[j]>key) {
//					flag=0;
//				}
//				if(flag==0&&k<s.length) { // 该元素未出现过
//					int m = j-1; // j左边一个位置的索引
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
	 * 任然是以集合的观点处理，我们可以使用红黑树作为数据结构。
	 * 时间复杂度O(nlogn)
	 * @param s 输入数组
	 * @return ans 所有不重复的元素数组
	 */
	public int[] solution_three(int[] s) {
		return null;
	}
	
	/**
	 * 任然是以集合的观点处理，我们可以使用散列表作为数据结构。
	 * 最佳时间复杂度O(nlogn)
	 * 空间复杂度O(n)
	 * 最坏时间复杂度O(n^2)
	 * 空间复杂度O(n)
	 * @param s 输入数组
	 * @return ans 所有不重复的元素数组
	 */
	public int[] solution_four(int[] s) {
		return null;
	}
	
	
	/**
	 * 首先对输入数据进行排序预处理，然后在使用左边界、右边界进行控制，输出不重复元素及其个数
	 * 这里使用的是左边界控制，设左边界为l,右边界为r
	 * 初始化l=0,r=l+1
	 * 如果s[r]==s[l]，则r++
	 * 如果s[r]!=s[l]，则l=r，并且输出重复元素及其个数
	 * 时间复杂度O(nlogn)
	 * 空间复杂度O(1)
	 * @param s 输入数组
	 */
	public void solution_five_one(int[] s) {
		Arrays.sort(s); //进行排序预处理，时间复杂度为O(nlogn)
		int[] ans = new int[s.length];
		int l,r;
		// 时间复杂度为O(n)
		for(l=0; l<s.length; l=r) {
			for(r=l+1; r<s.length; r++) 
				if(s[r]!=s[l]) break;
			
			System.out.println(s[l]+" "+(r-l));
		}
		
		
		
	}
	
	
	/**
	 * 首先对输入数据进行排序预处理，然后在使用左边界、右边界进行控制，输出不重复元素及其个数
	 * 这里使用的是右边界控制，设左边界为l,右边界为r
	 * 初始化l=0,r=l+1
	 * 如果s[r]==s[l]，则r++
	 * 如果s[r]!=s[l]，则l=r，并且输出重复元素及其个数
	 * 时间复杂度O(nlogn)
	 * 空间复杂度O(1)
	 * @param s 输入数组
	 */
	public void solution_five_two(int[] s) {
		Arrays.sort(s); //进行排序预处理，时间复杂度为O(nlogn)
		int l,r;
		for(l=0,r=0; r<s.length; r++) {
			if(s[r]!=s[l]) {
				System.out.println(s[l]+" "+(r-l));
				l=r;
			}
		}
		System.out.println(s[l]+" "+(r-l)); // 输出最后不重复元素
	}
	
	

	
	
	
    public int[] twoSum(int[] nums, int target) {
    	// 使用HashMap作为数据结构，
    	//基本思想是：把数组的索引作为value，数组的值作为key，
    	//然后对数组进行遍历，对于当前处理的某个元素，如果在map中存在使得与当前处理元素之和为target的，
    	//返回map的value以及当前元素的索引，否则将当前元素加入到map中
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
