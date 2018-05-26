package com.example.yucalorie.king.manager;
import android.content.*;
import com.example.yucalorie.king.utils.*;
import android.database.sqlite.*;
import android.database.*;
import com.example.yucalorie.king.model.*;

public class AccountManager
{
	private Context context;
    public final static String TABLE_NAME="tb_user";
	public final static String DEFAULT_CREATE_TABLE_SQL=
	"create table if not exists "+TABLE_NAME+" (id integer primary key autoincrement,"+
	"nick text,"+
	"passwd text,"+
	"QQ text,"+
	"email text)";
	private SimpleSQLiteOpenHelper helper;

	public AccountManager(Context context)
	{
		this.context = context;
		helper=new SimpleSQLiteOpenHelper(context);
	}
	
	public boolean login(User user){
		if(user!=null)
		     return login(user.getNick(),user.getPasswd());
		else 
		     return false;
	}
	
	public boolean register(User user){
		if(user!=null)
			return register(user.getNick(),user.getPasswd(),user.getQQ(),user.getEmail());
		else
			return false;
	}
	
	public boolean login(String user,String passwd){
		boolean is=false;
		if(user!=null&&passwd!=null){
			SQLiteDatabase db = helper.getWritableDatabase();
			Cursor cursor=db.rawQuery("select id from "+TABLE_NAME+" where nick = ? and passwd = ?",new String[]{user,passwd});
			if(cursor.moveToNext()){
				is=true;
			}
			db.close();
		}
		return is;
	}
	
	public boolean register(String user,String passwd,String QQ,String email){
		boolean is=false;
		if(user!=null&&passwd!=null){
			SQLiteDatabase db = helper.getWritableDatabase();
			db.execSQL("insert into "+TABLE_NAME+"(nick,passwd,QQ,email) values ('"+user+"','"+passwd+"','"+QQ+"','"+email+"')");
			db.close();
            is=true;
		}
		return is;
	}
}
