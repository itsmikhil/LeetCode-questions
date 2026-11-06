
import java.util.ArrayList;

public class Solution 
{
    public static class trie{
        public class node{
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
            void setWordCompleted(){
                isWordCompleted=true;
            }
            
        }
        node root;
        trie(){
            root=new node();
        }
        void insert(String word){
            node temp=root;
            for(int i=0;i<word.length();i++){
                char curr=word.charAt(i);
                if(!temp.contains(curr)){
                    temp.putChar(curr);
                }
                temp=temp.getNext(curr);
            }
            temp.setWordCompleted();
        }
        void findAllWords(node temp,StringBuilder sb,ArrayList<String> list){
            if(temp.isWordCompleted==true){
                list.add(sb.toString());
            }
            for(int i=0;i<26;i++){
                if(temp.links[i]!=null){
                    sb.append((char)(i+'a'));
                    findAllWords(temp.links[i],sb,list);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        ArrayList<ArrayList<String>> getSearch(String q){
            ArrayList<ArrayList<String>> ans=new ArrayList<>();
            node temp=root;
            boolean flag=false;
            for(int i=0;i<q.length();i++){
                char curr=q.charAt(i);
                ArrayList<String> list=new ArrayList<>();
                if(flag==true){
                    // list.add("No suggestions found");
                    ans.add(list);
                    continue;
                }
                if(temp.contains(curr)){
                    temp=temp.getNext(curr);
                    node store=temp;
                    StringBuilder sb=new StringBuilder(q.substring(0,i+1));
                    findAllWords(store,sb,list);
                    ans.add(list);
                }else{
                    return ans;
                }
            }
            return ans;
        }
    }
    public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr)
    {
        trie t=new trie();
        for(String el:contactList){
            t.insert(el);
        }
        return t.getSearch(queryStr);
    }
}