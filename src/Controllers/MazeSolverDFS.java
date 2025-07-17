package Controllers;

import java.util.*;

import models.Cell;

public class MazeSolverDFS implements MazeSolver {

    private List<Cell> path = new ArrayList<>();
    private boolean[][] visited;

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        visited = new boolean[grid.length][grid[0].length];
        path.clear();
        if (dfs(grid, start, end)) {
            return path;
        }
        return new ArrayList<>();
    }

    private boolean dfs(boolean[][] grid, Cell current, Cell end) {
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

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : dirs) {
            Cell next = new Cell(row + dir[0], col + dir[1]);
            if (dfs(grid, next, end)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}