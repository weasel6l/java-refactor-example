package com.example.refactoring.textparser;

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
class Employee {
    
    /**
     * 従業員のID
     */
    private final String id;

    /**
     * 従業員の名前（FirstName）
     */
    private final String firstName;

    /**
     * 従業員の名前（LastName）
     */
    private final String lastName;
}
