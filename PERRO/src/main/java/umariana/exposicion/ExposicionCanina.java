package umariana.exposicion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author JOSE CABRERA - SAMUEL BETANCOURT
 */
public class ExposicionCanina {
        ArrayList<Perro> misPerros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args) {
        
        ExposicionCanina p = new ExposicionCanina();
        p.mostrarMenu();
    }
    
    public void mostrarMenu(){
        boolean activa = true;

        do {
            System.out.println(" ___________________________________");
            System.out.println("|        EXPOSICION CANINA          |");
            System.out.println("|___________________________________|");
            System.out.println("|        1. AGREGAR PERRO           |");
            System.out.println("|___________________________________|");
            System.out.println("|  2. LISTA DE PERROS INSCRITOS     |");
            System.out.println("|___________________________________|");
            System.out.println("|  3. LOCALIZAR PERRO POR NOMBRE    |");
            System.out.println("|___________________________________|");
            System.out.println("|     4. BUSCAR PERRO GANADOR       |");
            System.out.println("|___________________________________|");
            System.out.println("| 5. BUSCAR PERRO CON MENOR PUNTAJE |");
            System.out.println("|___________________________________|");
            System.out.println("|   6. BUSCAR PERRO CON MAS AÑOS    |");
            System.out.println("|___________________________________|");
            System.out.println("|            7. SALIR               |");
            System.out.println("|___________________________________|");
            
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    try {
                        agregarPerro();
                    }catch(NombreDuplicadoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("ORDENAR LISTA POR:");
                    System.out.println("1. POR EDAD");
                    System.out.println("2. POR PUNTOS");

                    int opcion2 = sc.nextInt();
                    switch(opcion2){
                        case 1:
                            listaPorEdad();
                            break;
                        case 2:
                            listaPorPuntos();
                            break;
                }
                    break;
                case 3:
                    localizarPerro();
                    break;
                case 4:
                    perroGanador();
                    break;
                case 5:
                    perroMenorPuntaje();
                    break;
                case 6:
                    perroMayorEdad();
                    break;
                case 7:
                    activa = false;
                    System.out.println("PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
            }
        }while (activa);
    }
    
    public void agregarPerro() throws NombreDuplicadoException{
        System.out.println("DIGITE NOMBRE DEL PERRO");
        String nombre = sc.next();
        if(!misPerros.isEmpty()){
         for(Perro p : misPerros)   
         {
          if(p.getNombre().equalsIgnoreCase(nombre)) 
          {
              throw new NombreDuplicadoException();
          }
         }
        }
        System.out.println("INGRESAR RAZA");
        String raza = sc.next();
        System.out.println("INGRESAR EDAD");
        int edad = sc.nextInt();
        System.out.println("INGRESAR PUNTOS");
        int puntos = sc.nextInt();
        System.out.println("INGRESAR FOTO");
        String foto = sc.next();
        
        Perro nuevoPerro = new Perro(nombre, edad, puntos, raza, foto);
        misPerros.add(nuevoPerro);
    }
    
    public void listaPorEdad(){
        for (int i = 0; i < misPerros.size() - 1; i++)
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                
                if(p1.getEdad() > p2.getEdad()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p2);    
                }
            }
        System.out.println("LISTA ORDENADA POR EDAD");
        for (Perro a : misPerros) {
            System.out.println("NOMBRE: " + a.getNombre());
            System.out.println("EDAD: " + a.getEdad());
            System.out.println("RAZA: " + a.getRaza());
            System.out.println("PUNTOS: " + a.getPuntos());
            System.out.println("FOTO: " + a.getFoto());
        }
    }
    
    public void listaPorPuntos(){
        for (int i = 0; i < misPerros.size() - 1; i++)
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                
                if(p1.getPuntos() > p2.getPuntos()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p2);    
                }
            }
        System.out.println("LISTA ORDENADA POR PUNTOS");
        for (Perro b : misPerros) {
            System.out.println("NOMBRE: " + b.getNombre());
            System.out.println("EDAD: " + b.getEdad());
            System.out.println("RAZA: " + b.getRaza());
            System.out.println("PUNTOS: " + b.getPuntos());
            System.out.println("FOTO: " + b.getFoto());
        }
    }
    
    public void localizarPerro(){
        boolean perroEncontrado = false;
        System.out.println("DIGITE NOMBRE DEL PERRO");
        String nombreB = sc.next();
        
        for(Perro p : misPerros){
            if(p.getNombre().equals(nombreB)){
            System.out.println("NOMBRE: " + p.getNombre());
            System.out.println("EDAD: " + p.getEdad());
            System.out.println("RAZA: " + p.getRaza());
            System.out.println("PUNTOS: " + p.getPuntos());
            System.out.println("FOTO: " + p.getFoto());
                
                perroEncontrado = true;
            }
        }
        
    }
    
    public void perroGanador(){
        System.out.println("EL PERRO GANADOR FUE");
        for(int i = 0; i < misPerros.size()-1; i++){
            for(int j = i + 1; j < misPerros.size(); j++){
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                if(p1.getPuntos() < p2.getPuntos()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p1);
                }
            }
        }
        
        Perro mayorp = misPerros.get(0);
        System.out.println("NOMBRE: " + mayorp.getNombre());
        System.out.println("CON " + mayorp.getPuntos() + " PUNTOS");
        System.out.println("FOTO: " + mayorp.getFoto());
    }
    
    public void perroMenorPuntaje(){
        System.out.println("EL PERRO CON MENOR PUNTAJE FUE");
        for(int i = 0; i < misPerros.size()-1; i++){
            for(int j = i + 1; j < misPerros.size(); j++){
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                if(p1.getPuntos() > p2.getPuntos()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p1);
                }
            }
        }
        
        Perro menorp = misPerros.get(0);
        System.out.println("NOMBRE: " + menorp.getNombre());
        System.out.println("CON " + menorp.getPuntos() + " PUNTOS");
        System.out.println("FOTO: " + menorp.getFoto());
    }
    
    public void perroMayorEdad(){
       System.out.println("EL PERRO CON MAYOR EDAD ES");
        for(int i = 0; i < misPerros.size()-1; i++){
            for(int j = i + 1; j < misPerros.size(); j++){
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                if(p1.getEdad() < p2.getEdad()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p1);
                }
            }
        }
        
        Perro mayore = misPerros.get(0);
        System.out.println("NOMBRE : " + mayore.getNombre());
        System.out.println("CON " + mayore.getEdad() + " AÑOS");
        System.out.println("FOTO: " + mayore.getFoto());
    }
}