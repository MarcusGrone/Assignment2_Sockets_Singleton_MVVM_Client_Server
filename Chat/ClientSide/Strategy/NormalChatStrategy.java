package Chat.ClientSide.Strategy;

public class NormalChatStrategy implements ChatStrategy
{
  @Override public String formatMessage(String message)
  {
    return "Normal: " + message;
  }
}