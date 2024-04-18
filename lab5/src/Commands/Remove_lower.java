package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;

public class Remove_lower extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Remove_lower (Console console, CollectionManager collectionManager){
        super("remove_lower", "удаляет все эелемента из коллекции, чьи id превышают заданный.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            collectionManager.removeLowerElem(args[1]);
        }catch (Exception e){
            console1.println(e.getMessage());
        }
    }
}
