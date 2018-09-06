package test;

public class MaximumSubarray {
	
	private class retValue{
		double max_sum;
		int l;
		int r;
		public retValue(double max_sum, int l, int r) {
			this.max_sum = max_sum;
			this.l = l;
			this.r = r;
		}
	}
	
	/**
	 * 蛮力法求解最大子数组问题
	 * @param a 需要求最大子数组的数组
	 * @return 最大子数组之和
	 */
	public retValue findmaximumsubarray_one(int[] a){
		double sum=0, max_sum=Double.NEGATIVE_INFINITY;
		int l=0, r=0;
		for(int low=0; low<a.length; low++){
			sum=0;
			for(int high=low; high<a.length; high++){
				sum += a[high];
				if(Double.compare(sum, max_sum)>0){
					max_sum = sum;
					l = low;
					r = high;
				}
			}
		}
		
		System.out.println("最大子数组和为："+max_sum+","+"对应的索引为i："+l+" j为："+r);
		return new retValue(max_sum, l, r);
	}
	/**
	 * 利用分治法处理最大子数组问题：
	 * 最大子数组存在的位置只能有一下三种情况：
	 * 1.完全位于子数组A[low..mid)
	 * 2.完全位于子数组A[mid..high)
	 * 3.跨越了中点
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	public retValue findmaximumsubarray_two(int[] a, int low, int high){
		if((high - low)==1) return new retValue(a[low], low, high); // 基础情形，只有一个元素时
		else{
			int mid = low + (high - low)/2;
			// 处理三种情况
			retValue left = findmaximumsubarray_two(a, low, mid);
			retValue right = findmaximumsubarray_two(a, mid, high);
			retValue middle = findmaxcrossingsubarray(a, low, mid, high);
			
			// 通过比较三个返回值中max_sum的大小来确定最大子数组存在于哪种情况
			if(left.max_sum>right.max_sum && left.max_sum>middle.max_sum)
				return left;
			else if(right.max_sum>left.max_sum && right.max_sum>middle.max_sum)
				return right;
			else return middle;
			
			
		}
		
		
	}
	/**
	 * 处理跨域中点的情况
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 * @return
	 */
	private retValue findmaxcrossingsubarray(int[] a, int low, int mid, int high){
		double sum=0, max_sum_left=Double.NEGATIVE_INFINITY, max_sum_right=Double.NEGATIVE_INFINITY;
		int left=0,right=0;
		// 从中点向前一直考察
		for(int l=mid; l>=low; l--){
			sum += a[l];
			if(Double.compare(sum, max_sum_left)>0){
				max_sum_left = sum;
				left = l;
			}
		}
		// 从中点向后一直考察
		sum = 0;
		for(int r=mid+1; r<high; r++){
			sum += a[r];
			if(Double.compare(sum, max_sum_right)>0){
				max_sum_right = sum;
				right = r;
			}
		}
		return new retValue((max_sum_left+max_sum_right), left, right);
	}
	
	
	
	public static void main(String args[]){
		MaximumSubarray m = new MaximumSubarray();
		int[] a = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		m.findmaximumsubarray_one(a);
		retValue ret = m.findmaximumsubarray_two(a, 0, a.length);
		System.out.println("最大子数组和为："+ret.max_sum+","+"对应的索引为i："+ret.l+" j为："+ret.r);
	}
	
}
