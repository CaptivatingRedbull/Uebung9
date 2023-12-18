package Aufgabe2d;

public class TestModul {
    public static void main(String[] args) {
        /*
        int [] werte = new int[100];
        for(int i = 0; i < werte.length; i++)
            werte[i] = i+1;
        Modul modul = new Modul(1000, werte);
        for (int i = 0; i < werte.length; i++) {
            System.out.println(werte[i] + ", ");
        }*/
        Modul.MultiTafel multiTafel = new Modul.MultiTafel(10);
        System.out.println(multiTafel.getInverseTafel(10));
    }
}
