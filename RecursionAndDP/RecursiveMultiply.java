// multiply two positive integers without using the * or / operator with min operations.
// 2 x 5 = 5 + 5 (or 2 + 2 + 2 + 2 + 2)
public class RecursiveMultiply {
    public static void main(String[] args) {
        int product = getProduct(5,78);
        System.out.println(product);
    }

    private static int getProduct(int a, int b) {
        int num = Math.max(a, b);
        int times = Math.min(a, b);

        //int[] results = new int[times+1];
        return helper(num, times);
    }

    /** simple recursive function O(times) */
    /*private static int helper(int num, int times) {
        int answer = num;

        if(times == 0) return 0;
        if(times == 1) return answer;

        answer += helper(num, times-1);

        return answer;
    }*/

    /** Exponential? O(2^log times) - with repeated work  */
    /*private static int helper(int num, int times) {
        if(times == 0) return 0;
        if(times == 1) return num;

        int halfTime = times / 2;
        int firstHalf = helper(num, halfTime); // example 5 + 5 + 5 + 5 --> (5 + 5) + (5 + 5)
        int secondHalf = firstHalf;  

        if(times % 2 == 1) { // odd times, 5 + 5 + 5 --> 5 + helper(num, 2) --> 5 + 10
            secondHalf = helper(num, times - halfTime);
        }

        return firstHalf + secondHalf;
    }*/

    /** cache results O(log times) */
    /*private static int helper(int num, int times, int[] results) {
        if(times == 0) return 0;
        if(times == 1) return num;

        if(results[times] != 0) {
            return results[times];
        }

        // no cached result, compute half. If uneven, compute another half. If even double it.
        int halfTime = times >> 1; // times / 2
        
        int firstHalf = helper(num, halfTime, results); // example 5 + 5 + 5 + 5 --> (5 + 5) + (5 + 5)
        int secondHalf = firstHalf;  

        if(times % 2 == 1) { // odd times, 5 + 5 + 5 --> 5 + helper(num, 2) --> 5 + 10
            secondHalf = helper(num, times - halfTime, results);
        }

        results[times] = firstHalf + secondHalf;
        return results[times];
    }*/

    /** Realization that odd times is just even answer * 2 + num  */
    // 5 x 3 --> helper(5, 1)  x 2 (10) + 5
    // O(log times)
    private static int helper(int num, int times) {
        if(times == 0) return 0;
        if(times == 1) return num;

        int halfTime = times / 2;
        int firstHalf = helper(num, halfTime); 
    
        if(times % 2 == 1) { // odd times, 5 + 5 + 5 --> helper(num, 2) +  --> 5 + 10
            return firstHalf + firstHalf + num;
        }

        return firstHalf + firstHalf;
    }
}