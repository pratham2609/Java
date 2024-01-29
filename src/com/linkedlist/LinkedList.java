package com.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;

    private int size;
    public LinkedList(){
        this.size = 0;
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

    public void insertLast(int val){
        Node node = new Node(val);

        // next to head
        tail.next = node;

        // changing position of head
        tail = node;

        // if it is the first element
        if(head == null) head = tail;
        size += 1;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
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
}
