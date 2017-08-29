package cn.kcrxorg.peoplechecker.mapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.kcrxorg.peoplechecker.beans.User;


/**
 * Created by chang on 2017/8/18.
 */
public class Usermapper {
    DBHelper helper;
    SQLiteDatabase db;
    Context mcontext;

    public Usermapper(Context context) {
        this.helper = new DBHelper(context, "PeopleChecker.db", null, 1);
        this.db = helper.getWritableDatabase();
        mcontext=context;
    }
    public User getUserbyUsrSnandBankid(String usersn,int bankid)
    {
    	User user=new User();
    	String[] selectionArgs=new String[]{bankid+"",usersn};
    	Cursor queryCursor= db.query("T_USER",new String[]{"*"},
    			"BANKID=? and USERSN=?",selectionArgs,null,null,null);
    	
    	  while(queryCursor.moveToNext()){
              user.setUserId(queryCursor.getInt(queryCursor.getColumnIndex("USERID")));
              user.setUserName(queryCursor.getString(queryCursor.getColumnIndex("USERNAME")));
              user.setUserSn(queryCursor.getString(queryCursor.getColumnIndex("USERSN")));
              user.setBankId(queryCursor.getInt(queryCursor.getColumnIndex("BANKID")));
              user.setUserpic(queryCursor.getBlob(queryCursor.getColumnIndex("USERPIC")));
          }
    	return user;
    	
    }
    public List<User> getUsersFromBankId(int Bankid)
    {
        List<User> userList=new ArrayList<User>();
        String[] selectionArgs=new String[]{Bankid+""};
        Cursor queryCursor= db.query("T_USER",new String[]{"*"},"BANKID=?",selectionArgs,null,null,null);
        while(queryCursor.moveToNext()){
            User user=new User();
            user.setUserId(queryCursor.getInt(queryCursor.getColumnIndex("USERID")));
            user.setUserName(queryCursor.getString(queryCursor.getColumnIndex("USERNAME")));
            user.setUserSn(queryCursor.getString(queryCursor.getColumnIndex("USERSN")));
            user.setBankId(queryCursor.getInt(queryCursor.getColumnIndex("BANKID")));
            user.setUserpic(queryCursor.getBlob(queryCursor.getColumnIndex("USERPIC")));
            userList.add(user);
        }
        return userList;
    }
    public List<User> getUsers()
    {
        List<User> userList=new ArrayList<User>();
        Cursor queryCursor = db.query("T_USER",new String[]{"*"},null,null,null,null,null);
        while(queryCursor.moveToNext()){
            User user=new User();
            user.setUserId(queryCursor.getInt(queryCursor.getColumnIndex("USERID")));
            user.setUserName(queryCursor.getString(queryCursor.getColumnIndex("USERNAME")));
            user.setUserSn(queryCursor.getString(queryCursor.getColumnIndex("USERSN")));
            user.setBankId(queryCursor.getInt(queryCursor.getColumnIndex("BANKID")));
            user.setUserpic(queryCursor.getBlob(queryCursor.getColumnIndex("USERPIC")));
            userList.add(user);
        }
        return userList;
    }
    public long insertUser(User user)
    {
        int userid=user.getUserId();
        String username=user.getUserName();
        String usersn=user.getUserSn();
        int userbankid=user.getBankId();
        byte[] userpic=user.getUserpic();

        ContentValues values = new ContentValues();
        //   values.put("BANKID", bankid);
        values.put("USERNAME", username);
        values.put("USERSN", usersn);
        values.put("BANKID",userbankid);
        values.put("USERPIC",userpic);
        long insertrs=0;
        insertrs = db.insert("T_USER", null, values);

        return insertrs;
    }

    public int deleteUser(User user)
    {
        String[] args = {user.getUserSn()};
        int deleters = db.delete("T_USER", "USERSN=?",args);
        return deleters;
    }

}
