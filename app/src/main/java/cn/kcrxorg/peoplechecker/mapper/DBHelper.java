package cn.kcrxorg.peoplechecker.mapper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chang on 2017/8/18.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String creaTBankTable="CREATE TABLE [T_Bank] (\n" +
                "  [BANKID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
                "  [BANKNAME] VARCHAR(50) NOT NULL, \n" +
                "  [BANKSN] VARCHAR(20) NOT NULL UNIQUE);\n" ;
        
        String creaTUserTable="CREATE TABLE [T_User] (\n" +
                "  [USERID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
                "  [USERNAME] VARCHAR(20) NOT NULL, \n" +
                "  [USERSN] VARCHAR(20) NOT NULL UNIQUE, \n" +
                "  [BANKID] INTEGER NOT NULL CONSTRAINT [bankidFK] REFERENCES [T_Bank]([BANKID]) ON DELETE CASCADE ON UPDATE CASCADE MATCH SIMPLE, \n" +
                "  [USERPIC] BLOB);\n";
        String creatClienIpTalbeString="CREATE TABLE [T_CLIENTIP]([IP] VARCHAR(20) NOT NULL UNIQUE)";

        db.execSQL(creaTBankTable);
        db.execSQL(creaTUserTable);
        db.execSQL(creatClienIpTalbeString);
        db.execSQL("insert into T_BANK values (null,'工商银行','00000001')");
        db.execSQL("insert into T_BANK values (null,'农业银行','00000002')");
        db.execSQL("insert into T_BANK values (null,'中国银行','00000003')");
        db.execSQL("insert into T_BANK values (null,'建设银行','00000004')");
        db.execSQL("insert into T_BANK values (null,'交通银行','00000005')");
        db.execSQL("insert into T_BANK values (null,'邮政储蓄银行','00000006')");
       
        db.execSQL("insert into T_CLIENTIP values ('127.0.0.1')");
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
