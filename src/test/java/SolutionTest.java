import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1(){
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> expected = new ArrayList<>(List.of( root.left, root.right.right));
        List<TreeNode> actual = new Solution().findDuplicateSubtrees(root);

        Assert.assertEquals(expected, actual);

    }
    public void test2(){
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> expected = new ArrayList<>(List.of( root.left, root.right.right));
        List<TreeNode> actual = new Solution().findDuplicateSubtrees(root);

        Assert.assertEquals(expected, actual);

    }
}
