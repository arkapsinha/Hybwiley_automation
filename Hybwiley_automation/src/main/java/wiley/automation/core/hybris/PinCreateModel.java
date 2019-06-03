package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/pin/pin.create.impex")
public class PinCreateModel extends HybrisBaseModel {

    private String code;

    private String productCode;

    public PinCreateModel(String code, String productCode) {
        this.code = code;
        this.productCode = productCode;
    }
}
