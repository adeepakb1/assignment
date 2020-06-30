package com.assignment.assignment.API;

public class Main {

    public static void main(String[] args) {

        LinkedListNode l =
                new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode
                        (4, null))));


        LinkedListNode current = l, next= null, prev=null;

        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        l=prev;
        while(l!=null){
            System.out.println(l.value);
            l=l.next;
        }
    }





}


class LinkedList {
    public LinkedListNode head;

    public LinkedList(LinkedListNode head) {
        this.head = head;
    }
}

class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value, LinkedListNode next) {
        this.value = value;
        this.next = next;
    }
}
