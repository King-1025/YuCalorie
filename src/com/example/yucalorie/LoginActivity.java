package com.example.yucalorie;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import com.example.yucalorie.king.manager.*;
import android.content.*;
import com.example.yucalorie.king.model.*;
import android.preference.*;
import com.example.yucalorie.king.utils.*;

public class LoginActivity extends Activity implements OnClickListener
{
	private Context context;
	private Button login;
	private Button register;
	private Button reset;
	private Button ok;
	
	private EditText loginNick;
	private EditText loginPasswd;
	
	private EditText registerNick;
	private EditText registerPasswd0;
	private EditText registerPasswd1;
	private EditText registerQQ;
	private EditText registerEmail;
	
	private ViewGroup includeLogin;
	private ViewGroup includeRegister;
	
	
	private CheckBox autoLogin;
	
	private AccountManager userMg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO: Implement this method
		setFullScreen();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		context=this;
		initAllView();
		userMg=new AccountManager(this);
	}
	

	private void setFullScreen(){
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);  

	}
	
	private void initAllView(){
		login=(Button) findViewById(R.id.loginButtonLogin);
		register=(Button) findViewById(R.id.loginButtonRegister);
		reset=(Button) findViewById(R.id.registerButtonReset);
		ok=(Button) findViewById(R.id.registerButtonOK);
		
		login.setOnClickListener(this);
		register.setOnClickListener(this);
		reset.setOnClickListener(this);
		ok.setOnClickListener(this);
		
		loginNick=(EditText) findViewById(R.id.loginEditTextNick);
		loginPasswd=(EditText) findViewById(R.id.loginEditTextPasswd);
		

		if(getIntent().getBooleanExtra(MyApplication.FLAG_EXIT,false)){
			SharedPreferences sp=this.getApplicationContext().getSharedPreferences(MyApplication.SESSION_NAME,context.MODE_PRIVATE);
			String name=sp.getString(MyApplication.KEY_NAME,"");
			String passwd=sp.getString(MyApplication.KEY_ORDER,"");
			
			loginNick.setText(name);
			loginPasswd.setText(passwd);
			
			Checker.cleanSession(context);
		}
		
		registerNick=(EditText) findViewById(R.id.registerEditTextNick);
		registerQQ=(EditText) findViewById(R.id.registerEditTextQQ);
		registerEmail=(EditText) findViewById(R.id.registerEditTextEmail);
		registerPasswd0=(EditText) findViewById(R.id.registerEditTextPasswd0);
		registerPasswd1=(EditText) findViewById(R.id.registerEditTextPasswd1);
		
		includeLogin=(ViewGroup) findViewById(R.id.activitycontrolincludeLogin);
		includeRegister=(ViewGroup) findViewById(R.id.activitycontrolincludeRegister);
		
		autoLogin=(CheckBox) findViewById(R.id.loginSwitchAutoLogin);
		
		autoLogin.setChecked(true);
	}
	
	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		int id=p1.getId();
		switch(id){
			case R.id.loginButtonLogin:
				String nick=loginNick.getText().toString();
			    String passwd=loginPasswd.getText().toString();
				
				if(checkIsNull(nick,passwd)){
				
					if(userMg.login(nick,passwd)){
						if(autoLogin.isChecked()){
							Checker.saveSession(context,nick,passwd);
						}else{
							Checker.cleanSession(context);
						}
						startActivity(new Intent(context,MainActivity.class));
						finish();
						showT("秘密瘦身计划,开始喽！");
						
				    }else{
						showT("用户名或密码错误！");
					}
				}
				
				break;
			case R.id.loginButtonRegister:
				includeLogin.setVisibility(View.INVISIBLE);
				includeRegister.setVisibility(View.VISIBLE);
				break;
			case R.id.registerButtonReset:
				reset();
				break;
			case R.id.registerButtonOK:
				if(checkIsNull(registerNick.getText().toString(),registerPasswd0.getText().toString())){
					if(checkPasswd()){
						User user=new User();
						user.setNick(registerNick.getText().toString());
						user.setPasswd(registerPasswd0.getText().toString());
						user.setEmail(registerEmail.getText().toString());
						user.setQQ(registerQQ.getText().toString());
						if(userMg.register(user)){
							showT("注册成功，开启瘦身计划吧！");
							loginNick.setText(user.getNick());
							loginPasswd.setText("");
							includeLogin.setVisibility(View.VISIBLE);
							includeRegister.setVisibility(View.INVISIBLE);
						}else{
							showT("注册失败，你的输入不合法！");
							reset();
						}
					}
				}
			    break;
		}
	}
	
	private void showT(String tmsg){
		Toast.makeText(context,tmsg,Toast.LENGTH_LONG).show();
	}
	
	private boolean checkIsNull(String nick,String passwd){
		boolean is=true;
		if(nick==null||nick.length()<=0){
			showT("用户名为空！");
			return !is;
		}
		if(passwd==null||passwd.length()<=0){
			showT("密码为空！");
			return !is;
		}
		return is;
	}
	
	private boolean checkPasswd(){
		boolean is=true;
		int len=registerPasswd0.getText().toString().length();
		if(len<8||len>20){
			showT("密码长度应该在8~20个字符之间！");
			return !is;
		}
		if(!registerPasswd0.getText().toString().equals(registerPasswd1.getText().toString())){
			showT("两次密码不一致！");
			return !is;
		}
		return is;
	}
	
	private void reset(){
		registerNick.setText("");
		registerPasswd0.setText("");
		registerPasswd1.setText("");
		registerQQ.setText("");
		registerEmail.setText("");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO: Implement this method
		if(keyCode==event.KEYCODE_BACK){
			if(includeRegister.getVisibility()==View.VISIBLE&&
			   includeLogin.getVisibility()==View.INVISIBLE){
				loginNick.setText("");
				loginPasswd.setText("");
				includeLogin.setVisibility(View.VISIBLE);
				includeRegister.setVisibility(View.INVISIBLE);
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
}
