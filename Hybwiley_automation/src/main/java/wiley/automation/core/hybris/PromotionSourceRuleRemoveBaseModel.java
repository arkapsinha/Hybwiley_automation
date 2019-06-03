package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/promotion/promotion.remove.impex")
public class PromotionSourceRuleRemoveBaseModel extends HybrisBaseModel {

    private String code;

    public PromotionSourceRuleRemoveBaseModel(String code) {
        this.code = code;
    }
}
