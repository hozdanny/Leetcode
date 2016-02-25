package Solution;

public class S002_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carrier = 0;
		ListNode head = new ListNode(0);
		ListNode curNode = head;
		/*
		 * 需要考虑到的情况
		 * 1. 两个list的长度不想等
		 * 2. carrier 最后进位
		 * 
		 */
		while (l1 != null || l2 != null || carrier != 0) {
			int sum = carrier;
			if (l1 != null) {
				sum = sum + l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum = sum + l2.val;
				l2 = l2.next;
			}
			carrier = sum / 10;
			ListNode node = new ListNode(sum % 10);
			curNode.next = node;
			curNode = curNode.next;
		}
		return head.next;
	}

	// test
	public static void main(String[] args) {
		S002_AddTwoNumbers addTwoNumbers = new S002_AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);

		ListNode head = addTwoNumbers.addTwoNumbers(l1, l2);

		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}