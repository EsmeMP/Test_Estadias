package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ejercicio1 {
    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    // Definición de la clase Lista
    static class Lista {
        int valor;
        Lista next;
        
        Lista(int valor){
            this.valor = valor;
            this.next = null;
        }
    }
    //Metodo para crear la lista enlazada
    // Se le pide al usuario la longitud de la lista y los valores de cada nodo
    public static Lista crearLista() throws IOException {
        System.out.println("Ingrese la longitud de la lista:");
        entrada = bufer.readLine(); 
        int n =Integer.parseInt(entrada);

        if (n == 0) {
            return null;
        }
        
        System.out.println("Ingrese el valor del nodo 1:");
        int valor = Integer.parseInt(bufer.readLine());
        if (valor < 0 || valor > 9) {
            System.out.println("El valor debe estar entre 0 y 9");
            return null;
        }
        Lista cabeza = new Lista(valor);
        Lista actual = cabeza;

        for (int i = 2; i <= n; i++) {
            System.out.println("Ingrese el valor del nodo " + i + ":");
            valor = Integer.parseInt(bufer.readLine());
            actual.next = new Lista(valor);
            actual = actual.next;
        }
        return cabeza;
    }

    //Metodo para poder imprimir la lista
    // Se imprime la lista en un formato similar a... [1,2,3]
    public static void imprimirLista(Lista cabeza) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Lista actual = cabeza;
        System.out.print("[");
        while (actual != null) {
            System.out.print(actual.valor );
            if (actual.next != null) {
                System.out.print(", ");
            }
            actual = actual.next;
        }
        System.out.println("]");
    }

    //Metodo para sumar dos listas
    // se suman los valores de las listas de forma que el primer nodo es la unidad
    // y el último nodo es la decena
    // se utiliza un acarreo para poder sumar los valores de las listas
    // se crea una lista auxiliar para almacenar el resultado
    public static Lista sumarListas(Lista l1, Lista l2) {
        Lista auxiliar = new Lista(0);
        Lista actual = auxiliar;
        int acarreo = 0;

        //mientras haya nodos en las listas o haya un acarreo
        // se suman los valores de las listas y se almacena el resultado en la lista auxiliar
        while (l1 != null || l2 != null || acarreo != 0) {
            int suma = acarreo;
            if (l1 != null) {
                suma += l1.valor;
                l1 = l1.next;
            }
            if (l2 != null) {
                suma += l2.valor;
                l2 = l2.next;
            }
            //se calcula el acarreo y se almacena el resultado en la lista auxiliar 
            acarreo = suma / 10;
            //se crea un nuevo nodo en la lista auxiliar con el resultado de la suma
            actual.next = new Lista(suma % 10);
            actual = actual.next;
        }
        return auxiliar.next;
    }

    public static void main(String[] args) throws IOException {
        // se crea y se imprime l1
        Lista l1 = crearLista();
        System.out.print("l1= ");
        imprimirLista(l1);
        // se crea y se imprime l2
        Lista l2 = crearLista();
        System.out.print("l2= ");
        imprimirLista(l2);
        // se suman las listas y se imprime el resultado
        System.out.println("Sumando l1 & l2...");
        Lista suma = sumarListas(l1, l2);
        System.out.print("Resultado: ");
        imprimirLista(suma);
    }
}
