package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface StringDef {
  String[] value() default {};
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\annotation\StringDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */