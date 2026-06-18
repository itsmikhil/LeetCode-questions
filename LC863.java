// Graph Method
// o(n) o(n)

// ek aur method hai woh bhi dekh lena

// Sabse pehle hum log ek map<TreeNode,TreeNode> lete hai jisme hum log har
// node ka parent store karte hai
// iss hume tree ko bhi graph bana diya hai
// fir hum bfs traversal
// exact wahi graph wala 
// issme bhi him visited maintain karte hai
//  aur ek ek kadam aage badhte jaate hai
class Solution {
    void parentMap(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    map.put(temp.left,temp);
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    map.put(temp.right,temp);
                    q.offer(temp.right);
                }
            }
        }
    }

    List<Integer> bfsTraversalFromTarget(TreeNode target,Map<TreeNode,TreeNode> map,int k){
        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> vis=new HashSet<>();
        q.offer(target);
        vis.add(target);

        int currLevel=0;

        while(!q.isEmpty()){
            int size=q.size();
            currLevel++;
            // break condition 
            // because abhi jo queue mai bacha hai wahi ans hai
            if(currLevel>k) break;
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null && !vis.contains(temp.left)){
                    vis.add(temp.left);
                    q.offer(temp.left);
                }
                if(temp.right!=null && !vis.contains(temp.right)){
                    vis.add(temp.right);
                    q.offer(temp.right);
                }
                if(map.containsKey(temp) && !vis.contains(map.get(temp))){
                    vis.add(map.get(temp));
                    q.offer(map.get(temp));
                }
            }
        }

        // BREAK karne ke baad jo
        //queue mai bach gaya wahi answer hai
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        parentMap(root,map);
        return bfsTraversalFromTarget(target,map,k);
    }
}