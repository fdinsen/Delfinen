
package factory;
import datasource.DBFacade;
import datasource.FileHandler;
import datasource.DataSource;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class DataSourceFactory {

        public DataSource getDataSource(DataSources type) {
        if (type == null) {
            return null;
        }
        if (type.equals(DataSources.FILE)) {
            return new FileHandler();

        } else if (type.equals(DataSources.DATABASE)) {
            return new DBFacade();
        }

        return null;
    }
}
