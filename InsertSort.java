package lecture5;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
/**
 * 插入排序，增量技术的典型
 * 最坏时间复杂度O(n^2)，最好时间复杂度O(n)，平均时间复杂度O(n^2)
 * @author Kevin
 *
 */
public class InsertSort {

	public void insert_sort(int[] v) {
		for(int i=1; i<v.length; i++) {
			int key = v[i];
			int j = i-1;
			while(v[j]>key) {
				v[j+1] = v[j];
				if((j--)==0) break;
			}
			v[j+1] = key;
		}	
		
	}
	
	
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		Random r = new Random();
		IntStream ints = r.ints(100000);
		
		int[] t = ints.toArray();
		long starTime1=System.currentTimeMillis();
		is.insert_sort(t);
		long endTime1=System.currentTimeMillis();
		long Time1=endTime1-starTime1;
		System.out.println("insert sort total cost time is "+ Time1+"ms");
		
		long starTime2=System.currentTimeMillis();
		Arrays.sort(t);
		long endTime2=System.currentTimeMillis();
		long Time2=endTime2-starTime2;
		System.out.println("quick sort total cost time is "+ Time2+"ms");
		
	}

}
