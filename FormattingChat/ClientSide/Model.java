package FormattingChat.ClientSide;

import FormattingChat.ClientSide.FormattingChatStrategy.BoldChatStrategy;
import FormattingChat.ClientSide.FormattingChatStrategy.ItalicChatStrategy;
import FormattingChat.ClientSide.FormattingChatStrategy.NormalChatStrategy;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.Socket;

public class Model implements Subject
{
  private ClientConnection clientConnection;
  private Socket socket;

  private PropertyChangeSupport support;
  private Message message;

  public Model()
  {
    support = new PropertyChangeSupport(true);
  }

  public boolean connectToServer(String host, int port, String clientName)
      throws IOException
  {
    try
    {
      this.socket = new Socket(host, port);
      this.clientConnection = new ClientConnection(socket, message -> {
        support.firePropertyChange("message", null, message);
      });
      System.out.println("From Model: Client has connected.");
      new Thread(clientConnection).start();
      return true;
    }
    catch (IOException e)
    {
      System.out.println(e);
      return false;
    }
  }

  public void sendMessage(String name, String messageContent) throws IOException
  {
    Message messageToSend = new Message(name, messageContent);
    clientConnection.send(messageToSend);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  public void strategyBold()
  {
    message.setChatStrategy(new BoldChatStrategy());
    support.firePropertyChange("strategyUpdated", null, new BoldChatStrategy());
  }

  public void strategyItalic()
  {
    message.setChatStrategy(new ItalicChatStrategy());
    support.firePropertyChange("strategyUpdated", null,
        new ItalicChatStrategy());
  }

  public void strategyNormal()
  {
    message.setChatStrategy(new NormalChatStrategy());
    support.firePropertyChange("strategyUpdated", null,
        new NormalChatStrategy());
  }

}
