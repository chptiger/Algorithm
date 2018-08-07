package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;  
  
/** 
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888  轻�?��?�定�?�试中的二�?�树题目 
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html  算法大全（3） 二�?�树 
 *  
 * TODO: 一定�?能熟练地写出所有问题的递归和�?�递归�?�法�? 
 * 
 * 1. 求二�?�树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代） 
 * 2. 求二�?�树的深度: getDepthRec（递归），getDepth  
 * 3. �?�?�??历，中�?�??历，�?��?�??历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec 
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2) 
 * 4.分层�??历二�?�树（按层次从上往下，从左往�?�）: levelTraversal, levelTraversalRec（递归解法�?） 
 * 5. 将二�?�查找树�?�为有�?的�?��?�链表: convertBST2DLLRec, convertBST2DLL 
 * 6. 求二�?�树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel 
 * 7. 求二�?�树中�?��?节点的个数：getNodeNumLeafRec, getNodeNumLeaf 
 * 8. 判断两棵二�?�树是�?�相�?�的树：isSameRec, isSame 
 * 9. 判断二�?�树是�?是平衡二�?�树：isAVLRec 
 * 10. 求二�?�树的镜�?（破�??和�?破�??原�?�的树两�?情况）：mirrorRec, mirrorCopyRec 
 * 10.1 判断两个树是�?�互相镜�?：isMirrorRec 
 * 11. 求二�?�树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2 
 * 12. 求二�?�树中节点的最大�?离：getMaxDistanceRec 
 * 13. 由�?�?�??历�?列和中�?�??历�?列�?建二�?�树：rebuildBinaryTreeRec 
 * 14.判断二�?�树是�?是完全二�?�树：isCompleteBinaryTree, isCompleteBinaryTreeRec 
 *  
 */  
public class Tree_Demo {  
    /* 
                 1  
                / \  
               2   3  
              / \   \  
             4  5   6  
     */  
    public static void main(String[] args) {  
        TreeNode r1 = new TreeNode(1);  
        TreeNode r2 = new TreeNode(2);  
        TreeNode r3 = new TreeNode(3);  
        TreeNode r4 = new TreeNode(4);  
        TreeNode r5 = new TreeNode(5);  
        TreeNode r6 = new TreeNode(6);  
          
        r1.left = r2;  
        r1.right = r3;  
        r2.left = r4;  
        r2.right = r5;  
        r3.right = r6;  
          
        convertBST2DLLRec(r1);
//      System.out.println(getNodeNumRec(r1));  
//      System.out.println(getNodeNum(r1));  
//      System.out.println(getDepthRec(r1));  
//      System.out.println(getDepth(r1));  
          
//      preorderTraversalRec(r1);  
//      System.out.println();  
//      preorderTraversal(r1);  
//      System.out.println();  
//      inorderTraversalRec(r1);  
//      System.out.println();  
//      inorderTraversal(r1);  
//      System.out.println();  
//      postorderTraversalRec(r1);  
//      System.out.println();  
//      postorderTraversal(r1);  
//      System.out.println();  
//      levelTraversal(r1);  
//      System.out.println();  
//      levelTraversalRec(r1);  
//      System.out.println();  
          
//      TreeNode tmp = convertBSTRec(r1);  
//      while(true){  
//          if(tmp == null){  
//              break;  
//          }  
//          System.out.print(tmp.val + " ");  
//          if(tmp.right == null){  
//              break;  
//          }  
//          tmp = tmp.right;  
//      }  
//      System.out.println();  
//      while(true){  
//          if(tmp == null){  
//              break;  
//          }  
//          System.out.print(tmp.val + " ");  
//          if(tmp.left == null){  
//              break;  
//          }  
//          tmp = tmp.left;  
//      }  
          
          
//      TreeNode tmp = convertBST2DLL(r1);  
//      while(true){  
//          if(tmp == null){  
//              break;  
//          }  
//          System.out.print(tmp.val + " ");  
//          if(tmp.right == null){  
//              break;  
//          }  
//          tmp = tmp.right;  
//      }  
          
//      System.out.println(getNodeNumKthLevelRec(r1, 2));  
//      System.out.println(getNodeNumKthLevel(r1, 2));  
          
//      System.out.println(getNodeNumLeafRec(r1));  
//      System.out.println(getNodeNumLeaf(r1));  
          
//      System.out.println(isSame(r1, r1));  
//      inorderTraversal(r1);  
//      System.out.println();  
//      mirror(r1);  
//      TreeNode mirrorRoot = mirrorCopy(r1);  
//      inorderTraversal(mirrorRoot);  
          
        System.out.println(isCompleteBinaryTree(r1));  
        System.out.println(isCompleteBinaryTreeRec(r1));  
          
    }  
  
    private static class TreeNode {  
        int val;  
        TreeNode left;  
        TreeNode right;  
  
        public TreeNode(int val) {  
            this.val = val;  
        }  
    }  
  
    /** 
     * 求二�?�树中的节点个数递归解法： O(n) 
     * （1）如果二�?�树为空，节点个数为0  
     * （2）如果二�?�树�?为空，二�?�树节点个数 = 左�?树节点个数 + 
     *            �?��?树节点个数 + 1 
     */  
    public static int getNodeNumRec(TreeNode root) {  
        if (root == null) {  
            return 0;  
        } else {  
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;  
        }  
    }  
      
    /** 
     *  求二�?�树中的节点个数迭代解法O(n)：基本�?想�?�LevelOrderTraversal， 
     *  �?�用一个Queue，在Java里�?��?�以用LinkedList�?�模拟  
     */  
    public static int getNodeNum(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
        int count = 1;  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
          
        while(!queue.isEmpty()){  
            TreeNode cur = queue.remove();      // 从队头�?置移除  
            if(cur.left != null){           // 如果有左孩�?，加到队尾  
                queue.add(cur.left);  
                count++;  
            }  
            if(cur.right != null){      // 如果有�?�孩�?，加到队尾  
                queue.add(cur.right);  
                count++;  
            }  
        }  
          
        return count;  
    }  
  
    /** 
     * 求二�?�树的深度（高度） 递归解法： O(n) 
     * （1）如果二�?�树为空，二�?�树的深度为0  
     * （2）如果二�?�树�?为空，二�?�树的深度 = max(左�?树深度， �?��?树深度) + 1 
     */  
    public static int getDepthRec(TreeNode root) {  
        if (root == null) {  
            return 0;  
        }  
  
        int leftDepth = getDepthRec(root.left);  
        int rightDepth = getDepthRec(root.right);  
        return Math.max(leftDepth, rightDepth) + 1;  
    }  
      
    /** 
     * 求二�?�树的深度（高度） 迭代解法： O(n) 
     * 基本�?想�?�LevelOrderTraversal，还是用一个Queue 
     */  
    public static int getDepth(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
          
        int depth = 0;                          // 深度  
        int currentLevelNodes = 1;      // 当�?Level，node的数�?  
        int nextLevelNodes = 0;         // 下一层Level，node的数�?  
          
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
          
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();      // 从队头�?置移除  
            currentLevelNodes--;            // �?少当�?Level node的数�?  
            if(cur.left != null){               // 如果有左孩�?，加到队尾  
                queue.add(cur.left);  
                nextLevelNodes++;           // 并增加下一层Level node的数�?  
            }  
            if(cur.right != null){          // 如果有�?�孩�?，加到队尾  
                queue.add(cur.right);  
                nextLevelNodes++;  
            }  
              
            if(currentLevelNodes == 0){ // 说明已�?�??历完当�?层的所有节点  
                depth++;                       // 增加高度  
                currentLevelNodes = nextLevelNodes;     // �?始化下一层的�??历  
                nextLevelNodes = 0;  
            }  
        }  
          
        return depth;  
    }  
      
      
  
    /** 
     * �?�?�??历，中�?�??历，�?��?�??历 �?�?�??历递归解法：  
     * （1）如果二�?�树为空，空�?作  
     * （2）如果二�?�树�?为空，访问根节点，�?�?�??历左�?树，�?�?�??历�?��?树 
     */  
    public static void preorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        System.out.print(root.val + " ");  
        preorderTraversalRec(root.left);  
        preorderTraversalRec(root.right);  
    }  
      
    /** 
     *  �?�?�??历迭代解法：用一个辅助stack，总是把�?�孩�?放进栈 
     *  http://www.youtube.com/watch?v=uPTCbdHSFg4 
     */  
    public static void preorderTraversal(TreeNode root) {  
        if(root == null){  
            return;  
        }  
          
        Stack<TreeNode> stack = new Stack<TreeNode>();      // 辅助stack  
        stack.push(root);  
          
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();     // 出栈栈顶元素  
            System.out.print(cur.val + " ");  
              
            // 关键点：�?先压入�?�孩�?，�?压入左孩�?，这样在出栈时会先打�?�左孩�?�?打�?��?�孩�?  
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
    }  
  
    /** 
     * 中�?�??历递归解法  
     * （1）如果二�?�树为空，空�?作。  
     * （2）如果二�?�树�?为空，中�?�??历左�?树，访问根节点，中�?�??历�?��?树 
     */  
    public static void inorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        inorderTraversalRec(root.left);  
        System.out.print(root.val + " ");  
        inorderTraversalRec(root.right);  
    }  
      
    /** 
     * 中�?�??历迭代解法 ，用栈先把根节点的所有左孩�?都添加到栈内， 
     * 然�?�输出栈顶元素，�?处�?�栈顶元素的�?��?树 
     * http://www.youtube.com/watch?v=50v1sJkjxoc 
     *  
     * 还有一�?方法能�?用递归和栈，基于线索二�?�树的方法，较麻烦以�?�补上 
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/ 
     */  
    public static void inorderTraversal(TreeNode root){  
        if(root == null){  
            return;  
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode cur = root;  
          
        while( true ){  
            while(cur != null){     // 先添加一个�?�空节点所有的左孩�?到栈  
                stack.push(cur);  
                cur = cur.left;  
            }  
              
            if(stack.isEmpty()){  
                break;  
            }  
                  
            // 因为此时已�?没有左孩�?了，所以输出栈顶元素  
            cur = stack.pop();  
            System.out.print(cur.val + " ");  
            cur = cur.right;    // 准备处�?��?��?树  
        }  
    }  
  
    /** 
     * �?��?�??历递归解法  
     * （1）如果二�?�树为空，空�?作  
     * （2）如果二�?�树�?为空，�?��?�??历左�?树，�?��?�??历�?��?树，访问根节点 
     */  
    public static void postorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        postorderTraversalRec(root.left);  
        postorderTraversalRec(root.right);  
        System.out.print(root.val + " ");  
    }  
      
    /** 
     *  �?��?�??历迭代解法 
     *  http://www.youtube.com/watch?v=hv-mJUs5mvU 
     *   
     */  
    public static void postorderTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
          
        Stack<TreeNode> s = new Stack<TreeNode>();      // 第一个stack用于添加node和它的左�?�孩�?  
        Stack<TreeNode> output = new Stack<TreeNode>();// 第二个stack用于翻转第一个stack输出  
          
        s.push(root);  
        while( !s.isEmpty() ){      // 确�?所有元素都被翻转转移到第二个stack  
            TreeNode cur = s.pop(); // 把栈顶元素添加到第二个stack  
            output.push(cur);         
              
            if(cur.left != null){       // 把栈顶元素的左孩�?和�?�孩�?分别添加入第一个stack  
                s.push(cur.left);  
            }  
            if(cur.right != null){  
                s.push(cur.right);  
            }  
        }  
          
        while( !output.isEmpty() ){ // �??历输出第二个stack，�?�为�?��?�??历  
            System.out.print(output.pop().val + " ");  
        }  
    }  
  
    /** 
     * 分层�??历二�?�树（按层次从上往下，从左往�?�）迭代 
     * 相当于广度优先�?�索，使用队列实现。队列�?始化，将根节点压入队列。当队列�?为空，进行如下�?作：弹出一个节点 
     * ，访问，若左�?节点或�?��?节点�?为空，将其压入队列 
     */  
    public static void levelTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.push(root);  
  
        while (!queue.isEmpty()) {  
            TreeNode cur = queue.removeFirst();  
            System.out.print(cur.val + " ");  
            if (cur.left != null) {  
                queue.add(cur.left);  
            }  
            if (cur.right != null) {  
                queue.add(cur.right);  
            }  
        }  
    }  
      
    /** 
     *  分层�??历二�?�树（递归） 
     *  很少有人会用递归去�?�level traversal 
     *  基本�?想是用一个大的ArrayList，里�?�包�?�了�?一层的ArrayList。 
     *  大的ArrayList的size和level有关系 
     *   
     *  这是我目�?�?到的最好的递归解法�? 
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543 
     */  
    public static void levelTraversalRec(TreeNode root) {  
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();  
        dfs(root, 0, ret);  
        System.out.println(ret);  
    }  
      
    private static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret){  
        if(root == null){  
            return;  
        }  
          
        // 添加一个新的ArrayList表示新的一层  
        if(level >= ret.size()){  
            ret.add(new ArrayList<Integer>());  
        }  
          
        ret.get(level).add(root.val);   // 把节点添加到表示那一层的ArrayList里  
        dfs(root.left, level+1, ret);       // 递归处�?�下一层的左�?树和�?��?树  
        dfs(root.right, level+1, ret);  
    }  
      
  
    /** 
     * 将二�?�查找树�?�为有�?的�?��?�链表 �?求�?能创建新节点，�?�调整指针。  
     * 递归解法： 
     * �?�考了http://stackoverflow.com/questions/11511898/converting-a-binary-search-tree-to-doubly-linked-list#answer-11530016 
     * 感觉是最清晰的递归解法，但�?注�?递归完，root会在链表的中间�?置，因此�?手动 
     * 把root移到链表头或链表尾 
     */  
    public static TreeNode convertBST2DLLRec(TreeNode root) {  
        root = convertBST2DLLSubRec(root);  
          
        // root会在链表的中间�?置，因此�?手动把root移到链表头  
        while(root.left != null){  
            root = root.left;  
        }  
        return root;  
    }  
      
    /** 
     *  递归转�?�BST为�?��?�链表(DLL) 
     */  
    public static TreeNode convertBST2DLLSubRec(TreeNode root){  
        if(root==null || (root.left==null && root.right==null)){  
            return root;  
        }  
          
        TreeNode tmp = null;  
        if(root.left != null){          // 处�?�左�?树  
            tmp = convertBST2DLLSubRec(root.left);  
            while(tmp.right != null){   // 寻找最�?�节点  
                tmp = tmp.right;  
            }  
            tmp.right = root;       // 把左�?树处�?��?�结果和root连接  
            root.left = tmp;  
        }  
        if(root.right != null){     // 处�?��?��?树  
            tmp = convertBST2DLLSubRec(root.right);  
            while(tmp.left != null){    // 寻找最左节点  
                tmp = tmp.left;  
            }  
            tmp.left = root;        // 把�?��?树处�?��?�结果和root连接  
            root.right = tmp;  
        }  
        return root;  
    }  
      
    /** 
     * 将二�?�查找树�?�为有�?的�?��?�链表 迭代解法 
//   * 类似inorder traversal的�?�法 
     */  
    public static TreeNode convertBST2DLL(TreeNode root) {  
        if(root == null){  
            return null;  
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode cur = root;        // 指�?�当�?处�?�节点  
        TreeNode old = null;            // 指�?��?一个处�?�的节点  
        TreeNode head = null;       // 链表头  
          
        while( true ){  
            while(cur != null){     // 先添加一个�?�空节点所有的左孩�?到栈  
                stack.push(cur);  
                cur = cur.left;  
            }  
              
            if(stack.isEmpty()){  
                break;  
            }  
                  
            // 因为此时已�?没有左孩�?了，所以输出栈顶元素  
            cur = stack.pop();  
            if(old != null){  
                old.right = cur;  
            }  
            if(head == null){       // /第一个节点为�?��?�链表头节点  
                head = cur;  
            }  
              
            old = cur;          // 更新old  
            cur = cur.right;    // 准备处�?��?��?树  
        }  
          
        return head;  
    }  
  
    /** 
     * 求二�?�树第K层的节点个数   递归解法：  
     * （1）如果二�?�树为空或者k<1返回0 
     * （2）如果二�?�树�?为空并且k==1，返回1 
     * （3）如果二�?�树�?为空且k>1，返回root左�?树中k-1层的节点个数与root�?��?树k-1层节点个数之和 
     *  
     * 求以root为根的k层节点数目 等价于 求以root左孩�?为根的k-1层（因为少了root那一层）节点数目 加上 
     * 以root�?�孩�?为根的k-1层（因为少了root那一层）节点数目 
     *  
     * 所以�?�到树，先把它拆�?左�?树和�?��?树，把问题�?解 
     *  
     */  
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {  
        if (root == null || k < 1) {  
            return 0;  
        }  
  
        if (k == 1) {  
            return 1;  
        }  
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);      // 求root左�?树的k-1层节点数  
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);    // 求root�?��?树的k-1层节点数  
        return numLeft + numRight;  
    }  
      
    /** 
     *  求二�?�树第K层的节点个数   迭代解法：  
     *  �?�getDepth的迭代解法 
     */  
    public static int getNodeNumKthLevel(TreeNode root, int k){  
        if(root == null){  
            return 0;  
        }  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
          
        int i = 1;  
        int currentLevelNodes = 1;      // 当�?Level，node的数�?  
        int nextLevelNodes = 0;         // 下一层Level，node的数�?  
          
        while( !queue.isEmpty() && i<k){  
            TreeNode cur = queue.remove();      // 从队头�?置移除  
            currentLevelNodes--;            // �?少当�?Level node的数�?  
            if(cur.left != null){               // 如果有左孩�?，加到队尾  
                queue.add(cur.left);  
                nextLevelNodes++;           // 并增加下一层Level node的数�?  
            }  
            if(cur.right != null){          // 如果有�?�孩�?，加到队尾  
                queue.add(cur.right);  
                nextLevelNodes++;  
            }  
              
            if(currentLevelNodes == 0){ // 说明已�?�??历完当�?层的所有节点  
                currentLevelNodes = nextLevelNodes;     // �?始化下一层的�??历  
                nextLevelNodes = 0;  
                i++;            // 进入到下一层  
            }  
        }  
          
        return currentLevelNodes;  
    }  
  
    /** 
     * 求二�?�树中�?��?节点的个数（递归） 
     */  
    public static int getNodeNumLeafRec(TreeNode root) {  
        // 当root�?存在，返回空  
        if (root == null) {  
            return 0;  
        }  
  
        // 当为�?��?节点时返回1  
        if (root.left == null && root.right == null) {  
            return 1;  
        }  
  
        // 把一个树拆�?左�?树和�?��?树之和，原�?��?�上一题  
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);  
    }  
      
    /** 
     *  求二�?�树中�?��?节点的个数（迭代） 
     *  还是基于Level order traversal 
     */  
    public static int getNodeNumLeaf(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
          
        int leafNodes = 0;              // 记录上一个Level，node的数�?  
          
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();      // 从队头�?置移除  
            if(cur.left != null){               // 如果有左孩�?，加到队尾  
                queue.add(cur.left);  
            }  
            if(cur.right != null){              // 如果有�?�孩�?，加到队尾  
                queue.add(cur.right);  
            }  
            if(cur.left==null && cur.right==null){          // �?��?节点  
                leafNodes++;  
            }  
        }  
          
        return leafNodes;  
    }  
  
    /** 
     * 判断两棵二�?�树是�?�相�?�的树。 
     * 递归解法：  
     * （1）如果两棵二�?�树都为空，返回真 
     * （2）如果两棵二�?�树一棵为空，�?�一棵�?为空，返回�?�  
     * （3）如果两棵二�?�树都�?为空，如果对应的左�?树和�?��?树都�?�构返回真，其他返回�?� 
     */  
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {  
        // 如果两棵二�?�树都为空，返回真  
        if (r1 == null && r2 == null) {  
            return true;  
        }  
        // 如果两棵二�?�树一棵为空，�?�一棵�?为空，返回�?�  
        else if (r1 == null || r2 == null) {  
            return false;  
        }  
  
        if(r1.val != r2.val){  
            return false;  
        }  
        boolean leftRes = isSameRec(r1.left, r2.left);      // 比较对应左�?树  
        boolean rightRes = isSameRec(r1.right, r2.right); // 比较对应�?��?树  
        return leftRes && rightRes;  
    }  
      
    /** 
     * 判断两棵二�?�树是�?�相�?�的树（迭代） 
     * �??历一�??�?��?�，这里用preorder 
     */  
    public static boolean isSame(TreeNode r1, TreeNode r2) {  
        // 如果两个树都是空树，则返回true  
        if(r1==null && r2==null){  
            return true;  
        }  
          
        // 如果有一棵树是空树，�?�一颗�?是，则返回false  
        if(r1==null || r2==null){  
            return false;  
        }  
          
        Stack<TreeNode> s1 = new Stack<TreeNode>();  
        Stack<TreeNode> s2 = new Stack<TreeNode>();  
          
        s1.push(r1);  
        s2.push(r2);  
          
        while(!s1.isEmpty() && !s2.isEmpty()){  
            TreeNode n1 = s1.pop();  
            TreeNode n2 = s2.pop();  
            if(n1==null && n2==null){  
                continue;  
            }else if(n1!=null && n2!=null && n1.val==n2.val){  
                s1.push(n1.right);  
                s1.push(n1.left);  
                s2.push(n2.right);  
                s2.push(n2.left);  
            }else{  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /** 
     * 判断二�?�树是�?是平衡二�?�树 递归解法：  
     * （1）如果二�?�树为空，返回真 
     * （2）如果二�?�树�?为空，如果左�?树和�?��?树都是AVL树并且左�?树和�?��?树高度相差�?大于1，返回真，其他返回�?� 
     */  
    public static boolean isAVLRec(TreeNode root) {  
        if(root == null){           // 如果二�?�树为空，返回真  
            return true;  
        }  
          
        // 如果左�?树和�?��?树高度相差大于1，则�?�平衡二�?�树, getDepthRec()是�?�?�实现过的求树高度的方法  
        if(Math.abs(getDepthRec(root.left) - getDepthRec(root.right)) > 1){  
            return false;  
        }  
          
        // 递归判断左�?树和�?��?树是�?�为平衡二�?�树  
        return isAVLRec(root.left) && isAVLRec(root.right);  
    }  
      
  
    /** 
     * 求二�?�树的镜�? 递归解法：  
     * （1）如果二�?�树为空，返回空 
     * （2）如果二�?�树�?为空，求左�?树和�?��?树的镜�?，然�?�交�?�左�?树和�?��?树 
     */  
    // 1. 破�??原�?�的树，把原�?�的树改�?其镜�?  
    public static TreeNode mirrorRec(TreeNode root) {  
        if (root == null) {  
            return null;  
        }  
  
        TreeNode left = mirrorRec(root.left);  
        TreeNode right = mirrorRec(root.right);  
  
        root.left = right;  
        root.right = left;  
        return root;  
    }  
      
    // 2. �?能破�??原�?�的树，返回一个新的镜�?树  
    public static TreeNode mirrorCopyRec(TreeNode root){  
        if(root == null){  
            return null;  
        }  
          
        TreeNode newNode = new TreeNode(root.val);  
        newNode.left = mirrorCopyRec(root.right);  
        newNode.right = mirrorCopyRec(root.left);  
          
        return newNode;  
    }  
      
    // 3. 判断两个树是�?�互相镜�?  
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){  
        // 如果两个树都是空树，则返回true  
        if(r1==null && r2==null){  
            return true;  
        }  
          
        // 如果有一棵树是空树，�?�一颗�?是，则返回false  
        if(r1==null || r2==null){  
            return false;  
        }  
          
        // 如果两个树都�?�空树，则先比较根节点  
        if(r1.val != r2.val){  
            return false;  
        }  
          
        // 递归比较r1的左�?树的镜�?是�?是r2�?��?树 和   
        // r1的�?��?树的镜�?是�?是r2左�?树  
        return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);  
    }  
      
    // 1. 破�??原�?�的树，把原�?�的树改�?其镜�?  
    public static void mirror(TreeNode root) {  
        if(root == null){  
            return;  
        }  
          
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        stack.push(root);  
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();  
              
            // 交�?�左�?�孩�?  
            TreeNode tmp = cur.right;  
            cur.right = cur.left;  
            cur.left = tmp;  
              
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
    }  
      
    // 2. �?能破�??原�?�的树，返回一个新的镜�?树  
    public static TreeNode mirrorCopy(TreeNode root){  
        if(root == null){  
            return null;  
        }  
          
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        Stack<TreeNode> newStack = new Stack<TreeNode>();  
        stack.push(root);  
        TreeNode newRoot = new TreeNode(root.val);  
        newStack.push(newRoot);  
          
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();  
            TreeNode newCur = newStack.pop();  
              
            if(cur.right != null){  
                stack.push(cur.right);  
                newCur.left = new TreeNode(cur.right.val);  
                newStack.push(newCur.left);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
                newCur.right = new TreeNode(cur.left.val);  
                newStack.push(newCur.right);  
            }  
        }  
          
        return newRoot;  
    }  
      
  
    /** 
     * 求二�?�树中两个节点的最低公共祖先节点  
     * 递归解法：  
     * （1）如果两个节点分别在根节点的左�?树和�?��?树，则返回根节点 
     * （2）如果两个节点都在左�?树，则递归处�?�左�?树；如果两个节点都在�?��?树，则递归处�?��?��?树 
     */  
    public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {  
        if (findNodeRec(root.left, n1)) {               // 如果n1在树的左�?树  
            if (findNodeRec(root.right, n2)) {      // 如果n2在树的�?��?树  
                return root;                                // 返回根节点  
            } else {            // 如果n2也在树的左�?树  
                return getLastCommonParentRec(root.left, n1, n2); // 递归处�?�  
            }  
        } else {                // 如果n1在树的�?��?树  
            if (findNodeRec(root.left, n2)) {           // 如果n2在左�?树  
                return root;  
            } else {                 // 如果n2在�?��?树  
                return getLastCommonParentRec(root.right, n1, n2); // 递归处�?�  
            }  
        }  
    }  
  
    // 帮助方法，递归判断一个点是�?�在树里  
    private static boolean findNodeRec(TreeNode root, TreeNode node) {  
        if (root == null || node == null) {  
            return false;  
        }  
        if (root == node) {  
            return true;  
        }  
  
        // 先�?试在左�?树中查找  
        boolean found = findNodeRec(root.left, node);  
        if (!found) {       // 如果查找�?到，�?在�?��?树中查找  
            found = findNodeRec(root.right, node);  
        }  
        return found;  
    }  
      
    // 求二�?�树中两个节点的最低公共祖先节点 （更加简�?版的递归）  
    public static TreeNode getLastCommonParentRec2(TreeNode root, TreeNode n1, TreeNode n2) {  
        if(root == null){  
            return null;  
        }  
          
        // 如果有一个match，则说明当�?node就是�?找的最低公共祖先  
        if(root.equals(n1) || root.equals(n2)){  
            return root;  
        }  
        TreeNode commonInLeft = getLastCommonParentRec2(root.left, n1, n2);  
        TreeNode commonInRight = getLastCommonParentRec2(root.right, n1, n2);  
          
        // 如果一个左�?树找到，一个在�?��?树找到，则说明root是唯一�?�能的最低公共祖先  
        if(commonInLeft!=null && commonInRight!=null){  
            return root;  
        }  
          
        // 其他情况是�?�?然在左�?树�?�?然在�?��?树  
        if(commonInLeft != null){  
            return commonInLeft;  
        }  
          
        return commonInRight;  
    }  
  
    /** 
     * �?�递归解法：  
     * 先求从根节点到两个节点的路径，然�?��?比较对应路径的节点就行，最�?�一个相�?�的节点也就是他们在二�?�树中的最低公共祖先节点 
     */  
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode n1, TreeNode n2) {  
        if (root == null || n1 == null || n2 == null) {  
            return null;  
        }  
  
        ArrayList<TreeNode> p1 = new ArrayList<TreeNode>();  
        boolean res1 = getNodePath(root, n1, p1);  
        ArrayList<TreeNode> p2 = new ArrayList<TreeNode>();  
        boolean res2 = getNodePath(root, n2, p2);  
  
        if (!res1 || !res2) {  
            return null;  
        }  
  
        TreeNode last = null;  
        Iterator<TreeNode> iter1 = p1.iterator();  
        Iterator<TreeNode> iter2 = p2.iterator();  
  
        while (iter1.hasNext() && iter2.hasNext()) {  
            TreeNode tmp1 = iter1.next();  
            TreeNode tmp2 = iter2.next();  
            if (tmp1 == tmp2) {  
                last = tmp1;  
            } else { // 直到�?�到�?�公共节点  
                break;  
            }  
        }  
        return last;  
    }  
  
    // 把从根节点到node路径上所有的点都添加到path中  
    private static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {  
        if (root == null) {  
            return false;  
        }  
          
        path.add(root);     // 把这个节点加到路径中  
        if (root == node) {  
            return true;  
        }  
  
        boolean found = false;  
        found = getNodePath(root.left, node, path); // 先在左�?树中找  
          
        if (!found) {               // 如果没找到，�?在�?��?树找  
            found = getNodePath(root.right, node, path);  
        }  
        if (!found) {               // 如果实在没找到�?明这个节点�?在路径中，说明刚�?添加进去的�?是路径上的节点，删掉�?  
            path.remove(root);    
        }  
  
        return found;  
    }  
  
    /** 
     * 求二�?�树中节点的最大�?离 �?�二�?�树中相�?最远的两个节点之间的�?离。 (distance / diameter) 
     * 递归解法：  
     * （1）如果二�?�树为空，返回0，�?�时记录左�?树和�?��?树的深度，都为0 
     * （2）如果二�?�树�?为空，最大�?离�?么是左�?树中的最大�?离，�?么是�?��?树中的最大�?离， 
     * �?么是左�?树节点中到根节点的最大�?离+�?��?树节点中到根节点的最大�?离， 
     * �?�时记录左�?树和�?��?树节点中到根节点的最大�?离。 
     *  
     * http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html 
     *  
     * 计算一个二�?�树的最大�?离有两个情况: 
 
        情况A: 路径�?过左�?树的最深节点，通过根节点，�?到�?��?树的最深节点。 
        情况B: 路径�?穿过根节点，而是左�?树或�?��?树的最大�?离路径，�?�其大者。 
        �?�需�?计算这两个情况的路径�?离，并�?�其大者，就是该二�?�树的最大�?离 
     */  
    public static Result getMaxDistanceRec(TreeNode root){  
        if(root == null){  
            Result empty = new Result(0, -1);       // 目的是让调用方 +1 �?�，把当�?的�?存在的 (NULL) �?树当�?最大深度为 0  
            return empty;  
        }  
          
        // 计算出左�?��?树分别最大�?离  
        Result lmd = getMaxDistanceRec(root.left);  
        Result rmd = getMaxDistanceRec(root.right);  
          
        Result res = new Result();  
        res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;        // 当�?最大深度  
        // �?�情况A和情况B中较大值  
        res.maxDistance = Math.max( lmd.maxDepth+rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance) );  
        return res;  
    }  
      
    private static class Result{  
        int maxDistance;  
        int maxDepth;  
        public Result() {  
        }  
  
        public Result(int maxDistance, int maxDepth) {  
            this.maxDistance = maxDistance;  
            this.maxDepth = maxDepth;  
        }  
    }  
      
    /** 
     * 13. 由�?�?�??历�?列和中�?�??历�?列�?建二�?�树（递归） 
     * 感觉这篇是讲的最为清晰的: 
     * http://crackinterviewtoday.wordpress.com/2010/03/15/rebuild-a-binary-tree-from-inorder-and-preorder-traversals/ 
     * 文中还�??到一�?�?��?开�?外空间的方法，等下次补上 
     */  
    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder){  
        TreeNode root = null;  
        List<Integer> leftPreOrder;  
        List<Integer> rightPreOrder;  
        List<Integer> leftInorder;  
        List<Integer> rightInorder;  
        int inorderPos;  
        int preorderPos;  
   
        if ((preOrder.size() != 0) && (inOrder.size() != 0))  
        {  
            // 把preorder的第一个元素作为root  
            root = new TreeNode(preOrder.get(0));  
   
            //  Based upon the current node data seperate the traversals into leftPreorder, rightPreorder,  
            //  leftInorder, rightInorder lists  
            // 因为知�?�root节点了，所以根�?�root节点�?置，把preorder，inorder分别划分为 root左侧 和 �?�侧 的两个�?区间  
            inorderPos = inOrder.indexOf(preOrder.get(0));      // inorder�?列的分割点  
            leftInorder = inOrder.subList(0, inorderPos);  
            rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());  
   
            preorderPos = leftInorder.size();                           // preorder�?列的分割点  
            leftPreOrder = preOrder.subList(1, preorderPos + 1);  
            rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());  
   
            root.left = rebuildBinaryTreeRec(leftPreOrder, leftInorder);        // root的左�?树就是preorder和inorder的左侧区间而形�?的树  
            root.right = rebuildBinaryTreeRec(rightPreOrder, rightInorder); // root的�?��?树就是preorder和inorder的�?�侧区间而形�?的树  
        }  
   
        return root;  
    }  
      
    /** 
        14.  判断二�?�树是�?是完全二�?�树（迭代） 
        若设二�?�树的深度为h，除第 h 层外，其它�?�层 (1～h-1) 的结点数都达到最大个数， 
        第 h 层所有的结点都连续集中在最左边，这就是完全二�?�树。 
        有如下算法，按层次（从上到下，从左到�?�）�??历二�?�树，当�?�到一个节点的左�?树为空时， 
        则该节点�?��?树必须为空，且�?��?��??历的节点左�?��?树都必须为空，�?�则�?是完全二�?�树。 
     */  
    public static boolean isCompleteBinaryTree(TreeNode root){  
        if(root == null){  
            return false;  
        }  
          
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
        boolean mustHaveNoChild = false;  
        boolean result = true;  
          
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();  
            if(mustHaveNoChild){    // 已�?出现了有空�?树的节点了，�?��?�出现的必须为�?�节点（左�?��?树都为空）    
                if(cur.left!=null || cur.right!=null){  
                    result = false;  
                    break;  
                }  
            } else {  
                if(cur.left!=null && cur.right!=null){      // 如果左�?树和�?��?树都�?�空，则继续�??历  
                    queue.add(cur.left);  
                    queue.add(cur.right);  
                }else if(cur.left!=null && cur.right==null){    // 如果左�?树�?�空但�?��?树为空，说明已�?出现空节点，之�?�必须都为空�?树  
                    mustHaveNoChild = true;  
                    queue.add(cur.left);  
                }else if(cur.left==null && cur.right!=null){    // 如果左�?树为空但�?��?树�?�空，说明这棵树已�?�?是完全二�?�完全树�?  
                    result = false;  
                    break;  
                }else{          // 如果左�?��?树都为空，则�?��?�的必须也都为空�?树  
                    mustHaveNoChild = true;  
                }  
            }  
        }  
        return result;  
    }  
      
    /** 
     * 14.  判断二�?�树是�?是完全二�?�树（递归） 
     * http://stackoverflow.com/questions/1442674/how-to-determine-whether-a-binary-tree-is-complete 
     *  
     */  
    public static boolean isCompleteBinaryTreeRec(TreeNode root){  
//      Pair notComplete = new Pair(-1, false);  
//      return !isCompleteBinaryTreeSubRec(root).equalsTo(notComplete);  
        return isCompleteBinaryTreeSubRec(root).height != -1;  
    }  
      
    // 递归判断是�?�满树（完美）  
    public static boolean isPerfectBinaryTreeRec(TreeNode root){  
        return isCompleteBinaryTreeSubRec(root).isFull;  
    }  
      
    // 递归，�?创建一个Pair class�?��?存树的高度和是�?�已满的信�?�  
    public static Pair isCompleteBinaryTreeSubRec(TreeNode root){  
        if(root == null){  
            return new Pair(0, true);  
        }  
          
        Pair left = isCompleteBinaryTreeSubRec(root.left);  
        Pair right = isCompleteBinaryTreeSubRec(root.right);  
          
        // 左树满节点，而且左�?�树相�?�高度，则是唯一�?�能形�?满树（若�?�树也是满节点）的情况  
        if(left.isFull && left.height==right.height){  
            return new Pair(1+left.height, right.isFull);  
        }  
          
        // 左树�?�满，但�?�树是满节点，且左树高度比�?�树高一  
        // 注�?到如果其左树为�?�完全树，则它的高度已�?被设置�?-1，  
        // 因此�?�?�能满足第二个�?�件�?  
        if(right.isFull && left.height==right.height+1){  
            return new Pair(1+left.height, false);  
        }  
          
        // 其他情况都是�?�完全树，直接设置高度为-1  
        return new Pair(-1, false);  
    }  
      
    private static class Pair{  
        int height;             // 树的高度  
        boolean isFull;     // 是�?�是个满树  
  
        public Pair(int height, boolean isFull) {  
            this.height = height;  
            this.isFull = isFull;  
        }  
  
        public boolean equalsTo(Pair obj){  
            return this.height==obj.height && this.isFull==obj.isFull;  
        }  
    }  
      
}
