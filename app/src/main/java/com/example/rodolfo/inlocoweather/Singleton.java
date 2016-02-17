package com.example.rodolfo.inlocoweather;

import java.util.ArrayList;

/**
 * Created by Rodolfo on 2/16/2016.
 */
public class Singleton {
    //Classe para transmissao de dados
    private static Singleton theInstance;

    public ArrayList<Cidade> arrayList;

    public static Singleton getInstance() {
        if (theInstance == null) {
            theInstance = new Singleton();
        }
        return theInstance;
    }
    private Singleton() {} // Construtor privado
}
