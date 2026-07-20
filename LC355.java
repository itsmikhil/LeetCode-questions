class Twitter {

    // Brute Force

    // for giving tiemStamp to each post
    static int time=0;
    // to access user object based on user Id
    HashMap<Integer,user> users; //userId,user

    class post{
        int postId,postTime;
        post(int postId){
            this.postId=postId;
            postTime=time;
            time++;
        }
    }
    
    class user{
        int userId;
        // will be used in creation of feed
        ArrayList<post> posts;
        // for quick access of following
        // and checking if A is already following B
        HashSet<Integer> following;
        user(int userId){
            this.userId=userId;
            posts=new ArrayList<>();
            following=new HashSet<>();
            // a person follows himself 
            // added this so that his post are also seen in feed
            following.add(userId);
        }
    }

    public Twitter(){
        users=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(users.containsKey(userId)){
            user acc=users.get(userId);
            acc.posts.add(new post(tweetId));
        }else{
            user newUser=new user(userId);
            users.put(userId,newUser);
            newUser.posts.add(new post(tweetId));
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // here first we are collecting all post done by user and his followings
        // then we are sorting it and sending atmost 10 postids

        // if user doesnt exist means he wont have any post or following
        // thats why create new user and return empty ArrayList
        if(!users.containsKey(userId)){
            user newUser=new user(userId);
            users.put(userId,newUser);
            ArrayList<Integer> ans=new ArrayList<>();
            return ans;
        }
        List<post> postsToBeShown=new ArrayList<>();
        List<Integer> feed=new ArrayList<>();

        user currUser=users.get(userId);
        for(int friend:currUser.following){
            user friendId=users.get(friend);
            for(post el: friendId.posts){
                postsToBeShown.add(el);
            }
        }

        Collections.sort(postsToBeShown,(a,b)->b.postTime-a.postTime);

        for (int i = 0; i < Math.min(10, postsToBeShown.size()); i++) {
            feed.add(postsToBeShown.get(i).postId);
        }
        
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        // handle if follower doesnt exist
        if(!users.containsKey(followerId)){
            user newUser=new user(followerId);
            users.put(followerId,newUser);
        }
        // i cant follow myself
        if(followerId==followeeId) return;
        // handle if followee doesnt exist
        if(!users.containsKey(followeeId)){
            user newUser=new user(followeeId);
            users.put(followeeId,newUser);
        }
        // if i already follow someone
        if(users.get(followerId).following.contains(followeeId)) return;

        users.get(followerId).following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // i cant unfollow myself
        if (followerId == followeeId) return;
        // if follower or followee doesnt exist then how can i unfollow them 
        if(!users.containsKey(followerId) || !users.containsKey(followeeId)){
            return;
        }
        users.get(followerId).following.remove(Integer.valueOf(followeeId));
    }
}
class Twitter {

    // Optimal
    // only change in adding new post and finding feed

    // for giving tiemStamp to each post
    static int time = 0;
    // to access user object based on user Id
    HashMap<Integer, user> users; // userId,user

    class post {
        int postId, postTime;

        post(int postId) {
            this.postId = postId;
            postTime = time;
            time++;
        }
    }

    class user {
        int userId;
        // will be used in creation of feed
        ArrayList<post> posts;
        // for quick access of following
        // and checking if A is already following B
        HashSet<Integer> following;

        user(int userId) {
            this.userId = userId;
            posts = new ArrayList<>();
            following = new HashSet<>();
            // a person follows himself
            // added this so that his post are also seen in feed
            following.add(userId);
        }
    }

    // stores current post along with its index in that user's post list
    class node {
        post currPost;
        int userId;
        int index;

        node(post currPost, int userId, int index) {
            this.currPost = currPost;
            this.userId = userId;
            this.index = index;
        }
    }

    public Twitter() {
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (users.containsKey(userId)) {
            user acc = users.get(userId);
            // insert at head
            acc.posts.add(0, new post(tweetId));
        } else {
            user newUser = new user(userId);
            users.put(userId, newUser);
            // insert at head
            newUser.posts.add(0, new post(tweetId));
        }
    }

    public List<Integer> getNewsFeed(int userId) {

        // if user doesnt exist means he wont have any post or following
        // thats why create new user and return empty ArrayList
        if (!users.containsKey(userId)) {
            user newUser = new user(userId);
            users.put(userId, newUser);
            return new ArrayList<>();
        }

        // Merge K Sorted Lists ki logic follow kar rahe hai.
        // Har user ki posts list pehle se hi descending order me sorted hai
        // kyuki har nayi post ko head par insert kar rahe hai.
        //
        // Sabse pehle har followed user ki latest post PQ me daalte hai.
        // PQ hume sabse latest post dega.
        // Us post ko feed me add karte hai, fir usi user ki next post PQ me daal dete hai.
        // Ye process tab tak repeat hota hai jab tak 10 posts na mil jaye ya PQ empty na ho.
        PriorityQueue<node> postsToBeShown = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.currPost.postTime, a.currPost.postTime));

        List<Integer> feed = new ArrayList<>();

        user currUser = users.get(userId);

        // put latest post of every followed user in PQ
        for (int friend : currUser.following) {
            user friendId = users.get(friend);

            if (friendId.posts.size() > 0) {
                postsToBeShown.offer(new node(friendId.posts.get(0), friend, 0));
            }
        }

        while (!postsToBeShown.isEmpty() && feed.size() < 10) {

            node top = postsToBeShown.poll();

            feed.add(top.currPost.postId);

            int nextIndex = top.index + 1;

            user curr = users.get(top.userId);

            // push next latest post of same user
            if (nextIndex < curr.posts.size()) {
                postsToBeShown.offer(
                        new node(curr.posts.get(nextIndex), top.userId, nextIndex));
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        // handle if follower doesnt exist
        if (!users.containsKey(followerId)) {
            user newUser = new user(followerId);
            users.put(followerId, newUser);
        }
        // i cant follow myself
        if (followerId == followeeId)
            return;
        // handle if followee doesnt exist
        if (!users.containsKey(followeeId)) {
            user newUser = new user(followeeId);
            users.put(followeeId, newUser);
        }
        // if i already follow someone
        if (users.get(followerId).following.contains(followeeId))
            return;

        users.get(followerId).following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // i cant unfollow myself
        if (followerId == followeeId)
            return;
        // if follower or followee doesnt exist then how can i unfollow them
        if (!users.containsKey(followerId) || !users.containsKey(followeeId)) {
            return;
        }
        users.get(followerId).following.remove(Integer.valueOf(followeeId));
    }
}