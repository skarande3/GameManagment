/**
 * Assignment #: ASU CSE205 Spring 2023 #11
 * Name: Shravan Karande
 * StudentID: 1225888172
 * Lecture: 10:30 am to 11:45 am. T TH
 * Description: This class has several methods such as addGameToStore, listGamesByPrice, removeGameFromStore, findMinNode, countGamesInStore, searchByPrice, calculateStoreValue, and searchMostPopularGame that use recursion. 
 */

public class ZyBoxLiveStore {

	private Node root; // Binary Search Tree root node

	// Constructor
	public ZyBoxLiveStore() {
		this.root = null;
	}

	// This recursive method adds a game object to a binary search tree based on its price and checks for duplicates.

	public Node addGameToStore(Node node, Game gameToAdd) {

		// If the current node is null, it create a new node with the @param game and return it

		Game game = gameToAdd;


		if (node == null) {// base case

			return new Node(game);

		}
		else { 

			double thenodeprice = node.getGame().getPrice();
			double thegameprice = game.getPrice();
			if (thegameprice < thenodeprice) {

				node.setLeft(addGameToStore(node.getLeft(), game));
			}

			// else if, When both variables are compared and thegameprice price is greater than the thenodeprice at the current node, add it to the right subtree

			else if (thenodeprice < thegameprice) {

				node.setRight(addGameToStore(node.getRight(), game));
			}

			// else if, thegameprice is equal to thenodeprice of the game at the current node, it states "Game at this price is in store inventory already." and do not add it to the tree

			else if (thenodeprice == thegameprice) {
				System.out.println("Game at this price is in store inventory already.\n");
			}
		}
		return node;
	}


	// This recursive method lists all the games in the store sorted by their prices (in ascending order).    

	public void listGamesByPrice(Node node) {

		//if node is null it returns nothing.
		if (node == null) {
			return;
		}
		// if it is not null it recursively traverses through the left node and then the right (In-order: left-root-right).  	   

		else{
			listGamesByPrice(node.getLeft());
			System.out.print(node.getGame().toString());
			listGamesByPrice(node.getRight());
		} 
	}


	// * removeGameFromStore(...) METHOD PROVIDED AS PART OF TEMPLATE
	// Removes a game from the BST based on the game's price (the BST key)
	public Node removeGameFromStore(Node node, double price) {
		if (node == null) {
			return null;
		}

		double nodePrice = node.getGame().getPrice();

		if (price < nodePrice) {
			node.setLeft(removeGameFromStore(node.getLeft(), price));
		} else if (price > nodePrice) {
			node.setRight(removeGameFromStore(node.getRight(), price));
		} else {
			// Found the node to be removed
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				// Node has two children, find successor and replace node
				Node successor = findMinNode(node.getRight());
				node.setGame(successor.getGame());
				node.setRight(removeGameFromStore(node.getRight(), successor.getGame().getPrice()));
			}
		}
		return node;
	}


	//This method is used to find the node with the smallest key value in a subtree rooted at a given node in a Binary Search Tree (BST).

	private Node findMinNode(Node right) {

		//if the leftmost node doesn't exist it is the left most and we return it (right)   	

		if (right.getLeft() == null) {
			return right; }

		// else it will recursively call the method again always looking for the lestmost node and then returning it.     	    

		return findMinNode(right.getLeft());

	}




	// This method recursively traverses the BST starting from the root node and counts the number of nodes (games) in the tree. 

	public int countGamesInStore(Node node) {

		int count = 0; 
		int leftnodesCount = 0; 
		int rightnodesCount = 0; 

		// if the node is null, there are no nodes in the subtree and it returns 0

		if (node == null) {
			return count; 
		}

		// this recursively counts the nodes in the left subtree

		leftnodesCount = countGamesInStore(node.getLeft());

		// this recursively counts the nodes in the right subtree

		rightnodesCount = countGamesInStore(node.getRight());

		// add the count of the current node

		count = leftnodesCount + rightnodesCount + 1;

		return count;
	}



	// This method searches for a game in the store based on the specified price.

	public Game searchByPrice(Node root, double price) {
		double cost = price; 

		// if the root is null, null is returned 

		if (root == null) {
			return null;
		}
		// this gets the Game object stored in the current root node and its price

		Game thegame = root.getGame();

		double gameprice = thegame.getPrice();

		// If the price of the game in the root node matches the @param price, it return the game

		if (gameprice == cost) {

			return thegame;

			// If the price of the game in the root node is greater than the target price, recursively search in the left subtree

		} else if (gameprice > cost) {

			return searchByPrice(root.getLeft(), cost);

			// If the price of the game in the root node is less than the target price, recursively search in the right subtree


		} else if (gameprice  < cost) {

			return searchByPrice(root.getRight(), cost);
		}

		// else it returns null asuming the game was  not found.             
		return null; 

	}

	// This method recursively calculates the total value of the store by adding up the prices of all the games stored in the store's nodes.

	public double calculateStoreValue(Node node) {

		double currentNodePrice = 0;
		double leftSubtreePrices = 0;
		double rightSubtreePrices = 0; 
		double totalPrice = 0;

		// if the @param node is null, returns 0.

		if (node == null) {
			return totalPrice; 
		}

		// calculate the prices of the current node, and recursively call the method to calcualte the left subtree, and the right subtree

		currentNodePrice = node.getGame().getPrice();

		leftSubtreePrices = calculateStoreValue(node.getLeft());

		rightSubtreePrices = calculateStoreValue(node.getRight());

		// add up the prices and return the total

		totalPrice = currentNodePrice + leftSubtreePrices + rightSubtreePrices;

		return totalPrice;
	}


	// This method returns the game with the highest number of downloads. 

	public Game searchMostPopularGame(Node node) {

		// if the @param node is null, returns null.

		if (node == null) {
			return null;
		}
		// initializing a Game variables to keep track of the most popular game and set it to the current game.

		Game currentgame = node.getGame(); 

		// travesring through the left subtree 

		Game leftMostPopular = searchMostPopularGame(node.getLeft());

		// if the node is not null and if the left subtree returns a game with more downloads than the current most popular game, the mostPopular variable is updated to the left subtree's game

		if (leftMostPopular != null && leftMostPopular.getDownloads() > currentgame.getDownloads()) {

			currentgame = leftMostPopular;
		}

		// travesring through the right subtree 

		Game rightMostPopular = searchMostPopularGame(node.getRight());

		// if the node is not null and if the right subtree returns a game with more downloads than the current most popular game, the mostPopular variable is updated to the right subtree's game 

		if (rightMostPopular != null && rightMostPopular.getDownloads() > currentgame.getDownloads()) {

			currentgame = rightMostPopular;
		}	    

		return currentgame;

	}


	// * searchByName(...) METHOD PROVIDED AS PART OF TEMPLATE
	// Searches for a game (by name) in the store. Returns null if there are no
	// games in the store or the game was not found. Otherwise, returns the Game
	// object with the game's matching name
	public Game searchByName(Node node, String name) {
		if (node == null) {
			return null;
		}
		Game leftResult = searchByName(node.getLeft(), name);
		if (leftResult != null) {
			return leftResult;
		}
		if (node.getGame().getName().equals(name)) {
			return node.getGame();
		}
		Game rightResult = searchByName(node.getRight(), name);
		return rightResult;
	}

	// * get/setRoot(...) METHODS PROVIDED AS PART OF TEMPLATE
	// getters and setters for the BST root
	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

}