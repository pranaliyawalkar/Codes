import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class group {
    int start;
    int end;
    int count;
}

public class TeamFormation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    TeamFormation sol1 = new TeamFormation();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            int[] num = new int[n];
            for (int i = 0; i < n ; i++)
                num[i] = sc.nextInt();
            Arrays.sort(num);
            int count = 1;
            int min = 999999999;
            int i = 0;
            ArrayList<group> groups = new ArrayList<group>();
            for (i = 0; i < n ; i++) {
                int min_group = 99999999;
                int min_count = 99999999;
                boolean flag = false;
                for (int j = groups.size() -1 ; j >= 0 ; j--) {
                    if(groups.get(j).end + 1 == num[i]) {
                        flag = true;
                        if (groups.get(j).count < min_count) {
                            min_count = groups.get(j).count;
                            min_group = j;
                        }
                    }
                    else if (groups.get(j).end != num[i])
                        break;
                }
                if (flag == true) {
                    group g1 = groups.get(min_group);
                    g1.end = num[i];
                    g1.count++;
                    groups.remove(min_group);
                    groups.add(g1);
                }
                else {
                    group g1 = new group();
                    g1.start = num[i];
                    g1.end = num[i];
                    g1.count = 1;
                    groups.add(g1);
                }
                /*for (int j = 0; j < groups.size(); j++)
                    System.out.print(groups.get(j).end + "  ");
                System.out.println();*/
            }
            for (i = 0; i < groups.size(); i++) {
                if (groups.get(i).count < min)
                    min = groups.get(i).count;
            }
            System.out.println(min);
        }
    }
}