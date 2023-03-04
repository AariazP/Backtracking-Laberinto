package org.example;

import java.util.ArrayList;
import java.util.List;

public class Laberinto {
    private char[][] laberinto; // Laberinto a resolver
    private List<char[][]> soluciones; // Lista de soluciones encontradas

    // Constructor de la clase
    public Laberinto(char[][] laberinto) {
        this.laberinto = laberinto;
        soluciones = new ArrayList<>();
    }

    // Método para buscar soluciones al laberinto
    public List<char[][]> buscarSoluciones(int x, int y) {
        buscar(x, y, new boolean[laberinto.length][laberinto[0].length], new char[laberinto.length][laberinto[0].length]);
        return soluciones;
    }

    // Método recursivo para buscar soluciones al laberinto
    private void buscar(int x, int y, boolean[][] visitados, char[][] camino) {
        // Verificar si la posición actual es válida
        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length || visitados[x][y] || laberinto[x][y] == '#') {
            return; // Si no es válida, se devuelve
        }

        visitados[x][y] = true; // Marcar la posición actual como visitada
        camino[x][y] = '*'; // Agregar la posición actual al camino

        // Verificar si se llegó a la meta
        if (x == 1 && y == 1) {
            soluciones.add(copiarCamino(camino)); // Si se llegó a la meta, se agrega el camino a la lista de soluciones
        } else {
            // Si no se llegó a la meta, se llama al método recursivamente para las posiciones vecinas
            buscar(x - 1, y, visitados, copiarCamino(camino)); // Arriba
            buscar(x + 1, y, visitados, copiarCamino(camino)); // Abajo
            buscar(x, y - 1, visitados, copiarCamino(camino)); // Izquierda
            buscar(x, y + 1, visitados, copiarCamino(camino)); // Derecha
        }

        visitados[x][y] = false; // Desmarcar la posición actual como visitada
        camino[x][y] = 'f'; // Marcar la posición actual como incorrecta en el camino
    }

    // Método para copiar un camino
    private char[][] copiarCamino(char[][] camino) {
        char[][] copia = new char[camino.length][camino[0].length];
        for (int i = 0; i < camino.length; i++) {
            System.arraycopy(camino[i], 0, copia[i], 0, camino[0].length);
        }
        return copia;
    }
}
