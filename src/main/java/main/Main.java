package main;

import datasource.DataSource;
import factory.DataSourceFactory;
import factory.DataSources;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class Main {
    DataSourceFactory dataSourceFactory = new DataSourceFactory();
    DataSource dataSource = dataSourceFactory.getDataSource(DataSources.DATABASE);
}
