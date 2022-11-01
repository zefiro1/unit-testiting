package com.in28minutes.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ListMockTest {
  List<String> mock = mock(List.class);

  @Test
  void sizeBasic() {

    when(mock.size()).thenReturn(5);
    assertEquals(5, mock.size());

  }
  @Test
  void returnDifferentValues() {
    when(mock.size()).thenReturn(5).thenReturn(10);
    assertEquals(5, mock.size());
    assertEquals(10, mock.size());

  }
  @Test
  void returnWithParamateres(){
    when(mock.get(0)).thenReturn("in28Minutes");
    assertEquals("in28Minutes",mock.get(0));
    assertNull(mock.get(1));
  }
  @Test
  void returnWithGenericParamateres(){
    when(mock.get(anyInt())).thenReturn("in28Minutes");
    assertEquals("in28Minutes",mock.get(0));
    assertEquals("in28Minutes",mock.get(1));

  }
  @Test
  void verificationBasics(){
    //SUT
    String value1 = mock.get(0);
    String value2 = mock.get(1);
    //Verify
    verify(mock).get(0);
    verify(mock, times(2)).get(anyInt());
    verify(mock, atLeast(1)).get(anyInt());
    verify(mock, atLeastOnce()).get(anyInt());
    verify(mock, atMost(2)).get(anyInt());
    verify(mock,never()).get(2);
  }
  @Test
  void argumentCapturing(){
    //SUT
    mock.add("SomeString");

    //Verification
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(mock).add(captor.capture());
    assertEquals("SomeString",captor.getValue());
  }
  @Test
  void multipleArgumentCapturing(){
    //SUT
    mock.add("SomeString1");
    mock.add("SomeString2");

    //Verification
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(mock, times(2)).add(captor.capture());
    List<String> allValues = captor.getAllValues();
    assertEquals("SomeString1",allValues.get(0));
    assertEquals("SomeString2",allValues.get(1));
  }
  @Test
   void mocking(){
    ArrayList arrayListMock = mock(ArrayList.class);
    arrayListMock.get(0);//null
    arrayListMock.size();//0
    arrayListMock.add("Test1");
    arrayListMock.add("Test2");
    arrayListMock.size();//0
    when(arrayListMock.size()).thenReturn(5);
    arrayListMock.size();//5
  }
  @Test
   void spying(){
    ArrayList arrayListSpy = spy(ArrayList.class);
    arrayListSpy.add("Test0");
    arrayListSpy.get(0);//Test0
    arrayListSpy.size();//1
    arrayListSpy.add("Test1");
    arrayListSpy.add("Test2");
    arrayListSpy.size();//3
    when(arrayListSpy.size()).thenReturn(5);

    arrayListSpy.add("Test3");
    arrayListSpy.size();//5

    verify(arrayListSpy).add("Test3");
  }
}
