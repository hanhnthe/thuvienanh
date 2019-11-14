/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author nguye_000
 */
public class Server {
    public final static int SERVER_PORT = 8888;
    public final static int NUMBER_OF_THREAD = 10;
    
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
       
            ExecutorService exacurtor = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
        ServerSocket server =  null;
        try{
            System.out.println("ket noi cong "+SERVER_PORT+"doi...");
            server = new ServerSocket(SERVER_PORT);
            System.out.println("server bat dau "+server);
            System.out.println("doi 1 client...");
            while(true){
                try{
                    Socket socket = server.accept();
                    //dong y luong tu socket
                    WorkerThread handler = new WorkerThread(socket);
                    exacurtor.execute(handler);
                
                    }catch(IOException e){
                        System.out.println("ket noi that bai");
                    }
                }
                     
             }catch(IOException e){
                    e.printStackTrace();
             }finally{
                    if(server!= null){
                       server.close();
            }
        }
    }
}
