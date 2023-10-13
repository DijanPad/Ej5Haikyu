public class Libero extends Player{

    private int recibos;

    

    public Libero(String name, String country, int errores, int aces, int saques, float efectividad, int recibos) {
        super(name, country, errores, aces, saques, efectividad);
        this.recibos = recibos;
    }

    public int getRecibos() {
        return recibos;
    }

    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    @Override
    public void setEfectividad(){
        float efectividad =  (((recibos - super.getErrores()) * 100 / (recibos + super.getErrores())) + super.getAces() * 100 / super.getSaques());
        super.setEfectividad(efectividad);
    }

    
}
