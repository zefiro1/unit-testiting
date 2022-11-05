package com.in28minutes.unittesting.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HamcrestMatchersTest {

  @Test
  void learning() {
    List<Integer> numbers = Arrays.asList(12,15,45);

    //================Hamcrest===================
    //assertThat(numbers,hasSize(3));
    //assertThat(numbers,hasItems(12,45));
    //assertThat(numbers,everyItem(greaterThan(10)));
    //assertThat(numbers,everyItem(lessThan(100)));
    //assertThat("ABCDE",containsString("BCD"));
    //assertThat("ABCDE",startsWith("ABC"));
    //assertThat("ABCDE",endsWith("CDE"));
    //================AssertJ===================
    assertThat(numbers).hasSize(3)
        .contains(12,15)
        .allMatch(x -> x >10)
        .allMatch(x -> x<100)
        .noneMatch(x -> x <0);
    assertThat("").isEmpty();
    assertThat(("ABCDE")).contains("BCD")
        .startsWith("ABC")
        .endsWith("CDE");
  }
}
