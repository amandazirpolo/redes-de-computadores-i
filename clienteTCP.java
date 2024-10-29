import java.io.*; 
import java.net.*; 

class clienteTCP { 

    public static void main(String argv[]) throws Exception 
    { 
        String frase; 
        String fraseModificada; 


        BufferedReader doUsuario = 
          new BufferedReader(new InputStreamReader(System.in)); 

        Socket socketCliente = new Socket("192.168.6.235", 6789); 
        
        System.out.println("Cliente TCP na porta="+ 
              + socketCliente.getLocalPort());

        DataOutputStream paraServidor = 
          new DataOutputStream(socketCliente.getOutputStream()); 
          
        BufferedReader doServidor = 
          new BufferedReader(new
          InputStreamReader(socketCliente.getInputStream())); 

//      int i=10;
 //     while (i>0) {

        frase = doUsuario.readLine(); 

        paraServidor.writeBytes(frase + '\n'); 

        fraseModificada = doServidor.readLine(); 

        System.out.println("Do Servidor: " + fraseModificada); 
  //      i--;
   //   }

        socketCliente.close(); 
                   
    } 
} 
