// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
// Example: 
//
//
// You may serialize the following tree:
//
//     1
//    / \
//   2   3
//      / \
//     4   5
//
// as "[1,2,3,null,null,4,5]"
//
//
// Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
//


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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        rserialize(root, sb);
        return sb.toString();
    }
    
    void rserialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(Integer.valueOf(root.val) + ",");
        rserialize(root.left, sb);
        rserialize(root.right, sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        for (String a : dataArr)
            System.out.println("input: "+a);
        List<String> list = new LinkedList<>(Arrays.asList(dataArr));
        return rdeserialize(list);
    }
    
    TreeNode rdeserialize(List<String> list){
        String curr_val = list.remove(0);
        if(curr_val.equals("null")){
            return null;            
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(curr_val));
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
