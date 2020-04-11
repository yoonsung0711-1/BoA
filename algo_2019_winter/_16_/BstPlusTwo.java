import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

/*

Input:
    5
   / \
  3   6
 / \   \
2   4   7
Target = 9
Output: True

[5,3,6,2,4,null,7]

[]
[2]
[2, 3]
[2, 3, 4]
[2, 3, 4, 5]
[2, 3, 4, 5, 6]
[2, 3, 4, 5, 6, 7]

[2, 3] [2, 4] [2, 5] [2, 6] [2, 7]
-> 5, 6, 7, 8, 9
[3, 4] [3, 5] [3, 6] [3, 7]
-> 7, 8, 9, 10
[4, 5] [4, 6] [4, 7]
-> 9, 10, 11
[5, 6] [5, 7]
-> 11, 12
[6, 7]
-> 13
 */
public class BstPlusTwo {
    LinkedList<Integer> sArr = new LinkedList<>();
    LinkedList<Integer> comb = new LinkedList<>();
    LinkedList<LinkedList<Integer>> snapshot = new LinkedList<>();
    LinkedList<LinkedList<Integer>> combset= new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
//        System.out.println("\ncomb:");
        System.out.println(
            new BstPlusTwo().findTarget(root, 9)
        );
    }

    public boolean findTarget(TreeNode root, int k) {
        traverse(root);
//        /* log/ */System.out.println();

        int n = sArr.size(); int d = 2; int start = 0;
        dfs(n, d, start);
        return combset.stream().map(x -> x.get(0) + x.get(1)).collect(Collectors.toCollection(HashSet::new)).contains(k);
    }

    private void dfs(int n, int d, int start) {
        if (comb.size() == d) {
            combset.add((LinkedList<Integer>) comb.clone());
//            /* log/ */snapshot.add((LinkedList<Integer>) comb.clone());
//            /* log/ */System.out.print(comb);
        }
        for (int i = start; i < n; i++) {
            comb.add(sArr.get(i));
            dfs(n, d, i + 1);
//            if (comb.size() == d && i == n - 1) {
                /*
                System.out.println();
                 */
//                System.out.println("\n-> " + snapshot.stream().map(x -> x.get(0) + x.get(1)).map(y -> y.toString()).collect(Collectors.joining(", ")));
//                snapshot.clear();
//            }
            comb.remove(comb.size() - 1);
        }
    }

    public void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        sArr.add(node.val);
//        /* log/ */System.out.println(sArr);
        traverse(node.right);
    }
}
