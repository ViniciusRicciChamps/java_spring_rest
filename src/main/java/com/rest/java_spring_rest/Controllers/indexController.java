package com.rest.java_spring_rest.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.java_spring_rest.Model.Usuario;
import com.rest.java_spring_rest.Repository.UsuarioRepository;

@RestController
@RequestMapping(value = "usuario")
public class indexController {

    @Autowired /* se fosse CDI seria @Inject */
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id){
        Optional<Usuario> usuario =  usuarioRepository.findById(id);
        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> usuario(){
        List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    /* ************ Passando parametro na requisição
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity init(@RequestParam(value = "nome", defaultValue = "null") String nome){
        System.out.println(nome);
        return new ResponseEntity("seu nome é " + nome, HttpStatus.OK);
    }
    
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> iEntity(){

        /*inserindo dados manualmente
        Usuario usuario = new Usuario();
        usuario.setId(152L);
        usuario.setLogin("vini@ricci");
        usuario.setSenha("12345");
        usuario.setNome("Vinicius Costa Ricci");

        Usuario usuario2 = new Usuario();
        usuario2.setId(15L);
        usuario2.setLogin("davi@ricci");
        usuario2.setSenha("87896");
        usuario2.setNome("Davi Ricci");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario2);
        usuarios.add(usuario);
        
        return new ResponseEntity(usuarios, HttpStatus.OK);
        
    }*/
}
