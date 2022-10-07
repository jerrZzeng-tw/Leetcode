package leetcode.easy;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        long start = 1;
        long end = n;
        long middle = 0;

        int version = 1702766719;
        while ((end - start) != 1) {
            middle = (start + end) / 2;
            if (middle >= version) {
                end = middle;
            } else {
                start = middle;
            }
        }

        return (int) start;
    }
    
}
