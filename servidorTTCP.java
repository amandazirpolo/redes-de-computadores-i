import java.io.*; 
import java.net.*; 
import java.util.*;

class servidorTTCP { //com thread

  public static void main(String argv[]) throws Exception 
    { 
      String fraseCliente; 
      String fraseEmMaiusculas; 

      ServerSocket socketRecepcao = new ServerSocket(6789); 
  
      while(true) { 
  
            System.out.println("Aguardando novo cliente");
  
            Socket socketConexao = socketRecepcao.accept(); 
            
            
                // create a new thread object
                trataCliente clientSock
                    = new trataCliente(socketConexao);
  
                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
                
                System.out.println("Thread criada para cliente: "
                                   + socketConexao.getInetAddress()
                + " na porta: "
                + socketConexao.getPort());
  
      } 
    } 
} 
