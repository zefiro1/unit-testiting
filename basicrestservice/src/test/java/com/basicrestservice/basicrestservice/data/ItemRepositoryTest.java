package com.basicrestservice.basicrestservice.data;

import com.basicrestservice.basicrestservice.ItemRepository;
import com.basicrestservice.basicrestservice.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository;

  @Test
  void testFindAll() {
    List<Item> all = itemRepository.findAll();
    assertEquals(3,all.size());
  }
}
