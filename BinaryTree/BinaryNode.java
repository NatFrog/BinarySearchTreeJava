package assign08;

/**
 * Represents a generically-typed binary tree node. Each binary node contains
 * data, a reference to the left child, and a reference to the right child. This
 * code was adapted from the lab 9 code
 * 
 * @author Judy Ojewia and Natalie Hicks
 * @version March 21, 2024
 */
public class BinaryNode<Type> {

	private Type data;

	private BinaryNode<Type> parent;

	private BinaryNode<Type> leftChild;

	private BinaryNode<Type> rightChild;

	/**
	 * This constructor creates a binary node that has values for data,
	 * a left child, right child, and a parent
	 * 
	 * @param data - the Type that defines this node
	 * @param leftChild - the node in this BST attached to this node's left
	 * @param rightChild - the node in this BST attached to this node's right
	 * @param parent - the node that this node comes from
	 */
	public BinaryNode(Type data, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild, BinaryNode<Type> parent) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}

	/**
	 * This constructor creates a binary node from a single Type parameter
	 * 
	 * @param data - Type that becomes the data of this node
	 */
	public BinaryNode(Type data) {
		this(data, null, null, null);
	}

	/**
	 * This method sets the parent of this node to a new node
	 * 
	 * @param parent the node that is the parent
	 */
	public void setParent(BinaryNode<Type> parent) {
		this.parent = parent;
	}

	/**
	 * This method gets the parent of this node
	 * 
	 * @return the parent node
	 */
	public BinaryNode<Type> getParent() {
		return this.parent;
	}

	/**
	 * This method gets the data of this node
	 * 
	 * @return the node data
	 */
	public Type getData() {
		return data;
	}

	/**
	 * This method sets the data of this node equal to new data
	 * 
	 * @param data - the node data to be set
	 */
	public void setData(Type data) {
		this.data = data;
	}

	/**
	 * This method returns the left child of this node
	 * 
	 * @return reference to the left child node
	 */
	public BinaryNode<Type> getLeftChild() {
		return leftChild;
	}

	/**
	 * This method sets the value of this node's leftChild to a new node
	 * 
	 * @param leftChild - reference of the left child node to be set
	 */
	public void setLeftChild(BinaryNode<Type> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * This method returns the right child of this node
	 * 
	 * @return reference to the right child node
	 */
	public BinaryNode<Type> getRightChild() {
		return rightChild;
	}

	/**
	 * This method sets the value of this node's right child to a new node
	 * 
	 * @param rightChild - reference of the right child node to be set
	 */
	public void setRightChild(BinaryNode<Type> rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * This method returns the leftmostNode in the binary tree at this node
	 * 
	 * @return reference to the leftmost node in the binary tree rooted at this node
	 */
	public BinaryNode<Type> getLeftmostNode() {
		if (leftChild == null)
			return this;
		return leftChild.getRightmostNode();
	}

	/**
	 * This method returns the rightmostNode in the binary tree at this node
	 * 
	 * @return reference to the rightmost node in the binary tree rooted at this
	 *         node
	 */
	public BinaryNode<Type> getRightmostNode() {
		if (rightChild == null)
			return this;
		return rightChild.getRightmostNode();
	}

	/**
	 * This method returns the successor of this node
	 * 
	 * @return
	 */
	public BinaryNode<Type> successor() {
		return rightChild.getLeftmostNode();
	}

	/**
	 * Helper method to link the data of succesor's children to succesor's parent.
	 * Used as a helper method for the remove method.
	 * 
	 * @return
	 */
	public void updateSuccessor() {
		BinaryNode<Type> data = this.getRightChild();
		BinaryNode<Type> parent = this.getParent();
		parent.setLeftChild(data);
		if (data != null)
			data.setParent(parent);
	}

}
