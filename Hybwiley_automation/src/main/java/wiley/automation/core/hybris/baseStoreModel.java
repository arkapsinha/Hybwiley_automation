package wiley.automation.core.hybris;


import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/baseStore/baseStore.update.impex")
public class baseStoreModel extends HybrisBaseModel {

    @ModelDefaultValue(value = "wel")
    private String uid;

    @ModelDefaultValue(value = "true")
    private String captchacheckenabled;

    public baseStoreModel(Boolean captchacheckenabled) {
        this.captchacheckenabled = String.valueOf(captchacheckenabled);
    }
}

