package com.dsa.pattersrch;

public class Assignmentd6 {

	public static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[low] <= arr[mid]) {

				if (target >= arr[low] && target < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (target > arr[mid] && target <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 14, 18, 21, 3, 6, 8, 9 };
		int target = 8;

		int index = binarySearch(arr, target);

		if (index != -1) {
			System.out.println("Element found at index: " + index);
		} else {
			System.out.println("Element not found in the array.");
		}
	}
}
