package Patterns.DFS;

// =====================================================
// 113. Path Sum II
// =====================================================

import java.util.ArrayList;
import java.util.List;

public class PathSumFinder {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentpath = new ArrayList<>();

        dfs(root, targetSum, currentpath, result);

        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result){
        if(node == null)
            return;

        path.add(node.val);

        if(node.left ==null && node.right==null && remainingSum==node.val ){
            result.add(new ArrayList<>(path));
        }else {
            dfs(node.left, remainingSum-node.val, path, result );
            dfs(node.right, remainingSum-node.val, path, result );
        }
        path.remove(path.size()-1);
    }
}
