package LeetCode;

/**
 * Created by coco on 17/3/4.
 */
public class No234PalindromeList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode reverse = new ListNode(head.val);

        int size = 0;
        ListNode headR = head;
        while(headR.next!=null){
            ListNode temp = new ListNode(headR.next.val);
            temp.next = reverse;
            reverse = temp;
            headR = headR.next;
            size++;
        }
        System.out.println(size);
        for(int i=0;i<(size+1)/2;i++){
            if(head.val!=reverse.val)
                return false;
            else{
                head = head.next;
                reverse = reverse.next;
            }
        }
        return true;
    }
    public void display(ListNode head){
        while(head!=null){
            System.out.print(head.val+"---");
            head = head.next;
        }
        System.out.println();
    }
    public void test(){
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        display(head);
        System.out.println(isPalindrome(head));
    }

    public static void main(String[] args){
        No234PalindromeList palindromeList = new No234PalindromeList();
        palindromeList.test();

    }
}
