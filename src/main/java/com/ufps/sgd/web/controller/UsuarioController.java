package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.dto.AuthenticationRequest;
import com.ufps.sgd.domain.dto.AuthenticationResponse;
import com.ufps.sgd.domain.service.UsuarioService;
import com.ufps.sgd.persistence.entity.Mensaje;
import com.ufps.sgd.persistence.entity.Usuario;
import com.ufps.sgd.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return this.usuarioService.findById(id);
    }

    @GetMapping
    public List<Usuario> listar() {
        return this.usuarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Usuario usuario) {
        Map<String, Object> response = new HashMap<>();
        Usuario u = this.usuarioService.findByAlias(usuario.getAlias());
        if (u == null) {
            this.usuarioService.save(usuario);
            response.put("mensaje", "usuario creado correctamente");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        } else {
            response.put("mensaje", "el alias del usuario: " + usuario.getAlias() + " no esta disponible");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        this.usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void eliminar(@PathVariable Long id) {
        this.usuarioService.deleteById(id);
    }

    @GetMapping("/{id}/mensajes/remitente")
    public List<Mensaje> buscarMensajesPorRemitente(@PathVariable Long id) {
        return this.usuarioService.findByRemitente(id);
    }

    @GetMapping("/{id}/mensajes/receptor")
    public List<Mensaje> buscarMensajesPorReceptor(@PathVariable Long id) {
        return this.usuarioService.findByReceptor(id);
    }

    @PostMapping("/{idUsuario}/rol/{idRol}")
    public void agregarRol(@PathVariable Long idUsuario, @PathVariable Long idRol) {
        this.usuarioService.agregarRol(idUsuario, idRol);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        try {
            request.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = usuarioService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
