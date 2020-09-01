package com.inflearn.thejava;

import java.util.Optional;

public class OnlineClass {

  private Integer id;

  private String title;

  private boolean closed;

  private Progress progress;

  public OnlineClass(Integer id, String title, boolean closed) {
    this.id = id;
    this.title = title;
    this.closed = closed;
  }

  public Integer getId() {
    return id;
  }

  public Optional<Progress> getProgress() {
    return Optional.ofNullable(progress);
  }

  public void setProgress(Optional<Progress> progress) {
    progress.ifPresent(p -> this.progress = p);
  }

  public String getTitle() {
    return title;
  }

  public boolean isClosed() {
    return closed;
  }
}
