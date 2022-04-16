class Solution {
    public int numSteps(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        int count = 0;
        int i=list.size()-1;
        while(true){
            if(list.size()==1 && list.get(0)=='1'){
                break;
            }
            if(list.get(i)=='1'){
                int j=i;
                while(j>=0 && list.get(j)!='0'){
                    list.set(j,'0');
                    j--;
                }
                if(j<0){
                    list.add(0,'1');
                    i++;
                }else{
                    list.set(j,'1');
                }
            }else{
                list.remove(i);
                i--;
            }
            count++;
        }
        return count;
    }
}