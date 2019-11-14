/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_control;

import com.sun.security.ntlm.Client;
import CustomerView.LoginView1;
import CustomerView.Search;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author nguye_000
 */
  public class ClientRun {
      public static final String SERVER_IP = "0.0.0.0";
    public static final int SERVER_PORT = 8888;
    
    public static void main(String[] args) throws IOException{
        Socket socket = null;
        try{
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("da ket noi voi ser ver " + socket);
           ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
            LoginView1 login = new LoginView1(socket,is, os,dataInput,dataOut);
            login.setVisible(true);
            System.out.println(""+login);

        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
