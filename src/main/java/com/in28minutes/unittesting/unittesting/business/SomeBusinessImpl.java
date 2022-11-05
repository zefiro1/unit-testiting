package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

  private SomeDataService someDataService;

  public void setSomeDataService(SomeDataService someDataService) {
    this.someDataService = someDataService;
  }
  public int calculateSum(int[] data) {

    return Arrays.stream(data).reduce(Integer::sum).orElse(0);

  }

  public int calculateSumUsingDataService() {
    int sum = 0;
    int[] data = someDataService.retriveAllData();
    for (int value : data) {
      sum += value;
    }
    return sum;
  }


}
