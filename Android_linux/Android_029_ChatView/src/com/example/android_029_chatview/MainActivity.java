package com.example.android_029_chatview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
public class MainActivity extends Activity {
 protected static final String TAG = "MainActivity";
 private ChattingAdapter chatHistoryAdapter;
 private List<ChatMessage> messages = new ArrayList<ChatMessage>();
 private ListView chatHistoryLv;
 private Button sendBtn;
 private EditText textEditor;
 //private ImageView sendImageIv;
 //private ImageView captureImageIv;
 //private View recording;
 //private PopupWindow menuWindow = null;
 @Override
 public void onCreate(Bundle savedInstanceState) {
  requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
  super.onCreate(savedInstanceState);
  setContentView(R.layout.chatting);
  getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.chatting_title_bar);
  chatHistoryLv = (ListView) findViewById(R.id.chatting_history_lv);
  setAdapterForThis();
  sendBtn = (Button) findViewById(R.id.send_button);
  textEditor = (EditText) findViewById(R.id.text_editor);
  
  sendBtn.setOnClickListener(l);
  
  
  
 }
 // 设置adapter
 private void setAdapterForThis() {
  initMessages();
  chatHistoryAdapter = new ChattingAdapter(this, messages);
  chatHistoryLv.setAdapter(chatHistoryAdapter);
 }
 // 为listView添加数据
 private void initMessages() {
  messages.add(new ChatMessage(ChatMessage.MESSAGE_FROM, "hello"));
  messages.add(new ChatMessage(ChatMessage.MESSAGE_TO, "hello"));
  messages.add(new ChatMessage(ChatMessage.MESSAGE_FROM, "你好吗？"));
  messages.add(new ChatMessage(ChatMessage.MESSAGE_TO, "非常好!"));
  messages.add(new ChatMessage(ChatMessage.MESSAGE_FROM, "欢迎光临我的博客，http://hi.csdn.net/lyfi01"));
  messages.add(new ChatMessage(ChatMessage.MESSAGE_TO, "恩，好的，谢谢"));
 }
 
 private View.OnClickListener l = new View.OnClickListener() {
  public void onClick(View v) {
   if (v.getId() == sendBtn.getId()) {
    String str = textEditor.getText().toString();
    String sendStr;
    if (str != null
      && (sendStr = str.trim().replaceAll("r", "").replaceAll("t", "").replaceAll("n", "")
        .replaceAll("f", "")) != "") {
     sendMessage(sendStr);
    }
    textEditor.setText("");
   }
  }
  // 模拟发送消息
  private void sendMessage(String sendStr) {
   messages.add(new ChatMessage(ChatMessage.MESSAGE_TO, sendStr));
   chatHistoryAdapter.notifyDataSetChanged();
  }
 };
}
