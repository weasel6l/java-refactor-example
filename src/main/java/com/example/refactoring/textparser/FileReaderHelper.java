package com.example.refactoring.textparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.experimental.UtilityClass;

/**
 * ファイル読み込みのユーティリティクラス
 * 指定されたファイルを読み込み、従業員データを処理するためのメソッドを提供する
 */
@UtilityClass
class FileReaderHelper {
    
    /**
     * 指定されたファイルパスからファイルを読み込み、従業員データをリストとして返す
     * ファイルの読み込み中にエラーが発生した場合、Optional.empty()を返す
     * 
     * @param filePath 読み込むファイルのパス
     * @return 従業員データのリスト、読み込みに失敗した場合はOptional.empty()
     */
    public static Optional<List<Employee>> readFile(final String filePath) {
        try (final BufferedReader employeeDataReader = new BufferedReader(new FileReader(filePath))) {
            return Optional.of(EmployeeDataParser.parseEmployees(employeeDataReader));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
