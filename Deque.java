package a02;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Class deque that will create an empty deque, this class will also have 
 * methods that will be utilized by the deque such as, adding and removing 
 * values from the beginning and the end, along with returning statistics of the deque
 * and this deque will implement in iterator
 * @author Hai Le and Jaeden Eldred
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
	//Create private methods that will keep track of the first and last value in the deque
	private Node first;
	private Node last;
	private int n; //Private int named n that will be keeping track of the size of the deque

	/*
	 * Create a class Node of type Item with variables item and next 
	 */
	public class Node{
		private Item item; //Private item that will keep track of the value of the Node
		private Node next; //Private Node named next that will be used as the next node
		private Node prev; //Private Node named prev that will be used as the last node
	}
	/**
	 * Create an empty deque
	 * set the size of the deque which is n to 0
	 */
	public Deque() {
		n = 0;
	}
	
	/**
	 * Method isEmpty that will check if the deque is empty
	 * If n is 0, then it's empty, return true
	 * if not, then return false
	 * @return
	 */
	public boolean isEmpty() {
		return n == 0; //This means return true only if n is 0, this will return false otherwise
	}
	
	/**
	 * Method size that will return the number of items on the deque
	 * @return n
	 */
	public int size() {
		return n;
	}
	
	/**
	 * Method addFirst that will add the desired item to the beginning of the deque
	 * and also increment the spot of every item that is after the newly added item to the next Node
	 * @param item
	 */
	public void addFirst(Item item) {
		//Throw method for checking if the parameter is null
		nullError(item);
		
		//If item is not null, then this code will run.
		//Create a new node named old first to keep track of the last first node
		Node oldFirst = first;
		
		//Make the value of Node first a new node with no value
		first = new Node();
		
		//Make the item value equal to the parameter item
		first.item = item;
		
		//Make the node next after the first node's value to be the vallue of the Node oldFirst
		first.next = oldFirst;
		
		//If the current deque is empty, or this is the first node added to the deque, set the node's value to first and last since it's the only Node 
		if(last == null) {
			last = first;
		}
		//If it's not empty, then set the value of the very first Node to variable first
		else {
			first.next.prev = first; //first.next.prev is basically the current node
		}	
		n++; //increment n by 1 at the very end
	}
	
	/**
	 * Method addLast that will add the desired item to the end of the deque
	 * This method will be implementing a swap between the current last node and a new node that will be added on the end
	 * @param item
	 */
	public void addLast(Item item) {
		//Throw method for checking if the parameter is null
		nullError(item);
		
		//If item is not null, this code will run.
		//Create a new node named oldLast to keep track of the last node in order to swap
		Node oldLast = last;
		
		//Make Node last a new Node with no value
		last = new Node();
		
		//Set the item value of Node last to the parameter item
		last.item = item;
		
		//Set the value of the node after last null because it will still have reference to it
		last.next = null;
		
		//Set the value of the Node before last to the value of Node oldLast
		last.prev = oldLast;
		
		//If the deque is empty, make the value of the Node first and last the same because only 1 Node exist in the deque currently
		if(first == null) {
			first = last;
		}
		//if the deque is not empty, then set the very last Node's value to the value of the Node last
		else {
			last.prev.next = last;
		}
		n++;
	}
	
	/**
	 * Method removeFirst which will be removing the value that is in the Node in front
	 * removeFirst will 
	 * @return
	 */
	public Item removeFirst() {
		//Check to see if the deque is empty with a method that will throw an exception error if deque is empty
		emptyError();
		
		//Create a new item that will keep the value of the current first Node
		Item item = first.item;
		
		//Make the value of the node named first to the value of the node after that by calling .next 
		first = first.next;
		
		//Decrement the size of the list every time a Node is removed
		n--;
		
		//Return the item that was removed
		return item;
	}
	
	public Item removeLast() {
		//Check to see if the deque is empty with a method that will throw an exception error if deque is empty
		emptyError();
		
		//Create a new item that will keep the value of the current first Node
		Item item = last.item;
		
		//Make the value of the node named last to the value of the node previous by calling .prev
		last = last.prev;
		
		//Last is still referenced to the node after that, so you would have to set last.next value to null;
		last.next = null;
		
		//Decrement the size of the list every time a Node is removed
		n--;
		
		//Return the item that was removed
		return item;
	}
	
	/*
	 * Throw NullPointerException if user wants to add null. The exception will exit this method without going to further code
	 */
	private void nullError(Item item) {
		if(item == null) throw new NullPointerException("The item added cannot be null");
	}

	/*
	 * If the deque is empty, set variables first and last to null, and throw an error message saying cannot remove from empty queue
	 */
	private void emptyError() {
		if(isEmpty()) {
			first = null;
			last = null;
			throw new UnsupportedOperationException("Cannot remove from an empty deque");
		}
	}
	
	/**
	 * Implement an iterator of type Item
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		//Create a new variable named current and initialize it with the value of first Node;
		private Node current = first;
		
		//Create a method of type boolean named hasNext, and it will return true if the next Node is not null.
		@Override
		public boolean hasNext() {
			return current != null;
		}

		//Create a method named next that will return the next item 
		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException(); //If it doesn't have next, throw an exception
				Item item = current.item; //make a new item to keep track of the value of current
				current = current.next; //set current's value to the next node's value
				return item; //return the item that was storing current's first value
		}
		
		//Create the method remove, but when it is called, throw an UnsupportedOperationException error.
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
	}
	
	//Test the code in the main method
	public static void main(String[] args) {
		//Create a new deque called deck of type String. Must declare type or else this will get mad at you.
		Deque<String> deck = new Deque<String>();
		deck.addFirst("Hello");	
		deck.addFirst("Hey");
		deck.addFirst("What");
		deck.addFirst("lol");
		deck.removeFirst();
		
		//Create a new iterator of type String named it with the value of deck.iterator
		Iterator<String> it = deck.iterator();
		while(it.hasNext()) { //While the iterator has next element, print that element
			System.out.println(it.next());
		}
	}
}
