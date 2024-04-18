package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;

/**
 * Команда которая выводит элементы, значение поля enginePower которых больше заданного
 */
public class Filter_greater_than_engine_power extends Command{
    final private Console console;
    private final CollectionManager collectionManager;
    public Filter_greater_than_engine_power(Console console, CollectionManager collectionManager){
        super("filter_greater_than_engine_power", "выводит значения полей больше заданного.");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            collectionManager.filterByEngine(args[1]);
        }catch(Exception e){
            console1.println(e.getMessage());
        }
    }
}
