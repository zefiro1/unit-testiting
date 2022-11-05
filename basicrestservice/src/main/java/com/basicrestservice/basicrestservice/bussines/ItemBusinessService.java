package com.basicrestservice.basicrestservice.bussines;

import com.basicrestservice.basicrestservice.ItemRepository;
import com.basicrestservice.basicrestservice.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

  @Autowired
  private ItemRepository repository;

  public Item retriveHardcodedItem() {
    return new Item(1, "Ball", 10, 100);
  }

  public  List<Item> retriveAllItems(){
    List<Item> items = repository.findAll();
    for (Item item : items)
      item.setValue(item.getPrice() * item.getQuantity());
    return items;
  }


}
