package Commands;

import Managers.CollectionManager;
import Models.Coordinates;
import Models.Vehicle;
import Utilites.Console;
import Utilites.StandartConsole;
import exeptions.NumberValueExeption;
import query.Ask;

/**
 * Команда которая осуществляет добавление нового элемента в колекцию.
 */
public class Insert extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Insert(Console console, CollectionManager collectionManager){
        super("insert {element}",  "добавление нового элемента в коллекцию.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws Ask.AskBreak, NumberValueExeption {
        Console console1 = new StandartConsole();
        if (args.length == 2 && !CollectionManager.getTable().containsKey(args[1])){
            try{
                console1.println("Начало заполнения коллекции.");
                Object vehicle = Ask.askVehicle(console1, 1L);
                CollectionManager.add(args[1], (Vehicle) vehicle);
                console1.println("Транспорт успеuшно добавлен");
            }catch (NumberFormatException e) {
                console1.println("\u001B[31m" + "Вы ввели что-то неправильно, проверьте " +
                        "что вы ввели все согласно требованиям." + "\u001B[0m");
            }
        }
        else{
            console1.println("Проверьте что все введенные вами данные соответсвтуют действительности, а ключи не совпадают.");
        }
    }
}
