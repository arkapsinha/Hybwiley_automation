package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.HybrisRequestor;
import wiley.automation.core.impex.ImpexFormatter;
import wiley.automation.core.impex.ImpexImporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Hybriser {

    private static Hybriser _instance = null;
    private final static Logger LOG = LoggerFactory.getLogger(Hybriser.class);
    public static Hybriser getInstance(){
        if(_instance == null) _instance = new Hybriser();
        return _instance;
    }

    public void runImport (HybrisBaseModel model){
        LOG.info("Start impex model import ["+model.toString()+"]");
        String finalStr = ImpexFileReader.read(getClass().getResourceAsStream(model.getPathToImpex()), model.getModel());
        HybrisRequestor.runImport(finalStr);
    }

    public void runImport (HybrisBaseModel ... models){
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.asList(models).forEach(model ->
            {
                LOG.info("Start impex model import ["+model.toString()+"]");
                stringBuffer.append(ImpexFileReader.read(getClass().getResourceAsStream(model.getPathToImpex()), model.getModel())).append("\n");
            }
        );
        HybrisRequestor.runImport(stringBuffer.toString());
    }

    public void runScripting(HybrisBaseModel model, int repeatCount){
        LOG.info("Start run model scripting ["+model.toString()+"]");
        String finalStr = ImpexFileReader.read(getClass().getResourceAsStream(model.getPathToImpex()), model.getModel());
        HybrisRequestor.runScripting(finalStr, repeatCount);
    }

    public void runScripting(HybrisBaseModel model){
        runScripting(model, 1);
    }
}
