/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    static class PairComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode a , ListNode b){
            return a.val - b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new PairComparator());
        for(ListNode node : lists){
            if(node!=null){
                pq.offer(node);
            }
        }


        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            tmp.next = smallest;
            tmp = tmp.next;

            if(smallest.next!=null){
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}
