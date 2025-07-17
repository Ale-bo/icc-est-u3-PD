package Controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cell;

public class MazeSolverRecursivoCompleto implements MazeSolver {
    private boolean[][] visited;

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        visited = new boolean[grid.length][grid[0].length];
        List<Cell> path = new ArrayList<>();

        if (findPath(grid, start, end, path)) {
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path) {
        int row = current.row;
        int col = current.col;

        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
            !grid[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        path.add(current);

        if (row == end.row && col == end.col) {
            return true;
        }

        
        if (findPath(grid, new Cell(row + 1, col), end, path) ||
            findPath(grid, new Cell(row - 1, col), end, path) ||
            findPath(grid, new Cell(row, col + 1), end, path) ||
            findPath(grid, new Cell(row, col - 1), end, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
