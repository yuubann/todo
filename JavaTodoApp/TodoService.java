import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TodoService{

    private List<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";

    //コンストラクタで起動時に自動読み込み
    public TodoService(){
        loadFromFile();
    }

    public void addTask(String title){
        tasks.add(new Task(title));
        saveToFile();
    }

    public List<Task> getTasks(){
        return Collections.unmodifiableList(tasks);
    }

    public boolean completeTask(int index){
        if(index < 0 || index >= tasks.size()){
            return false;
        }
        tasks.get(index).markDone();
        saveToFile();
        return true;
    }

    // ファイルへ保存するメソッド
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME), StandardCharsets.UTF_8)))) {
            for (Task task : tasks) {
                // 「タスク名,完了状態」の形式で保存
                writer.println(task.getTitle() + "\t" + task.isDone());
            }
        } catch (IOException e) {
            System.out.println("保存中にエラーが発生しました: " + e.getMessage());
        }
    }

    // ファイルから読み込むメソッド
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; // ファイルがなければ何もしない

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String title = parts[0];
                    boolean isDone = Boolean.parseBoolean(parts[1]);

                    Task task = new Task(title);
                    if (isDone) task.markDone(); // 完了済みなら状態を復元
                    tasks.add(task);
                }
            }
        }catch (IOException e) {
            System.out.println("読み込み中にエラーが発生しました: " + e.getMessage());
        }
    }
}







