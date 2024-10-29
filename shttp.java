import java.io.*; 
import java.net.*; 
import java.util.*;

class shttp { 

  public static void main(String argv[]) throws Exception 
    { 
      ServerSocket socketRecepcao = new ServerSocket(80); 
  
      while(true) { 
  
            System.out.println("Aguardando novo cliente na porta" + 
                    socketRecepcao.getLocalPort());
  
            Socket socketConexao = socketRecepcao.accept(); 
            
            
                // create a new thread object
                trataHttp clientSock
                    = new trataHttp(socketConexao);
  
                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
                
                System.out.println("Servidor na porta: "+ socketConexao.getLocalPort()+
                        " conectado a cliente: "
                                   + socketConexao.getInetAddress()
                + " na porta: "
                + socketConexao.getPort());
  
      } 
    } 
} 
