package cn.kcrxorg.peoplechecker.beans;

/**
 * Created by chang on 2017/8/18.
 */
public class Bank {

    private int bankId;
    private String bankName;
    private String bankSn;

    public Bank(int bankId, String bankName, String bankSn) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankSn = bankSn;
    }

    public Bank() {
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }



    public String getBankSn() {
        return bankSn;
    }

    public void setBankSn(String bankSn) {
        this.bankSn = bankSn;
    }




    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


}