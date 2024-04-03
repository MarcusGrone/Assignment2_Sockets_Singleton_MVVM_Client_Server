package FormattingChat.ClientSide.Strategy;

public class BoldChatStrategy implements ChatStrategy
{
  public String formatMessage(String message) {
    return "<b>" + message + "</b>";
  }
}