package com.rest.java_spring_rest.Model;

import java.io.Serializable;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone", allocationSize = 1, initialValue = 1)
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_telefone")
    private Long id;

    private String numero;

    // MUITOS PARA UM, MUITOS TELEFONES PARA UM USUARIO
    @ManyToOne
    @JoinColumn(foreignKey =  @ForeignKey(name = "id_usuario_FK"))
    private Usuario usuario_fk;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
