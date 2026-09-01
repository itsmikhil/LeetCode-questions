class Solution {
    public int maxDistance(int[] position, int m) {

        // question maximize the minimum dis
        // matlab adj balls ke beech ka distance jo bhi hai uska minimum lo
        // aur isse maximize karne ki koshish karo

        // same as agressive cows
        
        Arrays.sort(position);

        int low=1;

        int max=position[position.length-1];
        int min=position[0];
        int high=max-min;

        while(low<=high){

            int mid= low + (high-low)/2;

            // mid is minGAP
            int numOfBalls=1;
            int prevIdx=0;

            for(int i=1;i<position.length;i++){
                if(position[i]-position[prevIdx]>= mid){
                    numOfBalls++;
                    prevIdx=i;
                }
            }

            if(numOfBalls<m){
                high=mid-1;
            }else{
                low=mid+1;
            }

        }

        return high;


    }
}