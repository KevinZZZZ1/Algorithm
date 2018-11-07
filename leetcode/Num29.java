package leetcode;

public class Num29 {
	
    public static int divide(int dividend, int divisor) {
        if(divisor == 0) 
            return -1;
        
        
        
        long ans=0;
        long abs_dividend,abs_divisor; // 选用long类型，方便溢出处理
        abs_dividend = Math.abs((long)dividend); // 取得被除数的绝对值
        abs_divisor = Math.abs((long)divisor); // 取得除数的绝对值
        
        if(abs_dividend == 0 || abs_dividend<abs_divisor)
            return 0;
        
//        if(abs_divisor!=1){ // 除数不为1
//            // 先不考虑符号，直接进行除法
//            while(abs_dividend>=abs_divisor){ // 这种方法正确性没有问题，但是超时了...
//                ans++;
//                abs_dividend = abs_dividend - abs_divisor;
//            }
//        }else{
//            ans = abs_dividend;
//        }
//        
        
        if(abs_divisor!=1){ // 除数不为1
            // 先不考虑符号，直接进行除法，这里改进了上面的方法，由于被除数abs_dividend=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
            long sum; // 纪录abs_divisor*2^n(n=0,1,2,...)
            while (abs_divisor <= abs_dividend) {
                sum = abs_divisor;
                int count = 1;
                while (sum + sum <= abs_dividend) { // 纪录下最大的abs_divisor*2^count
                    count += count;
                    sum += sum;
                }
                abs_dividend = abs_dividend - sum;
                ans = ans + count;
            }
        }else{
            ans = abs_dividend;
        }
        


    
        // 对符号进行判断
        if((dividend>0)&&(divisor<0) || (dividend<0)&&(divisor>0)) //异号
            ans = -ans;
        
        // 溢出情况判断
        if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE) return Integer.MAX_VALUE;
        
        return (int)ans;
    }
	
    public static void main(String[] args) {
    	int a = 26;
    	int b = 3;
    	
    	System.out.println(divide(a, b));
    	
    	
    	
    }
    
}
