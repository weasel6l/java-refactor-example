package com.example.refactoring.textparser;

import java.util.List;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 従業員データを処理するアプリケーションのエントリーポイント
 * コマンドライン引数を解析し、指定されたファイルを処理する
 */
public class EmployeeDataProcessor {

    /**
     * ログ取得用のLoggerインスタンス
     */
    private static final Logger LOGGER = LogManager.getLogger(EmployeeDataProcessor.class);

    /**
     * 処理開始時のメッセージ
     */
    private static final String STARTING_APPLICATION_MESSAGE = "Starting the application...";

    /**
     * 処理終了時のメッセージ
     */
    private static final String APPLICATION_FINISHED_MESSAGE = "Application finished.";

    /**
     * ファイルから従業員データを読み込めなかった場合のメッセージ
     */
    private static final String FAILED_MESSAGE = "Failed to read employee data from file";

    /**
     * 従業員リストの情報を一つずつログ出力するためのConsumer
     */
    private static final Consumer<List<Employee>> logEmployees = list -> list.stream().forEach(LOGGER::info);

    /**
     * 従業員データの読み込みに失敗した場合にエラーログを出力するためのConsumer
     */
    private static final Consumer<String> logError = (filePath) -> LOGGER.error("{}: {}", FAILED_MESSAGE, filePath);

    /**
     * アプリケーションのエントリーポイント
     * コマンドライン引数を解析し、指定されたファイルを処理する
     *
     * @param args コマンドライン引数
     */
    public static void main(final String[] args) {
        LOGGER.info(STARTING_APPLICATION_MESSAGE);
        ArgumentParser.parse(args).ifPresent(EmployeeDataProcessor::processEmployeeData);
        LOGGER.info(APPLICATION_FINISHED_MESSAGE);
    }

    /**
     * 従業員データを処理するメソッド
     * ファイルから従業員データを読み込み、情報をログに出力する
     *
     * @param filePath 処理するファイルのパス
     */
    private static void processEmployeeData(final String filePath) {
        FileReaderHelper.readFile(filePath).ifPresentOrElse(logEmployees, () -> logError.accept(filePath));
    }
}
