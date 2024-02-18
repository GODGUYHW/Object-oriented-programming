package LabOop.Lab3.Bird;

import java.util.Scanner;

public class bird {

    private String name;
    private int age;
    private int weight;
    private int foodInStomach;
    private boolean special;
    private int foodWeight;
    String gender;
    String txt;
    private static Scanner input = new Scanner(System.in);

    public bird(String name, String gender, int age, int weight, int foodInStomach, boolean special) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.foodInStomach = foodInStomach;
        this.special = special;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getWeight() {
        return weight;
    }

    public int getFoodInStomach() {
        return foodInStomach;
    }

    public boolean getSpecial() {
        return special;
    }

    public String getName() {
        return name;
    }

    public void talk() {
        System.out.print("my name is " + name + "(this bird can only speak English): ");
        String txt = input.nextLine().toLowerCase();
        if (txt.startsWith("speak")) {
            System.out.println(name + " said: " + txt.substring(5));
        } else {
            System.out.println(name + " is " + age + " years old.");
        }
    }

    public void eat(int foodWeight) {
        if (foodWeight < 0) {
            System.out.println("Please enter a positive number for the weight!");
            foodInStomach += foodWeight;
            foodWeight = 0;
            return;
        }
        System.out.println("You ate " + foodWeight + " grams of food.");
        foodInStomach += foodWeight;
        if (foodInStomach > weight) {
            if (special) {
                weight = 0;
                foodInStomach = 0;
            } else {
                foodInStomach = weight;
            }
        } else {
            weight += foodInStomach;
        }
    }

    public void poop() {
        if (foodInStomach > 0) {
            System.out.print("Do you need to poop (yes or no)? ");
            String txt = input.nextLine().toLowerCase();
            if (txt.startsWith("yes")) {
                if (special == true) {
                    weight = 0;
                    foodInStomach = 0;
                    System.out.println("Food in your stomach is " + foodInStomach);
                } else {
                    System.out.print("How much poop do you want to pooped out ? ");
                    int poop = input.nextInt();
                    foodInStomach -= poop;
                    weight -= poop;
                    System.out.println("Food in your stomach is " + foodInStomach);
                }
            } else if (txt.startsWith("no")) {
                System.out.println("Your weight is " + weight + " grams.");
                System.out.println("The food in your stomach is " + foodInStomach + " grams.");
            } else {
                System.out.println("Please enter only yes or no.");
            }
        } else if (foodInStomach < 0) {
            System.out.println("Please enter the data again.");
        } else if (foodInStomach == 0) {
            System.out.println("The bird has diarrhea and there is nothing left in its stomach.");
        }
    }

    public bird breed(bird a) {
        gender.toLowerCase();
        if (this.gender.equals(a.gender)) {
            System.out.println("Can not breed");
        } else {
            bird BabyBird = new bird(name, gender, age, weight, foodInStomach, special);
            BabyBird.name = this.name.substring(0, 1) + a.name.substring(0, 1);
            BabyBird.age = 0;
            BabyBird.weight = 0;
            BabyBird.foodInStomach = 0;
            BabyBird.gender = this.gender;
            BabyBird.special = this.special;
            return BabyBird;
        }
        return null;
    }
}
