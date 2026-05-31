class Solution {
    class meeting{
        int start;
        int end;
        int pos;
        meeting(int start,int end,int pos){
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
    public int maxMeetings(int start[], int end[]) {
        // TC:- (2*n + nlogn)
        // SC:- (n)
        // Greedy idea:
        // Sort meetings by end time so that we always pick the meeting
        // that finishes earliest. This leaves the maximum remaining time
        // for future meetings, giving us the best chance to schedule more meetings.
        
        // storing meetings in our custom class
        meeting arr[]=new meeting[start.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=new meeting(start[i],end[i],i);
        }
        // sorting based on end time
        Arrays.sort(arr,(a,b)->a.end-b.end);
        
        int endTimeOfMeetings=-1;
        int count=0;
        
        // FOLLOW UP:-
        // we have stored posi in class meeting so  that if interviewer asks
        // us to print all the meetings possible then we can just add the posi in 
        // a AL and print it
        
        for(int i=0;i<arr.length;i++){
            if(endTimeOfMeetings<arr[i].start){
                endTimeOfMeetings=arr[i].end;
                count++;
            }
        }
        
        return count;
    }
}
