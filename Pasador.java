public class Pasador extends Player{
    
    private int fintas;
    private int pases;

    
    public Pasador(String name, String country, int errores, int aces, int saques, float efectividad, int fintas,
            int pases) {
        super(name, country, errores, aces, saques, efectividad);
        this.fintas = fintas;
        this.pases = pases;
    }


    public int getFintas() {
        return fintas;
    }


    public void setFintas(int fintas) {
        this.fintas = fintas;
    }


    public int getPases() {
        return pases;
    }


    public void setPases(int pases) {
        this.pases = pases;
    }

    @Override
    public void setEfectividad(){
        float efectividad =   (((pases + fintas - super.getErrores()) * 100 / (pases + fintas + super.getErrores())) + super.getAces() * 100 / super.getSaques());
        super.setEfectividad(efectividad);
    }

}
