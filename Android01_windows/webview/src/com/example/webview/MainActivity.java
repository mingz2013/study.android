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
		// 设置WebView属性,能够执行javascript脚本
		webView.getSettings().setJavaScriptEnabled(true);
		// 加载Url内容
		webView.loadUrl("http://google.com");
		
		/*/ 这里也可以使用webview加载静态网页
		String html = "";
		html += "<html>";
		html += "<body>";
		html += "<a href=http://www.google.com>Google Home</a>";
		html += "</body>";
		html += "</html>";
		webView.loadData(html, "text/html", "utf-8");
		*/
		
		// 设置Web视图客户端,为了让WebView能够响应超链接功能
		webView.setWebViewClient(new HelloWebViewClient());
		
	}
	// Web客户端
	private class HelloWebViewClient extends WebViewClient{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}
		
	}
	@Override// 设置回退
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	} 



}
