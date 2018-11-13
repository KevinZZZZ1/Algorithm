package leetcode;

public class Num02 {

	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0); // Ҫ���ص�List
        ListNode pre = null; // ��¼ǰһ�����
        while(l1!=null || l2!=null || carry!=0){ // 
            int l1_val = l1==null?0:l1.val; // �ж�
            int l2_val = l2==null?0:l2.val;
            int val = (l1_val+l2_val+carry)%10; // ����ֵ
            carry = (l1_val+l2_val+carry)/10; // �����λ

            
            if(pre==null){ // ��ͷ�����в�����pre == null ��ʾ��ǰ���ڴ���res���
                res.val = val;
                pre = res;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
                
            ListNode cur = new ListNode(val); // ׼������res�Ľ��
            pre.next = cur;
            pre = cur; 
            // ���l1,l2���Ϊ��,�򲻽��к��Ʋ���
            if(l1!=null) {
	            l1 = l1.next;
            }
            if(l2!=null) {
            	l2 = l2.next;
            }
        }
        
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		
		
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		
		addTwoNumbers(l1, l2);
		
	}

}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
