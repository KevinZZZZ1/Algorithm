package test;

public class Num08 {

    public int myAtoi(String str) {
    	// ����ַ���Ϊ�գ�����Ϊ���ַ���ֱ�ӷ���0
    	if(str==null||str.equals("")) return 0;
        // ��ȡȥ���ַ�����β�Ŀո�
    	String trim = str.trim();
    	// ���ȥ����β�ո��Ϊ���ַ������򷵻�0
    	if(trim.equals("")) return 0;
    	else{
    		char c = trim.charAt(0);
    		// ��ͷһ���ַ���Ϊ���š����š����֣��򷵻�0
    		if(c==45||c==43||(c<=57&&c>=48)){
    			char[] charArray = trim.toCharArray();
    			String s = "0";
    			// ��һ���ַ�Ϊ������
    			if(c==45||c==43){
    				for(int i=1; i<charArray.length; i++){
    					if(charArray[i]>=48&&charArray[i]<=57) s+=charArray[i];
    					else break;
    				}
    			}
    			//��һ���ַ�Ϊ����
    			else{
    				for(int i=0; i<charArray.length; i++){
    					if(charArray[i]>=48&&charArray[i]<=57) s+=charArray[i];
    					else break;
    				}
    			}
    			//����ַ���λ��̫�ֱ࣬�ӷ���Integer�����Сֵ
    			long ans = 0L;
    			try{
    				ans = Long.parseLong(s);
    			}catch(Exception e){
        			if(c==45&&s.length()>11) 
        				return Integer.MIN_VALUE;
        			else if(c==43&&s.length()>11)
        				return Integer.MAX_VALUE;
        			else if(s.length()>10)
        				return Integer.MAX_VALUE;
    			}
    			if(c==45) ans = -ans;
    			if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
    			else if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    			
    			return (int) ans;

    			
    		}
    		else return 0;
    		
    	}
    }
	
	public static void main(String[] args){
		String s = "-91283472332";
		Num08 n = new Num08();
		System.out.println(n.myAtoi(s));
	}
	
	
}
