class Solution {
    // BFS
    // TC:- N*wordLength*26
    // N:- because in worst case sab words queue mai jaayegi
    // wordLength*26 :- inner loops for changing words
    class pair{
        String word;
        int dis;
        pair(String word,int dis){
            this.word=word;
            this.dis=dis;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        // set for fast lookup to see if the word exist in your wordList or no
        HashSet<String> set=new HashSet<>();
        for(String el:wordList){
            set.add(el);
        }
        // start with beginWord
        q.offer(new pair(beginWord,1));
        // its given that wordList may or may not contain beginWord
        if(set.contains(beginWord)) set.remove(beginWord);
        while(!q.isEmpty()){
            pair temp=q.poll();
            // Found case
            if(temp.word.equals(endWord)) return temp.dis;
            // replace chars and check if wordList waale word bante hai ki nhi
            for(int i=0;i<temp.word.length();i++){
                for(char j='a';j<='z';j++){
                    // NOTE THE NEW METHODS USED
                    char arr[]=temp.word.toCharArray();
                    arr[i]=j;
                    String newStr=new String(arr);
                    // if word is found in wordList
                    if(set.contains(newStr)){
                        // we remove it from set because so baar baar ussi word pe naa jaate rahe
                        // like we have VIS aaray in BFS wahi same
                        set.remove(newStr);
                        q.offer(new pair(newStr,temp.dis+1));
                    }
                }
            }
        }
        return 0;
    }
}