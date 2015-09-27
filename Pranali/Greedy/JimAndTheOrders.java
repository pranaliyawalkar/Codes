import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class item {
    int num;
    int value;
}
class item_sort implements Comparator<item> {
    public int compare(item i1, item i2) {
        return i1.value - i2.value;
    }
}

public class JimAndTheOrders {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    JimAndTheOrders sol1 = new JimAndTheOrders();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<item> items = new ArrayList<item>();
        for (int i = 0; i < n ; i++) {
            int t = sc.nextInt();
            t += sc.nextInt();
            item i1 = new item();
            i1.num = i+1;
            i1.value = t;
            items.add(i1);
        }
        Collections.sort(items, new item_sort());
        for (int i = 0; i < n ; i++)
            System.out.print(items.get(i).num + " ");
    }
}