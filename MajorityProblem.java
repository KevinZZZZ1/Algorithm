package algorithmspace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 解决的是寻找一个数组中过半数的问题，（过半数是指该元素出现的次数超过数组长度的一半）
 * 这个问题的思路大概有两个方向，
 * 1.先对元素进行排序，再进行下一个操作
 * 2.通过纸笔演算归纳出一个规律：在一个数组中，如果将非过半数元素和过半数元素相抵消（也就是
 * 非过半元素和过半元素同时去掉一个），那么不会影响数组中过半数元素的选择；
 * 如果将两个非过半数相抵消，那么更不会影响数组中过半数的选择。
 * @author kevin
 *
 */
public class MajorityProblem {
	
	
	/**
	 * 
	 * @param input 有序数组
	 * @return HashMap<元素值, 出现次数>
	 */
	private HashMap<Integer, Integer> findDuplicate(int[] input){
		// 用一个hashmap来存储元素以及其出现的次数
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
	 * 第一种方法是：先对输入进行排序，在使用类似于元素去重的办法来解决，
	 * 具体来说就是，输出每个元素出现的次数，比较其是否大于数组长度的一半
	 * @param input 
	 * @return 数组input的过半数，若输出Integer.MIN_VALUE表示不存在
	 */
	public int findMajority_one(int[] input){
		Arrays.sort(input); // 对输入进行排序
		
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
	 * 还有一种方法是，先对输入数组进行排序，根据过半数的性质可知，长度为n的数组的中间位置，
	 * 即input[n/2]一定是在过半数组成的区间里的。所以我们可以利用这个性质，从中间位置起，
	 * 根据元素值是否相同，向左、右延展，再判断这个区间的大小
	 * @param input
	 * @return 数组input的过半数，若输出Integer.MIN_VALUE表示不存在
	 */
	public int findMajority_two(int[] input){
		int ans = Integer.MIN_VALUE;
		Arrays.sort(input);
		int standard = input.length/2;
		int mid = input[standard];
		// 采用左开右开的区间格式
		int i=standard, j=standard;
		while(i>=0&&j<input.length){
			if(input[i]==mid) i--;
			if(input[j]==mid) j++;
			
		}
		//ans = j-i-1// 个数
		if(j-i-1>standard)
			ans = input[i+1];
		return ans;
	}
	
	
	/**
	 * 第二种方法是：创建一个容器来存放所有的过半数，对于数组中的每个元素来说，
	 * 如果当前处理元素和容器中的元素值相同，则将该元素放入容器中，并将容器元素个数加1
	 * 如果当前处理元素和容器中的元素值不同，则从容器中取出一个过半数“抵消”当前处理的元素，并将容器中元素数减1
	 * @param input
	 * @return 数组input的过半数，若输出Integer.MIN_VALUE表示不存在
	 * 时间复杂度为O(n)
	 */
	public int findMajority_three(int[] input){
		int ans = Integer.MIN_VALUE;
		int standard = input.length/2;
		int count = 0, i=0;
		int majority = Integer.MIN_VALUE;
		// 遍历数组
		for(;i<input.length;i++){
			// 容器中没有元素
			if(count==0){ 
				majority=input[i];
				count++;
			}
			else if(majority==input[i]) count++;
			else count--; // 抵消操作
		}
		
		if(count==0) 
			return ans;
		else{
			count = 0;
			for(int a:input)
				if(majority==a) count++;
			if(count>standard) // 判断是否满足过半数的条件
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
