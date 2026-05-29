class Solution {
    public int characterReplacement(String s, int k) {
        // Better->Tc->O(n+26*n) n->right pointer movement , 26*n->left pointer movement and maxFreq updation
        // Funda :- windowLength-maxFreqOfAChar <=k ---> valid case  --> pura KHELA iska hai
        int left=0;
        int right=0;
        // freq of char in curr window
        int freq[]=new int[26];
        int maxLen=0;
        int maxFreq=0;
       while(right<s.length()){
        // update freq of newly coming char inside window
        freq[s.charAt(right)-'A']++;
        // check if maxFreq has changed
        maxFreq=Math.max(maxFreq,freq[s.charAt(right)-'A']);
        // if invalid case then make the window smaller
        // window Len->right-left+1
        // wahi upaar wla formula ka invalid case windowLength-maxFreqOfAChar >k
        while(((right-left+1)-maxFreq)>k){
            // update freq of chars who were removed from widow
            freq[s.charAt(left)-'A']--;
            left++;
            //  find the maxFreq again in array because ho sakta hai maxFreq wla char he remove hua ho
            maxFreq=0;
            for(int i=0;i<26;i++){
                maxFreq=Math.max(maxFreq,freq[i]);
            }
        }
        // update maxLen
        maxLen=Math.max(maxLen,right-left+1);
        right++;
       }
        return maxLen;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        // Optimal->Tc->O(n+n) n->right pointer movement , n->left pointer movement (in WORST CASE)
        // Funda :- windowLength-maxFreqOfAChar <=k ---> valid case  --> pura KHELA iska hai

        // Yaha pe hum jab window ko chota karte hai tabhi maxFreq ko update nhi karte
        // eg:- [AABA]BBA -> maxFreq=3-> valid case maxLen=4
        // [AABAB]BA -> maxFreq=3->invalid case
        // therefore shrinking
        // A[ABAB]BA if we update maxFreq=2 ->invalid case
        // AA[BAB]BA if we update maxFreq=2 ->valid case -> but here len is 3
        // we already have a better len found thats why our maxLen is 4
        // this is why we not going to update maxFreq in OPTIMAL solution
        // because maxFreq find karne se hume choti size wala valid case milta hai
        // kiska hume kaam nhi kyuki hume sirf largest se matlab hai
        // OPTIMAL:-
        // [AABAB]BA -> maxFreq=3->invalid case
        // therefore shrinking
        // A[ABAB]BA ->maxFrwq=3(no update)-> according to formula valid case because 4-3=>1
        // A[ABABB]A ->maxFreq=3 -> but invalid case because 5-3=2
        // AA[BABB]A (Shrink) -> maxFreq=3(no update) -> valid case 4-3=1
        // AA[BABBA] ->maxFreq=3 -> but invalid case because 5-3=2
        // AABA[BBA] ->maxFreq=3 -> maxLen=4 after this right cross string.length

        // WHY maxFreq IS NEVER DECREASED AFTER SHRINKING THE WINDOW:
        // We only care about windows LONGER than any we've already found.
        // So maxFreq only needs to increase — a lower maxFreq would only
        // produce a window of the same or smaller size, which can't improve maxLen.
        //
        // Three cases:
        //   1. maxFreq increases → genuinely longer valid window found → maxLen updates
        //   2. maxFreq stays same (stale after shrink) → window just slides forward,
        //      size unchanged → no incorrect maxLen update
        //   3. maxFreq decreases (we never allow this) → would shrink window below
        //      our best, wasting iterations
        //
        // When maxFreq is stale (overstated), (windowSize - maxFreq) stays small,
        // so the while loop exits early and the window slides instead of shrinking.
        // This is intentional — we never want the window to go below maxLen.
        
        int left=0;
        int right=0;
        // freq of char in curr window
        int freq[]=new int[26];
        int maxLen=0;
        int maxFreq=0;
       while(right<s.length()){
        // update freq of newly coming char inside window
        freq[s.charAt(right)-'A']++;
        // check if maxFreq has changed --> only Natural Update
        maxFreq=Math.max(maxFreq,freq[s.charAt(right)-'A']);
        // if invalid case then make the window smaller
        // window Len->right-left+1
        // wahi upaar wla formula ka invalid case windowLength-maxFreqOfAChar >k
        while(((right-left+1)-maxFreq)>k){
            // update freq of chars who were removed from widow
            freq[s.charAt(left)-'A']--;
            left++;
        }
        // update maxLen
        maxLen=Math.max(maxLen,right-left+1);
        right++;
       }
        return maxLen;
    }
}