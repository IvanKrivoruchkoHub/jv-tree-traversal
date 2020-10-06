package core.basesyntax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    // Root of Binary Tree
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /* Given a binary tree, print its nodes according to the 
      "bottom-up" post order traversal. (left - right - root)*/
    public List<Node> getNodesPostOrder(Node node) {
        List<Node> listNodesOfTree = new ArrayList<>();
        if (node != null) {
            listNodesOfTree.addAll(getNodesPostOrder(node.getLeft()));
            listNodesOfTree.addAll(getNodesPostOrder(node.getRight()));
            listNodesOfTree.add(node);
        }
        return listNodesOfTree;
    }

    public List<Node> getNodesPostOrderSecondWay(Node node) {
        List<Node> listNodesOfTree = new ArrayList<>();
        postOrder(node, listNodesOfTree);
        return listNodesOfTree;
    }

    private void postOrder(Node node, List<Node> listOfNodes) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft(), listOfNodes);
        postOrder(node.getRight(), listOfNodes);
        listOfNodes.add(node);
    }

    /* Given a binary tree, print its nodes in inorder(left - root - right)*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> listNodesOfTree = new ArrayList<>();
        if (node != null) {
            listNodesOfTree.addAll(getNodesPostOrder(node.getLeft()));
            listNodesOfTree.add(node);
            listNodesOfTree.addAll(getNodesPostOrder(node.getRight()));
        }
        return listNodesOfTree;
    }

    public List<Node> getNodesInorderSecondWay(Node node) {
        List<Node> listElementsOfTree = new ArrayList<>();
        inOrder(node, listElementsOfTree);
        return listElementsOfTree;
    }

    private void inOrder(Node node, List<Node> listOfNodes) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft(), listOfNodes);
        listOfNodes.add(node);
        inOrder(node.getRight(), listOfNodes);
    }

    /* Given a binary tree, print its nodes in pre order (root - left - right)*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> listNodesOfTree = new ArrayList<>();
        if (node != null) {
            listNodesOfTree.add(node);
            listNodesOfTree.addAll(getNodesPostOrder(node.getLeft()));
            listNodesOfTree.addAll(getNodesPostOrder(node.getRight()));
        }
        return listNodesOfTree;
    }

    public List<Node> getNodesPreOrderSecondWay(Node node) {
        List<Node> listElementsOfTree = new ArrayList<>();
        preOrder(node, listElementsOfTree);
        return listElementsOfTree;
    }

    private void preOrder(Node node, List<Node> listOfNodes) {
        if (node == null) {
            return;
        }
        listOfNodes.add(node);
        preOrder(node.getLeft(), listOfNodes);
        preOrder(node.getRight(), listOfNodes);
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queueElementsOfTree = new LinkedList<>();
        List<Node> resultList = new ArrayList<>();
        queueElementsOfTree.add(node);

        while (!queueElementsOfTree.isEmpty()) {
            Node tempNode = queueElementsOfTree.poll();
            resultList.add(tempNode);
            if (tempNode.getLeft() != null) {
                queueElementsOfTree.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queueElementsOfTree.add(tempNode.getRight());
            }
        }
        return resultList;
    }
}
