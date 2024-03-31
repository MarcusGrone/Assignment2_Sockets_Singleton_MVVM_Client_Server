package FormattingChat.ClientSide;

import FormattingChat.ClientSide.FormattingChatStrategy.ChatStrategy;

import java.io.Serializable;

public class Message implements Serializable
{
  private String name;
  private String content;

  private ChatStrategy chatStrategy;


  public Message(String name, String content)
  {
    this.name = name;
    this.content = content;
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

  public String getContent()
  {
    return content;
  }
}
