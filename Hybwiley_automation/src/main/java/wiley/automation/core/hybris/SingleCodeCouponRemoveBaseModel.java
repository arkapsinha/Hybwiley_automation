package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/coupon/coupon.remove.impex")
public class SingleCodeCouponRemoveBaseModel extends HybrisBaseModel {

    private String couponId;

    public SingleCodeCouponRemoveBaseModel(String couponId) {
        this.couponId = couponId;
    }
}
