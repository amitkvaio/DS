package acom.single;

public class Util {
	public static void displayList(Node head) {
		int count = 0;
		if (head == null) {
			System.out.println("There is no nodes are present in the given linked list!!!");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
			count++;
			if (count > 37)
				break;
		}
		System.out.print("Null\n");
	}
}
