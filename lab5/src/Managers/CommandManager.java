package Managers;

import Commands.*;
import Utilites.Console;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс для обработки комманд.
 */
public class CommandManager {
    private static HashMap<String, Command> ListOfCommands;
    private Console console;
    private CommandManager commandManager;
    private CollectionManager collectionManager;

    /**
     * Конструктор для квсех комманд.
     */
    public CommandManager(){
        ListOfCommands = new HashMap<>();
        ListOfCommands.put("help", new Help(console, commandManager));
        ListOfCommands.put("insert", new Insert(console, collectionManager));
        ListOfCommands.put("show", new Show(console, collectionManager));
        ListOfCommands.put("info", new Info(console, collectionManager));
        ListOfCommands.put("update", new Update(console, collectionManager));
        ListOfCommands.put("remove_key", new Remove_key(console, collectionManager));
        ListOfCommands.put("clear", new Clear(console, collectionManager));
        ListOfCommands.put("exit", new Exit(console, collectionManager));
        ListOfCommands.put("remove_greater", new Remove_greater(console, collectionManager));
        ListOfCommands.put("remove_lower", new Remove_lower(console, collectionManager));
        ListOfCommands.put("replace_if_lower", new Replace_if_lower(console, collectionManager));
        ListOfCommands.put("save", new Save(console, collectionManager));
        ListOfCommands.put("remove_any_by_fuel_consumption", new Remove_any_by_fuel_consumption(console, collectionManager));
        ListOfCommands.put("group_counting_by_fuel_consumption", new Group_counting_by_fuel_consumption(console, collectionManager));
        ListOfCommands.put("filter_greater_than_engine_power", new Filter_greater_than_engine_power(console, collectionManager));
        ListOfCommands.put("execute_script", new Execute_script(console, commandManager, collectionManager));
    }

    /**
     * Начало чтения команд из командной строки.
     * @param comand - команда посланная на вход
     * @throws Exception
     */

    public static void startExecuting(String comand) throws Exception {
        String commandName = comand.split(" ")[0];
        String[] fullCommand = comand.split(" ");
        Command command = ListOfCommands.get(commandName.toLowerCase());
        command.execute(fullCommand);
    }

    public HashMap<String, Command> getCommands(){
        return ListOfCommands;
    }
}
