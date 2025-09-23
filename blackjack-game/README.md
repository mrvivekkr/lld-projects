# Blackjack Game - Low Level Design Project

## Overview
This is a console-based Blackjack game implemented in Java, designed to demonstrate core software engineering principles through a clean and modular low-level design (LLD). The project showcases object-oriented design, design patterns, and best practices in building a turn-based card game system.

## Features
- Implements Blackjack rules with scoring, hits, stands, and bust conditions.
- Uses **State pattern** to manage game phases (Initial Deal, Player Turn, Dealer Turn, Game Over).
- Uses **Strategy pattern** for flexible scoring calculations.
- Represents cards with suits and ranks as enums for clarity and validation.
- Dealer's cards are currently fully visible throughout the game (face-up).
- Clear separation of concerns with dedicated packages for models, states, strategies, and application.

## Technologies
- Java 17 (or compatible version)
- Lombok for boilerplate code reduction (Getters, Setters, Constructors)
- Apache Commons Lang (for utilities if used)
- Built with standard Java collections and console input handling


## Installation and Running

1. Clone the repository.
2. Build the project using your preferred IDE or command line.
3. Run the application.


## How to Play
- Enter your player name when prompted.
- Both player and dealer cards are shown face-up throughout the game.
- Choose to **Hit (H)** to receive another card or **Stand (S)** to end your turn.
- After the player stands, the dealer plays according to Blackjack rules.
- The winner is determined based on who has the nearest score to 21 without going bust.

## Design Highlights
- **State Pattern:** Manages game phases ensuring state transitions are explicit and controlled.
- **Strategy Pattern:** Allows changing score calculation logic without modifying core game logic.
- **Encapsulation:** Game logic and domain entities are modular and extensible.
- **Extensibility:** Clear modular structure supports adding new features like face-down card logic in the future.

## Future Improvements
- Implement face-up/face-down visibility for dealer’s cards with flipping logic.
- Add support for multiple players.
- Implement betting, doubling down, splitting pairs.
- Add graphical UI or web interface.
- Support multiplayer networking.

## Contributing
Feel free to fork, open issues, or submit pull requests to improve the project.


