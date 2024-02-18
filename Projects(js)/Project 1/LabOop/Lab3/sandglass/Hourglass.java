package LabOop.Lab3.sandglass;

import java.lang.Thread;

public class Hourglass {

    int sandSideA;
    int sandSideB;
    int positionA = 2;

    public Hourglass(int sandSideA, int sandSideB) {
        this.sandSideA = sandSideA;
        this.sandSideB = sandSideB;
    }

    void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException p) {
            p.printStackTrace();
        }
    }

    void rotateRight90() {
        positionA = (positionA % 4) + 1;
        if (sandSideB < 0 || sandSideA < 0) {
            System.out.println("Plese enter sand in Sandglass");
            return;
        }
        if (positionA % 2 == 0) {
            System.out.print("A is on side " + positionA + ".");
            System.out.println(" Hourglass is in Horizontal");
        } else if (sandSideA > sandSideB && positionA == 1) {
            System.out.println("A is on side " + positionA);
            while (sandSideA > 0) {
                sandSideA -= 1000;
                sandSideB += 1000;
                System.out.println(
                        "amount of sand in A side is " + sandSideA + " and amount of sand in B side is " + sandSideB);
                delay();
            }
        } else if (sandSideB == 0 && positionA == 3) {
            System.out.println("There is no sand in B side");
        } else if (sandSideB > sandSideA && positionA == 3) {
            System.out.println("A is on side " + positionA);
            while (sandSideB > 0) {
                sandSideA += 1000;
                sandSideB -= 1000;
                System.out.println(
                        "amount of sand in A side is " + sandSideA + " and amount of sand in B side is " + sandSideB);
                delay();
            }
        } else if (sandSideA == 0 && positionA == 1) {
            System.out.println("There is no sand in A side");
        }
    }

    void rotateRight180() {
        for (int i = 0; i < 2; i++) {
            positionA = (positionA % 4) + 1;
        }
        if (sandSideB < 0 || sandSideA < 0) {
            System.out.println("Plese enter sand in Sandglass");
            return;
        }
        if (positionA % 2 == 0) {
            System.out.print("A is on side " + positionA + ".");
            System.out.println(" Hourglass is in Horizontal");
        } else if (sandSideA > sandSideB && positionA == 1) {
            System.out.println("A is on side " + positionA);
            while (sandSideA > 0) {
                sandSideA -= 1000;
                sandSideB += 1000;
                System.out.println(
                        "amount of sand in A side is " + sandSideA + " and amount of sand in B side is " + sandSideB);
            }
        } else if (sandSideB == 0 && positionA == 3) {
            System.out.println("There is no sand in B side");
        } else if (sandSideB > sandSideA && positionA == 3) {
            System.out.println("A is on side: " + positionA);
            while (sandSideB > 0) {
                sandSideA += 1000;
                sandSideB -= 1000;
                System.out.println(
                        "amount of sand in A side is " + sandSideA + " and amount of sand in B side is " + sandSideB);
            }
        } else if (sandSideA == 0 && positionA == 1) {
            System.out.println("There is no sand in A side");
        }
    }
}