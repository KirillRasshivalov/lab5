import Commands.Command;
import Commands.Help;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.Parser;
import Utilites.Console;
import Utilites.NullOutputStream;
import Utilites.StandartConsole;
import exeptions.NumberValueExeption;
import exeptions.RootException;
import org.xml.sax.SAXException;
import query.Ask;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static Managers.CollectionManager.table;


public class Main {
    /**
     * Класс старта программы.
     * @param - аргументы командной строки
     * @throws Ask.AskBreak
     * @throws NumberValueExeption
     */
    public static void main(String[] args) throws Ask.AskBreak, NumberValueExeption {
        StandartConsole Console = new StandartConsole();
        PrintStream nullPrintStream = new PrintStream(new NullOutputStream());
        System.setErr(nullPrintStream);
        try{
            Console.go(System.in, args);
        } catch (Exception e){
            Console.println(e.getMessage());
        }
    }
}