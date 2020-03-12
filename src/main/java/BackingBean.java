import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

public class BackingBean implements Serializable {
    private float x;
    private float y;
    private float r;
    private float xCanvas;
    private float yCanvas;
    private boolean DBflag;

    @Resource
    UserTransaction userTransaction;

    @EJB
    private DBConnection connection;

    private List<FishingPoint> fishingPoints = new ArrayList<>();

    private FIshGenerator fIshGenerator = new FIshGenerator();
    private String image;
    private String fishName;

    public BackingBean() {
        this.DBflag = false;
        this.r = 1;
        this.x = 0;
        this.y = 0;
        image = "resources/fishes/shrek.png";
        fishName = "";
    }

    private void addPointToDB(FishingPoint point){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        String sessionId = session.getId();
        point.setSession(sessionId);
        try {
            userTransaction.begin();
            connection.insert(point);
            userTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        Fish fish = fIshGenerator.generateFish();
        this.fishName = "Вы поймали " + fish.name + "!";
        this.image = fish.image;
        System.out.println(fishName + " " + image);
    }

    public String getImage(){
        return this.image;
    }

    public String getFishName(){
        return this.fishName;
    }

    public List<FishingPoint> getPointsForR(){
        List<FishingPoint> list = new ArrayList<>();
        for(int i = 0; i < fishingPoints.size(); i++){
            if(fishingPoints.get(i).getR() == r) {
                list.add(fishingPoints.get(i));
            }
        }
        return list;
    }

    public void setyCanvas(float yCanvas) {
        this.yCanvas = yCanvas;
    }

    public void setxCanvas(float xCanvas) {
        this.xCanvas = xCanvas;
    }

    public float getyCanvas() {
        return yCanvas;
    }

    public float getxCanvas() {
        return xCanvas;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void addPointFromForm() {
        FishingPoint fishingPoint = new FishingPoint(fishingPoints.size() + 1, x, y, r);
        fishingPoints.add(0, fishingPoint);
        addPointToDB(fishingPoint);
    }

    public List<FishingPoint> getFishingPoints() {
        if(!DBflag){
            try {
                userTransaction.begin();
                this.fishingPoints = getFishingPointsFromDB();
                DBflag = true;
                userTransaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
            return fishingPoints;
    }

    private List<FishingPoint> getFishingPointsFromDB() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        String sessionId = session.getId();
        fishingPoints = connection.findAll(sessionId);

        fishingPoints.sort((fp1, fp2) -> -(fp1.getNumber() - fp2.getNumber()));
        return fishingPoints;
    }

    public void setFishingPoints(List<FishingPoint> fishingPoints) {
        this.fishingPoints = fishingPoints;
    }

    public void addPointFromGraph() {
        String x = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("graph:xCanvas");
        String y = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("graph:yCanvas");
        setxCanvas(Float.parseFloat(x));
        setyCanvas(Float.parseFloat(y));
        FishingPoint fishingPoint = new FishingPoint(fishingPoints.size() + 1, xCanvas, yCanvas, r);
        fishingPoints.add(0, fishingPoint);
        addPointToDB(fishingPoint);
    }
}