package com.linkedlist;

public class Main {
    public static void main(String[] args) {
        // generic type of linkedlist
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(34);


        // calling other class of linkedlist
        LinkedList list = new LinkedList();

//        DoubleLinkedList list = new DoubleLinkedList();

//        CircularLinkedList list = new CircularLinkedList();
//        list.insertFirst(3);
//        list.insertFirst(18);
//        list.insertFirst(26);
//        list.insertFirst(50);
//        list.insertFirst(19);
//        list.insertLast(200);
//        list.insertLast(100);

//        list.insertMid(69, 20);

//        list.display();

        list.insertRecursion(8, 0);
        list.insertRecursion(9, 0);
        list.insertRecursion(10, 0);
        list.insertRecursion(7, 1);
//        list.delete(50);
        list.display();
//        list.displayReverse();
//        int val = list.deleteFirst();
//        System.out.println(val);
//        list.display();

//        System.out.println(list.deleteLast());

//        System.out.println(list.deleteOne(200));

//        System.out.println(list.find(200));
    }
}
