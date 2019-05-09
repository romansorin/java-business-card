package BusinessCard;

import java.util.ArrayList;
import java.util.Scanner;

public class BusinessCardView {
    private static BusinessCardView view;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<BusinessCard> cards = new ArrayList<>();
    private int option, selected;

    public static void main(String[] args) {
        view = new BusinessCardView();
        view.optionMenu();
    }

    /**
     * Provide user with an interface/menu to interact with the application
     */
    private void optionMenu() {
        System.out.println("Choose an option:");
        System.out.println("---------------------------");
        System.out.println("1. Create a business card");
        System.out.println("2. Edit a business card");
        System.out.println("3. Display a business card");
        System.out.println("4. Delete a business card");
        System.out.println("5. List all cards");
        System.out.println("6. Exit program");
        System.out.println("---------------------------");

        option = sc.nextInt();


        if (option == 1) {
            cards.add(BusinessCardController.create());
        } else if (option == 2) {
            listCards();
            BusinessCardController.edit(selectCard());
        } else if (option == 3) {
            listCards();
            BusinessCardController.view(selectCard());
        } else if (option == 4) {
            listCards();
            cards.remove(BusinessCardController.delete(selectCard()));
        } else if (option == 5) {
            listCards();
        } else if (option == 6) {
            tearDown();
        } else {
            System.out.println("Invalid option, please try again.");
        }

        System.out.println();
        optionMenu();
    }

    /**
     * List all existing cards by Index, Name, Email
     */
    private void listCards() {
        int count = 1;
        System.out.println("Cards:");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(count + ". " + cards.get(i).getName() + ", " + cards.get(i).getEmail());
            count++;
        }
    }

    /**
     * Allow user to select a business card for any CRUD actions
     *
     * @return BusinessCard
     */
    private BusinessCard selectCard() {
        System.out.println("Select a card by index, or type 0 to cancel.");
        selected = sc.nextInt();
        if (selected == 0)
            optionMenu();
        selected = selected - 1;
        return cards.get(selected);
    }

    /**
     * Close open scanner and system.
     */
    private void tearDown() {
        sc.close();
        System.out.println("Goodbye.");
        System.exit(0);
    }
}
