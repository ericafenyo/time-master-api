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

package com.ericafenyo.timemaster.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * User class represents a user model.
 */
public class User {

    /**
     * Unique identifier for the user.
     */
    private String id;

    /**
     * First name of the user.
     */
    private String firstName;

    /**
     * Last name of the user.
     */
    private String lastName;

    /**
     * Email address of the user.
     */

    private String email;

    /**
     * URL pointing to the user's profile picture.
     */
    private String picture;

    /**
     * Indicates whether the user account is confirmed.
     */
    private Boolean isConfirmed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonProperty("id")
    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("first_name")
    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("email")
    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("picture")
    public String picture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @JsonProperty("is_confirmed")
    public Boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @JsonProperty("created_at")
    public LocalDateTime createdAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public LocalDateTime updatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
