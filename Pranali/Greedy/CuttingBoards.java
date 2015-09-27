import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CuttingBoards {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        CuttingBoards so11  = new CuttingBoards();
        so11.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t= 0 ; t < T; t++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            BigInteger vcut = BigInteger.ONE;
            BigInteger hcut = BigInteger.ONE;
            ArrayList<BigInteger> vcost = new ArrayList<BigInteger>();
            ArrayList<BigInteger> hcost = new ArrayList<BigInteger>();
            for (int i = 0; i < m-1 ; i++)
                vcost.add(sc.nextBigInteger());
            for (int i = 0; i < n-1 ; i++)
                hcost.add(sc.nextBigInteger());
            int count = 0;
            Collections.sort(vcost);
            Collections.sort(hcost);
            BigInteger[] vprefixsum = new BigInteger[m];
            BigInteger[] hprefixsum = new BigInteger[n];
            for (int i = 0; i < m-1 ; i++) {
                if (i == 0) {
                    vprefixsum[i] = BigInteger.ZERO;
                }
                else {
                    vprefixsum[i] = vprefixsum[i-1].add(vcost.get(i-1));
                }
            }
            for (int i = 0; i < n-1 ; i++) {
                if (i == 0) {
                    hprefixsum[i] = BigInteger.ZERO;
                }
                else {
                    hprefixsum[i] = hprefixsum[i-1].add(hcost.get(i-1));
                }
            }
            int i = m-2;
            int j = n-2;
            BigInteger cost = BigInteger.ZERO;
            while (count < m+n-2) {
                if (i<0 || j<0) {
                    if (i <0 && j<0)
                        break;
                    if (i<0) {
                        cost = cost.add(vcut.multiply(hcost.get(j)));
                        //System.out.print("x" + j + "  ");
                        j--;
                        hcut = hcut.add(BigInteger.ONE);
                        
                    }
                    else if (j<0) {
                        cost = cost.add(hcut.multiply(vcost.get(i)));
                        //System.out.print("y" + i + "  ");
                        i--;
                        vcut = vcut.add(BigInteger.ONE);
                    }
                }
                else {
                    if (vcost.get(i).compareTo(hcost.get(j)) > 0) {
                        cost = cost.add(hcut.multiply(vcost.get(i)));
                        //System.out.print("y" + i + "  ");
                        i--;
                        vcut = vcut.add(BigInteger.ONE);
                    }
                    else if (vcost.get(i).compareTo(hcost.get(j)) < 0) {
                        cost = cost.add(vcut.multiply(hcost.get(j)));
                        //System.out.print("x" + j + "  ");
                        j--;
                        hcut = hcut.add(BigInteger.ONE);
                    }
                    else {
                        if (vprefixsum[i].compareTo(hprefixsum[j]) >= 0) {
                            cost = cost.add(hcut.multiply(vcost.get(i)));
                            //System.out.print("y" + i + "  ");
                            i--;
                            vcut = vcut.add(BigInteger.ONE);
                        }
                        else {
                            cost = cost.add(vcut.multiply(hcost.get(j)));
                            //System.out.print("x" + j + "  ");
                            j--; 
                            hcut = hcut.add(BigInteger.ONE);
                        }
                    }
                }
                count++;
            }
            System.out.println(cost.mod(new BigInteger("1000000007")));
        }
    }
}