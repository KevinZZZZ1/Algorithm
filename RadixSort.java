package lecture19;


/**
 * 基数排序的实现：
 * 基数排序也很简单，对于n个d位的数来说，从最低位开始对n个数进行排序，重复进行d次；
 * 对于n个数的排序一定要选用具有稳定性的排序，比如之前实现的计数排序；
 * 进一步，我们可以分析出基数排序的时间复杂度:
 * 由于每个计数排序是对n个[0,k]范围的数进行排序，所以时间复杂度为O(n+k),而这个过程要重复d次,所以总的时间复杂度为O(d(n+k))
 * @author Kevin
 *
 */
public class RadixSort {

	public static void radixSort(int[] a, int d) {
	    int n=1;//代表位数对应的数：1,10,100...
	    int k=0;//保存每一位排序后的结果用于下一位的排序输入
	    int length=a.length;
	    int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
	    int[] order=new int[length];//用于保存每个桶里有多少个数字
	    while(n<d){
	        for(int num:a) {//将数组array里的每个数字放在相应的桶里
	            int digit=(num/n)%10;
	            bucket[digit][order[digit]]=num;
	            order[digit]++;
	        }
	        for(int i=0;i<length;i++){//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
	        	
	            if(order[i]!=0){//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
	                for(int j=0;j<order[i];j++){
	                    a[k]=bucket[i][j];
	                    k++;
	                }
	            }
	            order[i]=0;//将桶里计数器置0，用于下一次位排序
	        }
	        n*=10;
	        k=0;//将k置0，用于下一轮保存位排序结果
	    }
	}
	
	
	
	public static void main(String[] args) {
		int[] A=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
	    radixSort(A, 100);
	    for(int num:A){
	        System.out.println(num);
	    }
		
	}

}
