package umariana.exposicion;

public class Perro {
    
    private String nombre;
    private String raza;
    private int edad;
    private int puntos;
    private String foto;

    public Perro(String nombre, int edad, int puntos, String raza, String foto) {
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = puntos;
        this.raza = raza;
        this.foto = foto;
    }

    public Perro() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}