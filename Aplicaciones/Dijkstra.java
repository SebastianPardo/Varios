package co.edu.unal.ds.Aplicaciones;

import java.util.*;

public class Dijkstra {

    //similar a los defines de C++
    static final int MAX = 10000005;  //maximo numero de v�rtices
    static final int INF = 1 << 30;  //definimos un valor grande que represente la distancia infinita inicial, basta conque sea superior al maximo valor del peso en alguna de las aristas

    //En el caso de java usamos una clase que representara el pair de C++
    static class Node implements Comparable<Node> {

        int first, second;

        Node(int d, int p) {							//constructor
            this.first = d;
            this.second = p;
        }

        public int compareTo(Node other) {				//es necesario definir un comparador para el correcto funcionamiento del PriorityQueue
            if (second > other.second) {
                return 1;
            }
            if (second == other.second) {
                return 0;
            }
            return -1;
        }
    };

    static Scanner sc = new Scanner(System.in);	   //para lectura de datos
    static List< List< Node>> ady;  //lista de adyacencia
    static int distancia[];          //distancia[ u ] distancia de v�rtice inicial a v�rtice con ID = u
    static boolean visitado[] = new boolean[MAX];   //para v�rtices visitados
    static PriorityQueue< Node> Q; //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
    static int V;                                      //numero de vertices
    static int previo[] = new int[MAX];  //para la impresion de caminos
    static List<Integer> exitlist = new ArrayList<>();

    //funci�n de inicializaci�n
    static void init() {
        ady = new ArrayList< List< Node>>();
        distancia = new int[MAX];
        visitado = new boolean[MAX];
        previo = new int[MAX];
        Q = new PriorityQueue< Node>();
        for (int i = 0; i <= V; ++i) {
            distancia[ i] = INF;  //inicializamos todas las distancias con valor infinito
            visitado[ i] = false; //inicializamos todos los v�rtices como no visitados
            previo[ i] = -1;      //inicializamos el previo del vertice i con -1
        }
    }

    //Paso de relajacion
    static void relajacion(int actual, int adyacente, int peso) {
        //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
        if (distancia[ actual] + peso < distancia[ adyacente]) {
            distancia[ adyacente] = distancia[ actual] + peso;  //relajamos el vertice actualizando la distancia
            previo[ adyacente] = actual;                         //a su vez actualizamos el vertice previo
            Q.add(new Node(adyacente, distancia[ adyacente])); //agregamos adyacente a la cola de prioridad
        }
    }

    //Impresion del camino mas corto desde el vertice inicial y final ingresados
    static void print(int destino) {
        if (previo[ destino] != -1) //si aun poseo un vertice previo
        {
            print(previo[ destino]);  //recursivamente sigo explorando
        }
        System.out.printf("%d ", destino);        //terminada la recursion imprimo los vertices recorridos
    }

    static void dijkstra(int inicial) {
        Q.add(new Node(inicial, 0)); //Insertamos el v�rtice inicial en la Cola de Prioridad
        distancia[ inicial] = 0;      //Este paso es importante, inicializamos la distancia del inicial como 0
        int actual, adyacente, peso;
        while (!Q.isEmpty()) {                   //Mientras cola no este vacia
            actual = Q.element().first;            //Obtengo de la cola el nodo con menor peso, en un comienzo ser� el inicial
            Q.remove();                           //Sacamos el elemento de la cola
            if (visitado[ actual]) {
                continue; //Si el v�rtice actual ya fue visitado entonces sigo sacando elementos de la cola
            }
            visitado[ actual] = true;         //Marco como visitado el v�rtice actual

            for (int i = 0; i < ady.get(actual).size(); ++i) { //reviso sus adyacentes del vertice actual
                adyacente = ady.get(actual).get(i).first;   //id del vertice adyacente
                peso = ady.get(actual).get(i).second;        //peso de la arista que une actual con adyacente ( actual , adyacente )
                if (!visitado[ adyacente]) {        //si el vertice adyacente no fue visitado
                    relajacion(actual, adyacente, peso); //realizamos el paso de relajacion
                }
            }
        }

        //System.out.printf( "Distancias mas cortas iniciando en vertice %d\n" , inicial );
        int exit = 0;
        for (int i = 1; i <= V; ++i) {
            //System.out.printf("Vertice %d , distancia mas corta = %d\n" , i , distancia[ i ] );
            exit ^= distancia[i];
        }
        exitlist.add(exit);
    }

    public static void main(String[] args) {
        int E, origen, destino, peso, inicial, casos;
        casos = sc.nextInt();
        for (int j = 0; j < casos; j++) {
            V = sc.nextInt();
            E = sc.nextInt();
            init();
            for (int i = 0; i <= V; ++i) {
                ady.add(new ArrayList<Node>()); //inicializamos lista de adyacencia
            }
            for (int i = 0; i < E; ++i) {
                origen = sc.nextInt();
                destino = sc.nextInt();
                peso = sc.nextInt();
                ady.get(origen).add(new Node(destino, peso));    //grafo diridigo
            }
            inicial = sc.nextInt();
            dijkstra(inicial);
        }
        for (Integer exit : exitlist) {
            System.out.println(exit);
        }
    }

}
