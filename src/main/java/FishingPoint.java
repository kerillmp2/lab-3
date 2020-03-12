import javax.persistence.*;

@Entity
@Table(name = "mypoints")
public class FishingPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float x;

    private float y;

    private float r;

    private int number;

    private boolean hited;

    private String session;

    public FishingPoint(){
    }

    public FishingPoint(int number, float x, float y, float r) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.r = r;
        this.hited = (x <= 0 && x >= -r && y >= 0 && y <= r) ||
                (y <= 0 && x <= 0 && (2 * x + y >= -r)) ||
                (x >= 0 && y >= 0 && (x * x + y * y <= r * r));
    }

    public FishingPoint(String sessionId, int number, float x, float y, float r, boolean hited){
        this.session = sessionId;
        this.number = number;
        this.x = x;
        this.y = y;
        this.r = r;
        this.hited = hited;
    }

    public int getNumber() {
        return number;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSession() {
        return session;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isHited() {
        return hited;
    }

    public void setHited(boolean hited) {
        this.hited = hited;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public boolean getHited() {
        return hited;
    }

    public String draw(int r) {
        if(r == this.r) {
            return String.format("drawPoint(%s, %s, %s, %s)", r, x, y, hited);
        }else return "";
    }

    @Override
    public String toString(){
        return session + " " + number + " (" + x + ", " + y + ", " + r + ") " + hited;
    }
}