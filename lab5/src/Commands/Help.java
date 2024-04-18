package Commands;

import Managers.CommandManager;
import Utilites.Console;
import Utilites.StandartConsole;

import java.util.HashMap;

/**
 * Команда которая выводит информцию по всем командам
 */
public class Help extends Command{
    private static Console console;
    private static CommandManager commandManager;
    public Help(Console console, CommandManager commandManager){
        super("help", "выводит информаци про доступные команды.");
        this.console = console;
        this.commandManager = commandManager;
    }
    @Override
    public void execute(String[] args){
        Console console1 = new StandartConsole();
        CommandManager commandManager = new CommandManager();
        HashMap<String, Command> ListOfCommands = commandManager.getCommands();
        for(String name : ListOfCommands.keySet()){
            Command command = ListOfCommands.get(name);
            console1.println(command.getName() + ": " + command.getDiscription());
        }
    }
}
