//Name:			Isaac Walker
//StudentID:	1212828316
//Class:		CSE360 - Calliss - Wed 3:05
//Assignment:	2
//Description:	Creates an array of integers. Can add, append, and remove integers. Can find the count
//				of integers in the list, and can search out a specific integer. Can return the first or
//				last integer of the list. Can return the size of the array, and can add all the array integers
//				into a string.

package cse360assign2;

import java.util.Arrays;

public class SimpleList {
	
	private int[] list; //array
	private int count; //counter of number of integers in array
	
	/**
	 * The constructor that creates a new array that can hold 10 integers, is named list, and
	 * gives it a counter set to 0.
	 */
	public SimpleList()
	{
		list = new int[10]; //initial size of array
		count = 0;
	}
	
	/**	
	 * The add method will either set the first element of list to the new integer
	 * and then increment the count if list is empty, or it will first push all
	 * elements in list forward without exceeding max array size and then set the
	 * first element of list to the new integer and increment the list.
	 * If the list is full, will increase in size by 50%
	 * @param enteringInteger the array that is being added to the list
	 */
	public void add(int enteringInteger)
	{
		if(count == 0)// for when the array is empty
		{
			list[0] = enteringInteger;
			count++;//increments the count
		}
		else if(count < list.length)// for when the array has multiple integers, but isn't full
		{
			for(int iterator = count; iterator > 0; iterator--)
			{
				list[iterator] = list[iterator - 1];
			}
			list[0] = enteringInteger;
			count++;//increments the count
		}
		else if(count == list.length)//for when the array is full
		{
			list = Arrays.copyOf(list, list.length + (list.length / 2));//does a copy transfer of the list into a list that is 1/2 times bigger
			
			for(int iterator = count; iterator > 0; iterator--)
			{
				list[iterator] = list[iterator - 1];
			}
			list[0] = enteringInteger;
			count++;//increments the count
		}
	}
	
	/**
	 * The remove method will find the location of the integer being removed and then
	 * remove the integer and bring all elements past the integer down the list. To
	 * finish, it will decrement the count. If more than 1 entry exists and more than
	 * 25% of the array is empty, it will decrease the array's size by 25%.
	 * @param exitingInteger
	 */
	public void remove(int exitingInteger)
	{
		if(count > 1)//as long as there is more than one entry removal can be started
		{
			if(count < (3 * list.length / 4))// if the count is less than 75% of the available array size
			{
				list = Arrays.copyOf(list, list.length - (list.length / 4));//does a copy transfer of the list into a list that is 1/4 smaller
			}
			int location = search(exitingInteger);// finds the location of the integer to be removed
			
			for(int iterator = location; iterator < count - 1; iterator++)//removes the integer by moving the rest of the array over it
			{
				list[iterator] = list[iterator + 1];
			}
			count--;//decrements the count
		}
	}
	
	/**
	 * The count method gives the number of elements in the list.
	 * @return integer value of the number of elements in the list
	 */
	public int count()
	{
		return count;//returns the count. No need to parse through when a variable was created for this.
	}
	
	/**
	 * The search method parses through the list till it finds the
	 * desired integer and then returns the position of that integer.
	 * If no integer is found then it returns the value "-1".
	 * @param wantedInteger the integer that is being searched for.
	 * @return returns either the integer value of the integer's
	 * position or "-1".
	 */
	public int search(int wantedInteger)
	{
		for (int iterator = 0; iterator < count; iterator++)
		{
			if(list[iterator] == wantedInteger)
			{
				return iterator;//immediately returns the location, so that it is focused on the first instance
			}
		}
		return -1;//otherwise returns -1
	}
	
	/**
	 * The toString method adds the list elements to one String separated by only
	 * a single space between elements.
	 * @return toString the string of the list integers.
	 */
	public String toString()
	{
		String listString = "";//initializing the string to be returned
		
		for(int iterator = 0; iterator < count; iterator++)
		{
			if(iterator == 0)//for the first integer
			{
				listString = listString + list[iterator];
			}
			else// adding the rest of the integers with a space before each one
			{
				listString = listString + " " + list[iterator];
			}
		}
		
		return listString;
	}
}
