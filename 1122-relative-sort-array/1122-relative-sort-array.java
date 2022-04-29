class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int []ans = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            map1.put(arr1[i],map1.getOrDefault(arr1[i],0)+1);
        }
        int j=0;
        for(int i=0;i<arr2.length;i++){
            int size=map1.get(arr2[i]);
            while(size-->0){
                ans[j]=arr2[i];
                j++;
            }
            map1.remove(arr2[i]);
        }
        ArrayList<Integer> tans = new ArrayList<>();
        for(int key:map1.keySet()){
            int size=map1.get(key);
            while(size-->0){
                tans.add(key);
            }
        }
        Collections.sort(tans);
        
        for(int i=0;i<tans.size();i++){   
            ans[j]=tans.get(i);
            j++;
        }
        return ans;
    }
}