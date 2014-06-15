import java.util.*;
import java.io.*;
import java.util.regex.*;

public class S{
  static final Pattern delimiters = Pattern.compile("[ ,.:;\'\"!?-]+");
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File("s2.in"));
    PrintWriter out = new PrintWriter(new File("s2.out"));
    int cases = Integer.parseInt(in.nextLine());
    // small = no asterisks
    // big = asterisks
    while(cases-->0) {
      String candidate = "";
      while(candidate.length() == 0) {
        candidate = in.nextLine();
      }
      int sentences = Integer.parseInt(candidate);
      double bestScore = 0.0;
      int bestIndex = 0;
      for(int z=1;z<=sentences;++z) {
        Scanner sentence = new Scanner(in.nextLine()).useDelimiter(delimiters);
        int words = 0;
        int score = 0;
        boolean asterisk = false;
        while(sentence.hasNext()) {
          String word = sentence.next();
          if (word.charAt(0) == '*') {
            asterisk = !asterisk;
          }
          ++words;
          int thisScore = 1;
          if (isAllCaps(word)) {
            thisScore *= 2;
          }
          if (asterisk) {
            thisScore *= 3;
          }
          score += thisScore;
          if (word.charAt(word.length()-1) == '*') {
            asterisk = !asterisk;
          }
        }
        if (1.0*score/words > bestScore) {
          bestScore = 1.0*score/words;
          bestIndex = z;
        }
      }
      out.println(bestIndex);
    }
    out.flush();
  }
  
  public static boolean isAllCaps(String word) {
    return word.equals(word.toUpperCase());
  }
}