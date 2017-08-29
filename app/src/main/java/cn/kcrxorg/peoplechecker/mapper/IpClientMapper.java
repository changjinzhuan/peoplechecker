package cn.kcrxorg.peoplechecker.mapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class IpClientMapper {

	  DBHelper helper;
	    SQLiteDatabase db;
	    public IpClientMapper(Context context) {
	        helper=new DBHelper(context, "PeopleChecker.db", null, 1);
	        db=helper.getWritableDatabase();
	    }
	    
	  public String getip(){
		  String ipString="127.0.0.1";
		  Cursor queryCursor = db.query("T_CLIENTIP",new String[]{"*"},null,null,null,null,null);
		  while(queryCursor.moveToNext()){
		  ipString=queryCursor.getString(queryCursor.getColumnIndex("IP"));
		  }
		  
		return ipString;
	  }
	  public int setip(String ipString)
	  {
		   ContentValues values = new ContentValues();
		   values.put("IP", ipString);
		  int updaters = db.update("T_CLIENTIP", values, null, null);
		  return updaters;
	  }
	  
}
