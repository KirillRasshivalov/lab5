package Utilites;

import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.Parser;

import javax.management.modelmbean.XMLParseException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс интерфейса, поддерживает некоторые методы, такие как печать на экран или чтение из файла.
 */
public class StandartConsole implements Console {
    public static String file_path_xml = "tst.xml";
    private static Scanner fileScanner = null;
    private static Scanner defScanner = new Scanner(System.in);
    @Override
    public void print(Object obj){
        System.out.print(obj);
    }
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
    @Override
    public String readline() throws NoSuchElementException, IllegalStateException {
        return (fileScanner!=null?fileScanner:defScanner).nextLine();
    }

    /**
     * Класс запуска основной программы.
     * @param input
     * @param args
     * @throws Exception
     * @throws XMLParseException
     */
    @Override
    public void go(InputStream input, String[] args) throws Exception, XMLParseException {
        try {
            Console console = new StandartConsole();
            Scanner scanner = new Scanner(input);
            CommandManager commandManager = new CommandManager();
            new CollectionManager();
            console.println("Начало выгрузки файла в коллекцию.");
            try {
                Parser.read(file_path_xml, false);
            } catch (Exception e) {
                console.println(e.getMessage());
                console.println("Возникла ошибка при чтение файла" + file_path_xml);
                System.exit(0);
            }
            console.println("Добро пожаловать в программу! Для того чтобы узнать что может программа введите 'help'");
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine().trim();
                if (!command.isEmpty()) {
                    try {
                        commandManager.startExecuting(command.toLowerCase());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
