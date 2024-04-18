package Commands;

import Managers.CollectionManager;
import Models.Vehicle;
import Utilites.Console;
import Utilites.StandartConsole;

import java.util.LinkedHashMap;

public class Show extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Show (Console console, CollectionManager collectionManager){
        super("show", "выводит введенные транспортные средства.");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        if (collectionManager.getTable().keySet().size() == 0){
            console1.println("Коллекция пуста.");
        }
        else {
            LinkedHashMap<String, Vehicle> table = CollectionManager.getTable();
            for (String key : table.keySet()) {
                console1.println(table.get(key).toString());
            }
        }
    }
}
