package modelo.dto;

import java.sql.Date;

/**
 *
 * @author Ricardo Camacho
 */
public class UsuarioDTO {
    private int id;
    private String email;
    private String password;
    private Date fechaIngreso;
    private boolean estatus;

   private PermisoDTO idPermiso;

    public UsuarioDTO(){}

    public UsuarioDTO(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public PermisoDTO getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(PermisoDTO idPermiso) {
        this.idPermiso = idPermiso;
    }
	
}
