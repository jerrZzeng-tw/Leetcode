package leetcode.easy;

public class MergeTwoSortedLists {

    public static void main(String[] args) throws Exception {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode list = mergeTwoLists(list1, list2);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode pre = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        pre.next = list1 == null ? list2 : list1;
        return head.next;
    }
    //    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //        ListNode result = null,master = null,branch=null;
    //        if(list1==null){
    //            return list2;
    //        }else if(list2==null){
    //            return list1;
    //        }
    //        if(list1.val<= list2.val){
    //            master = list1;
    //            branch = list2;
    //
    //        }else{
    //            master = list2;
    //            branch = list1;
    //        }
    //
    //        result = master;
    //
    //        while(branch!=null){
    //             if(master.next==null){
    //                 master.next = branch;
    //                 return result;
    //             }else{
    //                 if(master.next.val <= branch.val){
    //                     master = master.next;
    //                 }else{
    //                     ListNode temp;
    //                     temp = master.next;
    //                     master.next = branch;
    //                     branch = temp;
    //                 }
    //             }
    //        }
    //
    //    return result;
    //    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
