/** Programacion orientada a objetos -  seccion 10
 * Luis Francisco Padilla Juárez - 23663
 * E5, Polimorfismo via herencia
 * 18-10-2323
 * @return Libero
 */

public class Libero extends Player{

    private int recibos;

    

    public Libero(String name, String country, int errores, int aces, int saques, int recibos) {
        super(name, country, errores, aces, saques);
        this.recibos = recibos;
    }

    public int getRecibos() {
        return recibos;
    }

    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    @Override
    protected void setEfectividad(float holder) {
        float efectividad = ((recibos - super.getErrores()) * 100 / (recibos + super.getErrores())) 
        + (super.getAces() * 100 / super.getSaques());
        super.setEfectividad(efectividad);
    }

    @Override
    public String toString() {
        return "Libero " + super.toString();
    }

    
    
}
