package FormattingChat.ClientSide;

import FormattingChat.ClientSide.Strategy.ChatStrategy;

import java.io.Serializable;

public class Message implements Serializable
{
  private String name;
  private String message;

  private ChatStrategy chatStrategy;


  public Message(String name, String message)
  {
    this.name = name;
    this.message = message;
  }

  public ChatStrategy getChatStrategy()
  {
    return chatStrategy;
  }

  public void setChatStrategy(ChatStrategy chatStrategy)
  {
    this.chatStrategy = chatStrategy;
  }

  public String getName()
  {
    return name;
  }

  public String getMessage()
  {
    return message;
  }
}
