package a02;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class will be utilized to make an empty queue, and add elements into the queue in random order
 * Methods to utilize in this class will be adding and removing elements, checking if it's empty and the size of the queue
 * along with a method to return a random element in the queue as well as implement an iterator 
 * @author Hai Le and Jaeden Eldred
 *
 */
public class RandomizedQueue2<Item> implements Iterable<Item> {
	//Create a private variable of type Item called element, this will be utilized in the methods, and to refer to the random element
	private Item[] element;

	//Create private variables to utilize in the program
	private int n; //Create a private variable named size of type int to keep track of the size of the randomizedqueue

	/**
	 * Create an empty randomized queue with size 0
	 */
	public RandomizedQueue2()	{
		//Set the value of element to a new Object of Item with the value of 2 in the array
		element = (Item[]) new Object[2];
		n = 0;
	}

	/**
	 * Return the boolean value true if the queue is empty, and false otherwise
	 * @return
	 */
	public boolean isEmpty()	{
		return n == 0; //If size is 0, return true, any other case will return false
	}

	/**
	 * Return the size of the queue
	 * @return size
	 */
	public int size()	{
		return n;
	}

	/**
	 * Method enqueue that will be inserting the parameter into a random spot in the queue
	 * If the amounts of elements is the size of the queue, resize the queue to double it's length
	 * @param item
	 */
	public void enqueue(Item item) {
        if (item == null) throw new NullPointerException(); //Throw nullPointerException if the item parameter is null
        
        //If n is the same number as the total length, double the size by calling the resize method
		if(n == element.length) {
			resize(2 * element.length);
		}
		
		//If n is 0 then set the parameter item to the value of the index n of element
        if (n == 0) {
            element[n++] = item;
            return;
        }
        
        int randomIndex = StdRandom.uniform(n); //Create a new variable that will act as a random integer
        Item temp = element[randomIndex]; //Create a new Item called temp with the value of element at a random index
        element[randomIndex] = item; //Set the new item parameter to a random location in the element array
        element[n++] = temp; //Set the value of element array incremented to temp, which is the random index element with the value of item
	}

	/**
	 * This method will be removing a random item and return that item that was removed
	 * @return
	 */
	public Item dequeue() {
		//Create a new variable of type Item called temp to hold the value of the removed item that will be returned
		Item temp = null;
		return temp;
	}

	/**
	 * Method that will be getting a random item from the queue, and return it without removing it from the queue
	 * @return
	 */
	public Item sample() {
		Item temp = null;
		return temp;
	}

	/**
	 * Method that will be used to resize the size of the queue to double its own length
	 * @param i
	 */
	private void resize(int i) {

	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;

		}

	}

}
