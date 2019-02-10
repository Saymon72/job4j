package ssizov;
/*

 */
public class Profession {
    private String name;

    private String proff;

    private Profession() {

    }
    public Profession(String name, String proff) {
        this.name = name;
        this.proff = proff;
    }

    public String getName() {
        return this.name;
    }
    public String proff() {
        return this.proff;
    }
}