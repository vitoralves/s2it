package com.s2it.api.util;

public class BinaryTree {

	Node root;
    static int sum = 0;
    
	public BinaryTree() {
		sum = 0;
	}

	public void addNode(int key) {

        // Create a new Node and initialize it
        Node newNode = new Node(key);

        // If there is no root this becomes root
        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;

            // Future parent for our new Node
            Node parent;

            while (true) {

                // root is the top parent so we start
                // there
                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node
                if (key < focusNode.valor) {

                    // Switch focus to the left child
                    focusNode = focusNode.left;

                    // If the left child has no children
                    if (focusNode == null) {

                        // then place the new node on the left of it
                        parent.left = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.right;

                    // If the right child has no children
                    if (focusNode == null) {

                        // then place the new node on the right of it
                        parent.right = newNode;
                        return; // All Done

                    }

                }

            }
        }
    }

    public Node findNode(int key) {

        // Start at the top of the tree
        Node focusNode = root;

        // While we haven't found the Node
        // keep looking
        while (focusNode.valor != key) {

            // If we should search to the left
            if (key < focusNode.valor) {

                // Shift the focus Node to the left child
                focusNode = focusNode.left;

            } else {

                // Shift the focus Node to the right child
                focusNode = focusNode.right;

            }

            // The node wasn't found
            if (focusNode == null) {
                return null;
            }

        }

        return focusNode;

    }

    public static int sumBYNode(Node n) {
        if (n != null) {
            sum += n.valor;
            if (n.left != null) {
                sumBYNode(n.left);
            }
            if (n.right != null) {
                sumBYNode(n.right);
            }
        }
        
        return sum;
        
    }

}
