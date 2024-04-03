package Chat.ClientSide.Strategy;

public class BoldChatStrategy implements ChatStrategy
{
  public String formatMessage(String message) {
    return "Bold: " + message;
  }
}