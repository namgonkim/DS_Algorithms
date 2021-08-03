package backjoon;

import java.util.Scanner;

/*
문제: 트리 순회 (백준 1991)
유형: 트리, 재귀
날짜: 2021.08.03 (화)
 */
class Node {
    public char data;
    public Node left;
    public Node right;

    public Node(char data) {
        this.data = data;
    }
}

class Tree {
    public Node root;

    public void insert(char data, char left, char right) {
        // root가 비어있으면 root에 저장
        if(root == null) {
            if(data != '.'){
                root = new Node(data);
            }
            if(left != '.'){
                root.left = new Node(left);
            }
            if(right != '.') {
                root.right = new Node(right);
            }
        }
        // 아니라면 데이터가 쌓일 공간 찾아 저장
        else{
            search(root, data, left, right);
        }
    }
    public void search(Node root, char data, char left, char right){
        // root가 비어있으면 종료
        if(root == null) return;
        // root node의 데이터가 data라면
        else if(root.data == data) {
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        }
        // 못찾았으면 왼쪽, 오른쪽 아래 노드로
        else {
            search(root.left, data, left, right);
            search(root.right, data, left, right);
        }
    }
    // 전위 순회 - 루트 왼쪽 오른쪽
    public void preOrder(Node root) {
        System.out.print(root.data);
        // 왼쪽 먼저
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null) {
            preOrder(root.right);
        }
    }
    // 중위 순회 - 왼쪽 루트 오른쪽
    public void inOrder(Node root) {
        if(root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data);
        if(root.right != null) {
            inOrder(root.right);
        }

    }
    // 후위 순회 - 왼쪽 오른쪽 루트
    public void postOrder(Node root) {
        if(root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data);
    }
}
public class Main1991 {

    public static int n; // 이진 트리 노드 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Tree tree = new Tree();
        for(int i=0;i<n;i++) {
            char node, left, right;
            node = sc.next().charAt(0);
            left = sc.next().charAt(0);
            right = sc.next().charAt(0);
            tree.insert(node, left, right);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }
}
