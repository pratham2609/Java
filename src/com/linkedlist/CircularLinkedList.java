package com.linkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int size;
    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public Node find(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        if( head == null ) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int val){
        Node node = head;
        if( node == null ) return;

        if(node.value == val){
            head = head.next;
            tail = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }
    public void display(){
        Node temp = head;
        if ( head != null ){
            do{
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while(temp != head);
        }
        System.out.println("Head");
    }
}
