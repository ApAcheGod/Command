public class Invoker {

    private final Command createCommand;
    private final Command copyCommand;
    private final Command deleteCommand;
    private final Command rebaseCommand;

    public Invoker(Command createCommand, Command copyCommand, Command deleteCommand, Command rebaseCommand) {
        this.createCommand = createCommand;
        this.copyCommand = copyCommand;
        this.deleteCommand = deleteCommand;
        this.rebaseCommand = rebaseCommand;
    }

    public void create(){
        createCommand.execute();
    }

    public void copy(){
        copyCommand.execute();
    }

    public void delete(){
        deleteCommand.execute();
    }

    public void rebase(){
        rebaseCommand.execute();
    }
}


