package lesson03.PartOne;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int calculateSquare() {
        return length * width;
    }

    public int calculatePerimeter() {
        return 2 * (length + width);
    }
}
