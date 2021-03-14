/**
 * Class: CMSC204 
 * Instructor: Alexander
 * Description: This program 
 * Due: 3/13/2021
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Andrew Cudd  
 * @author Andrew Cudd
*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	protected int size;
	protected Node front, back;

	public BasicDoubleLinkedList() {
		size = 0;
		front = back = null;
	}

	// Adds an element to the end of the list
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node temp = new Node(data, null, back);
		if (back != null) {
			back.after = temp;
		}
		back = temp;
		if (front == null) {
			front = temp;
		}
		size++;
		return this;
	}

	// Adds element to the front of the list
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node temp = new Node(data, front, null);
		if (front != null) {
			front.before = temp;
		}
		front = temp;
		if (back == null) {
			back = temp;
		}
		size++;
		return this;
	}

	// Returns but does not remove the first element from the list.
	public T getFirst() {
		return front.item;
	}

	// Returns but does not remove the last element from the list.
	public T getLast() {
		return back.item;
	}

	// Notice you must not traverse the list to compute the size.
	public int getSize() {
		return size;
	}

	public ListIterator<T> iterator() {
		return new iter();
	}

	// Removes the first instance of the targetData from the list.
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node temp = null, curr = front;
		while (curr != null) {
			if (comparator.compare(curr.item, targetData) == 0) {
				if (curr == front) {
					front = front.after;
					curr = front;
				} else if (curr == back) {
					curr = null;
					back = temp;
					temp.after = null;
				} else {
					temp.after = curr.after;
					curr = curr.after;
				}
				size--;
			} else {
				temp = curr;
				curr = curr.after;
			}
		}
		return this;
	}
	// Removes and returns the first element from the list. If there are no elements
	// the method returns null.

	public T retrieveFirstElement() {
		if (size == 0) {
			throw new NoSuchElementException("Linked list is empty");
		}
		Node temp = front;
		front = front.after;
		front.before = null;
		size--;
		return temp.item;
	}
	// Removes and returns the last element from the list. If there are no elements
	// the method returns null.

	public T retrieveLastElement() {
		if (front == null) {
			throw new NoSuchElementException("Linked list is empty");
		}
		Node currentNode = front;
		Node previousNode = null;
		while (currentNode != null) {
			if (currentNode.equals(back)) {
				back = previousNode;
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.after;
		}
		size--;
		return currentNode.item;
	}
	// Returns an arraylist of the items in the list from head of list to tail of
	// list

	public ArrayList<T> toArrayList() {
		ArrayList<T> temp = new ArrayList<T>();
		ListIterator<T> iterator1 = new iter();
		while (iterator1.hasNext()) {
			temp.add(iterator1.next());
		}
		return temp;
	}

	public class iter implements ListIterator<T> {
		private Node current;
		private Node last;

		public iter() {
			current = front;
			last = null;
		}

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			if (current != null) {
				T returnData = current.item;
				last = current;
				current = current.after;
				if (current != null) {
					current.before = last;
				}
				return returnData;
			} else
				throw new NoSuchElementException();
		}

		public boolean hasPrevious() {
			return last != null;
		}

		public T previous() {
			if (last != null) {
				current = last;
				last = current.before;
				T returnData = current.item;
				return returnData;
			} else
				throw new NoSuchElementException();
		}

		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();

		}
	}

	protected class Node {
		protected T item;
		protected Node after, before;

		protected Node(T item, Node after, Node before) {
			this.item = item;
			this.after = after;
			this.before = before;
		}
	}
}
