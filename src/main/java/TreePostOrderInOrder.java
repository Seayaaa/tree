/**
 * @author lsy
 * @version 1.0
 * @date 2021/3/11 11:26
 */
public class TreePostOrderInOrder {

    class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;
    }

    int postIndex = 0;

    public TreeNode createTree1(int[] postOrder, int[] inOrder, int inBegin, int inEnd) {
        TreeNode rootNode = new TreeNode();
        rootNode.val = postOrder[postIndex];
        int rootIndex = findIndex(inOrder, postOrder[postIndex]);
        postIndex--;
        if (rootIndex == -1) {
            return rootNode;
        }
        // 先构建右子树
        rootNode.rightChild = createTree1(postOrder, inOrder, rootIndex+1, inEnd);
        rootNode.leftChild = createTree1(postOrder, inOrder, inBegin, rootIndex-1);
        return rootNode;
    }

    public int findIndex(int[] inOrder, int val) {
        for (int i=0;i<inOrder.length;i++) {
            if (inOrder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode createTree(int[] postOrder, int[] inOrder) {
        if (postOrder.length <= 0 || inOrder.length <= 0) {
            return null;
        }
        postIndex = postOrder.length-1;
        return createTree1(postOrder, inOrder, 0, inOrder.length-1);
    }
}
