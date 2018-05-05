package DataStructure.LinkList.Singular;

import java.util.HashSet;

import DataStructure.LinkList.Singular.SingularLinkList.Node;

public class SingularLinkListOpt {
	int frequency = 0;
	//Searching element into the LinkList Recursively
	public boolean searchRec(Node head, int data) {
		if(head == null) {
			return false;
		}
		
		if(head.data == data) {
			return true;
		}
		return searchRec(head.next,data);
	}
	//Swap nodes in a linked list without swapping data
	public void swapNodes(SingularLinkList sll, int x, int y) {
		//Same Node can't be swap
		if(x == y)
			return;
		//Searching For x
		Node prevX = null, currX = sll.head;
		while(currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}
		//Searching For y
		Node prevY = null, currY = sll.head;
		while(currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}
		//One of them not in List Can't be swap
		if(currX == null || currY == null)
			return;
		
		// If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            sll.head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
        	 sll.head = currX;
        
		// Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
	}
	//Print the middle of a given linked list
	public void printMiddle(SingularLinkList sll) {
		Node firstPtr = sll.head;
		Node secPtr = sll.head;
		while(secPtr != null) {
			firstPtr = firstPtr.next; 
			secPtr = secPtr.next.next;
		}
		System.out.println("Middle Element of List: "+firstPtr.data);
	}
	//Nth node from the end of a Linked List
	//Time Complexity: O(n) where n is the length of linked list.
	public void NthFromLast(SingularLinkList sll, int n) {
		Node firstPtr = sll.head;
		Node secPtr = sll.head;
		int count = 0;
		while(count < n) {
			if(secPtr == null) {
				System.out.println(n+" is greater than the no of nodes in the list");
				return;
			}
			secPtr = secPtr.next;
			count++;
		}
		while(secPtr != null) {
			firstPtr = firstPtr.next;
			secPtr = secPtr.next;
		}
		System.out.println(n+" node from the Last is: "+firstPtr.data);
	}
	
	//counts the number of times a given int occurs in a Linked List
	//Time Complexity: O(n)
	public int occurenceCount(Node head,int data) {
		
		if(head == null)
			return frequency;
		
		if(head.data == data) 
			frequency++;
		return occurenceCount(head.next,data);
	}
	/* Reverse a linked list 
	 * Time Complexity: O(n)
	   Space Complexity: O(1)
	*/
	public Node reverseList(Node sll) {
		Node pre = null;
		Node current = sll;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = pre;
			pre = current ;
			current = next;
		}
		sll = pre;
		return sll;
	}
	public Node reverseListRec(Node current, Node pre, Node next) {
		if(current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
			reverseListRec(current,pre,next);
		}
		return pre;
	}
	/* Merge two sorted linked lists */
	public void sortedMerge() {
		
	}
	//check if a singly linked list is palindrome
		public boolean isPalindrome(SingularLinkList sll){
			boolean flag = false;
			Node firstPtr = sll.head;
			Node secondPtr = sll.head;
			while(firstPtr.next != null) {
				firstPtr = firstPtr.next.next;
				secondPtr = secondPtr.next;
			}
			firstPtr = sll.head;
			sll.head = secondPtr.next;
//			reverseList(sll);
			Node reversePtr = sll.head;
			while(reversePtr != null) {
				flag = false;
				if(firstPtr.data == reversePtr.data)
					flag = true;
				firstPtr = firstPtr.next;
				reversePtr = reversePtr.next;
			}
			return flag;
		}
	/*Remove duplicates from a sorted linked list
	 * Time Complexity: O(n) where n is number of nodes in the given linked list.
	 */
	public void removeDuplicatesSorted(Node head) {
		Node node = head;
		if(head == null) {
			System.out.println("List is Emplty!!");
			return;
		}
		while(node.next != null) {
			if(node.data == node.next.data) {
				node.next =  node.next.next;
				node = head;
			}else
				node = node.next;
		}
	}
	
	/*Remove duplicates from a unsorted linked list Using Hashing
	 * Time Complexity: O(n) on average (assuming that hash table access time is O(1) on average).
	 */
	public void removeDuplicates(Node head) {
		if(head == null) {
			System.out.println("List is Emplty!!");
			return;
		}
		Node current = head;
		Node pre = null;
		HashSet<Integer> hs = new HashSet<>();
		
		while(current != null) {
			if(hs.contains(current.data)) {
				pre.next = current.next;
//				current = current.next.next;
			}else {
				hs.add(current.data);
				pre = current;
				
			}
			current = current.next;
		}
	}
	public Node duplicatesBtwLists(Node firstList, Node secondList) {
		SingularLinkList dNodeList = new SingularLinkList();
		HashSet<Integer> hs = new HashSet<>();
		if(firstList == null || secondList == null){
			System.out.println("List is Emplty!!");
			return null;
		}
		while(firstList != null) {
			hs.add(firstList.data);
			firstList = firstList.next;
		}
		while(secondList != null) {
			if(hs.contains(secondList.data))
				dNodeList.append(dNodeList, secondList.data);
			secondList = secondList.next;
		}
		return dNodeList.head;
	}
}

class TestSingularLinkListOpt{
	public static void main(String []args) {
		SingularLinkList sll = new SingularLinkList();
		SingularLinkListOpt sllOpt = new SingularLinkListOpt();
		sll.append(sll,11);
		sll.append(sll,12);
		sll.append(sll,15);
		sll.append(sll,21);
		sll.append(sll,9);
		sll.append(sll,12);
		sll.printList(sll);
		System.out.println();
		System.out.print("Data in the List:: "+sllOpt.searchRec(sll.head.next,21));
		
		SingularLinkList sll1 = new SingularLinkList();
		SingularLinkList sll2 = new SingularLinkList();
		SingularLinkList sll3 = new SingularLinkList();
		sll1.append(sll1,30);
		sll1.append(sll1,10);
		sll1.append(sll1,5);
		sll1.append(sll1,15);
		sll1.append(sll1,30);
		
		sll2.append(sll2,2);
		sll2.append(sll2,3);
		sll2.append(sll2,30);
		
		sll3.append(sll3,11);
		sll3.append(sll3,11);
		sll3.append(sll3,11);
		sll3.append(sll3,12);
		sll3.append(sll3,13);
		sll3.append(sll3,13);
		
		//Swapping Nodes
		System.out.print("\nBefore Swaping:: ");
		sll.printList(sll);
		sllOpt.swapNodes(sll, 9, 15);
		System.out.print("\nAfter Swaping:: ");
		sll.printList(sll);
		
		//Middle of a list
		System.out.println();
		sllOpt.printMiddle(sll);
		
		//node from the Last
		sll.printList(sll);
		System.out.println();
		sllOpt.NthFromLast(sll,3);
		
		//Occurrence of element in List
		System.out.print("occurenceCount in the List:: "+sllOpt.occurenceCount(sll.head,12));
		
		//Reverse a linked list
		sll.head=sllOpt.reverseList(sll.head);
		System.out.print("\n  test    Reversed linked list:: ");
		sll.printList(sll);
		
		System.out.println("\nisPalindrome:: "+sllOpt.isPalindrome(sll1));
		
		//Reverse a linked list Recursively
//		sllOpt.reverseListRec(sll.head, null, null);
//		sll.printList(sll);
		System.out.print("Sorted List with Duplicate Nodes:: ");
		sll.printList(sll3);
		sllOpt.removeDuplicatesSorted(sll3.head);
		System.out.print("\nAfter Removing Duplicate Nodes:: ");
		sll.printList(sll3);
		
		sll3.append(sll3,12);
		sll3.append(sll3,9);
		sll3.append(sll3,9);
		System.out.print("\nUnsorted List with Duplicate Nodes:: ");
		sll.printList(sll3);
		sllOpt.removeDuplicates(sll3.head);
		System.out.print("\nAfter Removing Duplicate Nodes:: ");
		sll.printList(sll3);
		System.out.print("\nAfter Removing Duplicate Form Two List:: ");
		sll.printList(sllOpt.duplicatesBtwLists(sll2.head, sll2.head));
		}
}
