public class Task{

 private String title;
 private boolean done;

 public Task(String title){
  this.title = title;
  this.done = false;
 }

 public void markDone(){
  this.done = true;
 }

 public boolean isDone(){
  return done;
 }

 public String getTitle(){
  return title;
 }

 @Override
 public String toString(){
  return(done ? "[×]" : "[ ]") + title;

}
}
