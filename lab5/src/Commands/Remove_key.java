package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;

public class Remove_key extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Remove_key(Console console, CollectionManager collectionManager){
        super("remove_key", "удаляет значение элемента по заданному ключу.");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            collectionManager.deleteElementByKey(args[1]);
        } catch (Exception e){
            console1.println(e.getMessage());
        }
    }
}
