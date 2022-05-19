class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean []visited = new boolean[arr.length];
        return helper(arr,visited,start);
        
    }
    public boolean helper(int []arr,boolean []visited,int index){
        if(index<0 || index>=arr.length || visited[index]==true) return false;
        if(arr[index]==0) return true;
        
        visited[index] = true;
        
        if(helper(arr,visited,index+arr[index])) return true;
        if(helper(arr,visited,index-arr[index])) return true;
        
        return false;
    }
}