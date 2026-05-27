class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        // we want to go till Math.sqrt(n) but it takes more time
        // thats why stop condi is i*i<=n 
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                list.add(i);
                // because eg 6*6 is 36 
                // thats why 6 shouldnt get added twice
                if(i*i!=n){
                    list.add(n/i);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}