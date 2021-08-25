package todolist;

import java.util.Scanner;

public class AskerWhatToDo {
    AskerHowManyItemsToAdd howmanyitemstoadd = new AskerHowManyItemsToAdd();
    AskerWhatToWrite askerwhattowrite = new AskerWhatToWrite();

    public void asker() {
        Scanner todoscanner = new Scanner(System.in);
        System.out.println("What you want to do? (add/read)");
        String todoanswer = todoscanner.nextLine();

        if(todoanswer.equals("add")) {
            howmanyitemstoadd.askerHowMany();
        } else if(todoanswer.equals("read")) {
            askerwhattowrite.whatYouWantToWrite();
        } else {
            System.out.println("Choose the correct option!");
        }
    }
}
