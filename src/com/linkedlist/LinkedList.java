package com.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;

    private int size;
    public LinkedList(){
        this.size = 0;
    }

    private class Node{
        private int value;
        private  Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);

        // next to head
        node.next = head;

        // changing position of head
        head = node;

        // if it is the first element
        if(tail == null) tail = head;
        size += 1;
    }

    public void insertRecursion(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){ // remaining indexes
            Node temp = new Node(val, node);
            size ++;
            return temp;
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        // changing position of head
        tail = node;
        // if it is the first element
        size += 1;
    }

    public void insertMid(int val, int index) {
        if (index == 0){
            insertFirst(val);
        return;
    }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        int count = 0;
        // go till one index before
        while(count != index - 1){
            temp = temp.next;
            count ++;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size += 1;

    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null) tail = null;
        size--;
        return val;
    }

    // value of a node
    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int deleteLast(){
        if(size <= 1) return deleteFirst();
        Node temp = get(size - 2);
        int val = tail.value;

        tail = temp;

        tail.next = null;
        return val;
    }

    public int deleteOne(int index){
        if(index == 0){
            return deleteFirst();
        }
        else if( index == size -1 ){
            return deleteLast();
        }

        Node prev = get(index - 1);

        int val = prev.next.value;

        prev.next = prev.next.next;

        return val;
    }

    public Node find(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value) return temp;
            temp = temp.next;
        }
        return null;
    }


    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    // questions
    public void duplicates(){
        Node temp = head;
        while(temp.next != null){
            // to check that node.next is null or not
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
                size --;
            }
            else temp = temp.next;
        }
        tail = temp;
        tail.next = null;
    }

    // merge two linked lists

    public static LinkedList merge(LinkedList first , LinkedList second){
        Node f = first.head;
        Node s = second.head;
        LinkedList ans = new LinkedList();
        while( f != null && s != null){
            if(f.value <= s.value){
                ans.insertLast(f.value);
                f = f.next;
            }
            else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while ( f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while ( s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }



    // cycle in linked list
    public boolean hasCycle(Node head) {
            Node fast = head;
            Node slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) return true;
            }
            return false;
    }

    // length of cycle

    public int lengthCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                // calculate length
                Node temp = slow;
                int length = 0;

                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        int length = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = lengthCycle(head);
                break;
            };
        }
        if(length == 0) return  null;

        // find the start
        Node f = head;
        Node s = head;
        while(length > 0){
            s = s.next;
            length--;
        }
        // keep moving both forward and they will neet at cycle start
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }


    // Happy number Google
//    https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        // linked list cycle
        int slow = n;
        int fast = n;
        do{
            slow = square(slow); // move one step
            fast = square(square(fast)); // move 2 steps
        }while(slow != fast);
        if(slow == 1){
            return true;
        }
        return false;
    }
    private int square(int n){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += rem * rem;
            n = n / 10;
        }
        return ans;
    }



    // middle of linked list using 2 pointers also
    // by the time the fast reaches end slow will be at half

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    // bubble sort
    public void bubbleSort(){
        bubbleSort(size - 1, 0);

    }
    private void bubbleSort(int row, int col){
        if(row == 0) return;

        if(col < row){
            Node first = get(col);
            Node second = get(col + 1);
            if(first.value > second.value){
                // swap
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if(second == tail){
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                     first.next = null;
                     second.next = tail;
                } else{
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else{
            bubbleSort(row - 1, 0);
        }
    }



    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertFirst(1);
        list1.insertFirst(3);
        list1.insertFirst(10);
        list1.insertFirst(5);
        list1.insertLast(11);

//        LinkedList list2 = new LinkedList();
//        list2.insertFirst(1);
//        list2.insertFirst(2);
//        list2.insertFirst(9);
//        list2.insertFirst(14);

//        LinkedList ans = LinkedList.merge(list1,list2);
//        ans.display();

        list1.bubbleSort();

        list1.display();
    }

}


