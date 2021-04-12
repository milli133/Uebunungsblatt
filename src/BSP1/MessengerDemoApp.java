package BSP1;

import java.util.ArrayList;

public class MessengerDemoApp {

    public static void main(String[] args) throws UserNotAdminException, UserNotFoundException, UserOfflineException {
        User user1 = new User("Franz", User.STATUS_ONLINE, true);
        User user2 = new User("Kevin", User.STATUS_ONLINE, true);
        User user3 = new User("Sepp", User.STATUS_ONLINE, true);
        User user4 = new User("Toni", User.STATUS_ONLINE, false);

        MessengerService ms = new MessengerService();

        try {
            ms.registerUser(user1);
            ms.registerUser(user2);
            ms.registerUser(user3);
            ms.registerUser(user4);
        } catch (UserAlreadyExistsException e) {
            e.getMessage();
        }

        DirectMessage m1 = null;
        DirectMessage m2 = null;
        DirectMessage m3 = null;

        try {
            m1 = new DirectMessage("DM1", user2, user4);
            m2 = new DirectMessage("DM2", user1, user3);
            m3 = new DirectMessage("DM3", user4, user3);
        } catch (MessageToSelfException e) {
            e.getMessage();
        }

        BroadcastMessage bm1 = new BroadcastMessage("BM1", user1);
        BroadcastMessage bm2 = new BroadcastMessage("BM2", user3);

        ArrayList<Message> ml = new ArrayList<>();
        ml.add(m1);
        ml.add(m2);
        ml.add(m3);
        ml.add(bm1);
        ml.add(bm2);

        for (Message m : ml) {
            try {
                if (m instanceof BroadcastMessage)
                    ms.sendBroadcastMessage((BroadcastMessage) m);

                if (m instanceof DirectMessage)
                    ms.sendDirectMessage((DirectMessage) m);
            } catch (MessengerException e) {e.printStackTrace();}
        }
    }
}
