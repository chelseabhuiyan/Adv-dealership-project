package com.pluralsight.dealership;
/**• Program will be responsible for starting the application via its main()
 method and then creating the user interface and getting it started. **/


public class Program {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(); // create the UI
        userInterface.display(); // start the menu loop
    }
}
