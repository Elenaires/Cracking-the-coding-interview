import java.util.*;

public class EightQueen {

    static final int GRID = 4;
    public static void main(String[] args){
        List<List<Integer>> results = new ArrayList<>();
        //findPosition(results, new ArrayList<Integer>(), 0 /* row */);
        bruteForce(results, new ArrayList<Integer>(), 0 /* row */);

        // print result
        int count = 1;
        for(List<Integer> result : results) {
            System.out.print(count + ": ");
            for(int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            count++;
        }
    }

    /** Optimal */ 
    // index of positions represents the row at which a queen is positioned
    // positions[index] represents the col at which a queen is positioned
    /*private static void findPosition(List<List<Integer>> results, List<Integer> positions, 
                                int row) {
        // found all positions
        if(row == GRID) {
            results.add(new ArrayList<Integer>(positions));
        }
        else {
            for(int col = 0; col < GRID; col++) {
                if(isValid(positions, col, row)) {
                    positions.add(col);
                    findPosition(results, positions, row+1);
                    positions.remove(positions.size()-1);
                }
            }
        }
    }

    private static boolean isValid(List<Integer> positions, int col, int row) {
        for(int previousQueenRow = 0; previousQueenRow < row; previousQueenRow++) {
            int previousQueenCol = positions.get(previousQueenRow);

            // check column
            if(col == previousQueenCol) {
                return false;
            }

            // check diagonal
            int colDistance = Math.abs(previousQueenCol - col);
            int rowDistance = row - previousQueenRow;
            if(colDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }*/

    /** brute force */
    // generate all position permutations (0,1,2,3 : 0,1,3,2 : 0,2,1,3 etc)
    // check validity of each permutation
    private static void bruteForce(List<List<Integer>> results, List<Integer> positions, int row) {
        if(row == GRID) {
            if(isValid(positions)) {
                results.add(new ArrayList<Integer>(positions));
            }
        }
        else {
            for(int col = 0; col < GRID; col++) {
                if(!positions.contains(col)) {
                    positions.add(col);
                    bruteForce(results, positions, row+1);
                    positions.remove(positions.size()-1);
                }
            }
        }
    }

    private static boolean isValid(List<Integer> positions) {
        for(int row = 1; row < positions.size(); row++) {
            for(int previousQueenRow = 0; previousQueenRow < row; previousQueenRow++) {
                int previousQueenCol = positions.get(previousQueenRow);

                // check column
                int col = positions.get(row);
                if(col == previousQueenCol) {
                    return false;
                }

                // check diagonal
                // equal col and row distances between current position and 
                // previous queen position means diagonal
                int colDistance = Math.abs(previousQueenCol - col);
                int rowDistance = row - previousQueenRow;
                if(colDistance == rowDistance) {
                    return false;
                }
            }
        }
        return true;
    }
}