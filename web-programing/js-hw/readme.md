Set Card Game



<img src="Screenshot 2021-01-23 211025.png">

<img src="Screenshot 2021-01-23 211025.png">

The goal of the game is to find SETs of three cards from the twelve cards placed on the desk. All cards have four properties:

- **SHAPE**: oval, squiggle, diamond
- **COLOR**: red, green, purlple
- **NUMBER**: 1,2, or 3 shapes
- **SHADING**: solid, striped or outlined shapes (only used in the subtasks for bonus points)

Every SET consists of three cards, where all properties are:

- the same on all of the cards
- different on all of the cards.

The selected cards have to adhere to these rules for ALL properties. Worded differently: if the three cards  have the same number of shapes, or 1 2 and 3; if the color is the same,  or all three colors; if all shapes are solid, or one solid, striped and  empty, etc...

[Correct and incorrect SETs (Linkek egy külső oldalra)](https://www.masterbaboon.com/wp-content/uploads/2010/09/sets_examples1-1024x586.png)

[Game rules (Linkek egy külső oldalra)](https://www.setgame.com/sites/default/files/instructions/SET INSTRUCTIONS - ENGLISH.pdf)

## The game

The game has two user interfaces:

- The *starting page*, which displays first, and where the settings can be found
- The *game page*, where the game can be played.

We call these "pages", but you don't have to make two separate HTML pages. Moreso, it is a requirement to  implement the game as a single-page application, and make the switch  between the interfaces in some way (e.g. toggling the `hidden` property of two `div`s.)

### Starting page

On the game's starting page, show:

- The name of the game
- The rules of the game (As text, as a link, as a dropdown, etc.)
- An option to set the number (and names) of players
- An option to set the game mode
- And other, miscellaneous options.

By default, the *Advanced* difficulty should be selected.

The **number of players** can be set from 1 to 10, the default is 1. Display changeable names for the selected number of players! The default names should be *Player1*, *Player2*, ..., *PlayerN*.

There are two **game modes**:

- *Practice*: All options are available, and in a one-player game, there is no timer.
- *Competitive*: The miscellaneous options aren't available, and the one-player game has the timer enabled as well.

The **miscellaneous** options:

- Enable or disable a button which tells if there is a SET in the current deal (*Competitive*: disabled)
- Enable or disable a button which shows a SET (*Competitive*: disabled)
- Automatic or button-based deal method for three new cards after no SET was discovered (*Competitive*: automatic)

Pressing a button labeled **Start** starts the game.

### The game page

- We play the game with three properties: SHAPE, COLOR, NUMBER. The SHADING of the shapes is solid, thus we have 3×3×3=27 cards.
- At the start of the game, generate the deck and shuffle it, then print it on the console.
- Following that, display 12 cards (preferably in a 3×4 layout)
- The players in front of the computer examine the table, and if someone finds a SET, they can declare it:
  1. The player tells the computer it's  their action (clicking on their name on the interface, or pressing an  assigned button on the keyboard)
  2. A timer of 10 seconds starts. If  the timer expires before the player makes a selection, the game  considers the player made a wrong selection. Displaying the time is  optional: you can show a countdown, or simply notify the player if time  is up.
  3. While declaring a SET, clicking on a card should select it. Clicking on an already selected card should  remove the selection. Any number of cards can be selected or deselected  until the player selects their third card, when the game switches to  evaluation.
- If the player made a wrong  selection, they lose a point, and the other players can try finding a  set. The original player can't make a new action until someone discovers a SET or all players fail the turn. If all players fail during a turn,  everybody gets re-enabled.
- If the player made a correct  selection, the three selected cards disappear from the table and the  player gets a point. All players who made a wrong selection this turn  are re-enabled, and the table draws three new cards.
- Dealing new cards onto the table  works while there is at least one card in the deck. Display the number  of remaining cards in the deck!
- If there are no more cards in the  deck and the table has no valid SET, the game ends. The program should  check for this automatically.
- If all players fail to find a SET, three new cards are dealt (automatically or by button, based on the option). If they find a SET in the expanded table, the extra cards are discarded for the next turn. **After a set is found on the expanded table the players continue the game with the cards remaining on the table.**
- Two types of hints are available (if enabled in the settings):
  - Asking the program if there is a valid SET on the current table
  - Asking the program to show a valid SET
- If there's only one player, measure the time since the start of the game. In this case, the player is  automatically selected (no need to tell the computer whose action is  happening).
- At the end of the game, the game  should display who is the first, second, etc. player. A button should  redirect the player to the settings.
- When there is only one player, three things change:
  - The game should keep track of the  time passed since the start of the game and show how long the player  took to finish (you can display this as a timer during the game as well)
  - The player is automatically selected when declaring a SET (no need to tell the game who is taking an action)
  - There is no 10s time limit for SET selection.
