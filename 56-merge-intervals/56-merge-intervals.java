class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<>();
        tem.add(intervals[0][0]);
        tem.add(intervals[0][1]);
        list.add(tem);
        int end = intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end = end < intervals[i][1] ? intervals[i][1] : end;
                list.get(list.size()-1).set(1,end);
            }else{
                end = intervals[i][1];
                tem = new ArrayList<>();
                tem.add(intervals[i][0]);
                tem.add(intervals[i][1]);
                list.add(tem);
            }
        }
        int [][]ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i][0]=list.get(i).get(0);
            ans[i][1]=list.get(i).get(1);
        }
        return ans;
    }
}