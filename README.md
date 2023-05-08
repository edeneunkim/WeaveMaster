# WeaveMaster
WeaveMaster is a game where the user must dodge incoming projectiles and survive as long as possible. There are orbs that periodically spawn that can be collected to affect how the game is played.
## Introduction
This is a personal project that I made during my free time. As someone interested in game development, I thought it would be useful for me to create a simple game to gain some experience in making games and apps. I enjoyed playing simple single-player retro games when I was younger, so I decided to make a similar style of game as way to understand how to develop games and demonstrate and improve my coding skills. I opted to use Java as I am experienced and familiar with making programs with GUI on Java compared to the other languages I know.
## Technologies
* Java 
* JUnit 5.8.1
## How to Play
WeaveMaster is a simple game and easy to learn to play. The user uses WASD or arrow keys to move the character around the board to dodge projectiles and collect orbs. The projectiles will come every certain number of cycles up to a maximum number of projectiles to ensure that the game is not impossible to play. The projectiles bounce around, making the game more challenging. There are different types of orbs that can be collected and affect the game state, such as orbs that increase the character's size or increases the projectiles' speed. Some orbs also benefit the user, such as slowing down the projectiles' speed. These orbs give the user points no matter the type and spawn and despawn every certain number of cycles. The game is over once the user is hit by a projectile, which then the user is given the option to replay by pressing space. 
<br>
To run the game, you can go to the WeaveMasterApp file in the ui package of the model package of the main folder. 
## Files
### main
The main file contains the model and ui packages, where the model package contains the object classes that represent the models used in the game, including MainCharacter, Points, Projectile, and Orb and its subtypes. The MainCharacter class represents the character that the user uses to navigate through the board to avoid projectiles and collect orbs. The Projectile class is the class representing the projectiles that the user will try to avoid. The Orb class is an abstract class representing the orb that the user will try to collect, with the Orb subtype classes representing the different types of orbs. The Points class represents the scoreboard and points system for the points that the user will receive throughout the game. The ui package contains the files for the GUI of the game. The ui package contains the WeaveMasterApp file, which is used to run the program. The Panel file in the ui package contains most of the code for running the game, so editing the game would most likely require changes in this file. 
### Test
The test file contains tests for the Orb and its subtypes, MainCharacter, and Projectile classes. These tests use the JUnit library and should cover most cases. 
## Sources
I used the following video to learn how to implement threads and run a game program:
* https://www.youtube.com/watch?v=oLirZqJFKPE
