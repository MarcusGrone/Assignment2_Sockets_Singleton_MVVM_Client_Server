package FormattingChat.ClientSide;

import FormattingChat.ClientSide.FormattingChatStrategy.BoldChatStrategy;
import FormattingChat.ClientSide.FormattingChatStrategy.ItalicChatStrategy;
import FormattingChat.ClientSide.FormattingChatStrategy.NormalChatStrategy;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.Socket;

public class Model implements Subject
{
 private ClientConnection clientConnection;
 private Socket socket;

 private PropertyChangeSupport support;
 private Message message;


 @Override public void addListener(String eventName,
     PropertyChangeListener listener)
 {

 }


 public void strategyBold()
 {
  message.setChatStrategy(new BoldChatStrategy());
  support.firePropertyChange("strategyUpdated",null,new BoldChatStrategy());
 }

 public void strategyItalic()
 {
  message.setChatStrategy(new ItalicChatStrategy());
  support.firePropertyChange("strategyUpdated",null,new ItalicChatStrategy());
 }

 public void strategyNormal()
 {
  message.setChatStrategy(new NormalChatStrategy());
  support.firePropertyChange("strategyUpdated",null,new NormalChatStrategy());
 }



}
