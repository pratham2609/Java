package com.linkedlist;

public class DoubleLinkedList {

    private Node head;
    private int size;
    private class Node{
        private int value;
        private DoubleLinkedList.Node next;
        private DoubleLinkedList.Node prev;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, DoubleLinkedList.Node next, DoubleLinkedList.Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public DoubleLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if( head != null ) head.prev = node;
        head = node;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        DoubleLinkedList.Node last = head;
        node.next = null;
        if(head == null) {
            node.prev = null;
            head =  node;
            return;

        }
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    public void insertMid(int val, int after){
        Node node = new Node(val);
        Node p = find(after);

        if ( p == null ){
            System.out.println("doesnot exist");
            return;
        }
        node.next = p.next;
        if (p.next.prev != null)
            p.next.prev = node;
        p.next = node;
        node.prev = p;

    }
    public Node find(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value) return temp;
            temp = temp.next;
        }
        return null;
    }

    public int deleteOne(int val){
        DoubleLinkedList.Node temp = head;
        int value = temp.value;
        while(temp != null){
            if(temp.value == val){
                value = temp.value;
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.prev = temp.next = null;
                return value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public int deleteOneIndex(int index){
        DoubleLinkedList.Node temp = get(index);;
        if(temp == null){
            System.out.println("not exist");
            return -1;
        }
        int value = temp.value;
        while(temp != null){
            if(temp.value == index){
                value = temp.value;
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.prev = temp.next = null;
                return value;
            }
            temp = temp.next;
        }
        return -1;
    }
    public void display(){
        DoubleLinkedList.Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void displayReverse(){
        DoubleLinkedList.Node temp = head;
        Node last = null;
        while(temp != null){
            last = temp;
            temp = temp.next;
        }
        while(last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("Start");
    }

}
