# Forest Adventure Text Based Game

This is a simple text-based adventure game where the player explores a virtual forest. The forest is represented by a 2D array of characters, where:

- 'T': Represents a tree (impassable)
- '.': Represents an open space (passable)
- 'P': Represents the player's current location

## Features

### Forest Generation

- **generateForest(int rows, int cols)**: Generates a forest of the specified size.
  - Takes the desired number of rows and columns as input.
  - Populates the forest randomly with trees and open spaces.
  - Places the player 'P' at a random empty location within the forest.

### Display Forest

- **displayForest(char[][] forest)**: Displays the current state of the forest.
  - Takes the forest array as input.
  - Prints the forest to the console, representing each character visually.

### Player Movement

- **movePlayer(char[][] forest, char direction)**: Moves the player within the forest.
  - Takes the forest array and a direction ('W' for Up, 'S' for Down, 'A' for Left, 'D' for Right) as input.
  - Checks if the move is valid (within forest boundaries and not into a tree).
  - Updates the player's location in the forest array if valid.
  - Prints an appropriate message if the move is invalid.

## How to Use

1. Compile the Java program `TextAdventureGame.java`.
2. Run the compiled program.
3. Follow the prompts to specify the number of rows and columns for the forest.
4. Explore the forest by entering directions ('W', 'A', 'S', 'D') for movement.
5. Enjoy your adventure!

## Example

Here's an example of how to run the game:

```bash
javac TextAdventureGame.java
java TextAdventureGame

```
## Screen Shot:
![image](https://github.com/codewithkrishan2/forest-adventure-game/assets/139488554/09e60ea7-9db7-44b4-85e1-8bbf52afa6e8)

