package Commands;

/**
 * Абстрактная команда с именем и описанием
 */
public abstract class Command{
    private final String name;
    private final String description;
    public Command(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDiscription(){
        return description;
    }

    public void execute(String[] args) throws Exception{

    }

    @Override
    public String toString(){
        return "Command { name = " + name + ", description = " + description + "}";
    }

}
