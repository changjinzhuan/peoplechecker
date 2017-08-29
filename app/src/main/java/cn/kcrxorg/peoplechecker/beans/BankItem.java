package cn.kcrxorg.peoplechecker.beans;

/**
 * Created by chang on 2017/8/29.
 */

public class BankItem {
    String bankname;
    String username1;
    String username2;
    byte[] userpic1=new byte[0];
    byte[] userpic2=new byte[0];

    public BankItem() {
    }

    public BankItem(String bankname, String username1, String username2, byte[] userpic1, byte[] userpic2) {
        this.bankname = bankname;
        this.username1 = username1;
        this.username2 = username2;
        this.userpic1 = userpic1;
        this.userpic2 = userpic2;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public byte[] getUserpic1() {
        return userpic1;
    }

    public void setUserpic1(byte[] userpic1) {
        this.userpic1 = userpic1;
    }

    public byte[] getUserpic2() {
        return userpic2;
    }

    public void setUserpic2(byte[] userpic2) {
        this.userpic2 = userpic2;
    }
}
