class BinarySearchTree {

	class Node { // Class containing left and right child of current node and key value
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	Node root; // Root of BST

	BinarySearchTree() { // Constructor
		root = null;
	}

	void delete(int key) { // This method calls deleteRec()
		root = deleteRec(root, key);
	}

	Node deleteRec(Node root, int key) { // A recursive function to delete an existing key in BST

		if (root == null) // Base Case: If the tree is empty
			return root;

		if (key < root.key) // Otherwise, recur down the tree
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		// if key is same as root's key, then This is the node to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest in the right
			// subtree)
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	int minValue(Node root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int newValue) { // A recursive function to insert a new key in BST

		// If the tree is empty, return a new node

		if (root == null) {
			root = new Node(newValue);
			return root;
		}

		// Otherwise, recur down the tree
		if (newValue < root.key)
			root.left = insertRec(root.left, newValue);
		else if (newValue > root.key)
			root.right = insertRec(root.right, newValue);

		// return the (unchanged) node pointer
		return root;
	}

	// This method mainly calls InorderRec()
	void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + "\n");
			inorderRec(root.right);
		}
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.key) {
			System.out.println("Student found in BST. ");
			return true;
		}
		return value < current.key ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}
}