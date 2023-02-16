package com.example.elbuensabor.Utilidades;

import com.example.elbuensabor.Entidades.Usuario;
import com.example.elbuensabor.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@Component
public class DataSeed implements CommandLineRunner {


    @Autowired
    private ArticuloInsumoRepositorio articuloInsumoRepositorio;
    @Autowired
    private ArticuloManufacturadoRepositorio articuloManufacturadoRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RubroArticuloRepositorio rubroArticuloRepositorio;

    @Autowired
    private RubroGeneralRepositorio rubroGeneralRepositorio;

    @Autowired
    private ReadScript readScript;



    @Value("classpath:scripts/articuloinsumo.sql")
    private Resource resourceArticuloInsumo;

    @Value("classpath:scripts/articulomanufacturado.sql")
    private Resource resourceArticuloManufacturado;

    @Value("classpath:scripts/rol.sql")
    private Resource resourceRol;

    @Value("classpath:scripts/usuario.sql")
    private Resource resourceUsuario;

    @Value("classpath:scripts/rubroarticulo.sql")
    private Resource resourceRubroArticulo;

    @Value("classpath:scripts/rubrogeneral.sql")
    private Resource resourceRubroGeneral;

    @Override
    public void run(String... args) throws Exception {

        cargarRol();
        cargarUsuario();
        cargarRubroGeneral();
        cargarRubroArticulo();
        cargarArticuloInsumo();
        cargarArticuloManufacturado();

    }

    private void cargarArticuloInsumo() throws Exception {

        if(articuloInsumoRepositorio.count()== 0){
            readScript.dataSourceInitializer(resourceArticuloInsumo);
        }

    }

    private void cargarArticuloManufacturado() throws Exception {

        if(articuloManufacturadoRepositorio.count()== 0){
            readScript.dataSourceInitializer(resourceArticuloManufacturado);
        }

    }
    private void cargarRol() throws Exception {

        if(rolRepositorio.count()== 0){
            readScript.dataSourceInitializer(resourceRol);
        }

    }
    private void cargarUsuario() throws Exception {

        if(usuarioRepositorio.count()== 0){
            Usuario usuario = Usuario.builder()
                    .usuario("admin")
                    .clave("admin")
                    .rol(rolRepositorio.getRolById(1l))
                    .build();
            usuarioRepositorio.save(usuario);
            Usuario usuario2 = Usuario.builder()
                    .usuario("cocinero")
                    .clave("cocinero")
                    .rol(rolRepositorio.getRolById(2l))
                    .build();
            usuarioRepositorio.save(usuario2);
            Usuario usuario3 = Usuario.builder()
                    .usuario("cliente")
                    .clave("cliente")
                    .rol(rolRepositorio.getRolById(3l))
                    .build();
            usuarioRepositorio.save(usuario3);
            Usuario usuario4 = Usuario.builder()
                    .usuario("cajero")
                    .clave("cajero")
                    .rol(rolRepositorio.getRolById(4l))
                    .build();
            usuarioRepositorio.save(usuario4);
        }
    }
    private void cargarRubroArticulo() throws Exception {

        if(rubroArticuloRepositorio.count()== 0){
            readScript.dataSourceInitializer(resourceRubroArticulo);
        }

    }
    private void cargarRubroGeneral() throws Exception {

        if(rubroGeneralRepositorio.count()== 0){
            readScript.dataSourceInitializer(resourceRubroGeneral);
        }

    }

}
