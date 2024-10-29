import java.io.*; 
import java.net.*; 
import java.util.*;


class trataCliente implements Runnable {
    private final Socket socketConexao;
  
        // Constructor
    public trataCliente(Socket socket)
    {
        this.socketConexao = socket;
    }
  
    public void run()
    {
      String fraseCliente; 
      String fraseEmMaiusculas; 
      
      try {
      
           BufferedReader doCliente = 
              new BufferedReader(new
              InputStreamReader(socketConexao.getInputStream())); 

           DataOutputStream  paraCliente = 
             new DataOutputStream(socketConexao.getOutputStream()); 

           fraseCliente= doCliente.readLine(); 

           System.out.println("Do Cliente " + socketConexao.getPort() 
                   + ": " + fraseCliente);

           fraseEmMaiusculas= fraseCliente.toUpperCase() + '\n'; 

           System.out.println("Para Cliente: " + fraseEmMaiusculas);

           paraCliente.writeBytes(fraseEmMaiusculas); 
           
      }
      catch (IOException e) {
                    e.printStackTrace();
                }
           
    } 
} 
