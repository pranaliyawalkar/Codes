import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MissingNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    MissingNumbers sol1 = new MissingNumbers();
        sol1.process();
    }
    
    public void process() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
        for(int i = 0;i <n ; i++) {
            int num = s.nextInt(); 
            if (a.containsKey(num))
                a.put(num, a.get(num) + 1);
            else
                a.put(num, 1);
        }
        int m = s.nextInt();
        for(int i = 0;i <m ; i++) {
            int num = s.nextInt(); 
            if (b.containsKey(num))
                b.put(num, b.get(num) + 1);
            else
                b.put(num, 1);
        }
        Iterator it = a.entrySet().iterator();
        ArrayList<Integer> missing = new ArrayList<Integer>();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int num = (int)pair.getKey();
            int value = (int)pair.getValue();
            int value2 = b.get(num);
            if (value!=value2)
                missing.add(num);
        }
        Collections.sort(missing);
        for (int i = 0; i < missing.size(); i++) {
            System.out.print(missing.get(i) + " ");
        }
    }
}