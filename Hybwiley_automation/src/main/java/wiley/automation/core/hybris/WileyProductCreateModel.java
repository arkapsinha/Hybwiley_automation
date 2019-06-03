package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/product/product.create.impex")
public class WileyProductCreateModel extends HybrisBaseModel {

    @ModelDefaultValue(value = "welProductCatalog")
    private String productCatalog;

    @ModelDefaultValue(value = "AUTOMATION_PRE_ORDER_BASE_PRODUCT")
    private String code;

    @ModelDefaultValue(value = "WEL_CMA_PART, WEL_CMA_CATEGORY")
    private String supercategories;

    @ModelDefaultValue(value = "pieces")
    private String unit;

    @ModelDefaultValue(value = "DIGITAL")
    private String editionFormat;

    @ModelDefaultValue(value = "VariantProduct")
    private String variantType;

    @ModelDefaultValue(value = "PRE_ORDER")
    private String lifecycleStatus;

    @ModelDefaultValue(value = "AutoPreOrderBProduct")
    private String name;

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSupercategories(String supercategories) {
        this.supercategories = supercategories;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setEditionFormat(String editionFormat) {
        this.editionFormat = editionFormat;
    }

    public void setVariantType(String variantType) {
        this.variantType = variantType;
    }

    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }

    public void setName(String name) {
        this.name = name;
    }
}
