package com.example.refactoring.permission;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 従業員の情報（Id, FirstName, LastName）を保持するビルダークラス
 */
@Getter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class User {

    /**
     * ユーザーのID
     */
    private final String id;

    /**
     * ユーザーの名前（FirstName）
     */
    private final String firstName;

    /**
     * ユーザーの名前（LastName）
     */
    private final String lastName;

    /**
     * ユーザーのステータス
     */
    private final UserStatus status;

    /**
     * ユーザーの役割
     */
    private final UserRole role;

    /**
     * ユーザーアカウントが本人確認済みかどうか
     */
    private final Boolean isAccountVerified;
}
