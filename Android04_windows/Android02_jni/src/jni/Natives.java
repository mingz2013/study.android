package jni;

public class Natives {
	// ԭ������ѭ��
	public static native int LibMain(String[] argv);
	
	// ����C �㴥����Ϣ
	private static void OnMessage(String text, int level){
		System.out.println("OnMessage text:" + text + " level=" + level);
		}
}
