package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import static src.ejercicio2.SubadenaSinRepetir.tamanioSubcadena;

public class ejercicio2 {
    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    //metodo para devolver la subcadena sin repetir caracteres
    public class SubadenaSinRepetir{
        public static int tamanioSubcadena(String s){
            HashMap<Character, Integer> charIndexMap = new HashMap<>();
            int left=0;
            int maxLength = 0;

            //cadena al puntero derecho y caracter actual en right
            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);

                //si el char se repite y su indice es mayor o igual que left significa que ya se repitio el caracter dentro de la ventana  
                if (charIndexMap.containsKey(currentChar)){
                    //se mueve el puntero despues del char repetido 
                    left = Math.max(left, charIndexMap.get(currentChar) +1);
                }
                //se actualiza la posicion del caracter en el mapa
                charIndexMap.put(currentChar, right);

                //calcular la longitud
                maxLength = Math.max(maxLength, right -left +1);
            }
            return maxLength;
        }
    }  

    public static void main(String[] args) throws IOException{
    System.out.println("Ingrese una cadena:");
    String s = bufer.readLine();
    System.out.println("La longitud sin repetir es: " + tamanioSubcadena(s) );
        
    }
}
