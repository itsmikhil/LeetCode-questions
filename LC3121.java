class Solution {
    public int numberOfSpecialChars(String word) {
        // logic:-last occ of smaller case shar should be less than first occ of upeer case char
        // brute force take 2 arrays => for upper and lower
        // store the idexes accordingly and  do the calculation

        // optimal(like below one ) SC:- O(n)
        // in case lower case char is visible=> store 1
        // now if you see upper char after lower => increment count and store -1
        // now if you have updated the counter but now you see lower case after upper case then decrement the count and mark that character as blacklisted by storing => -2
        int freq[]=new int[26];
        int count=0;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(Character.isLowerCase(curr)){
                // case when we have incremented and counter but now we saw lower char after upper char
                if(freq[curr-'a']==-1){
                    count--;
                    freq[curr-'a']=-2;
                    // update it to 1 only when it was zero
                    // because what if this character was blacklisted (viewed upper before lower) eg:- "AbcbDBdD"
                }else if(freq[curr-'a']==0){
                    freq[curr-'a']=1;
                }
            }else if(Character.isUpperCase(curr)){
                // blaclist char
                if(freq[(curr+32)-'a']==0){
                    freq[(curr+32)-'a']=-2;
                    // when upper is seen after lower -> valid case
                }if(freq[(curr+32)-'a']==1){
                    count++;
                    freq[(curr+32)-'a']=-1;
                }
            }
        }
        return count;
    }
}