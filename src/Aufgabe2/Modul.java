package Aufgabe2;

import java.util.Arrays;
import java.util.concurrent.LinkedTransferQueue;

public class Modul {
    int m;
    public Modul(int m, int [] arr){
        this.m = m;
        Rest[] reste = new Rest[m];
        for(int i = 0; i < m; i++)
            reste[i] = new Rest(i);
        for (int j : arr)
            reste[(j % m)].put(j);
        for (Rest rest : reste)
            System.out.println(rest);
    }
}

class Rest{
    int rest;
    int [] arr = new int[0];
    public Rest(int rest){
        this.rest = rest;
    }
    public void put (int num){
        int [] newArr = new int[arr.length+1];
        for(int i = 0; i < arr.length; i++)
            newArr[i] = arr[i];
        newArr[arr.length] = num;
        arr = newArr;
    }

    @Override
    public String toString() {
        String out = ("[" + rest + "] = { ");
        for(int i = 0; i < arr.length; i++){
            out += arr[i];
            if( i < (arr.length-1))
                out += ", ";
        }
        out += " }";
        return out;
    }
}