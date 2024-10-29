import java.io.*; 
import java.net.*; 
import java.util.*;


class trataHttp implements Runnable {
    private final Socket connectionSocket;
  
        // Constructor
    public trataHttp(Socket socket)
    {
        this.connectionSocket = socket;
    }
  
    public void run()
    {
      String requestMessageLine;
      String fileName;
      
    try {
      BufferedReader inFromClient =
              new BufferedReader(new InputStreamReader(
                      connectionSocket.getInputStream()));
      
      DataOutputStream outToClient =
              new DataOutputStream(
                      connectionSocket.getOutputStream());

      requestMessageLine = inFromClient.readLine();

      System.out.println(requestMessageLine);
      
      StringTokenizer tokenizedLine =
              new StringTokenizer(requestMessageLine);
      if (tokenizedLine.nextToken().equals("GET")){
          fileName = tokenizedLine.nextToken();
          if (fileName.startsWith("/") == true )
              fileName = fileName.substring(1);

          File file = new File(fileName);
          int numOfBytes = (int) file.length();
          FileInputStream inFile = new FileInputStream (fileName);
          byte[] fileInBytes = new byte[numOfBytes];
          inFile.read(fileInBytes);
          
          outToClient.writeBytes("HTTP/1.0 200 Document Follows\r\n");

        if (fileName.endsWith(".jpg"))
            outToClient.writeBytes("Content-Type: image/jpeg\r\n");
        if (fileName.endsWith(".gif"))
            outToClient.writeBytes("Content-Type: image/gif\r\n");
        outToClient.writeBytes("Content-Length: " + numOfBytes + "\r\n");
        outToClient.writeBytes("\r\n");
        outToClient.write(fileInBytes, 0, numOfBytes);
        
        
        
      }
      else { 
          System.out.println("Bad Request Message");
          outToClient.writeBytes("HTTP/1.0 404 File not found\r\n");
          outToClient.writeBytes("\r\n");
      }
      connectionSocket.close();
    }
    catch (IOException e) {
    }
}
}
     
