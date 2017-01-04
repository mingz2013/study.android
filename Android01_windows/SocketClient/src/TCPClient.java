import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TCPClient {
	public static void main(String[] args){
		try {
			// ����һ��Socket����ָ���������˵�IP��ַ�Ͷ˿ں�
			Socket socket = new Socket("192.168.1.104", 4567);
			// ʹ��InputStream����һ����ȡӲ���ϵ��ļ�
			InputStream inputStream = new FileInputStream("d://test.txt");
			// ��Socket�����еõ�OutputStream
			OutputStream outputStream = socket.getOutputStream();
			byte buffer [] = new byte[1024 * 4];
			int temp = 0;
			// ��InputStream���е�����ȡ������д��OutputStream����
			while((temp = inputStream.read(buffer)) != -1){
				outputStream.write(buffer, 0, temp);
			}
			outputStream.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
