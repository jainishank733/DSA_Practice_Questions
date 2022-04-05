package Session_31;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public class Node{
        char data;
        Map<Character, Node> children;
        boolean isMarked;
        int count;

        public Node(char data){
            this.data = data;
            this.children = new HashMap<>();
            this.isMarked = false;
            this.count = 0;
        }

    }

    Node root;

    public Trie(){
        this.root = new Node('*');
    }

    public void insert(String word){
        Node cur = root;
        for(char c: word.toCharArray()){
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            }else{
                Node n = new Node(c);
                cur.children.put(c,n);
                cur = n;
            }
            cur.count++;
        }
        cur.isMarked = true;
    }

    public boolean search(String word){
        Node cur = root;
        for(char c: word.toCharArray()){
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            }else{
                return false;
            }
        }
        return cur.isMarked;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }

        return true;
    }

    private int countPrefix(String prefix) {
        Node curr = root;

        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return 0;
            }
        }

        return curr.count;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
		trie.insert("RAJ");
		trie.insert("RAM");

		System.out.println(trie.search("RA"));
		trie.insert("RA");
		System.out.println(trie.search("RA"));

        trie.insert("hack");
        trie.insert("hackerrank");
        System.out.println(trie.startsWith("hac"));
        System.out.println(trie.countPrefix("rank"));

    }

}
