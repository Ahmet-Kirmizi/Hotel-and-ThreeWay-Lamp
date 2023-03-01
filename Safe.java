package ss.week2;

public class Safe {

    private boolean openClosed;
    private boolean activeDeactivate;

    Safe() {
        this.openClosed = false;
        this.activeDeactivate = false;
    }
    // check later
    Safe(boolean openClosed, boolean activeDeactivate) {
        this.openClosed = openClosed;
        this.activeDeactivate = activeDeactivate;
    }


    public void activate() {
        this.activeDeactivate = true;
    }

    public void deactivate() {
        this.activeDeactivate = false;

    }

    public void open() {
        this.openClosed = true;
    }

    public void close() {
        this.openClosed = false;

    }

    public boolean isActive() {
        return this.activeDeactivate;
    }

    public boolean isOpen() {
        return this.openClosed;

    }


}