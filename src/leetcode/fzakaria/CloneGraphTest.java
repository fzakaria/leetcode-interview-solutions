package leetcode.fzakaria;

import org.junit.Test;

import java.util.*;

public class CloneGraphTest {

    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        return cloneGraphHelper(node, new HashMap<>());
    }

    public static Node cloneGraphHelper(Node node, Map<Node, Node> visited) {

        // store the newNode which may be partial here.
        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        for (Node neighbor : node.neighbors) {

            if (visited.containsKey(neighbor)) {
               Node clonedNeighbor = visited.get(neighbor);
               newNode.neighbors.add(clonedNeighbor);
            } else {
                Node clonedNeighbor = cloneGraphHelper(neighbor, visited);
                newNode.neighbors.add(clonedNeighbor);
            }
        }

        return newNode;
    }

    @Test
    public void simpleTest() {
        // turn [[2,4],[1,3],[2,4],[1,3]] into Node
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.addAll(List.of(node2, node4));
        node2.neighbors.addAll(List.of(node1, node3));
        node3.neighbors.addAll(List.of(node2, node4));
        node4.neighbors.addAll(List.of(node1, node3));

        cloneGraph(node1);
    }

}
