package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/pin/pin.create.impex")
public class PinRemoveModel extends HybrisBaseModel {

    private String code;

    public PinRemoveModel(String code) {
        this.code = code;
    }
}
