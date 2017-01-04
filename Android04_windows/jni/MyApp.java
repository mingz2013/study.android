package myapp;

public class MyApp {
	// 加载c库
	System.loadLibrary("myapp");
	
	// 原生c函数定义
	native void GameMain(string[] args);
	
	static void main(string args[]) {
		MyApp app = new MyApp();
		app.GameMain(args);
	}
}