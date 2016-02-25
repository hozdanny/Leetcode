package Solution;

public class S004_FindMedianSortedArrays {
/*
 * 题目可转换成寻找第K大的元素
 *  */
	public double findMedianSortedArrays(int nums1[], int nums2[]) {
		int totalLength = nums1.length + nums2.length;
		int indexOfMedian = totalLength / 2;
		if (totalLength % 2 == 1) {
			return findKth(nums1, nums2, indexOfMedian+1, 0, nums1.length - 1, 0, nums2.length - 1);
		} else {
			return (findKth(nums1, nums2, indexOfMedian, 0, nums1.length - 1, 0, nums2.length - 1)
					+ findKth(nums1, nums2, indexOfMedian + 1, 0, nums1.length - 1, 0, nums2.length - 1)) / 2;
		}
	}

	public double findKth(int nums1[], int nums2[], int k, int n1s, int n1e, int n2s, int n2e) {
		int n1Length = n1e - n1s + 1;
		int n2Length = n2e - n2s + 1;
		if (n1Length > n2Length) {
			return findKth(nums2, nums1, k, n2s, n2e, n1s, n1e);
		}

		if (n1Length == 0) {
			return nums2[n2s + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[n1s], nums2[n2s]);
		}

		int sa = Math.min(n1Length, k / 2), sb = k - sa;
		if (nums1[n1s + sa - 1] == nums2[n2s + sb - 1]) {
			return nums1[n1s + sa - 1];
		} else if (nums1[n1s + sa - 1] > nums2[n2s + sb - 1]) {
			return findKth(nums1, nums2, k - sb, n1s, n1e, n2s + sb, n2e);
		} else {
			return findKth(nums1, nums2, k - sa, n1s + sa, n1e, n2s, n2e);
		}
	}

	public static void main(String[] args) {
		int num1[] = { 1, 2, 4, 8 };
		int num2[] = { 5, 9, 10 };
		S004_FindMedianSortedArrays fm = new S004_FindMedianSortedArrays();
		System.out.println(fm.findMedianSortedArrays(num1, num2));
	}
}
