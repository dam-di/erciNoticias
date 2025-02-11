package damx.ercinoticias.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "etiqueta")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('etiqueta_id_etiqueta_seq')")
    @Column(name = "id_etiqueta", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToMany
    @JoinTable(name = "noticiaetiqueta",
            joinColumns = @JoinColumn(name = "id_etiqueta"),
            inverseJoinColumns = @JoinColumn(name = "id_noticia"))
    private Set<Noticia> noticias = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(Set<Noticia> noticias) {
        this.noticias = noticias;
    }

}