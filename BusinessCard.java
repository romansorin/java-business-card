package BusinessCard;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * BusinessCard model for fields and attributes, as well as a basic constructor
 */

public class BusinessCard {
    protected String name, title, company, website, email, phone, address;
    private Scanner sc = new Scanner(System.in);

    /**
     * Create a new instance of business card
     *
     * @param attributes
     */
    public BusinessCard(ArrayList<Map.Entry<String, String>> attributes) {
        this.name = attributes.get(0).getValue();
        this.title = attributes.get(1).getValue();
        this.company = attributes.get(2).getValue();
        this.website = attributes.get(3).getValue();
        this.phone = attributes.get(4).getValue();
        this.email = attributes.get(5).getValue();
        this.address = attributes.get(6).getValue();
    }

    /**
     * Allow access to any field of business card
     *
     * @param i
     * @return String
     */
    public String getAny(int i) {
        String attr = "";
        switch (i) {
            case 0:
                attr = getName();
                break;
            case 1:
                attr = getTitle();
                break;
            case 2:
                attr = getCompany();
                break;
            case 3:
                attr = getWebsite();
                break;
            case 5:
                attr = getPhone();
                break;
            case 4:
                attr = getEmail();
                break;
            case 6:
                attr = getAddress();
                break;
        }
        return attr;
    }

    /**
     * Change the value of a field in an existing business card
     *
     * @param field
     */
    public void setField(int field) {
        System.out.println("Enter new value: ");
        switch (field) {
            case 1:
                setName(sc.nextLine());
                break;
            case 2:
                setTitle(sc.nextLine());
                break;
            case 3:
                setCompany(sc.nextLine());
                break;
            case 4:
                setWebsite(sc.nextLine());
                break;
            case 5:
                setPhone(sc.nextLine());
                break;
            case 6:
                setEmail(sc.nextLine());
                break;
            case 7:
                setAddress(sc.nextLine());
                break;
            default:
                System.out.println("Invalid input, please try again.");
                setField(field);
        }
    }

    /* Accessors */
    public String getName() {
        return this.name;
    }

    /* Mutators */
    private void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return this.company;
    }

    private void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return this.website;
    }

    private void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return this.phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    private void setAddress(String address) {
        this.address = address;
    }
}
