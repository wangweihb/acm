package offer.jianzhi;

public class 序列化二叉树 { // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        mySerialize(root,buffer);
        return buffer.toString();
    }

    /**
     * 注意这儿先序遍历生成串的时候，逗号的位置
     * @param root
     * @param buffer
     */
    public static void mySerialize(TreeNode root, StringBuffer buffer) {
        if(buffer.length() >0){
            buffer.append(",");
        }
        if(root != null){
            buffer.append(root.val);
            mySerialize(root.left, buffer);
            mySerialize(root.right, buffer);
        }else{
            buffer.append("#");
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String [] arr = data.split(",");
        int len = arr.length;
        if(arr[0]!="#"){
            TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
            rebuildTree(root, arr, 1, len);
            return root;
        }else{
            return null;
        }
    }
    public static Integer rebuildTree(TreeNode node,String [] arr, int i, int len){
        if(i < len && !"#".equals(arr[i])){
            TreeNode l = new TreeNode(Integer.valueOf(arr[i]));
            node.left = l;
            i = rebuildTree(l, arr, i+1, len);
        }else{
            node.left = null;
            i+=1;
        }
        if(i < len && !"#".equals(arr[i])){
            TreeNode r = new TreeNode(Integer.valueOf(arr[i]));
            node.right = r;
            i = rebuildTree(r, arr, i+1, len);
        }else{
            node.right = null;
            i+=1;
        }
        return i;
    }

    public static void main(String [] args){

        TreeNode treeNode1_1 = new TreeNode(1);
        TreeNode treeNode1_2 = new TreeNode(2);
        TreeNode treeNode1_3 = new TreeNode(3);
        TreeNode treeNode1_4 = new TreeNode(4);
        TreeNode treeNode1_5 = new TreeNode(7);
        TreeNode treeNode1_6 = new TreeNode(7);
        TreeNode treeNode1_7 = new TreeNode(5);
        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
//        treeNode1_2.left = treeNode1_4;
//        treeNode1_2.right = treeNode1_5;
        treeNode1_3.left = treeNode1_4;
//        treeNode1_3.right = treeNode1_7;
        String res = serialize(treeNode1_1);

        TreeNode node = deserialize(res);
        System.out.println(node.val);
    }
}
