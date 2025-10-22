# Flappy Bird
<<<<<<< HEAD

## Installation

To run the Flappy Bird game, you will need to have Java installed on your system. You can download the latest version of Java from the official website: [https://www.java.com/en/download/](https://www.java.com/en/download/).

Once you have Java installed, you can clone the repository and run the `Main.java` file to start the game.

```
git clone https://github.com/your-username/flappy-bird.git
cd flappy-bird
javac *.java
java Main
```

## Usage

The game is played by controlling a bird that must navigate through a series of pipes. The bird can be moved up by pressing the spacebar. The goal is to pass through as many pipes as possible without colliding with them.

The game will continue until the bird collides with a pipe or falls off the screen. When the game is over, the final score will be displayed.

To restart the game, press the spacebar while the game is over.

## API

The main classes in the project are:

- `Bird`: Represents the bird that the player controls.
- `Pipe`: Represents the pipes that the bird must navigate through.
- `FlappyBird`: The main game logic and rendering.
- `Main`: The entry point of the application.

The `Bird` and `Pipe` classes provide methods to access and modify the properties of the bird and pipes, respectively. The `FlappyBird` class handles the game logic, including collision detection, pipe placement, and score tracking.

## Contributing

If you would like to contribute to the Flappy Bird project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your forked repository.
5. Submit a pull request to the original repository.

## Testing

Run the main using your preferred IDE or framework
