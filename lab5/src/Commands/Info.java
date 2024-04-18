package Commands;

import Managers.CollectionManager;
import Managers.CommandManager;
import Utilites.Console;
import Utilites.StandartConsole;

/**
 * Команда которая выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)
 */
public class Info extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    public Info(Console console, CollectionManager collectionManager){
        super("info", "выводит информацию о коллекции (тип, дата инициализации, кол-во элементов.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        console1.println("Тип коллекции: " + collectionManager.getTable().getClass().getName());
        console1.println("Дата инициализации: " + collectionManager.getZonedDateTime());
        console1.println("Кол-во элементов: " + collectionManager.getTable().keySet().size());
    }

}
