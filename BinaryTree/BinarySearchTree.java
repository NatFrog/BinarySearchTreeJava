package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Represents a generically-typed BinarySearchTree (BST). The BST holds
 * generic binary nodes and connects the nodes based on if their data is 
 * smaller or larger than the previous node. 
 * 
 * @author Judy Ojewia and Natalie Hicks
 * @version March 21, 2024
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {

	private BinaryNode<Type> root;
	private int size;

	/**
	 * This constructor creates a binary search t
	 */
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * Ensures that this BST contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this BST
	 * @return true if this BST changed as a result of this method call 
	 */
	public boolean add(Type item) {
		if (this.root == null) {
			this.root = new BinaryNode<Type>(item);
			this.size++;
			return true;
		}

		BinaryNode<Type> temp = this.root;
		BinaryNode<Type> itemNode = new BinaryNode<Type>(item);

		while (true) {

			if (temp.getData().equals(item)) {
				return false;
			}

			if (temp.getData().compareTo(item) < 0) {
				if (temp.getRightChild() == null) {
					temp.setRightChild(itemNode);
					itemNode.setParent(temp);
					size++;
					return true;
				}
				temp = temp.getRightChild();
			}

			if (temp.getData().compareTo(item) > 0) {
				if (temp.getLeftChild() == null) {
					temp.setLeftChild(itemNode);
					itemNode.setParent(temp);
					size++;
					return true;
				}
				temp = temp.getLeftChild();
			}
		}
	}

	/**
	 * Ensures that this BST contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this BST
	 * @return true if this BST changed as a result of this method call. Otherwise,
	 *         returns false
	 */
	public boolean addAll(Collection<? extends Type> items) {
		boolean addAll = false;
		for (Type item : items) {
			addAll = add(item);
			if (add(item)) {
				return true;
			}
		}
		return addAll;
	}

	/**
	 * Removes all items from this set. The BST will be empty after this method
	 * call.
	 */
	public void clear() {
		this.root = null;
		this.size = 0;

	}

	/**
	 * Determines if there is an item in this BST that is equal to the specified
	 * item.
	 * 
	 * @param item - the item sought in this BST
	 * @return true if there is an item in this BST that is equal to the input item;
	 *         otherwise, returns false
	 */
	public boolean contains(Type item) {
		BinaryNode<Type> temp = root;
		while (temp != null) {
			Type data = temp.getData();

			if (data.compareTo(item) == 0) {
				return true;
			} else if (data.compareTo(item) < 0) {
				temp = temp.getRightChild();
			} else {
				temp = temp.getLeftChild();
			}
		}
		return false;
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in
	 * this BST that is equal to it.
	 * 
	 * @param items - the collection of items sought in this BST
	 * @return true if for each item in the specified collection, there is an item
	 *         in this BST that is equal to it; otherwise, returns false
	 */
	public boolean containsAll(Collection<? extends Type> items) {
		int containsA = 0;
		for (Type item : items) {
			if (contains(item)) {
				containsA++;
			}
		}
		return items.size() == containsA;
	}

	/**
	 * Returns the first (i.e., smallest) item in this BST.
	 * 
	 * @throws NoSuchElementException if the BST is empty
	 * @return the data of the smallest node
	 * 
	 */
	public Type first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("The set is empty");
		}
		return root.getLeftmostNode().getData();
	}

	/**
	 * Returns true if this BST contains no items.
	 * 
	 * @return true if the BST is empty
	 */
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the last (i.e., largest) item in this BST.
	 * 
	 * @throws NoSuchElementException if the BST is empty
	 * @return the data of the largest node
	 */
	public Type last() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("The set is empty");
		}
		return root.getRightmostNode().getData();

	}

	/**
	 * This method is a helper method for the remove method that searches through the
	 * BST and finds the binary node with the specified data type.
	 * 
	 * @param item - the data of the node we are looking for
	 * @return - the binary node that contains the correct data.
	 */
	private BinaryNode<Type> findRemove(Type item) {
		BinaryNode<Type> temp = root;
		while (temp != null) {
			Type data = temp.getData();

			if (data.compareTo(item) == 0) {
				return temp;
			} else if (data.compareTo(item) < 0) {
				temp = temp.getRightChild();
			} else {
				temp = temp.getLeftChild();
			}
		}
		return null;
	}

	/**
	 * Ensures that this BST does not contain the specified item by either removing
	 * the item or returning it.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually removed); otherwise, returns false
	 */
	public boolean remove(Type item) {

		BinaryNode<Type> removed = findRemove(item);

		if (removed == null)
			return false;
		else {
			size--;
		}

		// case1 : removed has no child
		if (removed.getLeftChild() == null && removed.getRightChild() == null) {
			if (removed.getParent() == null) {
				root = null;
				return true;
			} else if (removed.getParent().getLeftChild() == removed) {
				removed.getParent().setLeftChild(null);
				return true;
			} else {
				removed.getParent().setRightChild(null);
				return true;
			}
		}

		// case2: removed has only one child
		if ((removed.getLeftChild() != null && removed.getRightChild() == null)
				|| (removed.getRightChild() != null && removed.getLeftChild() == null)) {

			BinaryNode<Type> child;

			if (removed.getLeftChild() != null)
				child = removed.getLeftChild();
			else
				child = removed.getRightChild();

			if (removed.getParent() == null) {
				root = child;
				root.setParent(null);
				return true;
			}

			if (removed.getParent().getLeftChild() == removed) {
				removed.getParent().setLeftChild(child);
				return true;
			} else if (removed.getParent().getRightChild() == removed) {
				removed.getParent().setRightChild(child);
				return true;
			}
		}

		// case 3 removed has 2 children
		if ((removed.getLeftChild() != null && removed.getRightChild() != null)) {

			BinaryNode<Type> suc = removed.successor();

			if (removed.getParent() == null) {
				Type temp = suc.getData();
				remove(suc.getData());
				size++;
				root.setData(temp);

				return true;
			}

			if (removed.getParent().getLeftChild() == removed) {
				removed.getParent().getLeftChild().setData(suc.getData());
				removed.successor().updateSuccessor();
				return true;
			}
			if (removed.getParent().getRightChild() == removed) {
				removed.getParent().getRightChild().setData(suc.getData());
				removed.successor().updateSuccessor();
				return true;
			}

		}

		return false;

	}

	/**
	 * Ensures that this BST does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually removed); otherwise,
	 *         returns false
	 */
	public boolean removeAll(Collection<? extends Type> items) {
		int initialSize = this.size();

		for (Type item : items) {
			remove(item);
		}
		if (initialSize != this.size()) {
			return true;
		}
		return false;

	}

	/**
	 * Returns the number of items in this set.
	 * 
	 * @return number of items
	 */
	public int size() {
		return this.size;

	}

	/**
	 * Returns an ArrayList containing all of the items in this BST, in sorted
	 * order. This method is a driver method that calls the recursive toArrayList
	 * method
	 * 
	 * @return - an ArrayList containing every item in the BST in sorted order
	 */
	public ArrayList<Type> toArrayList() {

		ArrayList<Type> items = new ArrayList<Type>();

		if (isEmpty())
			return items;

		return toArrayList(root, items);

	}

	/**
	 * Returns an ArrayList containing all of the items in this BST, in sorted
	 * order.
	 * 
	 * @param start - The node that represents the root node or start of this
	 *              BinarySearchTree
	 * @param items - the ArrayList that items should be added to
	 * @return - an ArrayList containing every item in the BST in sorted order
	 */
	public ArrayList<Type> toArrayList(BinaryNode<Type> start, ArrayList<Type> items) {

		if (start.getLeftChild() != null) {
			toArrayList(start.getLeftChild(), items);
		}

		items.add(start.getData());

		if (start.getRightChild() != null) {
			toArrayList(start.getRightChild(), items);
		}
		return items;

	}

}
