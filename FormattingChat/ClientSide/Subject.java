package FormattingChat.ClientSide;

import java.beans.PropertyChangeListener;

public interface Subject
{
  void addPropertyChangeListener (String eventName, PropertyChangeListener listener);
}
