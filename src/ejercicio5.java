package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {
    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static class BuscarSubcadena{
        //metodo para buscar la subcadena
        public static int buscar(String haystack, String needle){
            int hLength = haystack.length();
            int nLength = needle.length();

            //si la aguja es vacia devuelve 0
            if (needle.isEmpty()){
                return 0;
            }
            //si la aguja es mas grande que pajar devuelve -1
            if (hLength < nLength){
                return -1;
            }
            
            //bucle exterior para recorrer el pajar
            for (int i = 0; i <= hLength - nLength; i++){
                //compara la subcadena del pajar con la aguja
                int j;
                //bucle interior para recorrer la aguja
                for (j = 0; j < nLength; j++){
                    if (haystack.charAt(i + j) != needle.charAt(j)){
                        break;
                    }
                }
            if (j == nLength){
                //devuelve la posicion de la aguja
                return i; 
            }
        }
        //si no se encuentra la aguja devuelve -1
        return -1; 
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Ingrese haystack (pajar)");
        String haystack = bufer.readLine();
        System.out.println("Ingrese needle (aguja)");
        String needle = bufer.readLine();

        int resultado = BuscarSubcadena.buscar(haystack, needle);
        System.out.println(resultado);  
    }
}
