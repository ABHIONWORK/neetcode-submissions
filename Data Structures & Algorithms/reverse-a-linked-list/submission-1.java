class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextN;


        while(curr!=null){
            nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }

        return prev;
    }
}
