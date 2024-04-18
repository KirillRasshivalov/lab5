package Commands;

import Managers.CollectionManager;
import Managers.Parser;
import Utilites.Console;
import Utilites.StandartConsole;
import exeptions.RootException;

import java.io.IOException;

public class Save extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Save(Console console, CollectionManager collectionManager){
        super("save", "сохраняет коллекцию в файл в формате .xml");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] arr){
        StandartConsole console1 = new StandartConsole();
        try{
            Parser.write(console1.file_path_xml);
            console1.println("Все изменения успешно сохранены.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RootException e) {
            throw new RuntimeException(e);
        }
    }
}
