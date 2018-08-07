
import Jama.Matrix;

/**
 * 关于解决fibonacci序列的算法，一共有5种。
 * fibonacci序列：f0=0,f1=1,f2=1......fn=fn-1+fn-2;
 * @author Kevin
 *
 */
public class Fibonacci {
	
	/**
	 * 使用定义进行暴力递归
	 * @param n
	 * @return fn
	 */
	public long solution_one(int n) {
		if(n==0) return 0L;
		if(n==1) return 1L;
		return solution_one(n-1)+solution_one(n-2);
	}
	
	/**
	 * 在solution_one的基础上进行改进，不重复计算已经计算过的值，而且使用数组作为该方法的数据结构
	 * @param n
	 * @return fn
	 */
	public long solution_two(int n) {
		if(n==0) return 0L;
		if(n==1) return 1L;
		long[] a = new long[n+1];
		a[0] = 0L;
		a[1] = 1L;
		for(int i=2; i<a.length; i++) {
			a[i] = a[i-1] + a[i-2];
		}
		return a[n];
	}
	
	/**
	 * 在solution_two的基础上进行改进，没必要把从f0到fn的所有值都保存下来，只要纪录fn-2,fn-1,fn即可
	 * @param n
	 * @return fn
	 */
	public long solution_three(int n) {
		if(n==0) return 0L;
		if(n==1) return 1L;
		long[] a = new long[3];
		a[0] = 0L;
		a[1] = 1L;
		for(int i=2; i<=n; i++) {
			a[2] = a[0] + a[1];
			a[0] = a[1];
			a[1] = a[2];
		}
		
		return a[2];
	}
	
	
	/**
	 * 在solution_three的基础上，使用线型代数中矩阵的知识进行求解
	 * [fn+1, fn].T = A*[fn, fn-1].T 其中A=[[1,1],[1,0]]
	 * 实际上A^n=[[fn+1,fn],[fn,fn-1]],这个时候在使用递归求解
	 * @param n
	 * @return [[fn+1,fn],[fn,fn-1]]
	 */
	public double[][] solution_four(int n) {
		if(n==0||n==1) return (new double[][] {{1,1},{1,0}});
		Matrix ans = new Matrix(new double[2][2]);
		Matrix a = new Matrix(new double[][] {{1,1},{1,0}});
		if(n%2==0) {
			// n为偶数的情况
			Matrix left = new Matrix(solution_four(n/2));
			Matrix right = new Matrix(solution_four(n/2));
			ans = left.times(right);
		}else {
			// n为奇数的情况
			Matrix left = new Matrix(solution_four(n/2));
			Matrix right = new Matrix(solution_four(n/2));
			ans = left.times(right).times(a);
		}
		
		return ans.getArray();
	}

	/**
	 * 在solution_four的基础上进行优化，由于solution_four中返回的一个矩阵，经过很多次运算，所以要进行简化
	 * A^2m = A^m * A^m
	 * A^m=[[fm+1,fm],[fm,fm-1]]
	 * f2m+1 = fm+1^2 + fm^2
	 * f2m = fm+1*fm + fm*fm-1
	 * 然后再使用递归的方法求解
	 * @param n
	 * @return[fn+1,fn]
	 */
	public double[] solution_five(int n) {
 		if(n==0) return new double[] {1,0};
		double[] ans = new double[2];
		if(n%2==0) {
			// n为偶数的情况
			// 
			double[] temp = solution_five(n/2);
			ans[0] = Math.pow(temp[0], 2) + Math.pow(temp[1], 2);
			ans[1] = (2*temp[0] - temp[1])*temp[1];
		}else {
			// n为奇数的情况
			double[] temp = solution_five(n/2);
			ans[0] = (2*temp[1] + temp[0])*temp[0];
			ans[1] = Math.pow(temp[0], 2) + Math.pow(temp[1], 2);
			
		}
		
		
		return ans;
	}
	
	
	
	public static void main(String[] args) {
		
		Fibonacci f = new Fibonacci();
		
		long starTime1=System.currentTimeMillis();
		System.out.println(f.solution_one(40));
		long endTime1=System.currentTimeMillis();
		long Time1=endTime1-starTime1;
		System.out.println("solution_one cost time: "+Time1+" ms");
		
		
		long starTime2=System.currentTimeMillis();
		System.out.println(f.solution_two(40));
		long endTime2=System.currentTimeMillis();
		long Time2=endTime2-starTime2;
		System.out.println("solution_two cost time: "+Time2+" ms");
		
		
		long starTime3=System.currentTimeMillis();
		System.out.println(f.solution_three(40));
		long endTime3=System.currentTimeMillis();
		long Time3=endTime3-starTime3;
		System.out.println("solution_three cost time: "+Time3+" ms");
		
		long starTime4=System.currentTimeMillis();
		System.out.println(f.solution_four(40)[0][1]);
		long endTime4=System.currentTimeMillis();
		long Time4=endTime4-starTime4;
		System.out.println("solution_four cost time: "+Time4+" ms");
		

		long starTime5=System.currentTimeMillis();
		System.out.println(f.solution_five(40)[1]);
		long endTime5=System.currentTimeMillis();
		long Time5=endTime5-starTime5;
		System.out.println("solution_five cost time: "+Time5+" ms");
		
	}

}
