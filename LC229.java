class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // optimal
        // similar to moore voting machine
        // count changes to count1,count2
        int count1=0;
        int count2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            // see that el1 and el2 same na ho jaye warna woh log ek dusre ka vote kaatte rahenge
            // thats why count condition imp
            if(count1==0 && el2!=nums[i]){
                el1=nums[i];
                count1=1;
            }else if(count2==0 && el1!=nums[i]){
                el2=nums[i];
                count2=1;
            }else if(nums[i]==el1){
                count1++;
            }else if(nums[i]==el2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        // isse hume bass elements mil jaate hai
        // par hume confirm toh karna he padhta hai unki freq ko
        List<Integer> list = new ArrayList<>();
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(el1==nums[i]) count1++;
            if(el2==nums[i]) count2++;
        }
        if(count1>nums.length/3){
            list.add(el1);
        }
        if(count2>nums.length/3){
            list.add(el2);
        }
        return list;
    }
}