<h1> XO Game – Java <h1>
<h3> Description </h3>
This project is a simple XO game implemented in Java as a practice application after learning core Java fundamentals.
The game includes two versions: <br>
- A GUI version <br>
- A terminal version <br>
Both versions follow the same game logic but provide different ways for the user to interact with the game. <br>
<h3>Game Rules </h3>
- The game always starts with Player X.<br>
- Players take turns placing their mark (X or O) on a 3×3 board.<br>
- A player wins if they complete a full row or column or diagonal with the same mark.<br>
- If the board becomes full with no winner, the game ends in a draw.<br>
- Attempting to play in an occupied cell is not allowed.<br>
<h4>GUI Version </h4>
- The board is represented by 9 buttons, arranged in a 3×3 grid.
Internally, the board state is stored using an array.<br>
- Players place their mark by clicking on a button.<br>
- Turns alternate automatically between X and O.<br>
- If a player clicks on an already occupied button, a dialog message appears informing them that the cell is occupied, and they are asked to play again.<br>
- When the game ends:<br>
  &nbsp &nbsp A dialog message appears showing X wins, O wins, or Draw.<br>
  &nbsp &nbsp Another dialog asks whether the user wants to play again.<br>
<h4>Terminal Version </h4>
- The game also starts with Player X.<br>
- Players choose where to place their mark by entering:<br>
  &nbsp &nbsp Row number, then column number<br>
- Example:<br>
  &nbsp &nbsp Entering 2 2 places the mark in the center cell.<br>
  &nbsp &nbsp Entering 1 3 places the mark in the upper-right cell.<br>
- The board is printed to the terminal after every move so the player can see the current state.<br>
- If a player tries to place a mark in an occupied cell, the program print a message and asks them to choose again.<br>
- When the game ends, the program displays the result (X wins, O wins, or Draw) and asks:<br>
  &nbsp &nbsp Type y to play again<br>
  &nbsp &nbsp Type n to exit<br>
<h3>What I Practiced</h3>
Using variables, loops, conditions, and methods
Managing program flow and turn-based logic
<h3>How to Run</h3>
- Clone the repository <br>
- Open the project in any Java IDE <br>
- Run the main class
