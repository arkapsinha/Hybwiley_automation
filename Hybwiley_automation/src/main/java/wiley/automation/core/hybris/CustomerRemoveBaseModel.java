package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/customer/customer.remove.impex")
public class CustomerRemoveBaseModel extends HybrisBaseModel {

    private String uid;

    public CustomerRemoveBaseModel(String uid) {
        this.uid = uid;
    }
}
