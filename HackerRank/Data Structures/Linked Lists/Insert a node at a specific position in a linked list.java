    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
            SinglyLinkedListNode insert = new SinglyLinkedListNode(data);
            SinglyLinkedListNode positionNode = head;
            //1. 찾기
            int i = 0;
            while(i<position-1){
                positionNode = positionNode.next;
                i++;
            }
            //2. 넣기 - 새로운 것의 next를 원래있던거 넣어주고 next 변경 작업
            insert.next = positionNode.next;
            positionNode.next = insert;

            return head;
    }
