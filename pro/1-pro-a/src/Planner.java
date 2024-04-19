import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Planner implements Serializable {
    private List<Task> tasks;

    public Planner() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(String name) {
        Task task = searchByName(name);
        tasks.remove(task);
    }

    public Task searchByName(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                return task;
            }
        }
        System.out.println("Úkol nenalezen");
        return null;
    }

    public void markTaskAsCompleted(String taskName) {
        Task task = searchByName(taskName);
        if (task != null && task.isCompleted() == false) {
            task.setCompleted(true);
        }
    }

    public void displayTasks() {
        for (Task task : tasks) {
            System.out.println("Jméno: " + task.getName());
            System.out.println("Popis: " + task.getDescription());
            System.out.println("Splněno: " + task.isCompleted());
            System.out.println();
        }
    }

    public void displayUnfinishedTasks() {
        for (Task task : tasks) {
            if (task.isCompleted() == false) {
                System.out.println("Jméno: " + task.getName());
                System.out.println("Popis: " + task.getDescription());
                System.out.println("Splněno: " + task.isCompleted());
                System.out.println();
            }
        }
    }

    public void savePlanToFile(String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Plán uložen");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Planner loadPlanFromFile(String fileName) {
        Planner planner = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            planner = (Planner) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Soubor neexistuje");
        }
        if (planner != null) {
            System.out.println("Načtený plán:");
            planner.displayTasks();
        }
        else {
            planner = new Planner();
        }
        return planner;
    }
}
