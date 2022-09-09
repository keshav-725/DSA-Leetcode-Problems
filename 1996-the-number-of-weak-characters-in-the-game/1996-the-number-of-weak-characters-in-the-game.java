class Solution {
    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int max = props[props.length-1][1];
        int count = 0;
        for(int i=props.length-2;i>=0;i--){
            if(props[i][1]<max){
                count++;
            }
            max = Math.max(max,props[i][1]);
        }
        return count;
    }
}