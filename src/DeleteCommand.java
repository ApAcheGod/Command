public class DeleteCommand implements Command{

    private final Receiver receiver;

    public DeleteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.delete();
    }
}
