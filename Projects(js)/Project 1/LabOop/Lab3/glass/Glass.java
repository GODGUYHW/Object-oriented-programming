package LabOop.Lab3.glass;

import java.util.Scanner;

public class Glass {

    int GlassCapacity = 0;
    int WaterInGlass = 0;
    static Scanner input = new Scanner(System.in);

    public Glass(int GlassCapacity, int WaterInGlass) {
        this.GlassCapacity = GlassCapacity;
        this.WaterInGlass = WaterInGlass;
        if (WaterInGlass > GlassCapacity) {
            WaterInGlass = GlassCapacity;
        } else if (WaterInGlass < 0) {
            System.out.println("Can not do that, please fix the water in a glass.");
            System.exit(0);
        }
    }

    void Capacity() {
        System.out.println("Glass capacity is " + GlassCapacity);
        System.out.println("Amount of water in glass is " + WaterInGlass);
    }

    void FillInWater() {
        System.out.println("Please Select choice");
        System.out.println("1.Fullfill  2.Fill in amount");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        if (choice == 1) {
            WaterInGlass = GlassCapacity;
            System.out.println("Water in Glass is Filled " + WaterInGlass);
        } else if (choice == 2) {

            System.out.print("Please insert water quantity: ");
            int WaterQuantity = input.nextInt();
            if (WaterQuantity > GlassCapacity) {
                WaterInGlass = GlassCapacity;
                System.out.println("Water in glass is " + WaterInGlass);

            } else if (WaterQuantity < 0) {
                WaterInGlass = 0;
                System.out.println("Can not fill, please fix the water in a glass.");

            } else {
                WaterInGlass += WaterQuantity;
                System.out.println("Water in glass is " + WaterInGlass);

            }

        }
    }

    void PourOnTheFloor() {
        System.out.println("Please Select choice");
        System.out.println("1.Pour in amount  2.Pour all water");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        if (choice == 1) {

            System.out.print("Please insert water quantity to pour: ");
            int WaterQuantity = input.nextInt();
            if (WaterQuantity > WaterInGlass) {
                System.out.println("Can not pour");

            } else if (WaterQuantity < 0) {
                System.out.println("Can not pour");

            } else {
                WaterInGlass -= WaterQuantity;

            }

        } else if (choice == 2) {
            System.out.println("Pour water out " + WaterInGlass);
            WaterInGlass = 0;
        }
    }

    void PourToGlass(Glass a) {
        System.out.println("Please Select choice");
        System.out.println("1.Pour in amount  2.Pour all water");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        if (choice == 1) {

            System.out.print("Please insert water quantity to pour: ");
            int WaterQuantity = input.nextInt();
            if (WaterQuantity > WaterInGlass) {
                System.out.println("Can not pour");

            } else if (WaterQuantity < 0) {
                System.out.println("Can not pour");

            } else {
                a.WaterInGlass += WaterQuantity;
                WaterInGlass -= WaterQuantity;
                System.out.println("Water in anoter glass is " + a.WaterInGlass);

            }

        } else if (choice == 2) {
            a.WaterInGlass += WaterInGlass;
            WaterInGlass = 0;
            System.out.println("Water in anoter glass is " + a.WaterInGlass);
        }
    }
}
