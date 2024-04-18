package Commands;

import Managers.CollectionManager;
import Utilites.Console;
import Utilites.StandartConsole;
import exeptions.NumberValueExeption;
import query.Ask;

public class Update extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Update(Console console, CollectionManager collectionManager){
        super("update", "обновляет значение элемента коллекции id которого равен заданному.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        Console console1 = new StandartConsole();
        try {
            collectionManager.updateIdEquels(args[1]);
        } catch (Ask.AskBreak e) {
            throw new RuntimeException(e);
        } catch (NumberValueExeption e) {
            throw new RuntimeException(e);
        }
    }
}
