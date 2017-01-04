package com.example.android_02_client;



import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.mingzz.chat.MessageFactory;
import com.mingzz.chat.client.ChatClient;
import com.mingzz.chat.client.User;
import com.mingzz.chat.message.UserMessage;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText usernameEditText;
	private EditText passwordEditText;
	private Button loginButton;
	private Button registerButton;
	
	//private AppGlobal appGlobal;// 全局变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        //appGlobal = (AppGlobal)getApplicationContext();// 获取全局变量对象
        if(AppGlobal.getUser() == null){
        	AppGlobal.setUser(new User());
        }
        if(AppGlobal.getUser().getChatClient() != null){
        	AppGlobal.getUser().getChatClient().stop();
        }
        Socket socket = null;
        try {
			
			socket = new Socket("192.168.60.19", 6666);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(LoginActivity.this, "创建socket失败，请检查网络联接...", Toast.LENGTH_LONG).show();
		}  
        AppGlobal.getUser().setChatClient(new ChatClient(socket) {
			
			@Override
			protected void doUserMessage(UserMessage userMessage) {
				// TODO Auto-generated method stub
				int MessageType = userMessage.MessageType;
				switch (MessageType) {
				case MessageFactory.USERMSGTYPE_OF_LOGIN:
					Intent intent = new Intent(LoginActivity.this, FriendListActivity.class);
					startActivity(intent);
					break;
				default:
					break;
				}
				
			}
		});
        
        usernameEditText = (EditText)findViewById(R.id.editText_username);
        passwordEditText = (EditText)findViewById(R.id.editText_password);
        loginButton = (Button)findViewById(R.id.button_Login);
        registerButton = (Button)findViewById(R.id.button_Register);
        
        
        
        loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username = usernameEditText.getText().toString();
				String password = passwordEditText.getText().toString();
				AppGlobal.getUser().setUserName(username);
				AppGlobal.getUser().setPassword(password);
				/*if(!AppGlobal.getUser().getChatClient().isConnect()){
					Toast.makeText(LoginActivity.this, "创建socket失败，请检查网络联接...", Toast.LENGTH_LONG).show();
					return;
				}*/
				Toast.makeText(LoginActivity.this, AppGlobal.getUser().getUserName(), Toast.LENGTH_LONG).show();
				System.out.println("fsdfds");
				AppGlobal.getUser().Login();
			}
		});
        registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//chatClient.send("Reverse", passwordEditText.getText().toString());
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});   
        
    }// oncreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent intent = new Intent(LoginActivity.this, SettingsActivity.class);
			startActivity(intent);
			break;
		case R.id.action_about:
			break;
		case R.id.action_opinions:
			break;
		case R.id.action_quit:
			
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}//onOptionsItemSelected
    
}//LoginActivity
