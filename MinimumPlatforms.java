class Solution {
    public int minPlatform(int start[], int end[]) {
        // optimal -> TC(2*nlogn + n) Sc(1)
        Arrays.sort(start);
        Arrays.sort(end);
        int count=0;
        int maxCount=0;
        int ptr1=0; // for start array
        int ptr2=0; // for end array
        while(ptr1<start.length && ptr2<end.length){
            if(start[ptr1]<=end[ptr2]){
                count++;
                ptr1++;
            }else if(start[ptr1]>end[ptr2]){
                count--;
                ptr2++;
            }
            maxCount=Math.max(maxCount,count);
        }
        while(ptr1<start.length){
            count++;
            ptr1++;
            maxCount=Math.max(maxCount,count);
        }
        while(ptr2<end.length){
            count--;
            ptr2++;
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
