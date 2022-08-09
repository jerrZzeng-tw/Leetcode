package leetcode.medium;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char temp = str.charAt(0);
        int count = 0;
        for (char c : str.toCharArray()) {
            if (temp != c) {
                sb.append(count);
                sb.append(temp);
                temp = c;
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(temp);
        return sb.toString();
    }
}
