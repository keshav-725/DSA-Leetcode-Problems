class Solution {
    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        TreeSet<Integer> set = new TreeSet<>();
        int count = 0;
        for(int i=props.length-1;i>=0;i--){
            if(set.higher(props[i][1])!=null){
                count++;
            }
            set.add(props[i][1]);
        }
        return count;
    }
}