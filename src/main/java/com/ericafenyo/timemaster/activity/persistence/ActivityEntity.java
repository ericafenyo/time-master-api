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

package com.ericafenyo.timemaster.activity.persistence;

import com.ericafenyo.timemaster.project.Project;
import com.ericafenyo.timemaster.project.persistence.ProjectEntity;
import com.ericafenyo.timemaster.tag.persistence.TagEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * An Activity represents a specific task or action within a {@link Project}
 */
@Entity(name = "activities")
@EntityListeners(AuditingEntityListener.class)
public class ActivityEntity {
  /**
   * Unique identifier for the activity
   */
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  /**
   * UUID for the activity
   */
  @Column(name = "uuid", nullable = false, unique = true)
  private String uuid;

  /**
   * Name of the activity (e.g., Cycling)
   */
  @Column(name = "name", nullable = false)
  private String name;

  /**
   * Description or details about the activity
   */
  @Column(name = "description", nullable = false)
  private String description = "";

  @Column(name = "estimation", nullable = false)
  /**
   * Original time estimation of the activity in seconds
   */
  private Long estimation = 0L;

  /**
   * Start time when the activity is initiated
   */
  @Column(name = "start_time", nullable = false)
  private LocalDateTime startTime;

  /**
   * End time when the activity is stopped or completed
   */
  @Column(name = "end_time", nullable = false)
  private LocalDateTime endTime;

  /**
   * Identifier of the project this activity belongs to
   */
  @ManyToOne()
  @JoinColumn(name = "project_id", nullable = false)
  private ProjectEntity project;

  @ManyToMany
  private Set<TagEntity> tags;

  /**
   * Time when the activity was created
   */
  @Column(name = "created_at", nullable = false)
  @CreatedDate
  private LocalDateTime createdAt;

  /**
   * Time when the activity was last updated
   */
  @Column(name = "updated_at", nullable = false)
  @LastModifiedDate
  private LocalDateTime updatedAt;

  public Long id() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String uuid() {
    return uuid;
  }

  public void setUUID(String uuid) {
    this.uuid = uuid;
  }

  public String name() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String description() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long estimation() {
    return estimation;
  }

  public void setEstimation(Long estimation) {
    this.estimation = estimation;
  }

  public LocalDateTime startTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime endTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public ProjectEntity project() {
    return project;
  }

  public void setProject(ProjectEntity project) {
    this.project = project;
  }

  public LocalDateTime createdAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime updatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
