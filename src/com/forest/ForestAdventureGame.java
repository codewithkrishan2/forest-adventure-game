package com.forest;
import java.util.Random;
import java.util.Scanner;

public class ForestAdventureGame {
    
    private static final char TREE = 'T';
    private static final char OPEN_SPACE = '.';
    private static final char PLAYER = 'P';

    private static final char MOVE_UP = 'W';
    private static final char MOVE_DOWN = 'S';
    private static final char MOVE_LEFT = 'A';
    private static final char MOVE_RIGHT = 'D';

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			
            // User input for number of rows and columns in the forest
			System.out.print("Enter the number of rows for the forest: ");
			int rows = scanner.nextInt();

			System.out.print("Enter the number of columns for the forest: ");
			int cols = scanner.nextInt();

			// Generate the forest as a 2D array
			char[][] forest = generateForest(rows, cols);

			// Display the forest
			displayForest(forest);

			// Player movement loop
			while (true) {
			    System.out.print("Enter direction for movement (W/A/S/D): ");
			    char direction = scanner.next().charAt(0);
			    System.out.println("Entered charachter is : "+direction);

			    // Move the player and display the forest
			    movePlayer(forest, direction);
			    displayForest(forest);
			}
		}
    }

    // Generate the forest
    public static char[][] generateForest(int rows, int cols) {
        char[][] forest = new char[rows][cols];
        Random rand = new Random();

        // Populate the forest with trees and open spaces
        for (char[] row : forest) {
            for (int j = 0; j < row.length; j++) {
                // Generate a random number between 0 and 1
                double randomNumber = rand.nextDouble();
                // If the random number is less than 0.3, assign a tree
                row[j] = randomNumber < 0.3 ? TREE : OPEN_SPACE;
            }
        }

        // Code to Place the player randomly...
        int playerRow;
        int playerCol;
        
        // Loop until the player is not placed on a tree
        do {
            playerRow = rand.nextInt(rows);
            playerCol = rand.nextInt(cols);
        } while (forest[playerRow][playerCol] == TREE);

        // Place the player on the forest
        forest[playerRow][playerCol] = PLAYER;

        return forest;
    }

    // Display the forest
    public static void displayForest(char[][] forest) {
        for (char[] row : forest) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Move the player
    public static void movePlayer(char[][] forest, char direction) {
        int[] playerLocation = getPlayerLocation(forest);
        int playerRow = playerLocation[0];
        int playerCol = playerLocation[1];
        switch (direction) {
            case MOVE_UP:
                if (playerRow > 0 && forest[playerRow - 1][playerCol] != TREE) {
                	System.out.println("Moving up...");
                    movePlayerToNewLocation(forest, playerRow - 1, playerCol);
                } else {
                    System.out.println("Invalid move: Cannot move up.");
                }
                break;
            case MOVE_DOWN:
                if (playerRow < forest.length - 1 && forest[playerRow + 1][playerCol] != TREE) {
                	System.out.println("Moving down...");
                    movePlayerToNewLocation(forest, playerRow + 1, playerCol);
                } else {
                    System.out.println("Invalid move: Cannot move down.");
                }
                break;
            case MOVE_LEFT:
                if (playerCol > 0 && forest[playerRow][playerCol - 1] != TREE) {
                	System.out.println("Moving left...");
                    movePlayerToNewLocation(forest, playerRow, playerCol - 1);
                } else {
                    System.out.println("Invalid move: Cannot move left.");
                }
                break;
            case MOVE_RIGHT:
                if (playerCol < forest[playerRow].length - 1 && forest[playerRow][playerCol + 1] != TREE) {
                	System.out.println("Moving right...");
                    movePlayerToNewLocation(forest, playerRow, playerCol + 1);
                } else {
                    System.out.println("Invalid move: Cannot move right.");
                }
                break;
            default:
                System.out.println("Invalid direction.");
        }
    }

    //This method moves the player to a new location in the forest
    private static void movePlayerToNewLocation(char[][] forest, int newRow, int newCol) {
        //Get the current location of the player
        int[] playerLocation = getPlayerLocation(forest);
        
        //Store the current row and Column of the player
        int playerRow = playerLocation[0];
        int playerCol = playerLocation[1];
        
        //Set the current location of the player to open space
        forest[playerRow][playerCol] = OPEN_SPACE;
        
        //Set the new location of the player to player
        forest[newRow][newCol] = PLAYER;
    }

    // Helper method to find the player's location
    private static int[] getPlayerLocation(char[][] forest) {
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                if (forest[i][j] == PLAYER) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
