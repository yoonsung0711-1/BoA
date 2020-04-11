
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.stream.Collectors;

public class MinDistBetweenNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        /* 예제 1/
        root = [4, 2, 6, 1, 3, null, null]
         */
        /* 예제 2/
        root = [90, 69, null, 49, 89, null, 52, null, null, null, null]
        */
        /*
        System.out.println(traverse(new Vector<Integer>(), root));
        */
    }
    public static int traverse(Vector<Integer> nums, TreeNode node) {
        /*
        System.out.println("---> stack opened @t node: " + node.val);
        */
        int min = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        if (node.left != null) {
            min = Math.min(traverse(nums, node.left), min);
            /* log/
            System.out.println("\t* left sub: " + min);
            */
        }
        /* log/
        System.out.println(nums);
        System.out.println("\tcur node: " + node.val);
        */
        if (nums.size() > 0) {
            diff = Math.abs(nums.lastElement() - node.val);
            /* log/
            System.out.println("\tdiff: " + diff);
            */
        }
        nums.add(node.val);
        if (node.right != null) {
            min = Math.min(traverse(nums, node.right), min);
            /*log/
            System.out.println("\t* right sub: " + min);
             */
        }
        min = Math.min(diff, min);
        /* log/
        System.out.println("<--- stack closed @t node: " + node.val + ", min :" + min + "\n");
         */
        return min;
    }

}
