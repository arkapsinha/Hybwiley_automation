package wiley.automation.core.hybris;

import static com.github.invictum.utils.properties.PropertiesUtil.getProperty;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PropertiesReader {

    private final static Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);

    private static CompositeConfiguration configuration = new CompositeConfiguration();

    static {
        try {
            configuration.addConfiguration(new SystemConfiguration());
            try {
                configuration.addConfiguration(new PropertiesConfiguration(getProperty("include.properties")));
            }
            catch (ConfigurationException configurationException){
                LOG.debug(getProperty("include.properties")+ " is not exist");
            }
            configuration.addConfiguration(new PropertiesConfiguration("common.data.properties"));
        } catch (ConfigurationException e) {
            LOG.error("Error in configuration: ", e);
            throw new RuntimeException(e);
        }
    }

    public static String getEnvironmentSpecificProperty(final String propertyName) {
        return configuration.getString(propertyName);
    }
}