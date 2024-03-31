package FormattingChat.ClientSide;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class ChatApplication extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      // Create a Socket object for connection
      Socket socket = new Socket("localhost", 2910);

      // Initialize the client connection with the socket
      ClientConnection clientConnection = new ClientConnection(socket);
      new Thread(clientConnection).start();

      FXMLLoader loader = new FXMLLoader(getClass().getResource("EncryptedChat.fxml"));
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
      primaryStage.setTitle("EncryptoChat");
      primaryStage.show();

      // Get the controller
      ChatViewController controller = loader.getController();

      // Set client connection in the controller
      controller.setClientConnection(clientConnection);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
