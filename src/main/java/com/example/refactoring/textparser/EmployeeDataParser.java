package com.example.refactoring.textparser;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 従業員データを解析して Employee オブジェクトに変換するユーティリティクラス
 * データはバリデーションチェック後、大文字に変換されてから Employee オブジェクトとしてマッピングされる
 */
class EmployeeDataParser {

    /**
     * 空白文字を表す正規表現
     */
    private static final String WHITESPACE_REGEX = "\\s+";

    /**
     * 従業員データに必要な要素数（Id, FirstName, LastName）
     */
    private static final int EMPLOYEE_DATA_LENGTH = 3;

    /**
     * 従業員データの文字列配列を解析し、Employee オブジェクトのリストを返す
     * データは大文字に変換され、バリデーションチェックが行われる
     * 
     * @param employeeDataReader 従業員データを読み込む BufferedReader
     * @return 解析後の Employee オブジェクトのリスト
     */
    public static List<Employee> parseEmployees(final BufferedReader employeeDataReader) {
        return employeeDataReader.lines()
                .map(String::toUpperCase)
                .map(line -> line.trim().split(WHITESPACE_REGEX))
                .filter(tokens -> tokens.length == EMPLOYEE_DATA_LENGTH)
                .map(tokens -> EmployeeMapper.convertToEmployee(tokens))
                .collect(Collectors.toList());
    }
}
