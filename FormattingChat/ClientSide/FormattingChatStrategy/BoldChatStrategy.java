package FormattingChat.ClientSide.FormattingChatStrategy;

public class BoldChatStrategy implements ChatStrategy
{
  public String formatMessage(String message) {
    return "<b>" + message + "</b>";
  }
}