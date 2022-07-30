 class Solution {
    public List<String> wordSubsets(String[] a, String[] b) {
    List<String> l = new ArrayList<String>();
    int target[]= new int[26];
    for(String i:b){
        int temp[]=new int[26];
        for(char c:i.toCharArray()){
            temp[c-'a']++;
            target[c-'a']=Math.max(target[c-'a'],temp[c-'a']);
            
        }
    }
    for(String j:a){
        int arr[]=new int[26];
        for(char c:j.toCharArray()) arr[c-'a']++;
        
        if(subset(arr,target)){
            l.add(j);
        }
    }
    return l;

}
private boolean subset(int[] source,int[] dest){
    for(int i=0;i<26;i++){
        if(dest[i]>source[i])return false;
    }
    return true;
}
}