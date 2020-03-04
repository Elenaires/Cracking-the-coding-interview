class Solution {

    // O(2^2n x n)
    public List<String> generateParenthesis(int n) {
        char[] array = new char[2*n];
        List<String> list = new ArrayList();
        for(int i = 0; i < (1 << 2*n); i++) { // O(2^2n)
            for(int j = 0; j < 2*n; j++) { // O(2n)
                if(((i>>j) & 1) != 0) {
                    array[j] = '(';
                }
                else {
                    array[j] = ')';
                }
            }
            if(valid(array)) { // O(2n)
                list.add(new String(array));
            }
        }
        
        return list;
    }
    
    private boolean valid(char[] array) {
        int balance = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == '(') balance++;
            else balance--;
            if(balance < 0) return false;
        }
        
        return balance == 0;
    }
}