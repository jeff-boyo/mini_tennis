<h1>MiniTennis</h1>

<h3>This is intended to be a simple fun project to learn with.</h3>

<h2>Goals:</h2>
 - learn some of the basic ideas of game programming in java
 - practice using the gradle build system from the command line
 - try out macAppBundle gradle plugin to make a standalone mac .app

<h2>Note:</h2>
I should probably have named this project differently. The end goal is more to have a reasonably functional block-breaker style game. Not a tennis/pong game. But whatever, renaming everything might be a pain. If i actually finish this, i should add as a goal, find a simple way to rename this project and its java package 'minitennis' to something more blockbreaker-ish. One thing at a time...

<h2>IMPORTANT:</h2>
I DID NOT INCLUDE ANY BUILT/COMPILED STUFF IN THIS REPO

.gitignore is set to ignore the gradle build/ directory, which I guess is standard practice. Anyway, to get some runnable .class files run:

>$ ./gradlew build

From there, you can do './gradlew run' to run the game [with the help of the 'application' plugin applied in build.gradle]. Or you can build a nice little working app using the 'macAppBundle' plugin by running:

>$ ./gradlew createApp

Note that this build indcludes a gradle wrapper [./gradlew] so no need to go mucking things up with calls to your own gradle version. everything is right there in ./gradlew, with the added bonus that you know its gonna work regardless of gradle version conflicts between our systems. Anyhow, do whatever you want.
