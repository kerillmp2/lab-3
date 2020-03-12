import javax.faces.bean.ManagedProperty;

public class Navigation  {
    private static final long serialVersionUID = 1L;
    private String pageId;

    public String moveToMainPage() {
        return "login";
    }

    public String moveToHomePage() {
        return "index";
    }

    public String processHome() {
        return "page";
    }

    public String processMain() {
        return "page";
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
}
