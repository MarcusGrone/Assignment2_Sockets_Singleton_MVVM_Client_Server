package FormattingChat.ClientSide;

import java.beans.PropertyChangeListener;

public interface Subject
{
  void addListener (String eventName, PropertyChangeListener listener);
}
