package com.rest.java_spring_rest.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> buscarUsuario() {
        List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/cadastrar", produces = "application/json")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {

        Usuario usuarioCadastro = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuarioCadastro, HttpStatus.OK);

    }
}
