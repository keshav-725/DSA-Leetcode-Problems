class Twitter {
    private static int timestamp = 0;
    Map<Integer,User> map;
    public class Tweet{
        int id;
        int time;
        Tweet next;
        
        public Tweet(int id){
            this.id = id;
            time = ++timestamp;
            next = null;
        }
    }
    public class User{
        int userId;
        Set<Integer> followed;
        Tweet tweet_head;
        
        public User(int id){
            this.userId = id;
            tweet_head=null;
            followed = new HashSet<>();
            follow(id);
        }
        public void follow(int followee){
            followed.add(followee);
        }
        public void unfollow(int followee){
            followed.remove(followee);
        }
        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweet_head;
            tweet_head = tweet;
        }
    }
    public Twitter() {
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
            User u = new User(userId);
            map.put(userId,u);
        }
        map.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> ans = new ArrayList<>();
        
        if(!map.containsKey(userId)) return ans;
        
        Set<Integer> users = map.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(),(a,b)->(b.time-a.time));
        
        for(int user : users){
            Tweet t = map.get(user).tweet_head;
            
            if(t!=null){
                pq.add(t);
            }
        }
        int n = 0;
        while(pq.size()>0 && n<10){
            Tweet t = pq.poll();
            
            ans.add(t.id);
            
            if(t.next != null){
                pq.add(t.next);
            }
            n++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            User u = new User(followerId);
            map.put(followerId,u);
        }
        if(!map.containsKey(followeeId)){
            User u = new User(followeeId);
            map.put(followeeId,u);
        }
        map.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followeeId) || followerId==followeeId){
            return;
        }
        map.get(followerId).unfollow(followeeId);
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