package exam02;

public abstract class MenuItem implements MenuRun{
    private String itemText;

    public MenuItem(String itemText) {
        this.itemText = itemText;
    }

    public String getItemText() {
        return itemText;
    }
}
