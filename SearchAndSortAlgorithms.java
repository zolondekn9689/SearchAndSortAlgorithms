package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Assignment: fill in algorithms using psuedocode.
 * I will attempt to use the same naming convention as the algorithm.
 * @author Nick Zolondek.
 */
public class SearchAndSortAlgorithms implements SearchableAndSortable
{

    /**
     * Searches for an element sequentially.
     * @param A the list being searched.
     * @param K the element attempted to being found.
     * @return index of K or -1 for can't find it.
     */
    @Override
    public int sequentialSearch(ArrayList<Integer> A, int K)
    {
        //Psuedocode: i is 0.
        int i = 0;
        //Set n as size of A.
        int n = A.size();

        //Loop around until K is found or i goes out of bounds.
        // Psuedocode: while i < n and A[i] != K do
        while (i < n && A.get(i) != K)
        {
            //increment i.
            i++;
        }

        // case which i is less than size.
        //Psuedocode: if i < n return i;
        if (i < n)
        {
            //Index of K.
            return i;
        }

        //Not found so return -1.
        return -1;
    }

    /**
     * Searches for an element by using binarysearch recursively.
     * @param data data being found.
     * @param value value attempted to being found.
     * @param low first index of the list.
     * @param high last index of the list.
     * @return the index of the element.
     */
    @Override
    public int binarySearchRecursive(ArrayList<Integer> data, int value, int low, int high)
    {
        //if (high < low)
        if (high < low)
            //return -1. For it can't find it.
            return -1;

        //mid = (low + high)/2; get the midpoint.
        int mid = (low + high)/2;

        // if (A[mid] > value); Mid is to high and cut it in half.
        if (data.get(mid) > value)
            // split the list down.
            return binarySearchRecursive(data, value, low, mid - 1);
        // else if (A[mid] < value; mid is less than value.
        //We want to split list from low being mid + 1 to high.
        else if (data.get(mid) < value) {
            return binarySearchRecursive(data, value, mid + 1, high);
        } else {
            //element is found.
            return mid;
        }

    }


    /**
     * Binary search through iterative form.
     * @param data arraylist being searched.
     * @param value value attempting to being found.
     * @return -1 if found else index where value is found.
     */
    @Override
    public int binarySearchIterative(ArrayList<Integer> data, int value)
    {

        //low = 0, high = N - 1. Initialize variables.
        int low = 0;
        int high = data.size() - 1;

        // Search through list from low to high. Psuedocode: while(low <= high)
        while (low <= high)
        {
            //Psuedocode: mid = (low + high)/2
            //Establish a mid point to compare from.
            int mid = (low + high)/2;
            //Psuedocode: if (A[mid] > value); reduce high point to one index less than mid.
            if (data.get(mid) > value) {
                //high = mid - 1;
                high = mid - 1;
            //Psudocode: else if(A[mid < value);
            //Midpoint is less than the value, so adjust the low endpoint.
            } else if (data.get(mid) < value) {
                low = mid + 1;
            } else {
                //Midpoint is the index the value found at.
                return mid;
            }
        }

        //Not found.
        return -1;
    }

    /**
     * Sorts list using insertion sort algorithm.
     * @param A list being sorted.
     */
    @Override
    public void insertionSort(ArrayList<Integer> A)
    {
        //Search through the list from point 1.
        //Psuedocode: for i is 1 to n - 1 do
        for (int index = 1; index < A.size(); index++)
        {
            //Psuedocode: v is A[i] and j is i - 1.
            //V stores value at index. J keeps track of the last ordered index.
            int v = A.get(index);
            int j = index - 1;

            // Psuedocode: j >= 0 and A[j] > v do
            // Compare when at j is larger than at the element at index.
            while (j >= 0 && A.get(j) > v)
            {
                //Set the new index A[j].
                A.set(j + 1, A.get(j));

                //Psuedocode: j is j - 1.
                //Decrement by one.
                j--;
            }

            //Psuedocode: A[j+1] is v.
            A.set(j + 1, v);

        }
    }

    /**
     * Quicksort algorithm.
     * @param A List of integers being sorted.
     * @param low the first element of the list.
     * @param high last element of the list.
     */
    @Override
    public void quickSort(ArrayList<Integer> A, int low, int high)
    {
        //Psuedocode: if (low < high); Validates the index.
        if (low < high)
        {
            //Pi is partioning the index, arr[pi] is now at the right place.
            //Psuedocode: pi = partition(arr, low, high).
            int pi = partition(A, low, high);

            //Quick sort before pi.
            quickSort(A, low, pi - 1);

            //Quick sort after pi
            quickSort(A, pi + 1, high);
        }
    }


    /**
     * Partitions the list.
     * @param A the list being partitioned.
     * @param left left of the index.
     * @param right right of the index.
     * @return a partition of A[l,..,r] with the split position returned as
     * this function's value.
     */
    @Override
    public int partition(ArrayList<Integer> A, int left, int right)
    {

        //p <-- A[l]
        int p = A.get(left);

        //i <-- l
        int i = left;

        //j <-- r + 1
        int j = right + 1;


        //repeat until i < j
        //Repeating loop until i and j meet.
        do {



            //repeat until A[i] >= p or i >= r
            do {
                // i <- i + 1
                i++;
            }while(!(A.get(i) >= p || i >= right));

            // repeat unttil A[j] <= p or j <= l
            do {
                j--;
            }while (!(A.get(j) <= p || j <= left));

            //swap(A[i], A[j])
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);



        }while ((i < j));

        //swap(A[i], A[j])
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);


        //swap (A[l], A[j])
        int temp2 = A.get(left);
        A.set(left, A.get(j));
        A.set(j, temp2);

        return j;

    }

    /**
     * Prints the arraylist.
     * @param data the list being printed.
     */
    @Override
    public void printArrayList(ArrayList<Integer> data)
    {
        //Loop around the list.
        for (int i = 0; i < data.size(); i++)
        {
            //print the value with a space.
            System.out.print(data.get(i)+ " ");

            //Print only 10 elements in each line.
            if (i % 10 == 0 && i > 0)
            {
                //Add a new line.
                System.out.println();
            }
        }


    }




}
