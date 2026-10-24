class Solution {
    // coverted string to day number
    int findDayNum(String str){
        String arr[]=str.split("-");
        int month=Integer.parseInt(arr[0]);
        int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
        int ans=0;
        // remeber month-1 -> IMP
        for(int i=0;i<month-1;i++){
            ans+=days[i];
        }
        return ans+Integer.parseInt(arr[1]);
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int AliceArrive=findDayNum(arriveAlice);
        int AliceLeave=findDayNum(leaveAlice);
        int BobArrive=findDayNum(arriveBob);
        int BobLeave=findDayNum(leaveBob);

        int start=Math.max(AliceArrive,BobArrive);
        int end=Math.min(AliceLeave,BobLeave);

        if(start<=end){
            return end-start+1;
        }
        return 0;
    }
}