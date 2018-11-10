package nreinas;

/**
 *
 * @author richy
 */
public class NReinas {

    int[] x;
 
    public NReinas() {
        x = new int[8];
    }
    //cuarto paso metodo boolano que verifica si es conveniente poner a la reina en la columna c y
     // fila f
    //volver al tercer paso
    public boolean esConveniente(int f, int c) {
        for (int i = 0; i < f; i++) {
            if (x[i] == c || (i - f) == (x[i] - c) ||(i - f) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }
    //ultimo paso 
    public void imprimeTablero(int[] x) {
        int tam = 8;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (x[i] == j) {
                    System.out.print("۞ ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    //tercer paso este metodo va recorriendo los posibles espacio hasta que 
        //encuentra uno donde no se ataquen
    public void backtracking(int f, int n) { 
      
        for (int c = 0; c < n; c++) {
            if (esConveniente(f, c)) {
                x[f] = c;
                if (f == n - 1) {
                    imprimeTablero(x);
                } else {
                    backtracking(f + 1, n);
                }
            }
        }
    }
    //Segundo paso se crea un metodo para llamar al metodo backtracking() y
    //le pasamos los parametros 0 para que empieze en la fila 0 y 8 para el numero de reinas
    public void llamaBT() {
        backtracking(0, 8);
    }
 
    //primer paso instanciar la clase NReinas para llamar a su metodo llamarBT()
    public static void main(String args[]) {
        NReinas R = new NReinas();
        R.llamaBT();
      
    }
    
}

