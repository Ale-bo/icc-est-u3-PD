package Controllers;
import java.util.ArrayList;
import java.util.List;

import models.Cell;

public class MazeSolverRecursivo implements MazeSolver{
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {

        if(grid == null || grid.length == 0){
            return new ArrayList<>();
        }

        List<Cell> path = new ArrayList<>();
        if(findPaht(grid , start , end , path)){
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPaht(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        // Valido si la base celda inicio su fila esta dentro de mi grid
        // Valido si la base celda inicio su row esta dentro de mi grid
        // Valido si la base celda es transitable == true

        int row = start.row;
        int col = start.col;
        if(row >= grid.length || col >= grid[0].length || !grid[row][col]){
            return false;
        }

        // Validar si es el final
        if(row == end.row && col == end.col){
            path.add(start);
            return true;
        }
        // Abajo
        if(findPaht(grid, new Cell(row + 1, col), end, path)){
            path.add(start);
            return true;
        }
        // Derecha
        if(findPaht(grid, new Cell(row, col + 1), end, path)){
            path.add(start);
            return true;
        }
        return false;
    }


}
