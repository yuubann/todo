import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Todo{
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    TodoService service = new TodoService();
    System.out.println(System.getProperty("file.encoding"));

    while(true){
      System.out.println("タスクを入力しよう！");
      System.out.println("input: リスト処理画面へ, exit: 退出");
      String input = scanner.nextLine();

      if(input.equals("exit")){
        break;
      }else if(input.equals("input")){
       TodoProcess.runTaskManagementMode(service, scanner);
      }else{
        if (input.trim().isEmpty()) {
         System.out.println("タスク名を入力してください。");
        }else{
         service.addTask(input);
      }
    }
  }
}
}

