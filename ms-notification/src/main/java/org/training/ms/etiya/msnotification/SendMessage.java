package org.training.ms.etiya.msnotification;

public class SendMessage {

    private String message;
    private String dest;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "SendMessage{" +
                "message='" + message + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
