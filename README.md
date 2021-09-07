# drag-squares

My solution for Chapter 6 Exercise 2 of “Introduction to Programming Using Java”.

NOTE: This is a javafx program. It requires the javafx library as a dependency. (See bottom of this README for javafx instructions).

Problem Description:
Write a program that shows a pair of dice. The dice are drawn on a Canvas. You can assume
that the size of the canvas is 100 by 100 pixels. When the user clicks on the canvas,
the dice should be rolled (that is, the dice should be assigned newly computed random values).
Each die should be drawn as a square showing from 1 to 6 dots.
Since you have to draw two dice, its a good idea to write a subroutine, such as “void
drawDie(GraphicsContext g, int val, int x, int y)”, to draw a die at the speci-
fied (x,y) coordinates. The second parameter, val, specifies the number of dots that are
showing on the die.

Javafx setup instructions:
Download javafx from: https://gluonhq.com/products/javafx/ (I used javafx 12). Save it to a location of your choice.
Unpack the zip folder.
Open my project with your IDE of choice (I use intellij IDEA).
Add the javafx/lib folder as an external library for the project. For intellij, this means going to "project structure" -> "libraries" -> "add library" ->{javafx location}/lib
Add the following as a VM argument for the project: --module-path "{full path to your javafx/lib folder}" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing,javafx.web
Build and run the project as normal.
