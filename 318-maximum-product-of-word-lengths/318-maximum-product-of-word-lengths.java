class Solution {
  public int maxProduct(String[] words) {
    int n = words.length;
    int[] sets = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        sets[i] |= (1 << words[i].charAt(j) - '0');
      }
    }
    int maxProd = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if ((sets[i] & sets[j]) == 0) { // Intersection?
          maxProd = Math.max(maxProd, words[i].length() * words[j].length());
        }
      }
    }
    return maxProd;
  }
}