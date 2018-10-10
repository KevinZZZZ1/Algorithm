package algorithmspace;

/**
 * �������Ҫ��ʵ�ֶѣ��ѵ�һЩ�����Լ�������
 * ������Ϊ�����ѵĲ����У�
 * 	����һ������;
 * 	ά��������;
 * 	���з���һ��Ԫ��;
 * 	�Ӷ���ȡ�����Ԫ��;
 * 	��ĳ���ڵ��ֵ��������;
 * 	��ȡ���Ԫ;
 *  ������;
 * @author kevin
 *
 */
public class Heap {
	private int[] heap; // ʹ��������Ϊ����ѵ����ݽṹ,����������һ����ȫ������������ķ�ʽ�洢
	private int length; // ��ʾ�ѵĴ�С
	/**
	 * �ҵ���i�����ĸ��ڵ�
	 * @param i ��i�����
	 * @return ��i�����ĸ��ڵ�
	 */
	private int findParents(int i){
		
		return i/2;
	}
	/**
	 * �ҵ���i���������ӽڵ�
	 * @param i ��i�����
	 * @return ��i���������ӽڵ�
	 */
	private int findLeftChild(int i){
		
		return i*2;
	}
	
	/**
	 * �ҵ���i�������Һ��ӽڵ�
	 * @param i ��i�����
	 * @return ��i�������Һ��ӽڵ�
	 */
	private int findRightChild(int i){
		return i*2+1;
	}
	
	/**
	 * ��ȡ��������Ԫ��
	 * @return ��������Ԫ��
	 */
	public int readMaxValue(){
		return this.heap[1];
	}
	
	/**
	 * ȡ���������Ԫ��
	 * @return �������Ԫ��
	 */
	public int getMaxValue(){
		int max = this.heap[1];
		this.heap[1] = this.heap[this.length];
		this.heap[this.length] = Integer.MIN_VALUE;
		length--;
		maintainHeap(1);
		return max;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void put(int value){
		this.heap[++this.length] = value;
		int i = this.length;
		while(i>0){
			int max = i;
			i = swim(i);
			if(max == i) break;
		}
	}
	
	/**
	 * 
	 */
	public void heapSort(){
		while(this.length>0){
			int n = length;
			int max = getMaxValue();
			this.heap[n] = max;
		}
		
	}
	
	/**
	 * ά�������ԣ����ڶ��У����˵�i��������⣬�����Ľڵ㶼���ֶ�����
	 * ��Ҫ�����ǣ�
	 * 	�����i��ֵ�������Һ��ӵ�ֵ���бȽϣ��ҳ��ϴ�ֵ�Ľ������ϸ����������i�����³�����
	 * 	���ν��У�ֱ�����i��������Ի��߽��i�ĸ߶�Ϊ0Ϊֹ
	 * 
	 * ʱ�临�Ӷ�ΪO(nlogn)
	 * @param i ��ʾû����������ԵĽ������
	 */
	public void maintainHeap(int i){
//		this.heap[0] = this.heap[i];
//		int r = findRightChild(i);
//		while(r<this.heap.length){ // ���i�����Һ��Ӷ�����
//			int max = i;
//			if(this.heap[max]<this.heap[r]) { // �Һ��ӵ�ֵ����
//				max = r;
//			}
//			if(this.heap[max]<this.heap[r-1]){ // ���ӵ�ֵ����r-1��ʾ���ӵ�����
//				max = r-1; 
//			}
//			if(max==i) break; // ���i�Ѿ�����������ˣ�����ѭ��
//			
//			//����λ��
//			this.heap[i] = this.heap[max];
//			this.heap[max] = this.heap[0];
//			
//			// ��i���λ������
//			i = max;
//			r = 2*i+1;
//		}
//		
//		if(r==this.heap.length && this.heap[i]<this.heap[r-1]){ //ֻ������û���Һ��ӵ����
//			this.heap[i] = this.heap[r-1];
//			i = r-1;
//		}
//		
//		this.heap[i] = this.heap[0];
		
		this.heap[0] = this.heap[i];
		int r = findRightChild(i);
		while(r<=this.length){ //���Һ��Ӷ����ڵ����
			int max = i;
			i = sink(i);
			if(i==max) break;
		}
		if(r-1<=this.length && r>this.length){ // ֻ�����ӵ����
			i = sink(i);
		}
		
		
		this.heap[i] = this.heap[0];
	}
	
	/**
	 * ��ĳ���������³�һ�β���
	 * @param i Ҫ�³��Ľ��
	 */
	private int sink(int i){
		int rchild = findRightChild(i);
		if(rchild<=this.length){// ���Һ��Ӷ�����
			int max = i;
			if(this.heap[max]<this.heap[rchild]) {
				// �Һ��Ӹ���
				max = rchild;
			}
			if(this.heap[max]<this.heap[rchild-1]){
				// ���Ӹ���
				max = rchild-1;
			}
			int temp = this.heap[i];
			this.heap[i] = this.heap[max];
			this.heap[max] = temp; 
			return max;
		}
		else if(rchild-1<=this.length && this.heap[i]<this.heap[rchild-1]){ // ֻ������
			int temp = this.heap[i];
			this.heap[i] = this.heap[rchild-1];
			this.heap[rchild-1] = temp; 
			i = rchild-1;
			return i;
		}
		return i;
	} 
	
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	private int swim(int i){
		int parents = findParents(i);
		if(this.heap[parents]<this.heap[i]) {
			int temp = this.heap[i];
			this.heap[i] = this.heap[parents];
			this.heap[parents] = temp;
			i = parents;
		}
		return i;
	}
	
	/**
	 * ���캯����Ҳ���Ǵ���һ�����ѣ�ʱ�临�Ӷ�ΪO(n)
	 * @param data ��Ҫ���ѵ�����
	 */
	public Heap(int[] data) {
		
		this.heap = new int[2*data.length];
		this.heap[0] = 0;

		this.length = data.length;
		for(int i=1; i<data.length; i++){
			heap[i] = data[i-1];
		}
		this.heap[data.length+1] = data[data.length];
		for(int n=data.length/2; n>0; n--){
			if(this.heap[n]>this.heap[n/2]) swim(n);
		}
		

	}
	
	
	
	public static void main(String[] args) {
		int[] test = new int[]{4,1,3,2,16,9,10,14,8,7};
		Heap h = new Heap(test);
//		//h.maintainHeap(2);
//		h.put(15);
//		h.heapSort();
//		System.out.println("---------");
		for(int i: h.heap)
			System.out.println(i+" ");
	}
	
	
}
