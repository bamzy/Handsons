package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.FIELD})
public @interface ColorInt {}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\annotation\ColorInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */