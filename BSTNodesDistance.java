package algo;

import java.util.ArrayList;
import java.util.List;

public class BSTNodesDistance {

	static Node root = null;
	static List<Integer> bst = new ArrayList<Integer>();
	public static void main(String [] args){		
		int[] values = {5,6,7,32,4,3,1,2};
		createBST(values);
		traverse();
		//Print tree
		bst.forEach(value -> System.out.print(value + "->"));
		int distance = findDistance(32,1);
		if(distance ==-1){
			System.out.println("\nNode not available");
		}else{
			System.out.println("\nDistance between val1 & val2: "+distance);
		}
		
	}
	
	static class Node{
		int data;
		Node leftChild;
		Node rightChild;
		
		public Node(int data){
			this.data= data;
		}
	}
	
	public static void createBST(int[] values){
		
		if(values!=null){
			for(int i=0;i<values.length;i++){
				insertNode(values[i]);
			}
		}
	}
	
	public static void insertNode(int data){
		if(root==null){
			root =new Node(data);
			return;
		}
		insert(root,data);
	}
	
	private static void insert(Node node, int data){
		if(data > node.data){
			if(node.rightChild!=null){
				insert(node.rightChild,data);
			}else{
				Node newNode = new Node(data);
				node.rightChild = newNode;
			}
		}else{
			//left child
			if(node.leftChild!=null){
				insert(node.leftChild,data);
			}else{
				Node newNode = new Node(data);
				node.leftChild = newNode;
			}
		}
	}
	public static void traverse(){
		if(root!=null){
			inOrderTraversal(root);
		}
	}
	
	private static void inOrderTraversal(Node node){
		if(node.leftChild!=null){
			inOrderTraversal(node.leftChild);
		}
		bst.add(node.data);
		if(node.rightChild!=null){
			inOrderTraversal(node.rightChild);
		}
		
	}
	public static int findDistance(int val1, int val2){
		
		int startIndex=-1;
		int endIndex=-1;
		for(int i=0; i<bst.size();i++){
			if(val1 > val2){
				if(bst.get(i)==val2){
					startIndex=i;
					continue;
				}
				if(startIndex > -1){
					if(bst.get(i)==val1){
						endIndex=i;
						break;
					}
				}
			}else{
				if(bst.get(i)==val1){
					startIndex=i;
					continue;
				}
				if(startIndex > -1){
					if(bst.get(i)==val2){
						endIndex=i;
						break;
					}
				}
			}
		}
		if(startIndex==-1 || endIndex==-1){			
			return -1;
		}
		return (endIndex-startIndex);
	}

}
