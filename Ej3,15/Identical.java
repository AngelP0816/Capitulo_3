

public class Identical {

	// Circular Linked list Node Class
	static class Node {
		int data;
		Node next;

		// Constructor
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	};

	
	static Node insertNode(Node head, Node tail, int d)
	{
		// Primera inserción en circular
		// linked list
		if (head == null) {
			Node newNode = new Node(d);
			head = newNode;
			tail = newNode;
			newNode.next = newNode;
			return newNode;
		}
		else {

			// Lista no vacía
			Node temp = new Node(d);
			temp.next = tail.next;
			tail.next = temp;
			return tail.next;
		}
	}

	static void print(Node head)
	{
		Node curr = head;

		if (head == null) {
			System.out.println("List is Empty ");
			return;
		}

		
		do {
			System.out.print(curr.data + " ");
			curr = curr.next;
		} while (curr != head);
		System.out.println();
	}

	// Función para devolver la longitud de
	// circular linked list
	static int length(Node head)
	{
		// Si circular linked list está vacío
		if (head == null) {
			return 0;
		}

		int size = 0;
		Node curr = head;

		// Else iterar hasta que el nodo NO sea head
		do {
			curr = curr.next;
			size++;
		} while (curr != head);
		return size;
	}

	// Función para comprobar que dos circular
	// linked list son idénticos o no
	static boolean checkIdentical(Node head1, Node head2)
	{
		// Obtener la longitud de la primera linked list
		int l1 = length(head1);

		// Obtener la longitud de la segunda linked list
		int l2 = length(head2);

		// Si l1!=l2 entonces linked list no puede
		// ser idéntica
		if (l1 != l2)
			return false;

		// Inicializar las variables
		int Count = 0;
		boolean flag = false;

		Node h1 = head1;
		Node h2 = head2;

		// Recorrer la lista
		while (true) {

			if (h1.data == h2.data) {
				h1 = h1.next;
				Count++;

				
				if (Count == l1)
					return true;
			}

			
			else {
				h1 = head1;
				Count = 0;

			
				if (flag)
					return false;
			}

			// Comprueba si h2 completa una rotación
			if (h2.next == head2)
				flag = true;

			// Mover h2 a h2.next
			h2 = h2.next;
		}
	}

	static Node head1, tail1, head2, tail2;

	public static void main(String[] args)
	{

		head1 = null;
		tail1 = null;

		head1 = tail1 = insertNode(head1, tail1, 1);
		tail1 = insertNode(head1, tail1, 2);
		tail1 = insertNode(head1, tail1, 3);
		tail1 = insertNode(head1, tail1, 4);
		tail1 = insertNode(head1, tail1, 5);
		tail1 = insertNode(head1, tail1, 1);
		tail1 = insertNode(head1, tail1, 2);
		tail1 = insertNode(head1, tail1, 6);

		head2 = null;
		tail2 = null;

		head2 = tail2 = insertNode(head2, tail2, 5);
		tail2 = insertNode(head2, tail2, 1);
		tail2 = insertNode(head2, tail2, 2);
		tail2 = insertNode(head2, tail2, 6);
		tail2 = insertNode(head2, tail2, 1);
		tail2 = insertNode(head2, tail2, 2);
		tail2 = insertNode(head2, tail2, 3);
		tail2 = insertNode(head2, tail2, 4);

		boolean flag = checkIdentical(head1, head2);
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
