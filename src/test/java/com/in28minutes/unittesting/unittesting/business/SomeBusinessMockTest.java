package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockImplTest {
  @InjectMocks
  SomeBusinessImpl business = new SomeBusinessImpl();
  @Mock
  SomeDataService dataServiceMock;

  @Test
  @DisplayName("Calculate Sum using mock")
  void calculateSumUsingDataServiceBasic() {

    when(dataServiceMock.retriveAllData()).thenReturn(new int[] { 1, 2, 3 });
    assertEquals(6, business.calculateSumUsingDataService());

  }

  @Test
  @DisplayName("Calculate Sum if empty using mock")
  void calculateSumUsingDataServiceEmpty() {

    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
    assertEquals(0, business.calculateSumUsingDataService());

  }

  @Test
  @DisplayName("Calculate Sum if one value using mock")
  void calculateSumUsingDataServiceOneValue() {

    when(dataServiceMock.retriveAllData()).thenReturn(new int[] { 5 });
    assertEquals(5, business.calculateSumUsingDataService());

  }
}