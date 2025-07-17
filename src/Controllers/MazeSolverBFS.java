package Controllers;

import java.util.*;

import models.Cell;

public class MazeSolverBFS implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Map<Cell, Cell> parent = new HashMap<>();

        Queue<Cell> queue = new LinkedList<>();
        queue.add(start);
        visited[start.row][start.col] = true;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            if (current.row == end.row && current.col == end.col) {
                return buildPath(parent, end);
            }

            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    grid[newRow][newCol] && !visited[newRow][newCol]) {
                    
                    Cell neighbor = new Cell(newRow, newCol);
                    queue.add(neighbor);
                    visited[newRow][newCol] = true;
                    parent.put(neighbor, current);
                }
            }
        }

        return new ArrayList<>();
    }

    private List<Cell> buildPath(Map<Cell, Cell> parent, Cell end) {
        List<Cell> path = new ArrayList<>();
        for (Cell at = end; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
