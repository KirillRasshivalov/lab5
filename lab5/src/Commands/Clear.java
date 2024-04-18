package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;

/**
 * Команда которая очищает коллекцию
 */
public class Clear extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Clear(Console console, CollectionManager collectionManager){
        super("clear", "очищает коллекцию.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            collectionManager.clearCollection();
        }catch (Exception e){
            console1.println(e.getMessage());
        }
    }
}
