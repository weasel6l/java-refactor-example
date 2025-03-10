package com.example.refactoring.textparser;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.experimental.UtilityClass;

/**
 * コマンドライン引数を解析し、ファイルパスを取得するクラス
 * 引数が正しく解析されると、ファイルパスが返され、解析に失敗した場合はエラーメッセージが表示される
 */
@UtilityClass
class ArgumentParser {

    /**
     * ログ取得用のLoggerインスタンス
     */
    private static final Logger LOGGER = LogManager.getLogger(ArgumentParser.class);

    /**
     * コマンドライン引数からファイルパスを取得するための短いオプション
     */
    private static final String FILE_OPTION = "f";

    /**
     * コマンドライン引数からファイルパスを取得するための長いオプション
     */
    private static final String FILE_OPTION_LONG = "file";

    /**
     * 引数が不正な場合に表示するエラーメッセージ
     */
    private static final String INVALID_ARGUMENT_USAGE_MESSAGE = "Usage: java EmployeeDataProcessor -f <file-path>";

    /**
     * ファイルパスのオプションの説明
     */
    private static final String FILE_OPTION_DESCRIPTION = "Path to the file";

    /**
     * コマンドラインオプションの作成
     * 
     * @return コマンドラインオプションのオブジェクト
     */
    private static final Supplier<Options> createOptions = () -> new Options().addOption(Option.builder(FILE_OPTION)
            .longOpt(FILE_OPTION_LONG)
            .hasArg()
            .desc(FILE_OPTION_DESCRIPTION)
            .build());

    /**
     * コマンドライン引数を解析してファイルパスを取得するFunction
     * 引数が正しく解析されればファイルパスをOptionalで返し、解析に失敗した場合はOptional.empty()を返す
     *
     * @param args コマンドライン引数
     * @return 引数が正しく解析された場合はファイルパス、解析に失敗した場合は Optional.empty()
     */
    private static final Function<String[], Optional<CommandLine>> parseArguments = args -> {
        try {
            return Optional.of(new DefaultParser().parse(createOptions.get(), args));
        } catch (ParseException e) {
            LOGGER.error(e);
            return Optional.empty();
        }
    };

    /**
     * 引数不正時に呼び出されるエラーハンドラー
     * エラーメッセージを表示し、Optional.empty()を返す
     *
     * @return Optional.empty()
     */
    private static final Supplier<Optional<String>> displayUsageError = () -> {
        System.out.println(INVALID_ARGUMENT_USAGE_MESSAGE);
        return Optional.empty();
    };

    /**
     * コマンドライン引数を解析し、ファイルパスを取得
     * 引数不正時はエラーメッセージ表示後にOptional.empty()を返す
     *
     * @param args コマンドライン引数
     * @return ファイルパス、引数不正時はOptional.empty()
     */
    public static Optional<String> parse(final String[] args) {
        return parseArguments.apply(args)
                .flatMap(command -> Optional.ofNullable(command.getOptionValue(FILE_OPTION)))
                .or(displayUsageError);
    }
}
