package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class SomeDataServiceStub implements SomeDataService{

  @Override
  public int[] retriveAllData() {
    return new int[]{1,2,3};
  }

}
class SomeBusinessStubImplTest {

  @Test @DisplayName("Calculate Sum using data service using data service")
  void calculateSumUsingDataServiceBasic() {
    SomeBusinessImpl business = new SomeBusinessImpl();
    business.setSomeDataService(new SomeDataServiceStub());
    int actualResult = business.calculateSumUsingDataService();
    int expectedResult = 6;
    assertEquals(expectedResult,actualResult);

  }
  @Test @DisplayName("Calculate Sum if empty using data service")
  void calculateSumUsingDataServiceEmpty() {
    SomeBusinessImpl business = new SomeBusinessImpl();
    business.setSomeDataService(new SomeDataServiceStub());
    int actualResult = business.calculateSumUsingDataService();
    int expectedResult = 0;
    assertEquals(expectedResult,actualResult);

  }
  @Test @DisplayName("Calculate Sum if one value using data service")
  void calculateSumUsingDataServiceOneValue() {
    SomeBusinessImpl business = new SomeBusinessImpl();
    business.setSomeDataService(new SomeDataServiceStub());
    int actualResult = business.calculateSumUsingDataService();
    int expectedResult = 5;
    assertEquals(expectedResult,actualResult);

  }
}