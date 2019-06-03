package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/coupon/coupon.create.impex")
public class SingleCodeCouponCreateBaseModel extends HybrisBaseModel {

    private String couponId;

    @ModelDefaultValue(value = "Autotests coupon 50 RUNTIME")
    private String name;

    @ModelDefaultValue(value = "10")
    private String maxRedemptionsPerCustomer;

    @ModelDefaultValue(value = "100")
    private String maxTotalRedemptions;

    @ModelDefaultValue(value = "true")
    private String active;

    public SingleCodeCouponCreateBaseModel(String couponId) {
        this.couponId = couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxRedemptionsPerCustomer(String maxRedemptionsPerCustomer) {
        this.maxRedemptionsPerCustomer = maxRedemptionsPerCustomer;
    }

    public void setMaxTotalRedemptions(String maxTotalRedemptions) {
        this.maxTotalRedemptions = maxTotalRedemptions;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
