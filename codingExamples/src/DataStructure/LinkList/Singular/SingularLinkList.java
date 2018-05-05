package DataStructure.LinkList.Singular;

public class SingularLinkList {
	static class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	Node head=null;
	//Print Method For printing LinkList
	public void printList(SingularLinkList sll) {
		if(sll.head == null) {
			System.out.print("List Is Empty!! ");
			return;
		}
		Node n = sll.head;
		while(n != null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	//Add At the front of the linked list
	public void prepend(int d) {
		Node new_node = new Node(d);
		new_node.next = head;
		head = new_node;
	}
	//Add node at the end of the list
	public void append(SingularLinkList sll, int d) {
		Node new_node = new Node(d);
		if(sll.head==null) {
			sll.head = new_node;
			return;
		}
		Node n = sll.head;
		while(n.next != null) {
			n = n.next;
		}
		n.next = new_node;
	}
	//Add After a node
	public void addAfter(SingularLinkList sll,int after_data,int new_data) {
		if(sll.head == null) {
			System.out.print("List Is Empty!! ");
			return;
		}
		Node new_node = new Node(new_data);
		Node n = sll.head;
		while(n.data != after_data) {
			n = n.next;
		}
		Node temp_node = n;
		new_node.next = temp_node.next;
		n.next = new_node;
	}
	//Deleting First Node of List
	public void deleteFirst(SingularLinkList sll) {
		if(sll.head == null) {
			System.out.print("List Is Empty!! ");
			return;
		}
		sll.head = sll.head.next;
		
	}
	//Delete Last Node form List
	public void deleteNode(SingularLinkList sll) {
		if(sll.head == null) {
			System.out.print("List Is Empty!! ");
			return;
		}
		Node n = sll.head;
		while(n.next.next != null) {
			n = n.next;
		}
		n.next = null;
	}
	//Delete Node after a Node form List
	public void deleteAfter(SingularLinkList sll,int after_data) {
		if(sll.head == null) {
			System.out.print("List Is Empty!! ");
			return;
		}
		Node n = sll.head;
		while(n.data != after_data) {
			n = n.next;
		}
		n.next = n.next.next;
	}
	
	public static void main(String []args) {
		SingularLinkList sll = new SingularLinkList();
		sll.head = new Node(1);
		sll.head.next = new Node(2); 
		sll.head.next.next = new Node(3);
		sll.printList(sll);
		//Prepending node to the List
		sll.prepend(4);
		System.out.println("");
		sll.printList(sll);
		//Appending node to the List
		sll.append(sll, 5);
		System.out.println("");
		sll.printList(sll);
		//Adding after a Node
		sll.addAfter(sll, 2, 6);
		System.out.println("");
		sll.printList(sll);
		//Delete First Node of the List
		sll.deleteFirst(sll);
		System.out.println("");
		sll.printList(sll);
		//Delete Last Node of the List
		sll.deleteNode(sll);
		System.out.println("");
		sll.printList(sll);
		//Delete Node After a Node
		sll.deleteAfter(sll, 2);
		System.out.println("");
		sll.printList(sll);
	}
}

