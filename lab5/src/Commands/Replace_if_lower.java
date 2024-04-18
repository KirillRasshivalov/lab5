package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;
import exeptions.NumberValueExeption;
import query.Ask;

public class Replace_if_lower extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Replace_if_lower(Console console, CollectionManager collectionManager){
        super("replace_if_lower", "заменить значение по ключу, если новое значение id больше страого.");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            collectionManager.replaceIfLower(args[1]);
        } catch(Exception e){
            console1.println(e.getMessage());
        }
    }
}
