package com.inflearn.thejava;

import java.time.Duration;

public class Progress {

  private Duration studyDuration;

  private boolean finished;

  public Duration getStudyDuration() {
    return studyDuration;
  }

  public void setStudyDuration(Duration studyDuration) {
    this.studyDuration = studyDuration;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }
}
