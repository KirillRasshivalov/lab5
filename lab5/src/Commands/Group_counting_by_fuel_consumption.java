package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;

import javax.swing.*;


/**
 * Команда которая группирует элементы коллекции по значению поля fuelConsumption, выводит количество элементов в каждой группе
 */
public class Group_counting_by_fuel_consumption extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    public Group_counting_by_fuel_consumption(Console console, CollectionManager collectionManager){
        super("group_counting_by_fuel_consumption", "группирует элементы коллекции по значению fuel, выводит " +
                "количество элементов в каждой группе.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        try{
            collectionManager.groupByFuel();
        }catch(Exception e){
            console1.println(e.getMessage());
        }
    }
}
