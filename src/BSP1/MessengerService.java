package BSP1;

import java.util.*;

public class MessengerService {

    private Map<String, User> users = new HashMap<>();
    private List<Message> history = new ArrayList<>();

    public void registerUser(User user) throws UserAlreadyExistsException {
        if (users.containsKey(user.getName()) == false)
            users.put(user.getName(), user);
        else
            throw new UserAlreadyExistsException("USER ALREADY EXISTS!");
    }

    public void unregisterUser(User user) throws UserNotFoundException {
        if (users.containsKey(user.getName()) == true)
            users.remove(user.getName());
        else
            throw new UserNotFoundException("USER NOT FOUND!");
    }

    public void sendDirectMessage(DirectMessage message) throws UserNotFoundException, UserOfflineException {
        if (users.containsKey(message.getFrom()) == true ||
        users.containsKey(message.getTo()) == true)
            throw new UserNotFoundException("FROM OR TO USER NOT FOUND!");

        if (message.getTo().getStatus() != User.STATUS_ONLINE)
            throw new UserOfflineException("RECIEVING USER OFFLINE!");

        System.out.println("Message '" + message.getText() + "' sent  from " + message.getFrom().getName() + " to " + message.getTo().getName());
        history.add(message);
    }

    public void sendBroadcastMessage(BroadcastMessage message) throws UserNotAdminException {
        User from = message.getFrom();

        if (from.isAdmin() == false)
            throw new UserNotAdminException("USER IS NO ADMIN!");

        for (User user : users.values()) {
            if (user.equals(from) == false)
                System.out.println("Message '" + message.getText() + "' sent from " + from.getName() + " to " + user.getName());
                history.add(message);
        }
    }
}
