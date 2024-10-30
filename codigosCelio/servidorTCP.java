package codigosCelio;
import java.io.*; 
import java.net.*; 

class servidorTCP { //sem threads

  public static void main(String argv[]) throws Exception 
    { 
      String fraseCliente; 
      String fraseEmMaiusculas; 

      ServerSocket socketRecepcao = new ServerSocket(6789); 

      while(true) { 

          System.out.println("Servidor rodando na porta: "+ 
                  socketRecepcao.getLocalPort() + "  Aguardando novo cliente." );
            Socket socketConexao = socketRecepcao.accept(); 

            System.out.println("Servidor rodando na porta: "+ 
                  socketConexao.getLocalPort() + ".\n Cliente conectado: "
                                   + socketConexao.getInetAddress()
                + " na porta: "
                + socketConexao.getPort());

           BufferedReader doCliente = 
              new BufferedReader(new
              InputStreamReader(socketConexao.getInputStream())); 

           DataOutputStream  paraCliente = 
             new DataOutputStream(socketConexao.getOutputStream()); 

           fraseCliente= doCliente.readLine(); 

           System.out.println("Do Cliente: " + fraseCliente);

           fraseEmMaiusculas= fraseCliente.toUpperCase() + '\n'; 

           System.out.println("Para Cliente: " + fraseEmMaiusculas);

           paraCliente.writeBytes(fraseEmMaiusculas); 
        } 
    } 
} 