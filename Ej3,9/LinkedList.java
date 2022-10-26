

import java.io.*;

public class LinkedList {

	Node head; 

	
	static class Node {

		int data;
		Node next;

		// Constructor
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	
	public static LinkedList insert(LinkedList list, int data)
	{
		
		Node new_node = new Node(data);
		new_node.next = null;

		
		if (list.head == null) {
			list.head = new_node;
		}
		else {
			
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			
			last.next = new_node;
		}

		return list;
	}

	// Método para imprimir el LinkedList.
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Recorrido por la LinkedList
		while (currNode != null) {
			// Imprime los datos en el nodo actual
			System.out.print(currNode.data + " ");

			// Pasar al siguiente nodo
			currNode = currNode.next;
		}

		System.out.println();
	}

	// Método para eliminar un nodo de la LinkedList por POSICIÓN
	public static LinkedList
	deleteAtPosition(LinkedList list, int index)
	{
		// Almacenar el nodo de head
		Node currNode = list.head, prev = null;

		// CASO 1:
		

		if (index == 0 && currNode != null) {
			list.head = currNode.next; 

			// Mostrar el mensaje
			System.out.println(
				index + " posición del elemento eliminado");

			// Devuelve la lista actualizada
			return list;
		}

		// CASO 2:
		int counter = 0;

	
		while (currNode != null) {

			if (counter == index) {
				// Ya que el nodo currNode es la posición requerida
				// posición Desvincular currNode de linked list
				prev.next = currNode.next;

				// Mostrar el mensaje
				System.out.println(
					index + " posición del elemento eliminado");
				break;
			}
			else {
				// f current position is not the index
				// continúa con el siguiente nodo
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}

		


		// CASO 3:
		if (currNode == null) {
			// Mostrar el mensaje
			System.out.println(
				index + " posición del elemento eliminado");
		}

		// Devuelve la lista actualizada
		return list;
	}

	
	public static void main(String[] args)
	{
		/* Empieza con la lista vacía. */
		LinkedList list = new LinkedList();

		//
		// ******INSERCIÓN******
		//

		// Insertar los valores
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);

		// Imprime la LinkedList
		printList(list);

		//
		// ******ELIMINACIÓN EN LA POSICIÓN******
		//

		// Eliminar el nodo en la posición 0
		deleteAtPosition(list, 0);

		// Imprime la LinkedList
		printList(list);

		// Eliminar el nodo en la posición 2
		deleteAtPosition(list, 2);

		// Imprimi la LinkedList
		printList(list);

		// Eliminar el nodo en la posición 1
		deleteAtPosition(list, 10);

		// Imprime la LinkedList
		printList(list);
	}
}
