package cn.kcrxorg.peoplechecker.beans;

import android.graphics.Bitmap;

/**
 * Created by chang on 2017/8/18.
 */
public class User {
    private int userId;
    private String userName;
    private String userSn;
    private int bankId;

    public byte[] getUserpic() {
        return userpic;
    }

    public void setUserpic(byte[] userpic) {
        this.userpic = userpic;
    }

    private byte[] userpic;

    public User(int userId, String userName, String userSn, int bankId) {
        this.userId = userId;
        this.userName = userName;
        this.userSn = userSn;
        this.bankId = bankId;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(String userSn) {
        this.userSn = userSn;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
}
