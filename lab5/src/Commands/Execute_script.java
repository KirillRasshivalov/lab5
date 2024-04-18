package Commands;

import Managers.CollectionManager;
import Managers.CommandManager;
import Models.Vehicle;
import Utilites.Console;
import Utilites.StandartConsole;
import exeptions.RootException;
import exeptions.TheSameFileINScriptException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

/**
 * Команда которая читает скрипт  из файла
 */
public class Execute_script extends Command {
    private static Stack<File> st = new Stack<>();
    private final Console console;
    private final CommandManager commandManager;
    private final CollectionManager collectionManager;

    public Execute_script(Console console, CommandManager commandManager, CollectionManager collectionManager) {
        super("execute_script", "осуществляет чтение команд из файла.");
        this.console = console;
        this.commandManager = commandManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws Exception {
        Console console1 = new StandartConsole();
        try {
            File file = new File(args[1]);
            if (!file.canRead()) {
                throw new RootException("У вас недостаточно прав для чтения данного файла.");
            }

            if (st.isEmpty()) {
                st.add(file);
            } else if (st.contains(file)) {
                throw new TheSameFileINScriptException("Вы пытаетесь вызвать скрипт от самого себя.");
            }
            st.add(file);
            String path = args[1];
            var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String line;
            String[] vehicle = new String[10];
            while ((line = br.readLine()) != null) {
                if (line.split(" ")[0].toLowerCase().equals("insert") || line.split(" ")[0].toLowerCase().equals("update")) {
                    String key = line.split(" ")[1];
                    for (int n = 1; n < 10; n++) {
                        if ((line = br.readLine()) != null) {
                            vehicle[n] = line;
                        }
                    }
                    collectionManager.add(key, new Vehicle(vehicle));
                } else {
                    try {
                        commandManager.startExecuting(line);
                    } catch (Exception e) {
                        console1.println(e.getMessage());
                    }
                }
            }
            st.pop();
        } catch (StackOverflowError e){
            console1.println("Стэк переполнен.");
        } catch (Exception e){
            console1.println("Произошла ошибка во время выполнения скрипта.");
        }
    }
}

