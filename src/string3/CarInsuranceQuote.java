package string3;

import java.util.*;

public class CarInsuranceQuote {
    public static void main(String[] args) {

        System.out.println("Welcome to the Cydeo car insurance!");

        Scanner scan = new Scanner(System.in);
        double premiumCost = 0;

        System.out.println("Enter your full name");
        String fullName = scan.nextLine().trim();

        System.out.println("Do you have a US driver license?");
        String yesOrNo = scan.next().toLowerCase();

        if (yesOrNo.equals("yes")) {
            System.out.println("Enter your zip code");
            int zipCode = scan.nextInt();
            if (zipCode == 20910 || zipCode == 20740) {
                premiumCost += 60;
            } else if (zipCode == 22102 || zipCode == 22103) {
                premiumCost += 30;
            } else {
                premiumCost += 50;
            }

            System.out.println("Is this vehicle owned, financed, or leased?");
            String carOwnedFinanced = scan.next().toLowerCase();
            if (carOwnedFinanced.equals("owned")) {
                premiumCost += 10;
            } else if (carOwnedFinanced.equals("financed")) {
                premiumCost += 15;
            } else {
                premiumCost += 20;
            }

            System.out.println("How is this vehicle primarily used?");
            String primarilyUsed = scan.next().toLowerCase();

            if (primarilyUsed.equals("business")) {
                premiumCost += 50;
            } else if (primarilyUsed.equals("pleasure")) {
                premiumCost += 10;
            } else if (primarilyUsed.equals("commuting")) {
                premiumCost += 20;
                System.out.println("How many days do you commute?");
                int days = scan.nextInt();
                premiumCost += days * 5;
            }

            System.out.println("How old are you?");
            int age = scan.nextInt();
            if (age < 16) {
                System.out.println("You can't be driving");
                System.exit(0);
            } else if (age < 20) {
                premiumCost *= 10;
            } else if (age < 25) {
                premiumCost *= 6;
            } else {
                premiumCost *= 2;
            }

            System.out.println("Have you had any accidents in the last 5 years?");
            String yesOrNoAccident = scan.next().toLowerCase();

            if (yesOrNoAccident.equals("yes")) {
                System.out.println("How many?");
                int accidents = scan.nextInt();
                premiumCost += accidents * 10;
            }
            scan.nextLine();

            System.out.println("What is the highest level of education you have completed?");
            String educationLevel = scan.nextLine().toLowerCase();

            if (educationLevel.equals("bachelors") || educationLevel.equals("masters")) {
                premiumCost -= premiumCost * 0.05;
            } else if (educationLevel.equals("phd")) {
                premiumCost -= premiumCost * 0.10;
            } else if (educationLevel.equals("high school")) {
                educationLevel = educationLevel.substring(0, educationLevel.indexOf(" "))
                        + educationLevel.substring(educationLevel.indexOf(" ") + 1);
                premiumCost += premiumCost * 0.05;
            }

            String first = fullName.substring(0, fullName.indexOf(" "));
            String last = fullName.substring(fullName.indexOf(" ") + 1);

            System.out.println(first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase() + " "
                    + last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase() + ", here's your quote!");

            System.out.println("This is your start premium cost: $" + premiumCost);

            System.out.println("This is your reference number: " + first.substring(0, 2).toUpperCase() + age
                    + last.substring(last.length() - 3).toUpperCase() + zipCode + educationLevel.toUpperCase());

        } else {
            System.out.println("You must have a license to get insurance!");
            System.exit(0);

        }
    }
}
