class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            int idx = people[i][1];
            list.add(idx,people[i]);
        }
        int [][]ans = new int[people.length][2];
        for(int i=0;i<ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}