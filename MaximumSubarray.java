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
	 * ����������������������
	 * @param a ��Ҫ����������������
	 * @return ���������֮��
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
		
		System.out.println("����������Ϊ��"+max_sum+","+"��Ӧ������Ϊi��"+l+" jΪ��"+r);
		return new retValue(max_sum, l, r);
	}
	/**
	 * ���÷��η�����������������⣺
	 * �����������ڵ�λ��ֻ����һ�����������
	 * 1.��ȫλ��������A[low..mid)
	 * 2.��ȫλ��������A[mid..high)
	 * 3.��Խ���е�
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	public retValue findmaximumsubarray_two(int[] a, int low, int high){
		if((high - low)==1) return new retValue(a[low], low, high); // �������Σ�ֻ��һ��Ԫ��ʱ
		else{
			int mid = low + (high - low)/2;
			// �����������
			retValue left = findmaximumsubarray_two(a, low, mid);
			retValue right = findmaximumsubarray_two(a, mid, high);
			retValue middle = findmaxcrossingsubarray(a, low, mid, high);
			
			// ͨ���Ƚ���������ֵ��max_sum�Ĵ�С��ȷ�����������������������
			if(left.max_sum>right.max_sum && left.max_sum>middle.max_sum)
				return left;
			else if(right.max_sum>left.max_sum && right.max_sum>middle.max_sum)
				return right;
			else return middle;
			
			
		}
		
		
	}
	/**
	 * ��������е�����
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 * @return
	 */
	private retValue findmaxcrossingsubarray(int[] a, int low, int mid, int high){
		double sum=0, max_sum_left=Double.NEGATIVE_INFINITY, max_sum_right=Double.NEGATIVE_INFINITY;
		int left=0,right=0;
		// ���е���ǰһֱ����
		for(int l=mid; l>=low; l--){
			sum += a[l];
			if(Double.compare(sum, max_sum_left)>0){
				max_sum_left = sum;
				left = l;
			}
		}
		// ���е����һֱ����
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
		System.out.println("����������Ϊ��"+ret.max_sum+","+"��Ӧ������Ϊi��"+ret.l+" jΪ��"+ret.r);
	}
	
}
