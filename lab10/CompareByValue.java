import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.util.Comparator;


class CompareByValue implements Comparator<Map.Entry<String,Integer>> {
   public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
      return b.getValue() - a.getValue();
   }
}