/** Programacion orientada a objetos -  seccion 10
 * Luis Francisco Padilla Juárez - 23663
 * E5, Polimorfismo via herencia
 * 18-10-2323
 * @return Haikyu
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Haikyu {
    public static void main(String[] args){

        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Float> Top3 = new ArrayList<Float>();
        float holder = 2;

        boolean run = true;
        int inputOption = 0;

        String database = "dataHaykyu.csv";
        String CalcHaikyu = "CalcHaikyu.txt";

        int top = 3;
        String menu = "Haikyu"+"\n"+
        "1. Mostar todos los jugadores"+"\n"+
        "2. Top "+top+" mejores liberos"+"\n"+
        "3. Numero de pasadores mas efectivos"+"\n"+
        "4. Guardar datos en CSV\n"+
        "5. Salir";
        Scanner scanner = new Scanner(System.in);

        //cargar datos de un CSV
        
            try (BufferedReader br = new BufferedReader(new FileReader(database))) {
                String encabezado = br.readLine();
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split(",");
                    
                    // Extraer los valores del CSV
                    String type = valores[0];
                    String name = valores[1];
                    String country = valores[2];
                    int errores = Integer.parseInt(valores[3]);
                    int aces = Integer.parseInt(valores[4]);
                    int saques = Integer.parseInt(valores[5]);
                    int extra1 = Integer.parseInt(valores[6]);
                    int extra2 = Integer.parseInt(valores[7]);
                    int extra3 = Integer.parseInt(valores[8]);
                    
    
                    if (type.equals("L")){
                    players.add(new Libero(name,country,errores,aces,saques,extra1));
                    }
                    if (type.equals("P")){
                    players.add(new Pasador(name,country,errores,aces,saques,extra1,extra2));
                    }
                    if (type.equals("O")){
                    players.add(new Opuesto(name,country,errores,aces,saques,extra1,extra2,extra3));
                    }
                    if (type.equals("A")){
                    players.add(new Auxiliar(name,country,errores,aces,saques,extra1,extra2,extra3));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(int i = 0; i<players.size();i++){
                players.get(i).setEfectividad(holder);
            }
        while(run == true){
            System.out.println(menu);
            
            System.out.println("Ingresa una opcion del menu: ");
            inputOption = scanner.nextInt();

            System.out.println("\n ");

            if(inputOption == 1){
                System.out.println("Todos los jugadores inscritos: \n");
                for(int i = 0; i<players.size();i++){
                    System.out.println(players.get(i).toString());
                }
            }

            if(inputOption == 2){

                //array de floats
                System.out.println("Top "+ top +" liberos:");
                for(int i = 0; i<players.size();i++){
                    if(players.get(i) instanceof Libero){
                    Top3.add(players.get(i).getEfectividad()); 
                    }
                }
                
                //ordenar el nuevo array de mayor a menor
                Collections.sort(Top3, new Comparator<Float>() {
                    public int compare(Float o1, Float o2) {
                        return Float.compare(o2, o1); 
                    }
                   
                });

                int num = 0;
    
                    //impirimir jugadores en su jerarquia a mejores jugadores
                    for (int i = 0; i<top; i++) {
                        num++;
                        for (int j = 0; j<players.size();j++){
                            if(players.get(j) instanceof Libero && Top3.get(i) - players.get(j).getEfectividad() == 0){
                            System.out.println(num + " " + players.get(j).toString());
                        }
                    
                    }
                } 
            System.out.println("\n");
            }
            if(inputOption == 3){
                int Pascounter = 0;
                for(int i = 0; i<players.size();i++){ 
                    //suponemos que le maximo es 80 por lo que el 85% es 68
                    if(players.get(i) instanceof Pasador && players.get(i).getEfectividad() >= 68){ 
                    Pascounter++;
                }
    
            }
            System.out.println("Hay " + Pascounter + " pasadores con una efectividad mayor al 85%.");
            System.out.println("\n ");
            }
    
                //cerrar programa
            if(inputOption == 5){
                System.out.println("Gracias por ver Haikyu.");
                run = !run;
            }
            if(inputOption == 4){
                System.out.println("Guardando...\n");
            try (FileWriter writer = new FileWriter(CalcHaikyu)) {
            
                writer.write("type,name,country,errors,aces,saques,efectividad,recibos,fintas,pases,ataques,bloqueos,bloquen't,\n");
                
                for (int i = 0; i <players.size(); i++) {
                
                if(players.get(i) instanceof Libero){
                    writer.write("L" + ","+
                    players.get(i).getName() + "," +
                    players.get(i).getCountry() + "," +
                    players.get(i).getErrores() + "," +
                    players.get(i).getAces() + "," +
                    players.get(i).getSaques() + "," +
                    players.get(i).getEfectividad() + "," +
                    ((Libero) players.get(i)).getRecibos() + "," +
                    "" + "," +
                    "" + "," +
                    "" + "," +
                    "" + "," +
                    ""+"\n" );
                }
                if(players.get(i) instanceof Pasador){
                    writer.write("P" + ","+
                    players.get(i).getName() + "," +
                    players.get(i).getCountry() + "," +
                    players.get(i).getErrores() + "," +
                    players.get(i).getAces() + "," +
                    players.get(i).getSaques() + "," +
                    players.get(i).getEfectividad() + "," +
                    "" + "," +
                    ((Pasador) players.get(i)).getFintas() + "," +
                    ((Pasador)players.get(i)).getPases() + "," +
                    "" + "," +
                    "" + "," +
                    "" + "\n" );
                }
                if(players.get(i) instanceof Opuesto) {
                    writer.write("O" + ","+
                    players.get(i).getName() + "," +
                    players.get(i).getCountry() + "," +
                    players.get(i).getErrores() + "," +
                    players.get(i).getAces() + "," +
                    players.get(i).getSaques() + "," +
                    players.get(i).getEfectividad() + "," +
                    "" + "," +
                    "" + "," +
                    "" + "," +
                    ((Opuesto) players.get(i)).getAtaques() + "," +
                    ((Opuesto) players.get(i)).getBloqueos() + "," +
                    ((Opuesto) players.get(i)).getBloqueosnt() + "\n" );
                }
                if(players.get(i) instanceof Auxiliar) {
                    writer.write("A" + ","+
                    players.get(i).getName() + "," +
                    players.get(i).getCountry() + "," +
                    players.get(i).getErrores() + "," +
                    players.get(i).getAces() + "," +
                    players.get(i).getSaques() + "," +
                    players.get(i).getEfectividad() + "," +
                    "" + "," +
                    "" + "," +
                    "" + "," +
                    ((Auxiliar) players.get(i)).getAtaques() + "," +
                    ((Auxiliar) players.get(i)).getBloqueos() + "," +
                    ((Auxiliar) players.get(i)).getBloqueosnt() + "\n");
                }
                
                
            } 
            System.out.println("Datos sobrescritos con éxito en " + CalcHaikyu +"\n");
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ocurrio un error al guardar en " + CalcHaikyu);
            }
            }
    
            else{
                System.out.println("Ingrese una opcion valida");
            }

        }
    }

}
