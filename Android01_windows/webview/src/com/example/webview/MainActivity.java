package com.example.webview;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView webView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webView = (WebView)findViewById(R.id.webView);
		// ����WebView����,�ܹ�ִ��javascript�ű�
		webView.getSettings().setJavaScriptEnabled(true);
		// ����Url����
		webView.loadUrl("http://google.com");
		
		/*/ ����Ҳ����ʹ��webview���ؾ�̬��ҳ
		String html = "";
		html += "<html>";
		html += "<body>";
		html += "<a href=http://www.google.com>Google Home</a>";
		html += "</body>";
		html += "</html>";
		webView.loadData(html, "text/html", "utf-8");
		*/
		
		// ����Web��ͼ�ͻ���,Ϊ����WebView�ܹ���Ӧ�����ӹ���
		webView.setWebViewClient(new HelloWebViewClient());
		
	}
	// Web�ͻ���
	private class HelloWebViewClient extends WebViewClient{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}
		
	}
	@Override// ���û���
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	} 



}
