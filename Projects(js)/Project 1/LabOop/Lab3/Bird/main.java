package LabOop.Lab3.Bird;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        bird nok = new bird("GO", "male", 10, 150, 0, true); // คำสั่ง new ใช้สร้างobject
        bird nok2 = new bird("BO", "female", 12, 120, 0, false);
        // nok2.eat(100);
        // nok2.poop();
        bird baby = nok.breed(nok2);
        baby.talk();
        baby.eat(100);
        bird newBaby = baby.breed(nok2);
        newBaby.talk();
        System.out.println(newBaby.getName());
        System.out.println(baby.getName());

    }
}