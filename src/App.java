// App.java
public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosPD();
    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        System.out.println("Fibonacci Recursivo:");
        long start = System.nanoTime();                  
        int resultado = ejerciciosPD.getFibonacci(50);
        long end = System.nanoTime();                       
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration );

        System.out.println("Fibonacci Programación Caching:");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonacciPD(50);
        end   = System.nanoTime();
        duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration );
    }
}
