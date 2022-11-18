package com.rest.java_spring_rest.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    //RETORNA O USUARIO DE ACORDO COM O ID FORNECIDO
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }

    //RETORNA TODOS O USUARIOS ENCONTRADOS DA BASE DE DADOS
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> buscarUsuario() {
        List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    //CADASTRA UM USUARIO FORNECENDO DADOS PELO CORPO DA REQUISIÇÃO
    @PostMapping(value = "/cadastrar", produces = "application/json")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCadastro = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuarioCadastro, HttpStatus.OK);

    }

    @PutMapping(value = "/alterar", produces = "application/json" )
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioAlterar = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioAlterar, HttpStatus.OK);
	}

    @DeleteMapping(value = "/deletar/{id}", produces = "application/text")
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable(value= "id") long id) {
        usuarioRepository.deleteById(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
}
