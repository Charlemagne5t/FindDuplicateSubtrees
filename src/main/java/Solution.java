import java.util.*;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
               Map<Integer, List<TreeNode>> map = new HashMap<>();
        dfs(map, root);
        System.out.println(map);
        List<TreeNode> result = new ArrayList<>();
        for (List<TreeNode> duplicates : map.values()){
            List<TreeNode> candidates = new ArrayList<>();
            for (int i = 0; i < duplicates.size(); i++) {
                for (int j = i + 1; j < duplicates.size(); j++) {
                    if(equals(duplicates.get(i), duplicates.get(j))){
                        final int k = i;
                        if(candidates.stream().noneMatch(c -> equals(c, duplicates.get(k)))){
                            candidates.add(duplicates.get(i));
                        }
                    }
                }
            }
            result.addAll(candidates);
        }

        return result;
    }
    private void dfs(Map<Integer, List<TreeNode>> map, TreeNode root){
        if(root == null){
            return;
        }
        if(!map.containsKey(root.val)){
            map.put(root.val, new ArrayList<>());
        }
        map.get(root.val).add(root);
        dfs(map, root.left);
        dfs(map, root.right);
    }
    private boolean equals (TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }
}

