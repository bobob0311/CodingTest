import java.util.*;

class Solution {
    static class Node {
        int x, y, idx;
        Node left, right;
        
        Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i<nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        Arrays.sort(nodes, (a,b) -> {
            if(b.y != a.y){
                return Integer.compare(b.y, a.y);
            }else{
                return Integer.compare(a.x, b.x);
            }
        });
        
        Node root = nodes[0];
        
        for(int i =1; i<nodes.length; i++){
            insertNode(root,nodes[i]);
        }
        preOrder(root);
        postOrder(root);
        
        int[][] answer = new int[2][nodeinfo.length];
        
        for(int i = 0; i<nodeinfo.length; i++){
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        
        
        return answer;
    }
    void insertNode(Node parent, Node child){
        if(child.x<parent.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                insertNode(parent.left, child);
            }
        }else {
            if(parent.right == null){
                parent.right = child;
            }else {
                insertNode(parent.right , child);
            }
        }
    }
    
    void preOrder (Node node){
        if(node != null){
            preOrderList.add(node.idx);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    void postOrder (Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            postOrderList.add(node.idx);
        }
    }
}