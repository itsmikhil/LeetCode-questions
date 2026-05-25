class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // important

        // INTUITION:- neg el humare previously iterated element ko destroy kar raha hai 
        // means we get the need of LIFO structure thats why STACK

        // Approach
        // jaise he postive dikhe hum stack mai dalte hai
        // jaise he nagative value dikhe hum destroy karte hai based on value
        // Case 1:-agar negative value aayi aur stack empty hai toh hum usse push karte hai kyuki woh  
        // left direction mai travel karega aur uss taraf koyi val baachi nhi hai isliye hum usse push kar rahe hai stack mai 
        // Case 2:- agar stack ke top negative hai aur curr negative val ko bhi hum push karenge because woh dono same
        // direction mai travel karenge and they will never collide
        // agar curr val +ve hai toh bhi push karenge kyuki woh asteriod left mai jaa chuka hai toh woh curr ko kabhi touch 
        // nhi karega 
        
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            // posi dekhte he push karo
           if(asteroids[i]>=0){
            s.push(asteroids[i]);
           }else{
            // case of collision
            // bigger neg destroying small posi els case
            while(!s.isEmpty() && s.peek()>0 && Math.abs(asteroids[i])>s.peek()){
                s.pop();
            }
            // if s.peek() and neg el are equal then both get destroyed 
            // thats why neg el shouldnt be pushed in stack thats why "continue"
            if(!s.isEmpty() && s.peek()>0 && Math.abs(asteroids[i])==s.peek()){
                s.pop();
                continue;
            }
            // agar neg el is sabko destroy kar diya toh usse push karo stack mai
            // ya phir stack ke andar bhi neg element ho toh daaldo 
            // because woh dono fir same direction mai travel karte rahenge and they will travel happily
            if(s.isEmpty() || s.peek()<0){
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