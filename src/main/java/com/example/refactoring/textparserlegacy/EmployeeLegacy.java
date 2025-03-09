package com.example.refactoring.textparserlegacy;

/**
 * 従業員の情報（Id, FirstName, LastName）を保持するクラス
 */
class EmployeeLegacy {

    /**
     * 従業員のID
     */
    private String id;

    /**
     * 従業員の名前
     */
    private String firstName;

    /**
     * 従業員の苗字
     */
    private String lastName;

    /**
     * コンストラクタ
     * 
     * @param id        従業員のID
     * @param firstName 従業員の名前
     * @param lastName  従業員の苗字
     */
    public EmployeeLegacy(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * 従業員のIDを取得するメソッド
     * 
     * @return 従業員のID
     */
    public String getId() {
        return id;
    }

    /**
     * 従業員の名前を取得するメソッド
     * 
     * @return 従業員の名前
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 従業員の苗字を取得するメソッド
     * 
     * @return 従業員の苗字
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * toStringメソッドをオーバーライドして従業員の情報を文字列で返す
     * 
     * @return 従業員の情報を文字列で返す
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
