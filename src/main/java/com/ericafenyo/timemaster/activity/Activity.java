/*
 * The MIT License (MIT)
 *
 * Copyright (C) 2023 Eric Afenyo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ericafenyo.timemaster.activity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * Activity is a core element used to track time for different tasks.
 */
public class Activity {
  /**
   * Unique identifier for the activity
   */
  private String id;

  /**
   * Name of the activity (e.g.Cycling)
   */
  private String name;

  /**
   * Description or details about the activity
   */
  private String description;

  /**
   * Estimation of the activity duration in seconds
   */
  private Long estimation;

  /**
   * Start time when the activity is initiated
   */
  private LocalDateTime startTime;

  /**
   * End time when the activity is stopped or completed
   */
  private LocalDateTime endTime;

  /**
   * Identifier of the project this activity belongs to
   */
  private String projectId;

  /**
   * Time when the activity was created
   */
  private LocalDateTime createdAt;

  /**
   * Time when the activity was last updated
   */
  private LocalDateTime updatedAt;

  @JsonProperty("id")
  public String id() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("name")
  public String name() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("description")
  public String description() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @JsonProperty("estimation")
  public Long estimation() {
    return estimation;
  }

  public void setEstimation(Long estimation) {
    this.estimation = estimation;
  }

  @JsonProperty("startTime")
  public LocalDateTime startTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  @JsonProperty("endTime")
  public LocalDateTime endTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  @JsonProperty("projectId")
  public String projectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  @JsonProperty("createdAt")
  public LocalDateTime createdAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @JsonProperty("updatedAt")
  public LocalDateTime updatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
