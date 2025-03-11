package com.example.refactoring.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN("管理者"),
    GUEST("ゲスト"),
    MEMBER("メンバー"),
    PREMIUM("プレミアム"),
    MODERATOR("モデレーター"),
    SUPPORT("サポート担当");

    private final String description;
}
