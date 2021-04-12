package BSP1;

public class DirectMessage extends Message {

    private User from;
    private User to;

    public DirectMessage(String text, User from, User to) throws MessageToSelfException {
        super(text);
        this.from = from;
        this.to = to;

        if (from == to) {
            throw new MessageToSelfException("USERS FROM AND TO ARE THE SAME!");
        }
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "DirectMessage{" +
                "from=" + from +
                ", to=" + to +
                "} " + super.toString();
    }
}
