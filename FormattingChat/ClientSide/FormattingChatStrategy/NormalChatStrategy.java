package FormattingChat.ClientSide.FormattingChatStrategy;


public class NormalChatStrategy implements ChatStrategy {
  @Override
  public String formatMessage(String message) {
    // No special formatting for normal messages, just return the original message
    return message;
  }
}