class Solution {
    public int[][] reconstructQueue(int[][] p) {
        int n = p.length;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = (p[i][0] << 11) + 0x7FF - p[i][1];

		java.util.Arrays.sort(a);
		int[] b = new int[n];
		int size = 0;
		for (int i = n - 1; i >= 0; i--, size++) {
			int v = a[i];
			int index = 0x7FF - v & 0x7FF;
			if (index != size)
				System.arraycopy(b, index, b, index + 1, size - index);
			b[index] = v;
		}
		for (int i = 0; i < n; i++) {
			p[i][0] = b[i] >>> 11;
			p[i][1] = 0x7FF - b[i] & 0x7FF;
		}
		return p;
    }
}