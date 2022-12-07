package leetcode.easy;

public class IslandPerimeter {

    public static void main(String[] args) {
        System.out.println(islandPerimeter_2(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

    /**
     * 檢查4個格子
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // upper
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }
                    // down
                    if (i == (grid.length - 1) || grid[i + 1][j] == 0) {
                        perimeter++;
                    }
                    // left
                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }
                    // right
                    if (j == (grid[i].length - 1) || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    /**
     * 檢查上面跟左邊的格子,有相鄰的陸地需-2
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter_2(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    // upper
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    // left
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }

                }
            }
        }
        return perimeter;
    }
}
