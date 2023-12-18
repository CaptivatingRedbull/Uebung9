package Aufgabe2d;

import java.awt.dnd.DragGestureEvent;

public class Modul {
    private final int m;  //modul
    Rest[] reste;


    public Modul(int m, int[] grundmenge) {  //Konstruktor mit gegebener Grundmenge
        this.m = m;

        int maxWert = 0;    //maximaler Wert, der in der grundmenge[], übergeben wurde
        for (int i : grundmenge)
            maxWert = Math.max(maxWert, i);

        reste = new Rest[m];    //für jeden möglichen Rest eine Restklasse in reste[] erstellen
        for (int i = 0; i < reste.length; i++)
            reste[i] = new Rest(i, m - 1, maxWert);

        for (int i : grundmenge)  //Werte den richtigen Restklassen zuteilen
            reste[i % m].put(i);
    }

    public Modul(int m){
        this(m, rndIntArray());
    }

    private static int[] rndIntArray(){
        int [] output = new int[((int)(Math.random()*1000))];
        for(int i = 0; i < output.length; i++)
            output[i] = ((int)(Math.random()*1000));
        return output;
    }

    public String sterneToString(){ //gibt alle sterneToSting methoden der Restklassen aus
        String output = "";
        for (int i = 0; i < m; i++)
            output += (reste[i].sterneToString() + (i == m - 1 ? "" : "\n"));
        return output;
    }


    @Override
    public String toString() {  //gibt alle toString methoden der Restklassen aus
        String output = "";
        for (int i = 0; i < m; i++)
            output += (reste[i].toString() + (i == m - 1 ? "" : "\n"));
        return output;
    }

    static class MultiTafel {
        int m;
        int maxRestLength = 0;
        int maxFaktorLength = 0;
        int[] [] multiTafel;

        public MultiTafel(int m){
            this.m = m;
            maxFaktorLength = String.valueOf(m).length();   //Formatierung
            maxRestLength = String.valueOf(m-1).length();
            multiTafel = new int[m][m];
            for(int i = 0; i < multiTafel.length; i++){
                for(int j = 0; j < multiTafel.length; j++)
                    multiTafel[i][j] = (i*j)%m;
            }
        }

        public int getInverse(int num){ //gibt inverses zu num zurück
            for(int i = 0; i < multiTafel.length; i++){
                if(multiTafel[num][i] == 1)
                    return i;
            }
            return -1;
        }

        public String getInverseTafel(int num){ //gibt eine Tabelle mit jeweiligen Inversen zu jedem Faktor einer MultiTafel zurück (falls vorhanden)
            String output = "";
            int inverse = 0;
            for(int i = 0; i < multiTafel.length; i++) {
                output += "[ " + String.format("%" + maxFaktorLength + "s", i) + " ]  [ ";    //erste Spalte
                inverse = getInverse(i);
                output += String.format("%" + maxFaktorLength + "s", (inverse != -1 ? inverse : "-")) + " ]\n";
            }
            return output;
        }


        @Override
        public String toString() {
            String output = "[ " + String.format("%" + maxFaktorLength + "s", m) + " ]  ";  // erste Zeile (Faktoren)
            for(int i = 0; i < multiTafel.length; i++)
                output += "[ " + String.format("%" + maxFaktorLength + "s", i) + " ]  ";
            output += "\n";

            for(int i = 0; i < multiTafel.length; i++){
                output += "[ " + String.format("%" + maxFaktorLength + "s", i) + " ]  ";    //erste Spalte
                for(int j = 0; j < multiTafel.length; j++)
                    output += String.format("%" + (maxFaktorLength+2) + "s", multiTafel[i][j]) + "    ";    //Werte
                output += "\n";
            }

            return output;
        }
    }


}

class Rest {
    private final int rest;
    private final int maxRestLength;
    private final int maxWertLength;
    private int[] werte = new int[0];

    public Rest(int rest, int maxRest, int maxWert) {
        this.rest = rest;
        this.maxRestLength = String.valueOf(maxRest).length();  //jeweils maximale Zeichenlänge der Reste bzw. Werte
        this.maxWertLength = String.valueOf(maxWert).length();  //für die Formatierung der Ausgabe
    }

    public void put(int wert) {  //Einfügen von Werten in die Restklasse
        int[] newWerte = new int[werte.length + 1];
        System.arraycopy(werte, 0, newWerte, 0, werte.length);
        newWerte[newWerte.length - 1] = wert;
        werte = newWerte;
    }

    public String sterneToString(){ //gibt pro Wert, der der Restklasse zugewiesen ist ein Stern zurückd
        String output = ("[ " + String.format("%" + maxRestLength + "s", rest) + " ] : ");    //Rest der Restklasse

        for (int i = 0; i < werte.length; i++)   //ein Stern pro Wert
            output += "* ";

        return output;
    }

    @Override
    public String toString() {
        String output = ("[ " + String.format("%" + maxRestLength + "s", rest) + " ] = { ");    //Rest der Restklasse

        if (werte.length == 0)
            return (output + "Keine Werte ergeben diesen Rest }");

        for (int i = 0; i < werte.length; i++)   //Werte der Restklasse
            output += (String.format("%" + maxWertLength + "s", werte[i]) + (i == werte.length - 1 ? "" : ", "));

        output += " }";

        return output;
    }
}

