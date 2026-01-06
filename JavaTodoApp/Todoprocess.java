import java.util.Scanner;
import java.util.List;

public class Todoprocess{

  private static void runTaskManagementMode(TodoService service, Scanner scanner){
   while(true){
    System.out.println("タスク処理をしよう!");
    System.out.println("list: 一覧表示, done 半角数字: 完了処理, exit: 退出");
    String command = scanner.nextLine();

     if(command.equals("exit")){
      break; //これで呼び出し元(main)に戻ります
     }else if(command.equals("list")){
      printTaskList(service);
     }else if(command.startsWith("done")){
      handleDone(service, command);
     }
    }
   }

  private static void printTaskList(TodoService service){
    List<Task> tasks = service.getTasks();
    if (tasks.isEmpty()) {
        System.out.println("現在、登録されているタスクはありません。");
        return;
    }
   System.out.println("----タスク一覧----");
   int index = 1;
   for(Task task : service.getTasks())
    System.out.println(index + ":" + task);
    index++;
   }
  }

  private static void handleDone(TodoService service, String command){
   String[] parts = command.split(" ");
   try{
    int inputIndex = Integer.parseInt(parts[1]);
    int listIndex = inputIndex - 1; //ユーザーの入力からリストの添字へ変換

    if(service.completeTask(listIndex)){
     System.out.println("完了しました!");
    }else{
     System.out.println("番号が不正です");
    }
   }catch(Exception e){ //要素不足や数値エラーをまとめてキャッチ
    System.out.println("有効な番号を入力してください");
   }
  }

}

