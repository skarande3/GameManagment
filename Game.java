/**
 * Assignment #: ASU CSE205 Spring 2023 #11
 * Name: Shravan Karande
 * StudentID: 1225888172
 * Lecture: 10:30 am to 11:45 am. T TH
 * Description: The Game class represents a video game and contains information such as the game's name, description, price, and number of downloads. it has accessor methods that allow access to the values of the variables. 
 */

public class Game {
    // Declare instance variables
    private String name;
    private String description;
    private double price;
    private int downloads;

    // Define constructor
    public Game(String name, String description, double price, int downloads) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.downloads = downloads;
    }

    // Define accessor methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getDownloads() {
        return downloads;
    }

    // Define string representation of Game objects
    @Override
    public String toString() {
        return name + "\n" + description + "\nZyBox Price: $" + String.format("%.2f", price) + "\n" + downloads
                + " downloads\n";
    }
}