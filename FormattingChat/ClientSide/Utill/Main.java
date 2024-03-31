package FormattingChat.ClientSide.Utill;

import static javafx.application.Application.launch;
import javafx.stage.Stage;
public class Main
{
  public static void main(String[] args) {launch();}

  public void start(Stage primaryStage) throws Exception{
  ModelFactory modelFactory = new ModelFactory();
  ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
  ViewControllerFactory viewControllerFactory = new ViewControllerFactory(viewModelFactory, primaryStage);

viewControllerFactory.getChatView();
  }
}
