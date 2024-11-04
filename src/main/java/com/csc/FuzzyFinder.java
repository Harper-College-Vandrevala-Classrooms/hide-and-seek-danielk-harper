package com.csc;

import java.util.*;

public class FuzzyFinder {
  // Your code goes here!
  public static void main(String args[]) {
    FuzzyListGenerator generator = new FuzzyListGenerator();
    FuzzyFinder finder = new FuzzyFinder();
    
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
    
    System.out.print(finder.binarySearch(sortedFuzzies));
    System.out.print(" ");
    System.out.print(finder.linearSearch(sortedFuzzies));
    System.out.println();
    System.out.println(finder.linearSearch(randomFuzzies));
  }
  
  public static int linearSearch(ArrayList<Fuzzy> list) {
    for(int i = 0; i < list.size(); i++) {
      if(list.get(i).color.equals("gold")) return i;
    }
    
    return -1;
  }
  
  public static int binarySearch(ArrayList<Fuzzy> list) {
    int start = 0;
    int end = list.size();
    
    while(true) {
      int i = (start + end) / 2;
      
      if(list.get(i).color.compareTo("gold") < 0) {
        start = i;
      } else if (list.get(i).color.compareTo("gold") > 0) {
        end = i;
      } else {
        return i;
      }
      
      if(start == end - 1) return -1;
    }
  }
}
