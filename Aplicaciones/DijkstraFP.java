package co.edu.unal.ds.finalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraFP {

    static final int INF = 1 << 30;  // un valor muy grande para inicializar "INFINITO" segun el algoritmo de dijkstra

    //Clase interna para simular los nodos del grafo dirigido
    static class Node implements Comparable<Node> {

        int destiny, weight;

        //constructor de la clase interna
        Node(int d, int p) {
            this.destiny = d;
            this.weight = p;
        }

        //es necesario definir un comparador para el correcto funcionamiento del PriorityQueue
        public int compareTo(Node other) {
            if (weight > other.weight) {
                return 1;
            }
            if (weight == other.weight) {
                return 0;
            }
            return -1;
        }
    };

    static Scanner sc = new Scanner(System.in);	   //para lectura de datos
    static List< List< Node>> graph;  //simular el grafo completo
    static int distance[];          //distance[ u ] distancia del vertice inicial al vertice con ID = u
    static boolean visited[];  //para los vertices visitados 
    static PriorityQueue< Node> Q; //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
    static int cities; //numero de ciudades del problema
    static int previous[];//es necesario para el algoritmo de dijkstra, segun lo averiguado
    static List<Integer> exitlist = new ArrayList<>(); // lista con la salida que se almacenara en el archivo

    //funcion de inicializacion, es necesario hacerlo cada vez para cada caso, debido a que si no se dejan en cero las listas y 
        // no se dejan en cero las listas y la cola de prioridad daran datos erroneos
    static void init() {
        graph = new ArrayList< List< Node>>();
        distance = new int[cities + 1];
        visited = new boolean[cities + 1];
        previous = new int[cities + 1];
        Q = new PriorityQueue< Node>();
        for (int i = 0; i <= cities; ++i) {
            distance[ i] = INF;  //inicializamos todas las distances con valor infinito segun dijkstra
            visited[ i] = false; //inicializamos todos los vertices como no visitados segun dijkstra
            previous[ i] = -1;   //inicializamos el previous del vertice i con -1 simulando que aun no ha sido visitado
        }
    }

    //Paso de relajacion
    static void relaxation(int here, int adjacent, int weight) {
        //Si la distance del origen al vertice siguiente + distancia de su arista es menor a la distancia del origen al vertice adyacente
        if (distance[ here] + weight < distance[ adjacent]) {
            distance[ adjacent] = distance[ here] + weight;  //relajamos el vertice actualizando la distancia
            previous[ adjacent] = here;                         //a su vez actualizamos el vertice anterior
            Q.add(new Node(adjacent, distance[ adjacent])); //agregamos el vertice adyacente a la cola de prioridad
        }
    }

    public static boolean writeFile(String fileName, List<Integer> list) {
        BufferedWriter bw = null;
        File file = new File(fileName);
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (Integer i : list) {
                bw.append(Integer.toString(i));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.err.println("Error in writeFile");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static void dijkstra(int initial) {
        Q.add(new Node(initial, 0)); //Insertamos el v�rtice inicial en la Cola de Prioridad
        distance[ initial] = 0;      //Este paso es importante, inicializamos la distance del inicial como 0
        int here, adjacent, weight;
        while (!Q.isEmpty()) {                   //Mientras cola no este vacia
            here = Q.element().destiny;            //Obtengo de la cola el nodo con menor peso, en un comienzo ser� el inicial
            Q.remove();                           //Sacamos el elemento de la cola
            if (visited[ here]) {
                continue; //Si el v�rtice actual ya fue visitado entonces sigo sacando elementos de la cola
            }
            visited[ here] = true;         //Marco como visitado el v�rtice actual
            for (int i = 0; i < graph.get(here).size(); ++i) { //reviso sus adyacentes del vertice actual
                adjacent = graph.get(here).get(i).destiny;   //id del vertice adyacente
                weight = graph.get(here).get(i).weight;        //peso de la arista que une actual con adyacente ( actual , adyacente )
                if (!visited[ adjacent]) {        //si el vertice adyacente no fue visitado
                    relaxation(here, adjacent, weight); //realizamos el paso de relajacion
                }
            }
        }
        int exit = 0;
        for (int i = 1; i <= cities; ++i) {
            exit ^= distance[i];
        }
        exitlist.add(exit);
    }

    public static void main(String[] args) {
        int roads, origin, destiny, weight, initial, cases;
        cases = sc.nextInt();
        for (int j = 0; j < cases; j++) {
            cities = sc.nextInt();
            roads = sc.nextInt();
            init();
            for (int i = 0; i <= cities; ++i) {
                graph.add(new ArrayList<Node>()); //inicializamos el grafo
            }
            for (int i = 0; i < roads; ++i) {
                origin = sc.nextInt();
                destiny = sc.nextInt();
                weight = sc.nextInt();
                graph.get(origin).add(new Node(destiny, weight));    //llenamos el grafo diridigo
            }
            initial = sc.nextInt();
            dijkstra(initial);
        }
        writeFile("exit.txt", exitlist);
    }

}
