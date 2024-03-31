package FormattingChat.ClientSide;

import javafx.application.Application;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    Application.launch(ChatApplication.class, args);

    try
    {
      System.out.println("Enter your name: ");
      String name = scanner.nextLine();
      System.out.println("Welcome, " + name + ", feel free to chat.");
      Socket socket = new Socket("localhost", 2910);
      ClientConnection clientConnection = new ClientConnection(socket);
      new Thread(clientConnection).start();

      while (true)
      {
        String messageContent = scanner.nextLine();
        Message message = new Message(name, messageContent);
        clientConnection.send(message);
      }
    }

    catch (IOException e)
    {
      throw new RuntimeException(e);
    }

  }
}