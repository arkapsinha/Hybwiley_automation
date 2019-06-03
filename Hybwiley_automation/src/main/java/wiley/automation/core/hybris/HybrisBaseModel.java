package wiley.automation.core.hybris;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybrisBaseModel {

    public Map<String, String> getModel(){
        List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());
        Map<String, String> results = new HashMap<>();
        fields.forEach(field -> {
            try {
                field.setAccessible(true);
                if(field.get(this) != null) {
                    results.put(field.getName(), field.get(this).toString());
                }
                else {
                    results.put(field.getName(), field.getAnnotation(ModelDefaultValue.class).value());
                }
                field.setAccessible(false);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return results;
    }

    public String getPathToImpex(){
        return this.getClass().getAnnotation(ModelImpexPath.class).path();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+getModel().toString();
    }
}
