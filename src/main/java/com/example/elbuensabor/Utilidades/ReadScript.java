package com.example.elbuensabor.Utilidades;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ReadScript {


    @Autowired
    private DataSource dataSource;
    public void dataSourceInitializer(Resource data) {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(databasePopulator(data));
        dataSourceInitializer.afterPropertiesSet();
    }

    private DatabasePopulator databasePopulator(Resource data) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(data);
        return populator;
    }

}
