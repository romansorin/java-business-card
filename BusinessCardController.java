package BusinessCard;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Controller to define logic and methods
 */

public class BusinessCardController {
    private static int count, field;
    private static ArrayList<Map.Entry<String, String>> attributes;
    private static Scanner sc;

    /**
     * Show the view for creating a business card
     *
     * @return BusinessCard
     */
    public static BusinessCard create() {
        sc = new Scanner(System.in);
        attributes = new ArrayList<>();
        System.out.println("Creating a new business card, please complete the following fields:");

        System.out.print("Name: ");
        attributes.add(new AbstractMap.SimpleEntry("Name", sc.nextLine()));

        System.out.print("Title: ");
        attributes.add(new AbstractMap.SimpleEntry("Title", sc.nextLine()));

        System.out.print("Company: ");
        attributes.add(new AbstractMap.SimpleEntry("Company", sc.nextLine()));

        System.out.print("Website: ");
        attributes.add(new AbstractMap.SimpleEntry("Website", sc.nextLine()));

        System.out.print("Phone: ");
        attributes.add(new AbstractMap.SimpleEntry("Phone", sc.nextLine()));

        System.out.print("Email: ");
        attributes.add(new AbstractMap.SimpleEntry("Email", sc.nextLine()));

        System.out.print("Address: ");
        attributes.add(new AbstractMap.SimpleEntry("Address", sc.nextLine()));

        return new BusinessCard(attributes);
    }

    /**
     * Show the view for editing a business card
     *
     * @param card
     */
    public static void edit(BusinessCard card) {
        System.out.println("What field would you like to edit?");
        System.out.println("Select 0 to finish.");
        count = 1;
        for (int i = 0; i < attributes.size(); i++) {
            System.out.println(i + 1 + ". " + attributes.get(i).getKey() + " - " + card.getAny(i));
            count++;
        }
        field = sc.nextInt();
        if (field != 0)
            card.setField(field);
    }

    /**
     * Show the view for displaying a business card
     *
     * @param card
     */
    public static void view(BusinessCard card) {
        int whiteSpaces = 20;
        int longestTotalLength = (longestLineLeftSide(card) + whiteSpaces + longestLineRightSide(card));

        printHorizontalBounds(longestTotalLength + 2);
        printEmptyLine(longestTotalLength);
        printEmptyLine(longestTotalLength);
        printEmptyLine(longestTotalLength);

        printFirstLine(card, whiteSpaces);
        printSecondLine(card, whiteSpaces);
        printThirdLine(card, whiteSpaces);
        printFourthLine(card, whiteSpaces);

        printEmptyLine(longestTotalLength);
        printEmptyLine(longestTotalLength);
        printEmptyLine(longestTotalLength);
        printHorizontalBounds(longestTotalLength + 2);
    }

    /**
     * Delete a business card
     *
     * @param card
     * @return BusinessCard
     */
    public static BusinessCard delete(BusinessCard card) {
        System.out.println("Card successfully deleted");
        return card;
    }

    /**
     * CLI / GUI methods for making the business card image
     **/
    private static void printFirstLine(BusinessCard card, int whiteSpaces) {
        System.out.print("| " + card.getName());
        diffInWordLength(card.getName(), longestLineLeftSide(card));
        printWhitespaces(whiteSpaces);
        diffInWordLength(card.getWebsite(), longestLineRightSide(card));
        System.out.print(card.getWebsite() + " |\n");
    }

    private static void printSecondLine(BusinessCard card, int whiteSpaces) {
        System.out.print("| " + card.getTitle());
        diffInWordLength(card.getTitle(), longestLineLeftSide(card));
        printWhitespaces(whiteSpaces);
        diffInWordLength(card.getEmail(), longestLineRightSide(card));
        System.out.print(card.getEmail() + " |\n");
    }

    private static void printThirdLine(BusinessCard card, int whiteSpaces) {
        System.out.print("| " + card.getCompany());
        diffInWordLength(card.getCompany(), longestLineLeftSide(card));
        printWhitespaces(whiteSpaces);
        diffInWordLength(card.getAddress(), longestLineRightSide(card));
        System.out.print(card.getAddress() + " |\n");
    }

    private static void printFourthLine(BusinessCard card, int whiteSpaces) {
        System.out.print("| ");
        printWhitespaces(longestLineLeftSide(card) + whiteSpaces);
        diffInWordLength(card.getPhone(), longestLineRightSide(card));
        System.out.print(card.getPhone() + " |\n");
    }

    /**
     * Count the length of a specified business card attribute
     *
     * @param attribute
     * @return int
     */
    private static int countAttributeLength(String attribute) {
        return attribute.length();
    }

    /**
     * Determine what attribute / field is longest (and how long) on the left side of the business card
     *
     * @param card
     * @return int
     */
    private static int longestLineLeftSide(BusinessCard card) {
        int max = Integer.MIN_VALUE;
        String[] attributes = {card.getName(), card.getTitle(), card.getCompany()};

        for (String attr : attributes) {
            if (countAttributeLength(attr) > max) {
                max = countAttributeLength(attr);
            }
        }
        return max;
    }

    /**
     * Determine what attribute / field is longest (and how long) on the right side of the business card
     *
     * @param card
     * @return int
     */
    private static int longestLineRightSide(BusinessCard card) {
        int max = Integer.MIN_VALUE;
        String[] attributes = {card.getWebsite(), card.getEmail(), card.getAddress()};
        for (String attr : attributes) {
            if (countAttributeLength(attr) > max) {
                max = countAttributeLength(attr);
            }
        }
        return max;
    }

    /**
     * Determine the difference between a specified word and the longest word on the business card
     *
     * @param word
     * @param longestWord
     */
    private static void diffInWordLength(String word, int longestWord) {
        int spacesToPrint = longestWord - word.length();
        for (int i = 0; i < spacesToPrint; i++)
            System.out.print(" ");
    }

    /**
     * Print the vertical borders/boundaries of the business card
     *
     * @param n
     */
    private static void printHorizontalBounds(int n) {
        for (int i = -1; i <= n; i++)
            System.out.print("-");
        System.out.println();
    }

    /**
     * Print whitespace
     *
     * @param whiteSpaces
     */
    private static void printWhitespaces(int whiteSpaces) {
        for (int i = 0; i < whiteSpaces; i++)
            System.out.print(" ");
    }

    /**
     * Print a line with nothing but whitespace and the outer boundaries
     *
     * @param whiteSpaces
     */
    private static void printEmptyLine(int whiteSpaces) {
        System.out.print("|");
        for (int i = -1; i <= whiteSpaces; i++)
            System.out.print(" ");
        System.out.print("|");
        System.out.println();
    }

}
