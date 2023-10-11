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

package com.ericafenyo.timemaster.user.internal;

import com.ericafenyo.timemaster.Mapper;
import com.ericafenyo.timemaster.user.UserEntity;
import com.ericafenyo.timemaster.user.UserRepository;
import com.ericafenyo.timemaster.user.UserService;
import com.ericafenyo.timemaster.user.model.User;
import com.ericafenyo.timemaster.user.requests.CreateUserRequest;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper<UserEntity, User> mapper;

    public UserServiceImpl(UserRepository userRepository, Mapper<UserEntity, User> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User create(CreateUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setUUID(UUID.randomUUID().toString());

        UserEntity savedEntity = userRepository.save(entity);

        return mapper.toModel(savedEntity);
    }
}
