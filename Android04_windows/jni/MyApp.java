package myapp;

public class MyApp {
	// ����c��
	System.loadLibrary("myapp");
	
	// ԭ��c��������
	native void GameMain(string[] args);
	
	static void main(string args[]) {
		MyApp app = new MyApp();
		app.GameMain(args);
	}
}