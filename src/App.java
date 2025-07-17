import java.util.Arrays;
import java.util.List;

import Controllers.MazeSolver;
import Controllers.MazeSolverBFS;
import Controllers.MazeSolverDFS;
import Controllers.MazeSolverRecursivo;
import Controllers.MazeSolverRecursivoCompleto;
import models.Cell;
import models.Maze;

public class App {
    public static void main(String[] args) throws Exception {
       // runEjerciciosPD();
        runMaze();
    }
/* 
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
*/ 
 private static void runMaze(){
        boolean[][] predefinedMaze = {
            {true,true,true,true},
            {false,true,true,true},
            {true,true,false,false},
            {true,true,true,true}
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);
        List<MazeSolver> solvers = Arrays.asList(
            new MazeSolverRecursivo(),
            new MazeSolverRecursivoCompleto(),
            new MazeSolverBFS(),
            new MazeSolverDFS()
            );
        
        String[] nombres = {
            "Recursivo",
            "Recursivo Completo",
            "BFS",
            "DFS"
        };

        for (int i = 0; i < solvers.size(); i++) {
            MazeSolver solver = solvers.get(i);
            String nombre = nombres[i];

            System.out.println("\nCamino con " + nombre + ":");
            List<Cell> path = solver.getPath(maze.getMatriz(), start, end);

            if (path.isEmpty()) {
                System.out.println("No se encontró camino.");
            } else {
                for (Cell cell : path) {
                    System.out.println(cell);
                }
            }
        }

    }
}
