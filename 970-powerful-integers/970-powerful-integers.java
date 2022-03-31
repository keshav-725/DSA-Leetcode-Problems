class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;Math.pow(x,i)<=bound;i++){
            if(y==1){
                int sum = (int)Math.pow(x,i)+1;
                if(sum<=bound && !set.contains(sum)){
                    list.add(sum);
                    set.add(sum);
                }
            }
            else{
                for(int j=0;Math.pow(y,j)<=bound;j++){
                    int sum = (int)Math.pow(x,i)+(int)Math.pow(y,j);
                    if(sum<=bound && !set.contains(sum)){
                        list.add(sum);
                        set.add(sum);
                    }
                }
            }
            if(x==1){
                break;
            }
        }
        return list;
    }
}