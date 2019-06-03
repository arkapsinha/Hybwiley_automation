package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/promotion/promotion.4.3.activate.impex")
public class PromotionSourceRuleActivateV43BaseModel extends HybrisBaseModel {

    private String rules;

    public PromotionSourceRuleActivateV43BaseModel(String rules) {
        this.rules = rules;
    }
}
