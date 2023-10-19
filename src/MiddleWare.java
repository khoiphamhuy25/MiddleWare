import java.io.*;
import java.net.*;

public class MiddleWare {
    public static void main(String[] args) {
        //Đọc dữ liệu từ config.properties
        ConfigReader crd = new ConfigReader();
        String svrAdd = crd.getServerAddress();
        String cltAdd = crd.getClientAddress();
        int svrPrt = crd.getServerPort();
        int cltPrt = crd.getClientPort();

        try {
            // Khởi tạo kết nối tới server
            Socket serverSocket = new Socket(svrAdd, svrPrt);

            // Tạo luồng vào và ra để gửi và nhận dữ liệu từ server
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter serverOut = new PrintWriter(serverSocket.getOutputStream(), true);

            // Khởi tạo kết nối tới client
            ServerSocket clientSocket = new ServerSocket(cltPrt);
            Socket client = clientSocket.accept();
            System.out.println("Client đã kết nối!");

            // Tạo luồng vào và ra để gửi và nhận dữ liệu từ client
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);

            // Tạo một luồng để đọc từ client và gửi tới server
            Thread clientToServer = new Thread(() -> {
                try {
                    String clientMessage;
                    while ((clientMessage = clientIn.readLine()) != null) {
                        System.out.println("Client nói: " + clientMessage);
                        serverOut.println(clientMessage); // Gửi tin nhắn tới server
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            clientToServer.start();

            // Tạo một luồng để đọc từ server và gửi tới client
            Thread serverToClient = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverIn.readLine()) != null) {
                        System.out.println("Server nói: " + serverMessage);
                        clientOut.println(serverMessage); // Gửi tin nhắn tới client
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverToClient.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
