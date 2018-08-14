package modelo.dto;

/**
 *
 * @author Ricardo Camacho
 */
public class RolDTO {
    private int id;
    private String nombreRol;
    private boolean estatus;

    public RolDTO(){}

    public RolDTO(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
}
