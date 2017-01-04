import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {
	public static void main(String[] args){
		try {
			// 创建一个DatagramSocket对象
			DatagramSocket socket = new DatagramSocket(4567);
			// 创建一个InetAddress对象
			InetAddress serverAddress = InetAddress.getByName("192.168.1.104");
			String str = "hello";
			byte data[] = str.getBytes();
			// 一个有数据的DatagramPacket对象
			DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 4567);
			// 发送
			socket.send(packet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
