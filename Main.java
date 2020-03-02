package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Check first, last and middle.
        int n = 100;
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(n * 10));

        }

        SearchAndSortAlgorithms sasa = new SearchAndSortAlgorithms();

        int indexOfValue = sasa.sequentialSearch(list, list.get(0));


        if (indexOfValue == 0) {
            System.out.println("Yes we found it at " + indexOfValue);
        } else {
            System.out.println("Uh-oh expected index 0 and got " + indexOfValue);

        }
        System.out.println("Not Sorted");
        sasa.printArrayList(list);
        Collections.sort(list); // Uses Java Collections to sort array for Binary Searches
        System.out.println("\nSorted:");
        sasa.printArrayList(list);



    }
}
