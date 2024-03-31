package FormattingChat.ClientSide.Utill;

import FormattingChat.ClientSide.ChatViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewControllerFactory
{
  private ViewModelFactory viewModelFactory;
  private ChatViewController chatViewController;

  private final Stage chatStage;

  private FXMLLoader fxmlLoader;

  public ViewControllerFactory(ViewModelFactory viewModelFactory,
      Stage chatStage)
  {
    this.viewModelFactory = viewModelFactory;
    this.chatStage = chatStage;
  }

  public ChatViewController getChatView() throws IOException  {
    if (chatViewController == null)  {
      fxmlLoader = new FXMLLoader(getClass().getResource("../FormattingChat/ClientSide/Chat.fxml"));
      fxmlLoader.setControllerFactory(controllerClass -> new ChatViewController(viewModelFactory.getChatViewModel(), this));

      Scene mainViewScene = new Scene(fxmlLoader.load());
      Stage chatStage = new Stage();
      chatStage.setTitle("GoHappyChat");
      chatStage.setScene(mainViewScene);
      chatStage.show();
      chatViewController = fxmlLoader.getController();
    }
    return chatViewController;
  }
}


