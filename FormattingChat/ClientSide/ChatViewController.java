package FormattingChat.ClientSide;

import FormattingChat.ClientSide.Utill.ViewControllerFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

  @FXML public void onNormalChatButtonPressed()
  {
    chatViewModel.messageToBold();
  }

  @FXML public void onBoldChatButtonPressed()
  {
    chatViewModel.messageToNormal();
  }

  @FXML public void onItalicButtonPressed()
  {
    chatViewModel.messageToItalic();
  }

  @FXML public void onMessageSendButtonPressed()
  {

  }

}