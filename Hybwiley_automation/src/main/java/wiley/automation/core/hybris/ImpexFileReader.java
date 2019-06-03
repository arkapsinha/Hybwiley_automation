package wiley.automation.core.hybris;

import wiley.automation.core.impex.ImpexFormatter;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

public class ImpexFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(ImpexFileReader.class);

    static String read(InputStream inputStream, Map<String, String> model) {
        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, "UTF-8");
            String content = writer.toString();

            LOG.debug("Loaded impex template: {}", content);

            for(Map.Entry<String, String> entry : model.entrySet()) {
                content = content.replace("{{" + entry.getKey() + "}}", entry.getValue());
            }

            LOG.debug("Impex string to import: {}", content);
            return content;
        } catch (IOException var8) {
            throw new IllegalStateException("Impex file not found");
        }
    }
}
