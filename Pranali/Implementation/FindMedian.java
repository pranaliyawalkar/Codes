import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.PriorityQueue;
import java.util.Collections;

public class FindMedian {

    int n;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    FindMedian sol1 = new FindMedian();
    Scanner scan = new Scanner(System.in);
    sol1.n = scan.nextInt();
    for (int i = 0 ; i < sol1.n; i++) {
        sol1.numbers.add(scan.nextInt());
    }
    sol1.process();
    }
    public void process(){
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(100);
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(100, Collections.reverseOrder());
        for (int i = 0 ;i < n; i++) {
            int element = numbers.get(i);
            int size1 = maxheap.size();
            int size2 = minheap.size();
            float median = 0;
            if (size1 ==0 && size2 ==0) {
                maxheap.offer(element);
                System.out.printf("%.1f",(float)element);
                System.out.println();
            }
            else if (size1 == size2) {
                median = ((float)minheap.peek() + maxheap.peek() ) / 2;
                if (element <= median) {
                    maxheap.offer(element);
                    System.out.printf("%.1f",((float)maxheap.peek()));
                    System.out.println();
                }
                else {
                    minheap.offer(element);
                    System.out.printf("%.1f",((float)minheap.peek()));
                    System.out.println();
                }
            }
            else if (size1 > size2) {
                median = (float)maxheap.peek();
                int int_med = maxheap.peek();
                if (element > median) {
                    minheap.offer(element);
                    System.out.printf("%.1f",(((float)maxheap.peek() + minheap.peek())/2));
                    System.out.println();
                }
                else {
                    maxheap.poll();
                    minheap.offer(int_med);
                    maxheap.offer(element);
                    System.out.printf("%.1f",(((float)maxheap.peek() + minheap.peek())/2));
                    System.out.println();
                }

            }
            else if (size1 < size2) {
                median = (float)minheap.peek();
                int int_med = minheap.peek();
                if (element > median) {
                    minheap.poll();
                    minheap.offer(element);
                    maxheap.offer(int_med);
                    System.out.printf("%.1f",(((float)maxheap.peek() + minheap.peek())/2));
                    System.out.println();
                }
                else {
                    maxheap.offer(element);
                    System.out.printf("%.1f",(((float)maxheap.peek() + minheap.peek())/2));
                    System.out.println();
                }

            }
        }
        
    }
}