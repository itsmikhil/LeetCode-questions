class Solution {
    public int totalFruit(int[] fruits) {
        // IMP QUESTION --> highly asked question according to comments
        // Better -> this can take O(2n) in worst case jab left and right dono pura move kare isliye optimize
        // "Find the longest continuous sub array that has exactly 2 distinct elements."
        // ye dekho GADBAD jo maine ki thi
        // mai ne left ko pehle ke update kar de raha tha
        // while(left<fruits.length){
        //     int val=map.get(fruits[left]);
        //     map.put(fruits[left],val-1);
        //     left++;  ---> ISSUE
        //     if(val-1==0){
        //         map.remove(fruits[left]); ----> This was removing the next fruit from map, not the curr one whose count is zero
        //         break;
        //     }
        // }
        // storing element and its freq
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
        while(right<fruits.length){
            // storing element and its freq
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            // means now we have more than 2 types of fruit in basket
            if(map.size()>2){
                // remove one type of fruit by moving left
                // NOte the gadbad i did --> mentioned it above
                while(left<fruits.length){
                    int val=map.get(fruits[left]);
                    map.put(fruits[left],val-1);
                    if(val-1==0){
                        map.remove(fruits[left]);
                        left++;
                        break;
                    }
                    left++;
                }
            }
            // agar sirf ek type ka fruit hai toh bhi chalega par max 2 type ke hone chaiye
            // this case is already handled
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        // IMP QUESTION --> highly asked question according to comments
        // Better -> this can take O(2n) in worst case jab left and right dono pura move kare isliye optimize
        // "Find the longest continuous sub array that has exactly 2 distinct elements."
        // Optimal --> O(n)
        // eg:- 33321111
        // jab left=0 and right =4 tab there are more than 2 type of fruit
        // pichle method (better wala) ke according hum while loop use karke
        // left ko zero se 3 pe leke aate the
        // iske kya hota tha ki worst case wale example mai TC :- o(2n)
        // ho jaati thi matlab left aur right dono pura arr traverse kar rahe hai
        // abb hum kya karte hai (optimal approach)
        // hum jo window size hai usko badhne nhi denge lekin max jo tabhi he update 
        // update karenge jab window valid ho
        // matlab [33321]111
        // 3[33211]11 -> 3 ki freq reduce ki aur 1 ki freq incremnet
        // 33[32111]1->same wahi  3 ki freq reduce ki aur 1 ki freq incremnet
        // 333[21111]->abhi window valid hai kyuki hume purana kharcha bhi remve kar diya aur aage walo ko saath bhi le liya 
        // abhi hum maxLength ko update kar sakte hai because window valid hai
        // APPROACH
        // jab window unvalid ho toh left aur right dono ko move karo window size ko same rakho
        // pichla kachra niklta jaayega and naya saamna aata jayega
        // jaise he window valid ho jaaye update max Length
        // storing element and its freq
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
        while(right<fruits.length){
            // storing element and its freq
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            // means now we have more than 2 types of fruit in basket 
            // dekho while loop hat gaya hai
            if(map.size()>2){
                int val=map.get(fruits[left]);
                map.put(fruits[left],val-1);
                if(val-1==0){
                    map.remove(fruits[left]);
                }
                left++;
            }else{
                // agar sirf ek type ka fruit hai toh bhi chalega par max 2 type ke hone chaiye
                // this case is already handled
                max=Math.max(max,right-left+1);
            }
            right++;
        }
        return max;
    }
}