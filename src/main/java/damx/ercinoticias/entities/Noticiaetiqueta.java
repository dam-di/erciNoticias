package damx.ercinoticias.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "noticiaetiqueta")
public class Noticiaetiqueta {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_noticia", nullable = false)
    private Noticia idNoticia;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_etiqueta", nullable = false)
    private Etiqueta idEtiqueta;

    public Noticia getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Noticia idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Etiqueta getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Etiqueta idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

}