package com.corejava.arrays;

public class RotateByN {
	/* 
	 * Time complexity : O(n * d) Where n is length of arr & d is number of rotation
	   Auxiliary Space : O(1)
	 */
	public void rotateByN(int []arr,int noOfRotation) {
		for(int i=0; i< noOfRotation; i++)
			rotateByOne(arr);
	}

	public void rotateByOne(int[] arr) {
		int i,temp = arr[0];
		for(i=0; i<arr.length-1; i++)
			arr[i] = arr[i+1];
		arr[i]=temp;
	}
	public void print(int arr[]) {
		for(int k=0; k<arr.length; k++) {
			System.out.print(" "+arr[k]+" ");
		}
	}
}

class TestRotateByN {
	public static void main(String[] args) {
		RotateByN rn = new RotateByN();
		int []arr = {1,4,6,8,10};
		rn.print(arr);
		System.out.println();
		rn.rotateByN(arr, arr.length);
		rn.print(arr);
	}
}