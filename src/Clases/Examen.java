package Clases;

import java.util.Date;

public class Examen {

    @Override
    public String toString() {
        return "Examen{" + "nombreModulo=" + nombreModulo + ", fecha=" + fecha + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Examen other = (Examen) obj;
        if ((this.nombreModulo == null) ? (other.nombreModulo != null) : !this.nombreModulo.equals(other.nombreModulo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.nombreModulo != null ? this.nombreModulo.hashCode() : 0);
        return hash;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }
    private String nombreModulo;
    private Date fecha;
    
    public Examen(String nombreModulo, Date fecha){
        this.nombreModulo = nombreModulo;
        this.fecha = fecha;
    }
    
    
}