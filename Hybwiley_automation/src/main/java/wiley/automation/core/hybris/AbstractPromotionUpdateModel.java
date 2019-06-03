package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/promotion/abstractPromotion.update.impex")
public class AbstractPromotionUpdateModel extends HybrisBaseModel {

    @ModelDefaultValue(value = "welPromoGrp")
    private String promotionGroup;

    @ModelDefaultValue(value = "false")
    private String enabled;

    public void setPromotionGroup(String promotionGroup) {
        this.promotionGroup = promotionGroup;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
