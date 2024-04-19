public class Main {
    public static void main(String[] args) {

        Planner planner = Planner.loadPlanFromFile("soubor.ser");

        Task task1 = new Task("Gym", "Jit do posilovny");
        Task task2 = new Task("Study", "Pracovat na školním projektu");
        Task task3 = new Task("Clean", "Vyluxovat");

        planner.addTask(task1);
        planner.addTask(task2);
        planner.addTask(task3);

        planner.markTaskAsCompleted("Gym");

        planner.displayTasks();
        planner.displayUnfinishedTasks();

        planner.savePlanToFile("soubor.ser");
    }
}