package modelo.dto;

/**
 *
 * @author Ricardo Camacho
 */
public class PermisoDTO {

    private int id;
    private boolean estatus;

    private int usuarios;
    private int medicos;
    private int pacientes;
    private int citas;
    private int recetas;
    private int medicamentos;
    private int venta;
    private int proveedores;
    private int sucursales;
    private int almacen;
    private int compra;
    private int idUsuario;
    

    private RolDTO idRol;

    public PermisoDTO() {
    }

    public PermisoDTO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public int getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }

    public int getMedicos() {
        return medicos;
    }

    public void setMedicos(int medicos) {
        this.medicos = medicos;
    }

    public int getPacientes() {
        return pacientes;
    }

    public void setPacientes(int pacientes) {
        this.pacientes = pacientes;
    }

    public int getCitas() {
        return citas;
    }

    public void setCitas(int citas) {
        this.citas = citas;
    }

    public int getRecetas() {
        return recetas;
    }

    public void setRecetas(int recetas) {
        this.recetas = recetas;
    }

    public int getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(int medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getProveedores() {
        return proveedores;
    }

    public void setProveedores(int proveedores) {
        this.proveedores = proveedores;
    }

    public int getSucursales() {
        return sucursales;
    }

    public void setSucursales(int sucursales) {
        this.sucursales = sucursales;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RolDTO getIdRol() {
        return idRol;
    }

    public void setIdRol(RolDTO idRol) {
        this.idRol = idRol;
    }

}
