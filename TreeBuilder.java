
public class TreeBuilder<T> {

	
	public LinkedBinaryTree<T> buildTree (T[] data){
		// making dataQueue and parent queue
		LinkedQueue<T> dataQueue = new LinkedQueue<T>();
		
		LinkedQueue<BinaryTreeNode<T>> parentQueue = new LinkedQueue<BinaryTreeNode<T>>();
		
		T a;
		T b;
		BinaryTreeNode<T> parent;
		// enqueue all elements to dataQueue (initializing dataQueue)
		for (int index=0 ; index <data.length; index ++) {
			dataQueue.enqueue(data[index]);
		}
		// creating class treeRoot and setting the first element of dataQueue as its root
		BinaryTreeNode<T> treeRoot = new BinaryTreeNode<T>(dataQueue.dequeue());
		parentQueue.enqueue(treeRoot);
		
		//iterating till dataQueue is empty
		while (!(dataQueue.isEmpty())) {
			a = dataQueue.dequeue();
			b = dataQueue.dequeue();
			
			parent = parentQueue.dequeue();
			
			// making a node from a and setting it as left side of the tree and enqueueing it to parentQueue
			if (a != null) {
				// making a node storing a 
				BinaryTreeNode<T> nodeStringA = new BinaryTreeNode<T>(a);
				parent.setLeft(nodeStringA);
				parentQueue.enqueue(nodeStringA);
			}
			//making a node from b and setting it as right side of the tree and enqueueing it to parentQueue
			if (b != null) {
				// making a node storing b 
				BinaryTreeNode<T> nodeStringB = new BinaryTreeNode<T>(b);
				parent.setRight(nodeStringB);
				parentQueue.enqueue(nodeStringB);
			}
		}
		return new LinkedBinaryTree<T> (treeRoot);
		
		
	}
}
