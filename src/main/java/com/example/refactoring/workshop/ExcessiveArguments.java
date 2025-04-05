package com.example.refactoring.workshop;

public class ExcessiveArguments {
    /**
     * メインメソッド
     * 
     * @param args コマンドライン引数
     */
    public static void main(final String[] args) {
        User user = new User("Tanaka Taro", "tanaka.taro@example.com", "123 Main St", "012-3456-7890", "admin");
        registerUser(user);
    }

    /**
     * ユーザーを登録するメソッド
     * 
     * @param userName    ユーザー名
     * @param userEmail   ユーザーのメールアドレス
     * @param userAddress ユーザーの住所
     * @param userPhone   ユーザーの電話番号
     * @param userRole    ユーザーの役割（例: "admin", "user", "guest"）
     */
    private static void registerUser(User user) {
        // ユーザーを登録する処理
    }
}
