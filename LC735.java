class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // important
        // jaise he postive dikhe hum stack mai dalte hai
        // jaise he nagative value dikhe hum destry karte hai based on value
        // Case 1:-agar negative value aayi aur stack empty hai toh hum usse push karte hai kyuki woh  
        // left direction mai travel karega aur uss taraf koyi val baachi nhi hai isliye hum usse push kar rahe hai stack mai 
        // Case 2:- agar stack ke top negative hai aur curr negative val ko bhi hum push karenge because woh dono same
        // direction mai travel karenge and they will never collide
        // agar curr val +ve hai toh bhi push karenge kyuki woh asteriod left mai jaa chuka hai toh woh curr ko kabhi touch 
        // nhi karega 
        
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                s.push(asteroids[i]);
            }else if(asteroids[i]<0){
                while(!s.isEmpty() && s.peek()>0 && Math.abs(asteroids[i])>s.peek()){
                    s.pop();
                }
                if(!s.isEmpty() && s.peek()>0 && s.peek()==Math.abs(asteroids[i])){
                    s.pop();
                    continue;
                }
                // important 
                if(s.isEmpty() || s.peek()<0){
                    System.out.println(asteroids[i]);
                    s.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[s.size()];
        int idx = s.size() - 1;

        while (!s.isEmpty()) {
            ans[idx] = s.pop();
            idx--;
        }

        return ans;
    }
}