package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/product/product.remove.impex")
public class WileyProductRemoveModel extends HybrisBaseModel {

    private String code;

    public WileyProductRemoveModel(String code) {
        this.code = code;
    }
}
