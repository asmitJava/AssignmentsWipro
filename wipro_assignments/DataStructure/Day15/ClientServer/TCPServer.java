package Day15.ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                CalculationRequest request = (CalculationRequest) inputStream.readObject();

                double result;
                switch (request.getOperation()) {
                    case "+":
                        result = request.getNum1() + request.getNum2();
                        break;
                    case "-":
                        result = request.getNum1() - request.getNum2();
                        break;
                    case "*":
                        result = request.getNum1() * request.getNum2();
                        break;
                    case "/":
                        result = request.getNum1() / request.getNum2();
                        break;
                    default:
                        result = 0;
                        break;
                }

                outputStream.writeDouble(result);
                outputStream.flush();

                inputStream.close();
                outputStream.close();
                clientSocket.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
