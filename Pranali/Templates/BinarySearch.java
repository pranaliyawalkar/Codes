
//Binary search a number in an array.

public class BinarySearch {
	int[] arr = new int[]{1, 2, 3, 5, 9, 200, 309};
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int ans = 0;
		ans= bs.search(4);
		System.out.println("4 : " + ans);
		ans = bs.search(199);
		System.out.println("199 : " + ans);
		ans = bs.search(0);
		System.out.println("0 : " + ans);
		ans = bs.search(310);
		System.out.println("310 : " + ans);
		ans = bs.search(3);
		System.out.println("3 : " + ans);
	}
	public int search(int num) {
		int l = 0;
		int r = arr.length-1;
		int m = (l+r)/2;
		while(l <= r) {
			if (l == r) {
				return l;
			}
			if (l+1 == r) {
				if (num <= arr[l])
					return l;
				if (num <= arr[r])
					return r;
				if (num > arr[r])
					return r+1;
			}
			m = (l+r)/2;
			if (num == arr[m])
				return m;
			if (num <= arr[m] && num > arr[m-1])
				return m;
			if (num < arr[m])
				r = m;
			if (num > arr[m])
				l = m;
		}
		return 0;
	}

}
