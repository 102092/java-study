package com.inflearn.thejava;

public class OnlineClass {

  private Integer id;

  private String title;

  private boolean closed;

  public OnlineClass(Integer id, String title, boolean closed) {
    this.id = id;
    this.title = title;
    this.closed = closed;
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public boolean isClosed() {
    return closed;
  }
}
