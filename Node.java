/**
 * Assignment #: ASU CSE205 Spring 2023 #11
 * Name: Shravan Karande
 * StudentID: 1225888172
 * Lecture: 10:30 am to 11:45 am. T TH
 * Description: The Node class represents a node in a binary tree data structure that contains a Game object and references to its left and right child nodes. It provides accessors and mutators for the Game object and child nodes.
 */

public class Node {
    // Declare instance variables
    private Game game;
    private Node left, right;

    // Define constructor
    public Node(Game game) {
        this.game = game;
        left = null;
        right = null;
    }

    // Define accessors/mutators
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}