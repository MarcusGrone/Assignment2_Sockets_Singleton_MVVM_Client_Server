package FormattingChat.ClientSide;

import FormattingChat.ClientSide.Utill.ViewControllerFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChatViewController
{

  private ChatViewModel chatViewModel;
  private ViewControllerFactory viewControllerFactory;
  @FXML public TextField nameField;
  @FXML public TextField messageInputTextField;
  @FXML public TextArea textArea;

  public ChatViewController(ChatViewModel chatViewModel,
      ViewControllerFactory viewControllerFactory)
  {
    this.chatViewModel = chatViewModel;
    this.viewControllerFactory = viewControllerFactory;
  }

  public void initialize()
  {
    chatViewModel.messageProperty()
        .addListener((obs, oldMessage, newMessage) -> {
          onMessageRecieved(newMessage);
        });
  }

  public void onMessageRecieved(String message)
  {
    Platform.runLater(() -> {
      textArea.appendText(message + "\n");
    });
  }

  public void onNameFieldButtonPressed() throws IOException
  {
    String clientName = nameField.getText();
    chatViewModel.connect("localhost", 2910, clientName);
    nameField.clear();
  }

  public void onMessageSendButtonPressed()
  {
    String message = messageInputTextField.getText();
    chatViewModel.sendMessage(chatViewModel.getCurrentClient(), message);
    messageInputTextField.clear();
  }

  public void onNormalChatButtonPressed()
  {
    chatViewModel.messageToBold();
  }

  public void onBoldChatButtonPressed()
  {
    chatViewModel.messageToNormal();
  }

  public void onItalicButtonPressed()
  {
    chatViewModel.messageToItalic();
  }

}