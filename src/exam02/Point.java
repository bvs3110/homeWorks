package exam02;

public class Point {
    private String mainText;
    private String firstChoice;
    private String firstText;
    private String secondChoice;
    private String secondText;

    public Point(String mainText, String firstText, String firstChoice, String secondText, String secondChoice) {
        this.mainText = mainText;
        this.firstChoice = firstChoice;
        this.firstText = firstText;
        this.secondChoice = secondChoice;
        this.secondText = secondText;
    }

    public String getMainText() {
        return mainText;
    }

    public String getFirstChoice() {
        return firstChoice;
    }

    public String getFirstText() {
        return firstText;
    }

    public String getSecondChoice() {
        return secondChoice;
    }

    public String getSecondText() {
        return secondText;
    }
}
