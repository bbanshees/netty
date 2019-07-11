package com.spike.netty;


public class Leetcode {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static  ListNode addTwo2 (ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }



    public static void main(String[] args) {
        Leetcode leetcode = new Leetcode();

        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode a =addTwo2(listNode1,listNode4);
        System.out.println(a.val+" "+a.next.val+" "+a.next.next.val+" ");



/*        System.out.println( leetcode.addTwoNumbers(listNode3,listNode6).val + "");
            System.out.println( leetcode.addTwoNumbers(listNode2,listNode5).val + "");*/
/*
        ListNode result = addTwoNumbers(listNode1,listNode4);
        result.next = addTwoNumbers(listNode1.next,listNode4.next);
        result.next.next = addTwoNumbers(listNode1.next.next,listNode4.next.next);

        System.out.println(result.val+" "+result.val+" "+result.next.val);
        System.out.println( leetcode.addTwoNumbers(listNode1,listNode4).val + "");*/
    }



}
