public class Player {
    
    private String name;
    private String country;
    private int errores;
    private int aces;
    private int saques;
    private float efectividad;

    public Player(String name, String country, int errores, int aces, int saques, float efectividad) {
        this.name = name;
        this.country = country;
        this.errores = errores;
        this.aces = aces;
        this.saques = saques;
        this.efectividad = efectividad;
    }


    protected String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }
    protected String getCountry() {
        return country;
    }
    protected void setCountry(String country) {
        this.country = country;
    }
    protected int getErrores() {
        return errores;
    }
    protected void setErrores(int errores) {
        this.errores = errores;
    }
    protected int getAces() {
        return aces;
    }
    protected void setAces(int aces) {
        this.aces = aces;
    }
    protected int getSaques() {
        return saques;
    }
    protected void setSaques(int saques) {
        this.saques = saques;
    }
    protected float getEfectividad() {
        return efectividad;
    }
    protected void setEfectividad(float efectividad) {
        this.efectividad = efectividad;
    }

    

}
