package leetcode.easy;

public class NumberOfSegmentsInString {

    public static void main(String[] args) {
        System.out.println(countSegments("  Hello,   my name   is John"));
    }

    public static int countSegments(String s) {

        s.split(" ");
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int count = 1;
        int index = s.indexOf(' ');
        while (index >= 0) {
            int newIndex = s.indexOf(' ', index + 1);
            if (index != newIndex - 1) {
                count++;
            }
            index = newIndex;
        }
        return count;
    }


    public static int countSegments_1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        String arr[] = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != "")
                count++;
        }
        return count;
    }
}
