package codigosCelio;
import java.io.*; 
import java.net.*; 

class clienteUDP { 
    public static void main(String args[]) throws Exception 
    { 

      BufferedReader doUsuario= 
        new BufferedReader(new InputStreamReader(System.in)); 

      DatagramSocket socketCliente = new DatagramSocket(); 

      System.out.println("Cliente UDP na porta="+ 
              + socketCliente.getLocalPort());

      InetAddress IPAddress = InetAddress.getByName("localhost"); 

      byte[] dadosEnvio = new byte[1024]; 
      byte[] dadosRecebidos = new byte[1024]; 

      String frase = doUsuario.readLine(); 
      dadosEnvio = frase.getBytes();         

	 DatagramPacket pacoteEnviado = 
         new DatagramPacket(dadosEnvio, dadosEnvio.length,
	 IPAddress, 9876); 

      socketCliente.send(pacoteEnviado); 

      DatagramPacket pacoteRecebido = 
         new DatagramPacket(dadosRecebidos, dadosRecebidos.length); 

      socketCliente.receive(pacoteRecebido); 

      String fraseModificada = 
          new String(pacoteRecebido.getData()); 

      System.out.println("Do Servidor:" + fraseModificada); 
      socketCliente.close(); 
      } 

} 