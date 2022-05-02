package leetcode;

import java.util.List;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode tmp = new ListNode(9);
		ListNode l1 = null;
		List<Integer> integers = List.of(9, 9, 9, 9, 9, 9);
		for (Integer integer : integers) {
			tmp.next = new ListNode(integer);
			if (l1 == null) {
				l1 = tmp;
			}
			tmp = tmp.next;
		}
		ListNode tmp2 = new ListNode(9);
		ListNode l2 = null;
		List<Integer> integers2 = List.of(9, 9, 9);
		for (Integer integer : integers2) {
			tmp2.next = new ListNode(integer);
			if (l2 == null) {
				l2 = tmp2;
			}
			tmp2 = tmp2.next;
		}
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode listNode = addTwoNumbers.addTwoNumbers(
				l1,
				l2
		);
		System.out.println(listNode);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int val = 0;
		ListNode sum = new ListNode(0);
		ListNode cur = sum;
		while (l1 != null || l2 != null || val != 0) {
			if (l1 != null) {
				val = val + l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				val = val + l2.val;
				l2 = l2.next;
			}
			cur.next = new ListNode(val % 10);
			cur = cur.next;
			val = val / 10;
		}
		return sum.next;
	}

	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
