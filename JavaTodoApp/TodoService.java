import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TodoService{

 private List<Task> tasks = new ArrayList<>();

 public void addTask(String title){
  tasks.add(new Task(title));
 }

 public List<Task> getTasks(){
  return Collections.unmodifiableList(tasks);
 }

 public boolean completeTask(int index){
  if(index < 0 || index >= tasks.size()){
   return false;
  }
  tasks.get(index).markDone();
  return true;
 }
}

 
             




