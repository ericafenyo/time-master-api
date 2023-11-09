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

package com.ericafenyo.timemaster.activity.internal;

import com.ericafenyo.timemaster.activity.Activity;
import com.ericafenyo.timemaster.activity.ActivityMapper;
import com.ericafenyo.timemaster.activity.ActivityService;
import com.ericafenyo.timemaster.activity.persistence.ActivityEntity;
import com.ericafenyo.timemaster.activity.persistence.ActivityRepository;
import com.ericafenyo.timemaster.activity.requests.CreateActivityRequest;
import com.ericafenyo.timemaster.activity.requests.UpdateActivityRequest;
import com.ericafenyo.timemaster.project.persistence.ProjectRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final ProjectRepository projectRepository;
    private final ActivityMapper mapper;

    public ActivityServiceImpl(
            ActivityRepository activityRepository,
            ProjectRepository projectRepository
    ) {
        this.activityRepository = activityRepository;
        this.projectRepository = projectRepository;
        this.mapper = Mappers.getMapper(ActivityMapper.class);
    }

    @Override
    public Activity create(CreateActivityRequest request, String projectId) {
//        ProjectEntity projectEntity = this.projectRepository.findById(projectId);
//        entity.setProject(projectEntity);

        ActivityEntity entity = new ActivityEntity();
        entity.setUuid(UUID.randomUUID().toString());
        entity.setName(request.name());
        entity.setDescription(request.description());
        entity.setEstimation(request.estimation());
        entity.setStartTime(request.startTime());
        entity.setEndTime(request.endTime());

        ActivityEntity result = this.activityRepository.save(entity);
        return mapper.toModel(result);
    }

    @Override
    public List<Activity> find() {
        List<ActivityEntity> entities = activityRepository.findAll();
        return entities.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Activity update(String activityId, UpdateActivityRequest request) {
        ActivityEntity entity = this.activityRepository.findById(activityId);
        if (entity == null) {
            throw new RuntimeException("Activity not found");
        }

        // Merge request into entity
        mapper.merge(request, entity);

        return mapper.toModel(this.activityRepository.save(entity));
    }
}
