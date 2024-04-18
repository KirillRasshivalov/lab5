package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;

public class Remove_greater extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Remove_greater(Console console, CollectionManager collectionManager){
        super("remove_greater", "удаляет все эелемента из коллекции, чьи id превышают заданный.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            collectionManager.removeGreaterElem(args[1]);
        }catch (Exception e){
            console.println(e.getMessage());
        }
    }
}
