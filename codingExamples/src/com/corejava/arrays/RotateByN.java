package com.corejava.arrays;

import java.util.Arrays;

public class RotateByN {
	/* 
	 * Time complexity : O(n * d) Where n is length of arr & d is number of rotation
	   Auxiliary Space : O(1)
	 */
	public void rotateByN(int []arr,int noOfRotation) {
		for(int i=0; i< noOfRotation; i++)
			rotateByOne(arr);
	}

	public void rotateByOne(int []arr) {
		int i,temp = arr[0];
		for(i=0; i<arr.length-1; i++)
			arr[i] = arr[i+1];
		arr[i]=temp;
	}
	public void print(int []arr) {
		for(int k=0; k<arr.length; k++) {
			System.out.print(" "+arr[k]+" ");
		}
	}
	/* 
	 * Time complexity : O(n/2) 
	   Auxiliary Space : O(1)
	 */
	public void reverse(int []arr) {
		for(int i=0; i<arr.length/2; i++){ 
			int temp = arr[i]; 
			arr[i] = arr[arr.length -i -1]; 
			arr[arr.length -i -1] = temp;
			}
	}
}

class TestRotateByN {
	public static void main(String []args) {
		RotateByN rn = new RotateByN();
		int []arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int []arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		rn.print(arr);
		System.out.println();
		rn.rotateByN(arr, 1);
		rn.print(arr);
		System.out.println("\n Reversing Arr");
		rn.print(arr1);
		rn.reverse(arr1);
		System.out.println();
		rn.print(arr1);
	}
}