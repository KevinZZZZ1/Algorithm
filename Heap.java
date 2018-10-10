package algorithmspace;

/**
 * 这个类主要是实现堆，堆的一些操作以及堆排序
 * 以最大堆为例，堆的操作有：
 * 	创建一个最大堆;
 * 	维护堆特性;
 * 	堆中放入一个元素;
 * 	从堆中取出最大元素;
 * 	对某个节点的值进行增加;
 * 	读取最大元;
 *  堆排序;
 * @author kevin
 *
 */
public class Heap {
	private int[] heap; // 使用数组作为二叉堆的数据结构,这样类似于一个完全二叉树以数组的方式存储
	private int length; // 表示堆的大小
	/**
	 * 找到第i个结点的父节点
	 * @param i 第i个结点
	 * @return 第i个结点的父节点
	 */
	private int findParents(int i){
		
		return i/2;
	}
	/**
	 * 找到第i个结点的左孩子节点
	 * @param i 第i个结点
	 * @return 第i个结点的左孩子节点
	 */
	private int findLeftChild(int i){
		
		return i*2;
	}
	
	/**
	 * 找到第i个结点的右孩子节点
	 * @param i 第i个结点
	 * @return 第i个结点的右孩子节点
	 */
	private int findRightChild(int i){
		return i*2+1;
	}
	
	/**
	 * 读取堆中最大的元素
	 * @return 堆中最大的元素
	 */
	public int readMaxValue(){
		return this.heap[1];
	}
	
	/**
	 * 取出堆中最大元素
	 * @return 堆中最大元素
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
	 * 维护堆特性，即在堆中，除了第i个结点以外，其他的节点都保持堆特性
	 * 主要步骤是：
	 * 	将结点i的值和其左右孩子的值进行比较，找出较大值的结点进行上浮操作，结点i进行下沉操作
	 * 	依次进行，直到结点i满足堆特性或者结点i的高度为0为止
	 * 
	 * 时间复杂度为O(nlogn)
	 * @param i 表示没有满足堆特性的结点索引
	 */
	public void maintainHeap(int i){
//		this.heap[0] = this.heap[i];
//		int r = findRightChild(i);
//		while(r<this.heap.length){ // 结点i的左右孩子都存在
//			int max = i;
//			if(this.heap[max]<this.heap[r]) { // 右孩子的值更大
//				max = r;
//			}
//			if(this.heap[max]<this.heap[r-1]){ // 左孩子的值更大，r-1表示左孩子的索引
//				max = r-1; 
//			}
//			if(max==i) break; // 结点i已经满足堆特性了，跳出循环
//			
//			//交换位置
//			this.heap[i] = this.heap[max];
//			this.heap[max] = this.heap[0];
//			
//			// 将i结点位置下移
//			i = max;
//			r = 2*i+1;
//		}
//		
//		if(r==this.heap.length && this.heap[i]<this.heap[r-1]){ //只有左孩子没有右孩子的情况
//			this.heap[i] = this.heap[r-1];
//			i = r-1;
//		}
//		
//		this.heap[i] = this.heap[0];
		
		this.heap[0] = this.heap[i];
		int r = findRightChild(i);
		while(r<=this.length){ //左右孩子都存在的情况
			int max = i;
			i = sink(i);
			if(i==max) break;
		}
		if(r-1<=this.length && r>this.length){ // 只有左孩子的情况
			i = sink(i);
		}
		
		
		this.heap[i] = this.heap[0];
	}
	
	/**
	 * 对某个结点进行下沉一次操作
	 * @param i 要下沉的结点
	 */
	private int sink(int i){
		int rchild = findRightChild(i);
		if(rchild<=this.length){// 左右孩子都存在
			int max = i;
			if(this.heap[max]<this.heap[rchild]) {
				// 右孩子更大
				max = rchild;
			}
			if(this.heap[max]<this.heap[rchild-1]){
				// 左孩子更大
				max = rchild-1;
			}
			int temp = this.heap[i];
			this.heap[i] = this.heap[max];
			this.heap[max] = temp; 
			return max;
		}
		else if(rchild-1<=this.length && this.heap[i]<this.heap[rchild-1]){ // 只有左孩子
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
	 * 构造函数，也就是创建一个最大堆，时间复杂度为O(n)
	 * @param data 需要建堆的数组
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
