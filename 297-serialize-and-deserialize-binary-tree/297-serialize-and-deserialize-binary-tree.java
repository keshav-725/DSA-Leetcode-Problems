/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index;
    public void serialize_(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        serialize_(root.left,sb);
        serialize_(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serialize_(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String []res = data.split(",");
        index = 0;
        TreeNode ans = deserialize_(res);
        return ans;
    }
    public TreeNode deserialize_(String[] res){
        if(res[index].equals("null")){
            index++;
            return null;
        }
        //System.out.println(index);
        TreeNode root = new TreeNode(Integer.parseInt(res[index]));
        index++;
        root.left = deserialize_(res);
        root.right = deserialize_(res);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));