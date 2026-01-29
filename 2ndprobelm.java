import java.util.*;

class Result {
    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        int n = parent.size();
        
        // 1. Create an array to store the total size of each department (subtree)
        long[] subtreeSum = new long[n];
        
        // 2. Fill it with the individual file sizes first
        for (int i = 0; i < n; i++) {
            subtreeSum[i] = files_size.get(i);
        }

        // 3. THE "EASY" LOGIC: Bottom-Up Summing
        // We walk BACKWARDS from the last folder to the first.
        // This ensures kids report their size to parents before parents report to grand-parents.
        for (int i = n - 1; i > 0; i--) {
            int myParent = parent.get(i);
            subtreeSum[myParent] += subtreeSum[i]; 
        }

        // 4. The total size of the whole tree is now at index 0
        long totalSum = subtreeSum[0];
        long minDifference = Long.MAX_VALUE;

        // 5. Try "cutting" every connection (except the root)
        for (int i = 1; i < n; i++) {
            // Difference = |Total - 2 * this_department|
            long currentDiff = Math.abs(totalSum - (2 * subtreeSum[i]));
            
            if (currentDiff < minDifference) {
                minDifference = currentDiff;
            }
        }

        return (int) minDifference;
    }
}

