package com.foroAlura.foroAlura.controlle;

import com.foroAlura.foroAlura.domain.model.topico.DatosActualizarTopico;
import com.foroAlura.foroAlura.domain.model.topico.DatosMostrar;
import com.foroAlura.foroAlura.domain.model.topico.DatosTopico;
import com.foroAlura.foroAlura.domain.model.topico.Topico;
import com.foroAlura.foroAlura.domain.repository.RepositoryTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    private RepositoryTopico repositoryTopico;
    public TopicoController(RepositoryTopico repositoryTopico) {
        this.repositoryTopico = repositoryTopico;
    }


    @GetMapping("/prueba")
    public void prueba(@RequestBody @Valid DatosTopico datosTopico){
        System.out.println(datosTopico);
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        var topico = repositoryTopico.getReferenceById(id);
        return ResponseEntity.ok(new DatosMostrar(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus(),
                topico.getCurso(),topico.getRespuesta()));
    }
    @GetMapping("/mostrar")
    public List<Topico> mostrar(){
        return repositoryTopico.findAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<DatosMostrar> crear(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
        var topico=repositoryTopico.save(new Topico(datosTopico));
        URI url=uriComponentsBuilder.path("/topico/unidad/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosMostrar(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus(),
                topico.getCurso(),topico.getRespuesta()));
    }

    @PutMapping("/actualizar/{id}")
    @Transactional
    public ResponseEntity<DatosMostrar> actualizar(@PathVariable Long id,@RequestBody @Valid DatosActualizarTopico datosActualizar){
        var topico= repositoryTopico.getReferenceById(id);
        topico.actualizar(datosActualizar);
        return ResponseEntity.ok(new DatosMostrar(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus(),
                topico.getCurso(),topico.getRespuesta()));
    }

    @DeleteMapping("/borrar/{id}")
    @Transactional
    public ResponseEntity borrar(@PathVariable Long id){
        var topico= repositoryTopico.getReferenceById(id);
        repositoryTopico.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
