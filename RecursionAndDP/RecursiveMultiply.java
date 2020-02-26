// multiply two positive integers without using the * or / operator with min operations.
// 2 x 5 = 5 + 5 (or 2 + 2 + 2 + 2 + 2)
public class RecursiveMultiply {
    public static void main(String[] args) {
        int product = getProduct(10,8);
        System.out.println(product);
    }

    private static int getProduct(int a, int b) {
        int num = Math.max(a, b);
        int times = Math.min(a, b);

        return helper(num, times);
    }

    /** simple recursive function */
    private static int helper(int num, int times) {
        int answer = num;

        if(times == 0) return 0;
        if(times == 1) return answer;

        answer += helper(num, times-1);

        return answer;
    }
}