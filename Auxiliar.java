/** Programacion orientada a objetos -  seccion 10
 * Luis Francisco Padilla Juárez - 23663
 * E5, Polimorfismo via herencia
 * 18-10-2323
 * @return Auxiliar
 */

public class Auxiliar extends Player{

    private int ataques;
    private int bloqueos;
    private int bloqueosnt;


    public Auxiliar(String name, String country, int errores, int aces, int saques, int ataques, int bloqueos, int bloqueosnt) {
        super(name, country, errores, aces, saques);
        this.ataques = ataques;
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
    public void setEfectividad(float efectividad){
        efectividad =   (((ataques + bloqueos - bloqueosnt - super.getErrores()) * 100 / (ataques +
        bloqueos + bloqueosnt + super.getErrores())) + super.getAces() * 100 / super.getSaques());
        super.setEfectividad(efectividad);
    }

    @Override
    public String toString() {
        return "Auxiliar " + super.toString() ;
    }
    
}
