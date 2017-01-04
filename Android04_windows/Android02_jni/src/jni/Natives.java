package jni;

public class Natives {
	// 原生库主循环
	public static native int LibMain(String[] argv);
	
	// 这会从C 层触发消息
	private static void OnMessage(String text, int level){
		System.out.println("OnMessage text:" + text + " level=" + level);
		}
}
