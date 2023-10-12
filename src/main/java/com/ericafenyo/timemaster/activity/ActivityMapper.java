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

import com.ericafenyo.timemaster.activity.persistence.ActivityEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ActivityMapper implements Function<ActivityEntity, Activity> {
  @Override
  public Activity apply(ActivityEntity entity) {
    Activity activity = new Activity();
    activity.setId(entity.uuid());
    activity.setName(entity.name());
    activity.setDescription(entity.description());
    activity.setEstimation(entity.estimation());
    activity.setStartTime(entity.startTime());
    activity.setEndTime(entity.endTime());
    activity.setProjectId(entity.project().uuid());
    activity.setCreatedAt(entity.createdAt());
    activity.setUpdatedAt(entity.updatedAt());

    return activity;
  }
}
