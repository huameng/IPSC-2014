import java.util.*;

public class T {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File("t1.in"));
    PrintWriter out = new PrintWriter(new File("t1.out"));
    int cases = in.nextInt();
    List<Range> smalls = new ArrayList<Range>();
    List<Range> bigs = new ArrayList<Range>();
    while(cases-->0) {
      int len = in.nextInt();
      int ranges = in.nextInt();
      int k = in.nextInt();
      while(ranges-->0) {
        int start = in.nextInt();
        int end = in.nextInt();
        if (start <= end-k) {
          bigs.add(new Range(start,end-k));
        }
        if (start+k <= end) {
          smalls.add(new Range(start+k,end));
        }
      }
      Collections.sort(smalls);
      Collections.sort(bigs);
      long covered = 0;
      long biggest = 0;
      for(Range r : smalls) {
        
      }
    }
  }
  
  private class Range implements Comparable<Range> {
    long start, end;
    public Range(long s, long e) {
      this.start = s;
      this.end = e;
    }
    
    public int compareTo(Range r) {
      if (r.start != start) {
        if (start > r.start) return 1;
        else return -1;
      }
      if (end > r.end) return 1;
      else return -1;
    } 
  }
}