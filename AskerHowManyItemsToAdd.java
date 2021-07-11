package todolist;

import java.util.Scanner;

public class AskerHowManyItemsToAdd {
    AddToDoItem addtodoitem = new AddToDoItem();

    public void askerHowMany() {
        Scanner howmanyscanner = new Scanner(System.in);
        System.out.println("How many items you want to add?");
        int howmany = howmanyscanner.nextInt();
        addtodoitem.addingItemsToDo(howmany);
    }
}
