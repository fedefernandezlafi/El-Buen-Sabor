package com.example.elbuensabor.Utilidades;

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

    @Value("Classpath: scripts/ARTICULOINSUMO-INSERT.SQL")
    private Resource resourceArticuloInsumo;

    @Value("Classpath: scripts/ARTICULOMANUFACTURADO-INSERT.SQL")
    private Resource resourceArticuloManufacturado;

    @Value("Classpath: scripts/ROL-INSERT.SQL")
    private Resource resourceRol;

    @Value("Classpath: scripts/USUARIO-INSERT.SQL")
    private Resource resourceUsuario;

    @Value("Classpath: scripts/RUBROARTICULO-INSERT.SQL")
    private Resource resourceRubroArticulo;

    @Value("Classpath: scripts/RUBROGENERAL-INSERT.SQL")
    private Resource resourceRubroGeneral;

    @Override
    public void run(String... args) throws Exception {

        //cargarRol();
        //cargarUsuario();
        //cargarRubroGeneral();
        //cargarRubroArticulo();
        //cargarArticuloInsumo();
        //cargarArticuloManufacturado();

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
            readScript.dataSourceInitializer(resourceUsuario);
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
