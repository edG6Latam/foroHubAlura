package com.foroAlura.foroAlura.domain.model.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topicos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name ="fecha_creacion" )
    private String fechaCreacion;
    @Enumerated
    @Column(name = "estado")
    private Status status;
    private String autor;
    private String curso;
    private String respuesta;

    public Topico(DatosTopico datosTopico) {
        this.titulo= datosTopico.título();
        this.mensaje=datosTopico.mensaje();
        this.fechaCreacion= datosTopico.fechaCreacion();
        this.status=datosTopico.status();
        this.autor= datosTopico.autor();
        this.curso= datosTopico.curso();
        this.respuesta= datosTopico.respuesta();
    }

    public void actualizar(DatosActualizarTopico datosActualizar) {
        if(datosActualizar.título()!=null){
            this.titulo=datosActualizar.título();
        }
        if(datosActualizar.mensaje()!=null){
            this.titulo=datosActualizar.título();
        }if(datosActualizar.fechaCreacion()!=null){
            this.fechaCreacion=datosActualizar.fechaCreacion();
        }if(datosActualizar.status()!=null){
            this.status=datosActualizar.status();
        }if(datosActualizar.autor()!=null){
            this.autor=datosActualizar.autor();
        }if(datosActualizar.curso()!=null){
            this.curso=datosActualizar.curso();
        }
        if(datosActualizar.respuesta()!=null){
            this.respuesta= datosActualizar.respuesta();
        }
    }
}
