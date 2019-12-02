package main;

import Controllers.Controller;
import datasource.DataSource;
import factory.DataSourceFactory;
import factory.DataSources;
import ui.console.MainConsoleUI;
import ui.console.UI;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class Main {

    public static void main(String[] args) {

        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        DataSource dataSource = dataSourceFactory.getDataSource(DataSources.DATABASE);
        MainConsoleUI ui = new MainConsoleUI(dataSource);
        Controller controller = ui.selectUser();
        ui.setController(controller);
        ui.startUI(controller);

    }

}
