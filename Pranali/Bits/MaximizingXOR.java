import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximizingXOR {
/*
 * Complete the function below.
 */

    static int maxXor(int l, int r) {
        int max_xor = -999;
        for (int a = l ; a<=r; a++) {
            for (int b = l; b <=r; b++) {
                int xor = a^b;
                if (xor > max_xor)
                    max_xor = xor;
            }
        }
        return max_xor;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}
