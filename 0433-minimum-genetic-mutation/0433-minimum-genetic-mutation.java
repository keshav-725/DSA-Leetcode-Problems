class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int src = -1;
        int dst = -1;
        String[] banks = new String[bank.length+1];
        banks[0] = start;
        
        for(int i = 0; i < bank.length; i++) {
            banks[i+1] = bank[i];
        }
        
        int[][] grid = new int[banks.length][banks.length];
        
        for(int i = 0; i < banks.length; i++) {
            if(start.equals(banks[i])) {
                src = i;
            }
            if(end.equals(banks[i])) {
                dst = i;
            }
            for(int j = 0; j < banks.length; j++) {
                int bitChanges = 0;
                
                for(int k = 0; k < 8; k++) {
                    if(banks[i].charAt(k) != banks[j].charAt(k)) {
                        bitChanges++;
                    }
                }
                if(bitChanges == 1) {
                    grid[i][j] = grid[j][i] = 1;
                }
            }
        }
        
        int[] visited = new int[banks.length];
        LinkedList<Integer> queue = new LinkedList<>();
        
        queue.add(src);
        visited[src] = 1;
        int[] distance = new int[banks.length];

        while(!queue.isEmpty()) {
            int val = queue.poll();
            
            for(int i = 0; i < banks.length; i++) {
                if(grid[val][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                    distance[i] = distance[val]+1;
                    
                    if(i == dst) {
                        return distance[i];
                    }
                }
            }
        }
        
        return -1;
    }
}
