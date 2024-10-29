import java.io.*; 
import java.net.*; 
  
class servidorUDP  { 
  public static void main(String args[]) throws Exception 
    { 
  
      DatagramSocket socketServidor = new DatagramSocket(9876); 
  
      byte[] dadosRecebidos = new byte[1024]; 
      byte[] dadosEnviados  = new byte[1024]; 
  
      System.out.println("Servidor UDP na porta= "  
              + socketServidor.getLocalPort() + 
              " aguarda cliente... ");
  
      String frase;
      String fraseEmMaiusculas;
          
      while(true) 
        { 
            DatagramPacket pacoteRecebido = 
             new DatagramPacket(dadosRecebidos, 
		dadosRecebidos.length); 
             socketServidor.receive(pacoteRecebido); 
          
          frase = new String(pacoteRecebido.getData()); 
  
          InetAddress IPAddress = pacoteRecebido.getAddress(); 
  
          int porta = pacoteRecebido.getPort(); 
  
          System.out.println("Cliente IP="+IPAddress+", porta="+
                  porta+" escreveu: "+frase);
  
          fraseEmMaiusculas = frase.toUpperCase(); 

          dadosEnviados = fraseEmMaiusculas.getBytes(); 
  
          DatagramPacket pacoteEnviado = 
             new DatagramPacket(dadosEnviados, 
                        dadosEnviados.length, IPAddress, porta); 
  
          socketServidor.send(pacoteEnviado); 
        } 
    } 
}  
