package com.basicrestservice.basicrestservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {
  @Id
  private int id;
  private String name;
  private int price;
  private int quantity;
  @Transient
  private int value;

  protected Item(){

  }
  public Item(int id, String name, int price, int quantity) {
    setId(id);
    setName(name);
    setPrice(price);
    setQuantity(quantity);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
  }
}
