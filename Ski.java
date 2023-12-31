
public class Ski {
	// instance variable for ski class
	private BinaryTreeNode<SkiSegment> root;
	
	public Ski(String[] data) {
		/* creating the array called segments that will contain the same information
		 * as the array parameter data but with SkiSegment objects
		 */
		
		SkiSegment[] segments = new SkiSegment[data.length];
		
		// iterating over all elements of data[]
		for(int i = 0; i<data.length; i++) {
			if (data[i] == null) {
				segments[i] = null;
			}
			// determining if it is a jump segment 
			else if (data[i].contains("jump")) {
				segments[i] = new JumpSegment(String.valueOf(i),data[i]);
			// determining if it is a slalom segment
			}else if (data[i].contains("slalom")) {
				segments[i] = new SlalomSegment(String.valueOf(i),data[i]);
			// otherwise regular segmenet(does not contain anything special)
			}else {
				segments[i] = new SkiSegment(String.valueOf(i),data[i]);
			}
			
		}
		//constructing tree with the data in array segments from previous step
		TreeBuilder<SkiSegment> tree = new TreeBuilder<SkiSegment>();
		LinkedBinaryTree<SkiSegment> TreeForSki = tree.buildTree(segments);
		// storing root of tree in instance variable root  
		root = TreeForSki.getRoot();
		
		
	}
	// returning trees root node
	public BinaryTreeNode<SkiSegment> getRoot(){
		return root;
	}
	// determining the next node to access
	public void skiNextSegment(BinaryTreeNode<SkiSegment> node,
			ArrayUnorderedList<SkiSegment> sequence) {
		sequence.addToRear(node.getData());
		
		 //first checking if node.getLeft() and node.getRight() is not null 
		if ((node.getLeft()!= null) && (node.getRight()!= null)) {
			// then checking if node.getLeft and node.getRight are instance of salolm segment
			if ((node.getLeft().getData() instanceof SlalomSegment) && (node.getRight().getData() instanceof SlalomSegment)) {
				//if node.getleft height is more than node.getRight: 
				if (((JumpSegment) node.getLeft().getData()).getHeight() > 
				((JumpSegment) node.getRight().getData()).getHeight()) {
					node = node.getLeft();
					skiNextSegment(node,sequence);
				}
				// if node.getLeft height is less than node.getRight:
				if (((JumpSegment) node.getLeft().getData()).getHeight() 
						< ((JumpSegment) node.getRight().getData()).getHeight()) {
					node = node.getRight();
					skiNextSegment(node,sequence);
				}
				// if node.getLeft height is equal to node.getHeight:
				if (((JumpSegment) node.getLeft().getData()).getHeight() ==
						((JumpSegment) node.getRight().getData()).getHeight()) {
					node = node.getRight();
					skiNextSegment(node, sequence);
				}
			}
			
		}
	}
	
}
