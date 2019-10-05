package servicios;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ObtenerMAC {
    
    private String macString;
    
    public String Agarrar() throws SocketException{
        InetAddress ip;
	try {

		ip = InetAddress.getLocalHost();

		NetworkInterface network = NetworkInterface.getByInetAddress(ip);

		byte[] mac = network.getHardwareAddress();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
                
                macString = sb.toString();

	} catch (UnknownHostException e) {

		e.printStackTrace();
	}
        return macString;
    }
}
