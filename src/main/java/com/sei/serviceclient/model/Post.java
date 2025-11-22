package com.sei.serviceclient.model;

public record Post(
        Long id,
        Long userId,
        String title,
        String body
) {
}
