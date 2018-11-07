package leetcode;

public class Num65 {
	
    public static boolean isNumber(String s) {
        
        //[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
        
    	
    	//ȥ��ǰ��Ŀո�
        s = s.trim();
        
        boolean pointSeen = false; // ��ʾ��ǰ���ַ��Ѿ����ֹ�С����
        boolean eSeen = false; // ��ʾ��ǰ���ַ��Ѿ����ֹ�e
        boolean numberSeen = false; // ��ʾ��ǰ���ַ��Ѿ����ֹ�����
        boolean numberAfterE = true; // ��ʾe֮���Ƿ�������
        
        for(int i=0; i<s.length(); i++) {// �����ַ�����ÿ���ַ���s.charAt(i)
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') { // ����������
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) { // �����С������e��������Լ����ֹ�С��������
                    return false; // �ǿ϶�����Valid Number
                }
                pointSeen = true; // ���ֹ�С����
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) { // �ڸ�e֮ǰ���ֹ�e����֮ǰû�����ֳ���
                    return false;
                }
                numberAfterE = false; //
                eSeen = true; // e����
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') { // "-"��"+"ֻ�ܳ�������ǰ��e�ĺ���
                    return false;
                }
            } else {
                return false; // ���������ַ�
            }
        }

        return numberSeen && numberAfterE;
        
        
    }
	
	
	public static void main(String[] args) {
		
		String test = " 99e2.5 ";
		
		boolean isNumber = isNumber(test);
		
	}

}
