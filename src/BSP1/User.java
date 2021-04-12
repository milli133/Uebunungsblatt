package BSP1;

import java.util.Objects;

public class User {
    public static String STATUS_ONLINE = "online", STATUS_OFFLINE = "offline";
    private String name, status;
    private boolean isAdmin;

    public User(String name, String status, boolean isAdmin) {
        this.name = name;
        this.status = status;
        this.isAdmin = isAdmin;

        if (status != STATUS_OFFLINE.toString() && status != STATUS_ONLINE) {
            throw new IllegalArgumentException("STATUS INVALID!");
        }
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
