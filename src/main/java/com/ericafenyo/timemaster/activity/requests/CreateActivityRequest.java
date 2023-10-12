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

package com.ericafenyo.timemaster.activity.requests;


import java.time.LocalDateTime;

/**
 * Activity is a core element used to track time for different tasks.
 */
public class CreateActivityRequest {
    /**
     * UUID for the activity
     */
    private String uuid;

    /**
     * Name of the activity (e.g., Task, Project)
     */
    private String name;

    /**
     * Description or details about the activity
     */
    private String description;

    /**
     * Original time estimation of the activity in seconds
     */
    private Long estimation = 0L;

    /**
     * Start time when the activity is initiated
     */
    private LocalDateTime startTime;

    /**
     * End time when the activity is stopped or completed
     */
    private LocalDateTime endTime;

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
}
