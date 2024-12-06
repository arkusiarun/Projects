package assessment.upi;

public class Bank {

    private String name;
    private ServerStatus serverStatus;

    public Bank(String name, ServerStatus serverStatus) {
        this.name = name;
        this.serverStatus = serverStatus;
    }

    public String getName() {
        return name;
    }

    public ServerStatus getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }
}
