package com.anudip.list;

//Node class for the singly linked list
class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class MiddleElement {
 public static void main(String[] args) {
     Node head = new Node(1);
     head.next = new Node(2);
     head.next.next = new Node(3);
     head.next.next.next = new Node(4);
     head.next.next.next.next = new Node(5);

     findMiddleElement(head);
 }

 // Function to find the middle element
 public static void findMiddleElement(Node head) {
     Node slow = head;
     Node fast = head;

     // Traverse the linked list using the slow and fast pointers
     while (fast!= null && fast.next!= null) {
         slow = slow.next; // Move one step at a time
         fast = fast.next.next; // Move two steps at a time
     }

     // When the fast pointer reaches the end, the slow pointer will be at the middle
     System.out.println("Middle element: " + slow.data);
 }
}