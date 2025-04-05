package com.example.refactoring.workshop;

public class RedundantLogicLegacy {
    /**
     * メインメソッド
     * 
     * @param args コマンドライン引数
     */
    public static void main(final String[] args) {
        System.out.println(isAdmin("admin"));
    }

    /**
     * 引数の値を基にユーザーがadminかどうかを判定するメソッド
     * 
     * @param userRole ユーザーの役割（例: "admin", "user", "guest"）
     * @return true: ユーザーが管理者の場合、false: それ以外の場合
     */
    private static boolean isAdmin(String userRole) {
        boolean adminFlag;
        if (userRole == "admin") {
            adminFlag = true;
        } else {
            adminFlag = false;
        }
        return adminFlag;
    }
}
