package com.in28minutes.unittesting.unittesting.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

  @Test @DisplayName("Calculate Sum")
  void calculateSum() {
    SomeBusinessImpl business = new SomeBusinessImpl();
    int actualResult = business.calculateSum(new int[]{1,2,3});
    int expectedResult = 6;
    assertEquals(expectedResult,actualResult);

  }
  @Test @DisplayName("Calculate Sum if empty")
  void calculateSum_empty() {
    SomeBusinessImpl business = new SomeBusinessImpl();
    int actualResult = business.calculateSum(new int[]{});
    int expectedResult = 0;
    assertEquals(expectedResult,actualResult);

  }
  @Test @DisplayName("Calculate Sum if one value")
  void calculateSum_oneValue() {
    SomeBusinessImpl business = new SomeBusinessImpl();
    int actualResult = business.calculateSum(new int[]{5});
    int expectedResult = 5;
    assertEquals(expectedResult,actualResult);

  }
}