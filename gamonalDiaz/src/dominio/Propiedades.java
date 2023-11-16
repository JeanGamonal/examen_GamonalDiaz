
package dominio;

public class Propiedades {
    private int id;
    private String nombre;
    private String direccion;
    private boolean activo;
    private String caracteristicas;
    private String estado;
    private float alquiler;
    private String created_at;
    private String updated_at;

    public Propiedades(int id, String nombre, String direccion, boolean activo, String caracteristicas, String estado, float alquiler, String created_at, String updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.activo = activo;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
        this.alquiler = alquiler;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Propiedades() {
        
    }
    
    public Propiedades(int aInt, String string, boolean aBoolean, String string1, String string2, float aFloat, String string3, String string4) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(float alquiler) {
        this.alquiler = alquiler;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Propiedades{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", activo=" + activo + ", caracteristicas=" + caracteristicas + ", estado=" + estado + ", alquiler=" + alquiler + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
    
}
