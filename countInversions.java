class Solution {
    
    // dry run on page 127
    
    // brute is 2 nested loops
    // better/optimal
    // divide and conquer
    // tc: (nlogn)
    // sc: (n)
    int ans=0;
    void merge(int arr[],int start,int mid,int end){
        
        int temp[]=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        
        while(i<=mid && j<=end){
            
            // agar left array ke ith element, right array ke jth element se
            // bada hai matlab, left array ke aage ke els bhi isse bade he  honge
            // isliye liye i se leke left array ke last tak ka count add karo
            // ans+=(mid-i+1)
            
            if(arr[i]>arr[j]){
                ans+=(mid-i+1);
                temp[k]=arr[j];
                j++;
                k++;
            }else{
                temp[k]=arr[i];
                i++;
                k++;
            }
        }
        
        while(j<=end){
            temp[k]=arr[j];
            j++;
            k++;
        }
        
        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        
        for(i=start,k=0;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
        
    }
    void divide(int arr[],int start,int end){
        
        if(start==end || start<0 || end>=arr.length) return;
        
        int mid=(start+end)/2;
        
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        
        merge(arr,start,mid,end);
        
    }
    public int inversionCount(int arr[]) {
        
        divide(arr,0,arr.length-1);
        return ans;
    }
}