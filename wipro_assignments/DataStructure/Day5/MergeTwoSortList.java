package com.anudip.Graph4;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class AssignmentD5 {

	public ListNode merge(ListNode head1, ListNode head2) {

		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.val > head2.val) {
			ListNode temp = head1;
			head1 = head2;
			head2 = temp;
		}

		ListNode current1 = head1;
		ListNode current2 = head2;
		ListNode prev1 = null;

		while (current1 != null && current2 != null) {

			while (current1 != null && current1.val <= current2.val) {
				prev1 = current1;
				current1 = current1.next;
			}

			if (prev1 != null) {
				prev1.next = current2;
			}

			ListNode temp = current1;
			current1 = current2;
			current2 = temp;
		}

		return head1;
	}

	public void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		AssignmentD5 merger = new AssignmentD5();

		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);

		ListNode merged1 = merger.merge(head1, head2);
		System.out.println("Merged List 1:");
		merger.printList(merged1);

		ListNode head3 = new ListNode(1);
		head3.next = new ListNode(2);
		head3.next.next = new ListNode(4);

		ListNode head4 = new ListNode(1);
		head4.next = new ListNode(3);
		head4.next.next = new ListNode(4);

		ListNode merged2 = merger.merge(head3, head4);
		System.out.println("Merged List 2:");
		merger.printList(merged2);
	}
}
