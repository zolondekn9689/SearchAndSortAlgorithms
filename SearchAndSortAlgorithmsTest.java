package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SearchAndSortAlgorithmsTest
{
    private SearchAndSortAlgorithms alg = new SearchAndSortAlgorithms();
    private int[] A = {5, 4, 3, 2, 6, 7};


    @org.junit.jupiter.api.Test
    void sequentialSearch()
    {

        //Works.
        for (int i = 0; i < A.length; i++)
        {
            assertEquals(i, alg.sequentialSearch(convert(A), A[i]));
        }

    }

    @org.junit.jupiter.api.Test
    void binarySearchRecursive()
    {
        ArrayList<Integer> sorted = getList();
        Collections.sort(sorted);


        // Test the whole arraylist to make sure the indexes are matched correctly.
        for (int i = 0; i < sorted.size(); i++)
        {
            int temp = sorted.get(i);
            assertEquals(i, alg.binarySearchRecursive(sorted, temp, 0, sorted.size() - 1));
        }


    }

    @org.junit.jupiter.api.Test
    void binarySearchIterative()
    {
        ArrayList<Integer> sorted = getList();
        Collections.sort(sorted);


        // Test the whole arraylist to make sure the list is correct.
        for (int i = 0; i < sorted.size(); i++)
        {
            int temp = sorted.get(i);
            assertEquals(i, alg.binarySearchIterative(sorted, temp));
        }

    }

    @org.junit.jupiter.api.Test
    void insertionSort()
    {
        ArrayList<Integer> list = convert(A);

        ArrayList<Integer> actual = convert(A);
        Collections.sort(actual);

        alg.insertionSort(list);

        //Make sure nothing is lost.
        assertEquals(A.length, list.size());

        //Check to make sure it works with two arrays.
        assertArrayEquals(toInt(actual), toInt(list));


        // --------------------TEST 3 --------------------
        ArrayList<Integer> nList = getRandomList();

        int[] expected2 = copySortedList(nList);

        alg.insertionSort(nList);


        assertArrayEquals(expected2, toInt(nList));


    }

    @org.junit.jupiter.api.Test
    void quickSort()
    {

        ArrayList<Integer> list = convert(A);
        int[] actual = copySortedList(list);

        alg.quickSort(list, 0, list.size() - 1);

        assertArrayEquals(actual, toInt(list));

        //----------TEST 2 -----------------
        ArrayList<Integer> randomList = getRandomList();
        alg.quickSort(randomList, 0, randomList.size() - 1);
        int[] random = toInt(randomList);
        int[] sortedRandom = copySortedList(randomList);


        assertArrayEquals(sortedRandom, random);


        // -------TEST 3 ------------------
        ArrayList<Integer> eList = getRandomList(0);
        alg.quickSort(eList, 0, eList.size() - 1);


    }




    public ArrayList<Integer> convert(int[] list) {
        ArrayList<Integer> nList = new ArrayList<>();

        for (int i = 0; i < list.length; i++)
        {
            nList.add(list[i]);
        }

        return nList;
    }

    public int[] toInt(ArrayList<Integer> list)
    {
        int[] newArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            newArray[i] = list.get(i);
        }
        return newArray;
    }


    public ArrayList<Integer> getList() {
        ArrayList<Integer> list = convert(A);
        return list;
    }

    public ArrayList<Integer> getRandomList()
    {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++)
        {
            list.add(getRandomNum());
        }

        return list;
    }

    public int getRandomNum() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public ArrayList<Integer> getRandomList(int num) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++)
        {
            list.add(getRandomNum());
        }

        return list;
    }


    public int[] copySortedList(ArrayList<Integer> original) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : original) {
            list.add(i);
        }

        Collections.sort(list);

        return toInt(list);

    }
}