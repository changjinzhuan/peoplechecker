package cn.kcrxorg.peoplechecker.mapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import cn.kcrxorg.peoplechecker.beans.Bank;





/**
 * Created by chang on 2017/8/18.
 */
public class BankMapper{
    DBHelper helper;
    SQLiteDatabase db;
    public BankMapper(Context context) {
        helper=new DBHelper(context, "PeopleChecker.db", null, 1);
        db=helper.getWritableDatabase();
        
    }
    
    public List<Bank> getBanks()
   {
       List<Bank> bankList=new ArrayList<Bank>();
       Cursor queryCursor = db.query("T_BANK",new String[]{"*"},null,null,null,null,null);
       while(queryCursor.moveToNext()){
           Bank bank=new Bank();
           bank.setBankId(queryCursor.getInt(queryCursor.getColumnIndex("BANKID")));
           bank.setBankName(queryCursor.getString(queryCursor.getColumnIndex("BANKNAME")));
           bank.setBankSn(queryCursor.getString(queryCursor.getColumnIndex("BANKSN")));
           bankList.add(bank);
       }
       return bankList;
    }
    public String getbanksn(int bankid)
    {
        String banksn="";
        String[] args = {bankid+""};

        Cursor queryCursor = db.query("T_BANK", new String[]{"banksn"}, "BANKID=?", args, null, null, null);
        while(queryCursor.moveToNext())
        {
            banksn=queryCursor.getString(queryCursor.getColumnIndex("BANKSN"));
        }
        return banksn;
    }

    
    public Bank getbankbysn(String banksn)
    {
    	Bank bank=new Bank();
    	String[] args = {banksn+""};

    	Cursor queryCursor = db.query("T_BANK",new String[]{"*"},"BANKSN=?",args,null,null,null);
    	  while(queryCursor.moveToNext())
    	  {
    		  bank.setBankId(queryCursor.getInt(queryCursor.getColumnIndex("BANKID")));
    		  bank.setBankName(queryCursor.getString(queryCursor.getColumnIndex("BANKNAME")));
    		  bank.setBankSn(queryCursor.getString(queryCursor.getColumnIndex("BANKSN")));
    	  }	
    	return bank;
    }
    public int updataBank(Bank bank,int bankid)
    {
        String bankname=bank.getBankName();
        String banksn=bank.getBankSn();
        ContentValues values = new ContentValues();
        //   values.put("BANKID", bankid);
        values.put("BANKNAME", bankname);
        values.put("BANKSN", banksn);
        String[] args = {bankid+""};

        int updaters = db.update("T_BANK", values, "BANKID=?", args);
        return updaters;
    }
    public long insertBank(Bank bank)
    {
        int bankid=bank.getBankId();
        String bankname=bank.getBankName();
        String banksn=bank.getBankSn();
        ContentValues values = new ContentValues();
     //   values.put("BANKID", bankid);
        values.put("BANKNAME", bankname);
        values.put("BANKSN", banksn);
        long insertrs=0;
        insertrs = db.insert("T_BANK", null, values);
        return insertrs;
    }

    public int deleteBank(Bank bank)
    {
        String[] args = {bank.getBankSn()};
        int deleters = db.delete("T_BANK", "BANKSN=?",args);
        return deleters;
    }
}
