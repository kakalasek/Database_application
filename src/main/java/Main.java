import Windows.MainMenu;

/* NOTE: Soon after starting this project, I learned, that layouts in Swing are actually pretty useful and would make this project work
*        far better on different machines and possibly save me a lot of struggle with using a null layout. Nevertheless, I already started
*        coding without using layouts, so you won't find them here. I am too lazy to rewrite it...
*  EDIT: Well.. From a certain point, I got tired of placing everything everytime with the coordinates... so some later pieces of code actually use layouts
*  EDIT: Don't take this code too seriously... it is mostly just me learning how to properly work in Swing and trying out some new techniques and methods...
*        but everything should somewhat work here of course
*  EDIT: Okay, in the end, I am doing everything with layouts... it is easier and I had some difficulties with my original design...
*  NOTE: I was too lazy to comment everything... it is not too important here anyway
*/
public class Main {
    public static void main(String[] args) {
        /* START OF THE PROGRAM */
        new MainMenu();
    }
}
