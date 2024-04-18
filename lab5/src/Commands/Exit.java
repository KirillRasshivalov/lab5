package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;

/**
 * Команда которая осуществляет выход из программы. Прерывание.
 */
public class Exit extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Exit (Console console, CollectionManager collectionManager){
        super("exit", "осуществляет выход из программы.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            console1.println("Программа завершена.");
            System.exit(1);
        } catch (Exception e){
            console1.println(e.getMessage());
        }
    }
}
