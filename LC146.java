class LRUCache {
    // highly repeated question 
    // DLL plus hashmap
    // DLL because we want to maintain order of recently used
    // hashmap so that we dont have to traverse again and again to find the node
    // in hashmap we are storing address of node siliye we dont have to traverse again and again ===> O(1)

    // recently used is at back(near tail)
    // least used is at front(near head)

    // create dummy head and tail so that we dont have to hanlde null prev and next cases ===> genius
    // dont forget to link gead and tail in initialization 

    // cases:-
    // put:-
    // 1:-check if key exist first if yes then it is case of updation
    // 2:- we know key doesnt exist but if capacity is not reached yet then we simply "push it from back(prev to tail)"
    // 3:- if capcicity is reached means we need to delete least used(next to head) and add new node(prev to tail)
    // get:- simple
    // 1:- exist if yes, shift it from its curr position to back(prev to tail)
    // 2:- if it doesnt exist return -1
    
    class node{
        int val;
        int key;
        node next;
        node prev;
        public node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    node head;
    node tail;
    HashMap<Integer,node> map;
    int cap;
    
    public LRUCache(int capacity) {
        head=new node(-1,-1);
        tail=new node(-1,-1);
        head.next=tail;
        tail.prev=head;
        head.prev=tail.next=null;
        map=new HashMap<>();
        cap=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            node nodeToBeShifted=map.get(key);
            node temp=nodeToBeShifted.prev;
            temp.next=temp.next.next;
            nodeToBeShifted.next.prev=temp;

            temp=tail.prev;
            nodeToBeShifted.next=tail;
            nodeToBeShifted.prev=temp;
            temp.next=nodeToBeShifted;
            tail.prev=nodeToBeShifted;

            return nodeToBeShifted.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            node nodeToBeShifted=map.get(key);
            nodeToBeShifted.val=value;
            node temp=nodeToBeShifted.prev;
            temp.next=temp.next.next;
            nodeToBeShifted.next.prev=temp;

            temp=tail.prev;
            nodeToBeShifted.next=tail;
            nodeToBeShifted.prev=temp;
            temp.next=nodeToBeShifted;
            tail.prev=nodeToBeShifted;
        }else if(map.size()<cap){
            node newNode=new node(key,value);
            node temp=tail.prev;
            newNode.next=tail;
            newNode.prev=temp;
            temp.next=newNode;
            tail.prev=newNode;
            map.put(key,newNode);
        }else{
            node nodeToBeDel=head.next;
            nodeToBeDel.next.prev=head;
            head.next=head.next.next;
            map.remove(nodeToBeDel.key);

            node newNode=new node(key,value);
            node temp=tail.prev;
            newNode.next=tail;
            newNode.prev=temp;
            temp.next=newNode;
            tail.prev=newNode;

            map.put(key,newNode);
        }
    }
}