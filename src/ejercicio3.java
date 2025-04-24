package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ejercicio3 {
    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public class ValidarCaracteres{
        public static boolean esPar (String s){
            //declaracion de la pila para almacenar los caracteres
            Stack<Character> pila = new Stack<>();
            //la cadena se recorre caracter por caracter
            for (char c : s.toCharArray()) {
                //si el caracter es de apertura se agrega a la pila
                if (c == '(' || c == '{' || c == '[') {
                    pila.push(c);
                //si el caracter es de cierre se verifica si la pila esta vacia
                } else if (c == ')' || c == '}' || c == ']') {
                    if (pila.isEmpty()) {
                        return false;
                    }
                    //si la pila no esta vacia se saca el caracter de la pila y se verifica si es par
                    char top = pila.pop();
                    if (!esPar(top, c)) {
                        return false;
                    }
                }
            }
            //si la pila esta vacia significa que todos los caracteres son pares   
            return pila.isEmpty();
        }

        private  static  boolean  esPar(char apertura, char cierre) {
            return (apertura == '(' && cierre == ')') ||
                   (apertura == '{' && cierre == '}') ||
                   (apertura == '[' && cierre == ']');
    }

    }
    public static void main(String[] args) throws IOException{
        System.out.println("Ingrese la cadena de characteres:");
        String s = bufer.readLine();    
        boolean resultado = ValidarCaracteres.esPar(s);
        System.out.println("Los caracteres son pares: " + resultado);
    }
}
