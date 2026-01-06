import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Todo{
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    TodoService service = new TodoService();

    while(true){
      System.out.println("タスクを入力しよう！");
      System.out.println("input: リスト処理画面へ, exit: 退出");
      String input = scanner.nextLine();

      if(input.equals("exit")){
        break;
      }else if(input.equals("input")){
       Todoprocess.runTaskManagementMode(service, scanner);
      }else{
        service.addTask(input);
      }
    }
  }
}
