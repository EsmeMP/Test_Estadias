package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {
        public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        public static String entrada;

        // clase interna para eliminar duplicados del arreglo
        public static class RemoverDuplicados{
            public int eliminarDuplicados(int[] nums){
                if (nums.length == 0) {
                    return 0;
                }
                int k = 1;
                //k representa donde se coloca el siguiente elemento unico
                //i recorre el arreglo
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] != nums[k - 1]) {
                        nums[k] = nums[i];
                        k++;
                    }
                }
                return k;
            } 
        }

        // metodo para imprimir el arreglo
        // imprime los primeros k elementos del arreglo y el resto como "_"
        public static void imprimirArreglo(int[] nums, int k) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                //si i es menor que k, imprime el elemento
                //si i es mayor o igual que k, imprime "_"
                if (i < k) {
                    System.out.print(nums[i]);
                } else {
                    System.out.print("_");
                }
                
                if (i < nums.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            // Instancia de la clase RemoverDuplicados
            RemoverDuplicados solucion = new RemoverDuplicados();
            
            System.out.println("Ingrese la longitud del arreglo:");
            try {
                entrada = bufer.readLine();
                int n = Integer.parseInt(entrada);
                int[] nums = new int[n];
                System.out.println("Ingrese los elementos del arreglo:");
                // leer los elementos del arreglo
                for (int i = 0; i < n; i++) {
                    nums[i] = Integer.parseInt(bufer.readLine());
                }
                int k = solucion.eliminarDuplicados(nums);
                System.out.print(k + ", numeros = ");
                imprimirArreglo(nums, k);
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese numeros enteros.");
            } catch (IOException e) {
                e.printStackTrace();
        }
        
    }
}
