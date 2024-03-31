package FormattingChat.ClientSide.Utill;

import FormattingChat.ClientSide.ChatViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;

  private ChatViewModel chatViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public ChatViewModel getChatViewModel()
  {
    if (chatViewModel == null)
    {
      chatViewModel = new ChatViewModel(modelFactory.getModel());
    }
    return chatViewModel;
  }
}
