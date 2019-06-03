package wiley.automation.core.impex;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

public class ImpexFormatter {
    private static final Logger LOG = LoggerFactory.getLogger(ImpexFormatter.class);

    private ImpexFormatter() {
    }

    @Deprecated
    public static String formatImpex(File impex, String... params) {
        try {
            String e = FileUtils.readFileToString(impex, "UTF-8");
            LOG.debug("Loaded impex template: {}", e);
            int index = 1;
            String[] var4 = params;
            int var5 = params.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String param = var4[var6];
                e = e.replace("{" + index + "}", param);
                ++index;
            }

            LOG.debug("Impex string to import: {}", e);
            return e;
        } catch (IOException var8) {
            throw new IllegalStateException("Impex file not found");
        }
    }

    @Deprecated
    public static String formatImpex(InputStream inputStream, Map<String, String> model) {
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