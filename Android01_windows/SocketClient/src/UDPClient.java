import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {
	public static void main(String[] args){
		try {
			// ����һ��DatagramSocket����
			DatagramSocket socket = new DatagramSocket(4567);
			// ����һ��InetAddress����
			InetAddress serverAddress = InetAddress.getByName("192.168.1.104");
			String str = "hello";
			byte data[] = str.getBytes();
			// һ�������ݵ�DatagramPacket����
			DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 4567);
			// ����
			socket.send(packet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
