package FormattingChat.ClientSide;

import java.beans.PropertyChangeEvent;

public class ChatViewModel
{
private Model clientModel;

  public ChatViewModel(Model clientModel)
  {
    clientModel.addListener("StrategyChange", this::Update);
  }

  public void messageToNormal()
  {
clientModel.strategyNormal();
  }

  public void messageToItalic()
  {
clientModel.strategyItalic();
  }

  public void messageToBold()
  {
clientModel.strategyBold();
  }


  private void Update(PropertyChangeEvent propertyChangeEvent)
  {


  }



}
