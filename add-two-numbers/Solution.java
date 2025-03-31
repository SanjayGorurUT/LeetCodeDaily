
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
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       List<Integer> lOne = new ArrayList<>();
       List<Integer> lTwo = new ArrayList<>();
       while(l1 != null) {
           lOne.add(l1.val);
           l1 = l1.next;
       }
       while(l2 != null) {
           lTwo.add(l2.val);
           l2 = l2.next;
       } 
       List<Integer> result = new ArrayList<>();
       int carryOver = 0;
       int n = lOne.size();
       int m = lTwo.size();
       while(n > m) {
           result.add(lOne.get(n - 1));
           n--;
       }
       while(m > n) {
           result.add(lTwo.get(m - 1));
           m--;
       }
       int keep = 0;
       while(n > 0) {
           keep = carryOver + lOne.get(n - 1) + lTwo.get(n - 1);
           if(keep > 10) {
               carryOver = 1;
           }
           result.add(keep % 10);
           n--;
       }
       System.out.println(result);
       return null;
   }
} {
    
}
