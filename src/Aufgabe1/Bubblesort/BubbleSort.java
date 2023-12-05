package Aufgabe1.Bubblesort;
/*
1   → übergebenes element größer
0   → gleich groß
-1  → übergebenes element kleiner
 */

public class BubbleSort {
    public static Sortierbar[] sort(Sortierbar[] array){
        boolean sortiert = false;
        while(!sortiert) {
            sortiert = true;
            for (int i = 0; i < (array.length-1); i++) {
                if (array[i].istGroesser(array[i + 1]) == 1) {
                    wechseln(array, i);
                    sortiert = false;
                }
            }
        }
        return array;
    }
    public static Sortierbar[] wechseln(Sortierbar[] array, int b){

        Sortierbar z = array[b];
        array[b] = array[b+1];
        array[b+1] = z;
        return array;
    }
}
