public class RebaseCommand implements Command{

    private final Receiver receiver;

    public RebaseCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.rebase();
    }
}
