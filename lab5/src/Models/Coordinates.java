package Models;

public class Coordinates {
    private Long x; //Поле не может быть null

    private Double y; //Поле не может быть null

    public Coordinates(Long x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "x = " + x + "; " + "y = " + y;
    }

    public Double getY() {
        return y;
    }

    public Long getX() {
        return x;
    }
}
