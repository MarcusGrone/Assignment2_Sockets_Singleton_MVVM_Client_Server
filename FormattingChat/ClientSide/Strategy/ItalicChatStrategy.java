package FormattingChat.ClientSide.Strategy;

public class ItalicChatStrategy implements ChatStrategy
{
  @Override public String formatMessage(String message)
  {
    return "<i>" + message + "</i>";
  }

}
