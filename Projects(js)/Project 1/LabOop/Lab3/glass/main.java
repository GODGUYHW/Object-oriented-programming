package LabOop.Lab3.glass;

public class main {
    public static void main(String[] args) {
        Glass G = new Glass(100, 0);
        Glass G1 = new Glass(100, 0);
        G.FillInWater();
        G.PourOnTheFloor();
        G.PourToGlass(G1);

    }
}
