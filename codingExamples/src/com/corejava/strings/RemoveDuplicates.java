package com.corejava.strings;

import java.util.Arrays;
import java.util.LinkedHashSet;



public class RemoveDuplicates {
	
	/***
	 * Removing Duplicates from String Using Sorting 
	 * @author Ashutosh
	 *
	 */
	public String removeDuplicates(String str) {
		char []arr = str.toCharArray();
		Arrays.sort(arr);
		System.out.println("Sorted Array::"+new String(arr));
		
		int i = 1, j = 1;
		while(j < arr.length-1) { 
			if(arr[j-1] != arr[j]) {
			arr[i] = arr[j];
			i++;
			}
		j++;
		}
		String removedDups = new String(arr);
		
		return removedDups.substring(0, i);
	}
	
	/* Function removes duplicate characters from the string
    Using Hashing (HashSet) */
    public String removeDuplicatesUsingHashing(String str){
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        for(int i=0;i<str.length();i++)
            lhs.add(str.charAt(i));
         return lhs.toString();
    }
}


class TestRemoveDuplicates{
	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		System.out.println("Remove Duplicates Using Char Array::"+rd.removeDuplicates("geeksforgeeks"));
		System.out.println("Remove Duplicates Using Hashing::"+rd.removeDuplicatesUsingHashing("geeksforgeeks"));
	}
}