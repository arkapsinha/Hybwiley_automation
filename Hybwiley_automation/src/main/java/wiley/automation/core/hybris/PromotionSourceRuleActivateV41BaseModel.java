package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/promotion/promotion.4.1.activate.impex")
public class PromotionSourceRuleActivateV41BaseModel extends HybrisBaseModel {

    private String rules;

    public PromotionSourceRuleActivateV41BaseModel(String rules) {
        this.rules = rules;
    }
}
