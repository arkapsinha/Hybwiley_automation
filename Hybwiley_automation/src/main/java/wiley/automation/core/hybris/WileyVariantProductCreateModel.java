package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/product/product.variant.create.impex")
public class WileyVariantProductCreateModel  extends HybrisBaseModel {

    @ModelDefaultValue(value = "welProductCatalog")
    private String productCatalog;

    @ModelDefaultValue(value = "AUTOMATION_PRE_ORDER_VARIANT_PRODUCT_DIG")
    private String code;

    @ModelDefaultValue(value = "AUTOMATION_PRE_ORDER_BASE_PRODUCT")
    private String baseProduct;

    @ModelDefaultValue(value = "WEL_CMA_TYPE_EBOOK")
    private String supercategories;

    @ModelDefaultValue(value = "pieces")
    private String unit;

    @ModelDefaultValue(value = "DIGITAL")
    private String editionFormat;

    @ModelDefaultValue(value = "1003806")
    private String isbn;

    @ModelDefaultValue(value = "AutoPreOrderVProductDig")
    private String name;

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBaseProduct(String baseProduct) {
        this.baseProduct = baseProduct;
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }
}
