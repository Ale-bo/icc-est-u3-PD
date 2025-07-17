package models;
public class Maze {
    private boolean[][] matriz;

    public Maze(boolean[][] matriz) {
        this.matriz = matriz;
    }

    

    public void printMaze(){
        for(boolean[] columna : matriz){
            for(boolean fila : columna){
                System.out.print(fila ? " - " : " * ");
            }
            System.out.println();
        }
    }



    public boolean[][] getMatriz() {
        return matriz;
    }

}