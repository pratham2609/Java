package com.linkedlist;


public class Main {
    public static void main(String[] args) {
        // generic type of linkedlist
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(34);


        // calling other class of linkedlist
        LinkedList list = new LinkedList();
        list.insertFirst(3);
        list.insertFirst(18);
        list.insertFirst(26);
        list.insertLast(100);
        list.display();
    }
}
