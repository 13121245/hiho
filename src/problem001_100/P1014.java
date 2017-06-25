package problem001_100;

import java.util.Scanner;
/**
 * Created by zjw on 2017/6/22.
 */

// Trie树
public class P1014 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        TrieTree tree = new TrieTree();
        n = Integer.valueOf(scan.nextLine());
        for(int i = 1; i <= n; i++) {
            String s = scan.nextLine();
            tree.addWord(s);
        }
        m = Integer.valueOf(scan.nextLine());
        for(int i = 1; i <= m; i++) {
            String s = scan.nextLine();
            System.out.println(tree.searchPrefix(s));
        }
    }

}

class TrieTree {
    TreeNode root = new TreeNode();

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TreeNode cur = root;
        for(int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if(cur.childs[index] == null) {
                cur.childs[index] = new TreeNode(chars[i]);
            }
            cur = cur.childs[index];
            cur.total += 1;
        }
        cur.flag = true;
    }

    public int searchPrefix(String aim) {
        char[] chars = aim.toCharArray();
        TreeNode cur = root;
        for(int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if(cur.childs[index] == null)
                return 0;
            else
                cur = cur.childs[index];
        }
        return cur.total;
    }
}

class TreeNode {
    // 孩子
    TreeNode[] childs = new TreeNode[26];
//     孩子节点的数量
//    int[] nums = new int[26];
    // 总数量
    int total = 0;
    // 该节点是否是一个单词的结尾
    boolean flag = false;
    char value;

    public TreeNode() {
    }

    public TreeNode(char value) {
        this.value = value;
    }

}
