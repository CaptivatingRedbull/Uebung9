package Aufgabe1.Armee;

import Aufgabe1.Bubblesort.BubbleSort;
import Aufgabe1.Soldat.Soldat;

public class Armee {
    public static void main(String[] args) {
        Soldat[] armee = new Soldat[10];
        System.out.println("Unsortiert:");
        for(int i = 0; i < armee.length; i++){
            armee[i] = new Soldat((150 + (int)(Math.random()*50)), "Soldat" + i);
            System.out.println(armee[i].toString());
        }
        BubbleSort.sort(armee);
        System.out.println("Sortiert: ");
        for (Soldat soldat : armee) System.out.println(soldat.toString());
    }
}
