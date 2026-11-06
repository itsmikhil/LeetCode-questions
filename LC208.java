class Trie {

    // explanation on pg 148

    node root;

    class node{
        node links[];
        boolean isWordCompleted;
        node(){
            links=new node[26];
            isWordCompleted=false;
        }
        boolean contains(char ch){
            return links[ch-'a']!=null;
        }
        void putChar(char ch){
            links[ch-'a']=new node();
        }
        node getNext(char ch){
            return links[ch-'a'];
        }
        void setEnd(){
            isWordCompleted=true;
        }
        boolean isTheWordCompleted(){
            return isWordCompleted;
        }
    }

    public Trie() {
        root=new node();
    }
    
    public void insert(String word) {
        node temp=root;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(!temp.contains(curr)){
                temp.putChar(curr);
            }
            temp=temp.getNext(curr);
        }
        temp.setEnd();
    }
    
    public boolean search(String word) {
        node temp=root;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(!temp.contains(curr)){
                return false;
            }
            temp=temp.getNext(curr);
        }
        return temp.isTheWordCompleted();
    }
    
    public boolean startsWith(String prefix) {
        node temp=root;
        for(int i=0;i<prefix.length();i++){
            char curr=prefix.charAt(i);
            if(!temp.contains(curr)){
                return false;
            }
            temp=temp.getNext(curr);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */