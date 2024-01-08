package Aufgabe1.Soldat;

import Aufgabe1.Bubblesort.Sortierbar;

public class Soldat extends Mensch implements Sortierbar {
    private int groesse;

    public Soldat(int groesse, String name) {
        super(name);
        this.groesse = groesse;
    }

    public int getGroesse() {
        return groesse;
    }

    @Override
    public int istGroesser(Sortierbar element) {
        if(!(element instanceof Soldat))    //eig überflüssig
            throw new RuntimeException("Fehlende Vergleichbarkeit");
        if (this.groesse > element.getGroesse())
            return 1;
        else if (this.groesse == element.getGroesse())
            return 0;
        else
            return -1;
    }

    @Override
    public String toString() {
        return ("Name: " +  super.getName() + "\t Große: " + getGroesse());
    }
}
