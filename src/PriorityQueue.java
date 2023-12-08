import java.util.*;
class PriorityQueue{
    static class Node{
        int data;
        //Lower values indicate higher priority
        int priority;
        Node next;
    }
    //Method to Create new Node
    static Node newNode(int d, int p){
        Node temp = new Node();
        temp.data = d;
        temp.priority = p;
        temp.next = null;
        return temp;
    }
    //Return the value at head
    static int peek(Node head){
        return head.data;
    }
    //Remove element with highest priority
    static Node pop(Node head){
        Node temp = head;
        head = head.next;
        return head;
    }
    //Adding element according priority
    static Node push (Node head, int d, int p){
        Node start = head;
//create new Node
        Node temp = newNode(d, p);
        //if newNode priority is higher than head node
        if (head.priority < p){
//insert new node before head
            temp.next = head;
            head = temp;
        }
        else{
//traverse the list to find position of last node
            while(start.next != null && start.next.priority > p){
                start = start.next;
            }
            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }
    //method to check is queue empty
    static int isEmpty(Node head){
        return (head == null) ? 1 : 0;
    }
    public static void main(String [] args){
        Node pq = new Node();
        pq = push(pq,4,1);
        pq = push(pq,5,2);
        pq = push(pq,6,3);
        pq = push(pq,7,0);
        while (isEmpty(pq) == 0){
            System.out.print(peek(pq) + " ");
            pq = pop(pq);
        }
    }
}