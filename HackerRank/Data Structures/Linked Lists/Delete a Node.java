//https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem

    // Complete the deleteNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

        SinglyLinkedListNode cur = head;

        if(position == 0){
            return head.next;
        }
        
        int i = 0;
        while(i < position-1){
        //int i = 1;
        //while(i < position){
            cur = cur.next;
            i++;
        }

        //delete = cur.next;
        if(cur.next.next != null){
            cur.next = cur.next.next;
        }   
        return head;
    }
