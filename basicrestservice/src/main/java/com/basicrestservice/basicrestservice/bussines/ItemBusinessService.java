package com.basicrestservice.basicrestservice.bussines;

import com.basicrestservice.basicrestservice.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

  public Item retriveHardcodedItem(){
    return new Item(1,"Ball",10,100);
  }
}
