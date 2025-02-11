package damx.ercinoticias.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link damx.ercinoticias.entities.Autor}
 */
public class AutorDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final String email;
    private final String bio;

    public AutorDto(Integer id, String nombre, String email, String bio) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorDto entity = (AutorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.bio, entity.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, bio);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "email = " + email + ", " +
                "bio = " + bio + ")";
    }
}