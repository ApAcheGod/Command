public class CreateCommand implements Command{

    private final Receiver receiver;

    public CreateCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.create();
    }
}
