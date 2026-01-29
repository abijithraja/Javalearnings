import java.util.*;

public class sample {
    public static void main (String args[]) {
        List<String> cus = Arrays.asList("abijith", "cook", "abijith");
        System.out.println(activeuser(cus));
    }
    public static List<String> activeuser(List<String> cus) {
        int n = cus.size();
        Collections.sort(cus);
        List<String> result = new ArrayList<>(); 
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            if (i == n - 1 || !cus.get(i).equals(cus.get(i + 1))) {
                
                if ((count * 100) / n >= 5) {
                    result.add(cus.get(i));
                }
                count = 0; 
            }
        }  
        return result; 
    }
}