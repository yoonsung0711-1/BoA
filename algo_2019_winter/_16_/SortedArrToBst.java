import java.util.Arrays;

public class SortedArrToBst {
    public static void main(String[] args) {
        int[] sortedArr = {-10, -3, 0, 5, 9};
        printTree(sortedArrayToBST(sortedArr));
    }
    public static TreeNode sortedArrayToBST(int[] arr) {
        if (arr.length == 0) return null;
        /*log/
        int mid;
        */
        TreeNode node = new TreeNode(arr[arr.length / 2]);
        /* log/
        System.out.println("length: " + sortedArr.length + ", array: " +  Arrays.stream(sortedArr).boxed().collect(Collectors.toCollection(LinkedList::new)));
        System.out.println("mid: " + (mid = sortedArr.length) / 2 + ", el: " + sortedArr[mid / 2]);
        System.out.println(node + "\n");
         */
        int[] left = Arrays.stream(arr).limit(arr.length / 2).toArray();
        int[] right = Arrays.stream(arr).skip(arr.length / 2 + 1).limit(arr.length / 2).toArray();
        node.left = sortedArrayToBST(left);
        node.right = sortedArrayToBST(right);
        return node;
    }

    public static void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }
}


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    @Override
    public String toString() {
        return "N(" + this.val + ")";
    }
}
