package com.example.refactoring.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {
    ACTIVE("アクティブユーザー"),
    INACTIVE("非アクティブユーザー"),
    BANNED("禁止ユーザー"),
    TRIAL("トライアルユーザー"),
    EXPIRED("期限切れ");

    private final String description;
}
