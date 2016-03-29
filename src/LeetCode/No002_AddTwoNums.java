package LeetCode;

/**
 * Created by Coco on 2016/3/29.
 */
public class No002_AddTwoNums {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode head = null;
        int remain=0;
        int times = 0;
        while (l1!=null||l2!=null){
            int a,b;
            if(l1==null)
                a = 0;
            else a = l1.val;
            if(l2==null)
                b = 0;
            else b = l2.val;
            //System.out.println("Plus:"+a+"+"+b);


            ListNode node = new ListNode((a+b+remain)%10);
            node.next = null;
            remain = (a+b+remain)/10;
            if(times == 0) {
                head = node;
                resultNode = head;
                times = -1;
            }else {
                resultNode.next = node;
                resultNode = node;
            }
            if(l1!=null)
                l1= l1.next;
            if(l2!=null)
                l2 = l2.next;
            //System.out.println("After:"+l1+"and"+l2);

        }
        if(remain!=0){
            ListNode node2 = new ListNode((remain));
            node2.next = null;
            resultNode.next = node2;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(6);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(7);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(2);
        //System.out.println("NodePlus:"+node1.val+"+"+node2.val);

        ListNode node = new No002_AddTwoNums().addTwoNumbers(node1, node2);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }

    }
}
