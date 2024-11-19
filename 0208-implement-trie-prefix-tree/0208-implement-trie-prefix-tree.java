import java.util.*;
// Trie : 문자열을 저장하고 빠르게 탐색하기 위한 트리 자료구조, 문자열 저장 시 노드에 문자 하나씩 저장
class Trie {
    class Node {
        Map<Character, Node> child; // child list map
        boolean eos; // end of string

        public Node() {
            this.child = new HashMap<>();
            this.eos = false;
        }
    }
    Node root;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node curNode = this.root;
        char[] wordArray = word.toCharArray();
        for(char w : wordArray) {
            // 현재 노드에 없으면 자식으로 생성 
            curNode.child.putIfAbsent(w, new Node());
            // 있으면 
            curNode = curNode.child.get(w);
        }

        curNode.eos = true;
    }
    
    public boolean search(String word) {
        Node node = this.root;
        char[] wordArray = word.toCharArray();
        for(char w : wordArray) {
            if(node.child.containsKey(w)) {
                node = node.child.get(w);
            }
            else {
                return false;
            }
        }
        return node.eos;
    }
    
    public boolean startsWith(String prefix) {
        Node node = this.root;
        char[] wordArray = prefix.toCharArray();
        for(char w : wordArray) {
            if(node.child.containsKey(w)) {
                node = node.child.get(w);
            }
            else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */