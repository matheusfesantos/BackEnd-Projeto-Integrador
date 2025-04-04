package com.example.overclockAPI.services;

import com.example.overclockAPI.entitys.Usuario;
import com.example.overclockAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

   public ResponseEntity<Usuario> buscarPorId(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            return ResponseEntity.ok(usuarioOptional.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
   }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public boolean deletarUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
            return true;
        }
        return false;
    }
}
