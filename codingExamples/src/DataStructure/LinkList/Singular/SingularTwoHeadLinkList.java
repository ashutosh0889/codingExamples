package DataStructure.LinkList.Singular;

import java.util.HashSet;

import DataStructure.LinkList.Singular.SingularLinkList.Node;

public class SingularTwoHeadLinkList {
	static class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	Node head1=null, head2=null;
	//Add node at the end of the list
		public void append(Node head, int d) {
			Node new_node = new Node(d);
			if(head==null) {
				head = new_node;
				return;
			}
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = new_node;
		}
		//Intersection point of two Linked Lists.
				public Node intersectPointOfTwoList(Node first, Node second) {
					HashSet<Node> nodeSet = new HashSet<Node>();
					while(first != null) {
						nodeSet.add(first);
						first = first.next;
					}
					while(second != null) {
						if(nodeSet.contains(second))
							return second;
						second = second.next;
					}
					return null;
				}
}
class TestSingularTwoHeadLinkList{
	public static void main(String []args) {
		SingularTwoHeadLinkList list = new SingularTwoHeadLinkList();
		//First List
		list.append(list.head1, 18);
		list.append(list.head1, 20);
		list.append(list.head1, 22);
		list.append(list.head1, 30);
		
		//Second List
		list.append(list.head2, 10);
		list.append(list.head2, 15);
		list.append(list.head2, 30);
		System.out.println("\nintersectPointOfTwoList:: "+list.intersectPointOfTwoList(list.head1,list.head2));
	}
}
