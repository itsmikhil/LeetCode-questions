class Solution {
	public void floydWarshall(int[][] dist) {
		// bohot simple hai yaar
        // this algo is for MULTIPLE src shortest path algo		
        // ADJ MATRIX is used -> note list is not used
        
        // intuition:
        // alag alag raaste se ek node par pohochne ki koshish karo
        // that is via via
        
        // bas outer loop ussi via ka hai
        // baaki dono inner loop toh bass matrix traversal ka hai
        
        // Works for negative edges
        // ✅ Positive-weight cyclic graph → Works perfectly.
        // ✅ Negative-weight cyclic graph (without negative cycles) → Works perfectly.
        //❌ Negative-weight cycle → Detectable, but shortest paths are undefined./
        
        // agar positive edges ho toh dijstra better rahega because 
        // uska tc is ElogV 
        // agar har node ke liye call karenge toh bhi V*ElogV
        // which is still less then n^3 of this algo
        
        // Negative edge cycle Detection:
        // khud pe pohohochne ka cost zero hota
        // agar khud pe pohochne ka cost negative ho jaye
        // matlab Negative edge cycle hai
        
        // tc: o(n^3)
        // sc: o(n^2)
		
		for (int via = 0; via<dist.length; via++) {
			for (int i = 0; i<dist.length; i++) {
				for (int j = 0; j<dist.length; j++) {
				    
				    // yaha infinite is rep by 1e8 -> question definition
				    // this IF is added just to avoid addition overflow	
					if (dist[i][via] != 100000000 && dist[via][j] != 100000000) {
						dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
					}
					
				}
			}
		}
		
	}
}
