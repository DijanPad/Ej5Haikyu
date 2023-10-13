public class Opuesto extends Player{

    private int ataques;
    private int bloqueos;
    private int bloqueosnt;


    public Opuesto(String name, String country, int errores, int aces, int saques, float efectividad, int bloqueos,
            int bloqueosnt) {
        super(name, country, errores, aces, saques, efectividad);
        this.bloqueos = bloqueos;
        this.bloqueosnt = bloqueosnt;
    }

    public int getAtaques() {
        return ataques;
    }
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }    

    public int getBloqueos() {
        return bloqueos;
    }
    public void setBloqueos(int bloqueos) {
        this.bloqueos = bloqueos;
    }
    public int getBloqueosnt() {
        return bloqueosnt;
    }
    public void setBloqueosnt(int bloqueosnt) {
        this.bloqueosnt = bloqueosnt;
    }

    @Override
    public void setEfectividad(){
        float efectividad =   (((ataques + bloqueos - bloqueosnt - super.getErrores()) * 100 / (ataques +
        bloqueos + bloqueosnt + super.getErrores())) + super.getAces() * 100 / super.getSaques());
        super.setEfectividad(efectividad);
    }
}
