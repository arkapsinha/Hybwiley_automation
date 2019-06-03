package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/price/price.create.impex")
public class PriceRowCreateModel extends HybrisBaseModel {

    private String productId;

    @ModelDefaultValue(value = "pieces")
    private String unit;

    @ModelDefaultValue(value = "USD")
    private String currency;

    @ModelDefaultValue(value = "50")
    private String price;

    @ModelDefaultValue(value = "1")
    private String minqtd;

    @ModelDefaultValue(value = "1")
    private String unitFactor;

    @ModelDefaultValue(value = "true")
    private String net;

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setMinqtd(String minqtd) {
        this.minqtd = minqtd;
    }

    public void setUnitFactor(String unitFactor) {
        this.unitFactor = unitFactor;
    }

    public void setNet(String net) {
        this.net = net;
    }
}
