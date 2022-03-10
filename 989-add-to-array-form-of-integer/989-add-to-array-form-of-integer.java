class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
	
		int carry = 0, sum = 0;
		List<Integer> list = new ArrayList<>();
		int count = A.length;
		while (count > 0 || carry > 0 || K>0) {
			if(count<=0) {
				sum = K % 10+ carry;
			}else {
				sum = A[count - 1] % 10 + K % 10+ carry;	
			}
			K = K / 10;
			list.add(sum % 10);
			carry = sum / 10;
			count--;
		}
		Collections.reverse(list);
		return list;
	
	
	
    }
}