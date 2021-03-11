/**
 * @desc 根据树的先序遍历和中序遍历确定一棵树
 * @author lsy
 * @version 1.0
 * @date 2021/3/11 11:12
 */
public class TreePreOrderInOrder {
    
    class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;
    }
    
    int preIndex = 0;
    
    public TreeNode createTree1(int[] preOrder, int[] inOrder, int inBegin, int inEnd) {
        TreeNode rootNode = new TreeNode();
        rootNode.val = preOrder[preIndex];
        int rootIndex = findIndex(inOrder, preOrder[preIndex]);
        preIndex++;
        if (rootIndex == -1) {
            return rootNode;
        }
        rootNode.leftChild = createTree1(preOrder, inOrder, inBegin, rootIndex-1);
        rootNode.rightChild = createTree1(preOrder, inOrder, rootIndex+1, inEnd);
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
    
    public TreeNode createTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length <= 0 || inOrder.length <= 0) {
            return null;
        }
        return createTree1(preOrder, inOrder, 0, inOrder.length-1);
    }
    
    
}
