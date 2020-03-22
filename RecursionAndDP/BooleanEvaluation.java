public class BooleanEvaluation {

    public static void main(String[] args) {
        String s = "1^0|0|1";
        boolean result = false;
        System.out.println(countEval(s, result));
    }

    public static int countEval(String s, boolean result) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return stringToBool(s) == result ? 1 : 0;

        int ways = 0;
        for(int i =  1; i < s.length(); i+=2) {
            String right = s.substring(0, i);
            String left = s.substring(i+1);

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            char c = s.charAt(i);
            if(c == '&') {
                totalTrue = leftTrue * rightTrue;
            }
            else if(c == '|') {
                totalTrue = leftTrue * rightFalse +
                            leftFalse * rightTrue +
                            leftTrue * rightTrue;
            }
            else if(c == '^') {
                totalTrue = leftTrue * rightFalse +
                            leftFalse * rightTrue;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }

        return ways;
    }

    private static boolean stringToBool(String s) {
        if(s.equals("0")) {
            return false;
        }
        else {
            return true;
        }
    }
}