package LeetCode;

/**
 * Created by coco on 17/3/5.
 */
public class No206_ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode isPalindrome(ListNode head) {

        if(head==null)
            return null;
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

        return reverse;
    }
}
