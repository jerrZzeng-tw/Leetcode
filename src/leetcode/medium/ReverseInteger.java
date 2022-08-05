package leetcode.medium;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123456789));
    }

    public static int reverse(int x) {
        int result = 0;
        if (x == 10) {
            return 1;
        }
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //判斷溢出，檢核計算後值是否相同，因為Java如果值溢出會壞掉 Ex:964632435*10 會變成 1056389758
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
