package damx.ercinoticias.services;

import damx.ercinoticias.dtos.AutorDto;
import damx.ercinoticias.entities.Autor;
import damx.ercinoticias.infos.AutorInfo;
import damx.ercinoticias.mappers.AutorMapper;
import damx.ercinoticias.models.ResponseModel;
import damx.ercinoticias.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private AutorMapper autorMapper;


    public ResponseModel obtenerAutoresPorNombre(String nombre) {
        List<AutorInfo> listaAutores = autorRepository.buscarPorNombre(nombre);
        if(listaAutores.isEmpty()){
            return new ResponseModel(1,"No existen registros",null);
        }
        return new ResponseModel(0,"Registros encontrados",listaAutores);
    }

    public ResponseModel crearAutor(AutorDto autordto) {
        Autor autor = autorMapper.toEntity(autordto);
        autor = autorRepository.save(autor);
        if(autor.getId() != null){
            return new ResponseModel(0,"Autor creado con id: "+autor.getId(),+autor.getId());
        }
        return new ResponseModel(1,"No se pudo realizar el registro",null);
    }

    public ResponseModel actualizarAutor(AutorDto autordto) {
        if(autordto.getId() == null){
            return new ResponseModel(1,"No se pudo realizar la actualización",null);
        }

        Autor autor = autorMapper.toEntity(autordto);
        autor = autorRepository.save(autor);
        if(autor.getId() != null){
            return new ResponseModel(0,"Autor actualizado con id: "+autor.getId(),+autor.getId());
        }
        return new ResponseModel(1,"No se pudo realizar el registro",null);
    }

    public ResponseModel eliminarAutor(AutorDto autordto) {

        if(!autorRepository.existsById(autordto.getId())){
            return new ResponseModel(1,"No existe el usuario indicado",null);
        }

        autorRepository.deleteById(autordto.getId());
        return new ResponseModel(0,"Autor eliminado",null);
    }
}
