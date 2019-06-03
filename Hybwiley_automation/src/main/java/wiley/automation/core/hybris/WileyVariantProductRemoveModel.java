package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/product/product.variant.remove.impex")
public class WileyVariantProductRemoveModel extends HybrisBaseModel {

    private String code;

    public WileyVariantProductRemoveModel(String code) {
        this.code = code;
    }
}
