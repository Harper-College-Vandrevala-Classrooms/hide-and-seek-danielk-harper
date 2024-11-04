package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;
  ArrayList<Fuzzy> randomFuzzies;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
    
    randomFuzzies = generator.randomizedRainbowFuzzies();
  }
  
  @Test
  void linearSearchSorted() {
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    
    assertEquals(finder.binarySearch(sortedFuzzies), finder.linearSearch(sortedFuzzies));
    assertEquals(true, finder.linearSearch(randomFuzzies) != -1);
  }
}
