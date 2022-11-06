class Twitter {
    class Pair{
        int userId;
        int tweetId;
        Pair(int userId,int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    HashMap<Integer,HashSet<Integer>> followers;
    ArrayList<Pair> tweets;
    public Twitter() {
        followers = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Pair(userId,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        int count = 10;
        for(int i=tweets.size()-1;i>=0 && count>0;i--){
            Pair p = tweets.get(i);
            if((followers.containsKey(userId) && followers.get(userId).contains(p.userId)) || userId==p.userId){
                newsFeed.add(p.tweetId);
                count--;
            }
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId,new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)) followers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */