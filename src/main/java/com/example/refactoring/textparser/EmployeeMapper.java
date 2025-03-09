package com.example.refactoring.textparser;

import lombok.experimental.UtilityClass;

/**
 * 文字列配列をEmployeeオブジェクトに変換するマッパークラス
 */
@UtilityClass
class EmployeeMapper {

    /**
     * 従業員データにおけるIDのインデックス
     */
    private static final int INDEX_ID = 0;

    /**
     * 従業員データにおける名字のインデックス
     */
    private static final int INDEX_LAST_NAME = 1;

    /**
     * 従業員データにおける名前のインデックス
     */
    private static final int INDEX_FIRST_NAME = 2;

    /**
     * 文字列配列をEmployeeオブジェクトに変換する
     * 
     * @param tokens 文字列配列（Id, FirstName, LastName）
     * @return Employeeオブジェクト
     */
    public static Employee convertToEmployee(final String[] tokens) {
        return Employee.builder()
                .id(tokens[INDEX_ID])
                .lastName(tokens[INDEX_LAST_NAME])
                .firstName(tokens[INDEX_FIRST_NAME])
                .build();
    }
}
