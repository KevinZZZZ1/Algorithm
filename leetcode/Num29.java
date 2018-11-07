package leetcode;

public class Num29 {
	
    public static int divide(int dividend, int divisor) {
        if(divisor == 0) 
            return -1;
        
        
        
        long ans=0;
        long abs_dividend,abs_divisor; // ѡ��long���ͣ������������
        abs_dividend = Math.abs((long)dividend); // ȡ�ñ������ľ���ֵ
        abs_divisor = Math.abs((long)divisor); // ȡ�ó����ľ���ֵ
        
        if(abs_dividend == 0 || abs_dividend<abs_divisor)
            return 0;
        
//        if(abs_divisor!=1){ // ������Ϊ1
//            // �Ȳ����Ƿ��ţ�ֱ�ӽ��г���
//            while(abs_dividend>=abs_divisor){ // ���ַ�����ȷ��û�����⣬���ǳ�ʱ��...
//                ans++;
//                abs_dividend = abs_dividend - abs_divisor;
//            }
//        }else{
//            ans = abs_dividend;
//        }
//        
        
        if(abs_divisor!=1){ // ������Ϊ1
            // �Ȳ����Ƿ��ţ�ֱ�ӽ��г���������Ľ�������ķ��������ڱ�����abs_dividend=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
            long sum; // ��¼abs_divisor*2^n(n=0,1,2,...)
            while (abs_divisor <= abs_dividend) {
                sum = abs_divisor;
                int count = 1;
                while (sum + sum <= abs_dividend) { // ��¼������abs_divisor*2^count
                    count += count;
                    sum += sum;
                }
                abs_dividend = abs_dividend - sum;
                ans = ans + count;
            }
        }else{
            ans = abs_dividend;
        }
        


    
        // �Է��Ž����ж�
        if((dividend>0)&&(divisor<0) || (dividend<0)&&(divisor>0)) //���
            ans = -ans;
        
        // �������ж�
        if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE) return Integer.MAX_VALUE;
        
        return (int)ans;
    }
	
    public static void main(String[] args) {
    	int a = 26;
    	int b = 3;
    	
    	System.out.println(divide(a, b));
    	
    	
    	
    }
    
}
