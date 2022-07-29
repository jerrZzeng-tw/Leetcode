package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        generate(10).forEach(t -> {
            t.forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> root = new ArrayList<>();
        root.add(Arrays.asList(1));
        List<Integer> upper = root.get(0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            rows.add(1);
            for (int j = 0; j < upper.size() - 1; j++) {
                rows.add(upper.get(j) + upper.get(j + 1));
            }
            rows.add(1);
            upper = rows;
            root.add(upper);
        }
        return root;
    }


}
