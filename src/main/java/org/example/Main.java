package org.example;

import java.util.List;

public class Main {
     public  static  char[][] laberinto = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };

    public static void main(String[] args) {
        Laberinto l = new Laberinto(laberinto);
        List<char[][]> soluciones = l.buscarSoluciones(8, 1);
        for (char[][] solucion : soluciones) {
            for (char[] fila : solucion) {
                for (char c : fila) {
                   if(c==0) c='#';
                   System.out.print(c);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("");
    }



}