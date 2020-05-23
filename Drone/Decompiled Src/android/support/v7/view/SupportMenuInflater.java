package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SupportMenuInflater extends MenuInflater {
  static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
  
  static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class };
  
  static final String LOG_TAG = "SupportMenuInflater";
  
  static final int NO_ID = 0;
  
  private static final String XML_GROUP = "group";
  
  private static final String XML_ITEM = "item";
  
  private static final String XML_MENU = "menu";
  
  final Object[] mActionProviderConstructorArguments;
  
  final Object[] mActionViewConstructorArguments;
  
  Context mContext;
  
  private Object mRealOwner;
  
  static {
    ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  }
  
  public SupportMenuInflater(Context paramContext) {
    super(paramContext);
    this.mContext = paramContext;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  private Object findRealOwner(Object paramObject) {
    return (!(paramObject instanceof android.app.Activity) && paramObject instanceof ContextWrapper) ? findRealOwner(((ContextWrapper)paramObject).getBaseContext()) : paramObject;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu) throws XmlPullParserException, IOException {
    MenuState menuState = new MenuState(paramMenu);
    int i = paramXmlPullParser.getEventType();
    int j = 0;
    Menu menu = null;
    while (true) {
      if (i == 2) {
        String str = paramXmlPullParser.getName();
        if (str.equals("menu")) {
          i = paramXmlPullParser.next();
        } else {
          throw new RuntimeException("Expecting menu, got " + str);
        } 
      } else {
        int m = paramXmlPullParser.next();
        i = m;
        if (m == 1) {
          i = m;
        } else {
          continue;
        } 
      } 
      boolean bool = false;
      int k = i;
      while (!bool) {
        Menu menu1;
        boolean bool1;
        String str;
        switch (k) {
          default:
            paramMenu = menu;
            bool1 = bool;
            i = j;
            k = paramXmlPullParser.next();
            j = i;
            bool = bool1;
            menu = paramMenu;
            continue;
          case 2:
            i = j;
            bool1 = bool;
            paramMenu = menu;
            if (j == 0) {
              String str1 = paramXmlPullParser.getName();
              if (str1.equals("group")) {
                menuState.readGroup(paramAttributeSet);
                i = j;
                bool1 = bool;
                menu1 = menu;
              } else if (menu1.equals("item")) {
                menuState.readItem(paramAttributeSet);
                i = j;
                bool1 = bool;
                menu1 = menu;
              } else if (menu1.equals("menu")) {
                parseMenu(paramXmlPullParser, paramAttributeSet, (Menu)menuState.addSubMenuItem());
                i = j;
                bool1 = bool;
                menu1 = menu;
              } else {
                i = 1;
                bool1 = bool;
              } 
            } 
            k = paramXmlPullParser.next();
            j = i;
            bool = bool1;
            menu = menu1;
            continue;
          case 3:
            str = paramXmlPullParser.getName();
            if (j != 0 && str.equals(menu)) {
              i = 0;
              menu1 = null;
              bool1 = bool;
            } else if (str.equals("group")) {
              menuState.resetGroup();
              i = j;
              bool1 = bool;
              menu1 = menu;
            } else if (str.equals("item")) {
              i = j;
              bool1 = bool;
              menu1 = menu;
              if (!menuState.hasAddedItem())
                if (menuState.itemActionProvider != null && menuState.itemActionProvider.hasSubMenu()) {
                  menuState.addSubMenuItem();
                  i = j;
                  bool1 = bool;
                  menu1 = menu;
                } else {
                  menuState.addItem();
                  i = j;
                  bool1 = bool;
                  menu1 = menu;
                }  
            } else {
              i = j;
              bool1 = bool;
              menu1 = menu;
              if (str.equals("menu")) {
                bool1 = true;
                i = j;
                menu1 = menu;
              } 
            } 
            k = paramXmlPullParser.next();
            j = i;
            bool = bool1;
            menu = menu1;
            continue;
          case 1:
            break;
        } 
        throw new RuntimeException("Unexpected end of document");
      } 
      return;
    } 
  }
  
  Object getRealOwner() {
    if (this.mRealOwner == null)
      this.mRealOwner = findRealOwner(this.mContext); 
    return this.mRealOwner;
  }
  
  public void inflate(int paramInt, Menu paramMenu) {
    if (!(paramMenu instanceof android.support.v4.internal.view.SupportMenu)) {
      super.inflate(paramInt, paramMenu);
      return;
    } 
    XmlResourceParser xmlResourceParser1 = null;
    XmlResourceParser xmlResourceParser3 = null;
    XmlResourceParser xmlResourceParser2 = null;
    try {
      XmlResourceParser xmlResourceParser = this.mContext.getResources().getLayout(paramInt);
      xmlResourceParser2 = xmlResourceParser;
      xmlResourceParser1 = xmlResourceParser;
      xmlResourceParser3 = xmlResourceParser;
      parseMenu((XmlPullParser)xmlResourceParser, Xml.asAttributeSet((XmlPullParser)xmlResourceParser), paramMenu);
      return;
    } catch (XmlPullParserException xmlPullParserException) {
      xmlResourceParser1 = xmlResourceParser2;
      throw new InflateException("Error inflating menu XML", xmlPullParserException);
    } catch (IOException iOException) {
      xmlResourceParser1 = xmlResourceParser3;
      throw new InflateException("Error inflating menu XML", iOException);
    } finally {
      if (xmlResourceParser1 != null)
        xmlResourceParser1.close(); 
    } 
  }
  
  private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
    private static final Class<?>[] PARAM_TYPES = new Class[] { MenuItem.class };
    
    private Method mMethod;
    
    private Object mRealOwner;
    
    public InflatedOnMenuItemClickListener(Object param1Object, String param1String) {
      this.mRealOwner = param1Object;
      Class<?> clazz = param1Object.getClass();
      try {
        this.mMethod = clazz.getMethod(param1String, PARAM_TYPES);
        return;
      } catch (Exception exception) {
        InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + param1String + " in class " + clazz.getName());
        inflateException.initCause(exception);
        throw inflateException;
      } 
    }
    
    public boolean onMenuItemClick(MenuItem param1MenuItem) {
      try {
        if (this.mMethod.getReturnType() == boolean.class)
          return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[] { param1MenuItem })).booleanValue(); 
        this.mMethod.invoke(this.mRealOwner, new Object[] { param1MenuItem });
        return true;
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      } 
    }
  }
  
  private class MenuState {
    private static final int defaultGroupId = 0;
    
    private static final int defaultItemCategory = 0;
    
    private static final int defaultItemCheckable = 0;
    
    private static final boolean defaultItemChecked = false;
    
    private static final boolean defaultItemEnabled = true;
    
    private static final int defaultItemId = 0;
    
    private static final int defaultItemOrder = 0;
    
    private static final boolean defaultItemVisible = true;
    
    private int groupCategory;
    
    private int groupCheckable;
    
    private boolean groupEnabled;
    
    private int groupId;
    
    private int groupOrder;
    
    private boolean groupVisible;
    
    ActionProvider itemActionProvider;
    
    private String itemActionProviderClassName;
    
    private String itemActionViewClassName;
    
    private int itemActionViewLayout;
    
    private boolean itemAdded;
    
    private char itemAlphabeticShortcut;
    
    private int itemCategoryOrder;
    
    private int itemCheckable;
    
    private boolean itemChecked;
    
    private boolean itemEnabled;
    
    private int itemIconResId;
    
    private int itemId;
    
    private String itemListenerMethodName;
    
    private char itemNumericShortcut;
    
    private int itemShowAsAction;
    
    private CharSequence itemTitle;
    
    private CharSequence itemTitleCondensed;
    
    private boolean itemVisible;
    
    private Menu menu;
    
    public MenuState(Menu param1Menu) {
      this.menu = param1Menu;
      resetGroup();
    }
    
    private char getShortcut(String param1String) {
      return (param1String == null) ? Character.MIN_VALUE : param1String.charAt(0);
    }
    
    private <T> T newInstance(String param1String, Class<?>[] param1ArrayOfClass, Object[] param1ArrayOfObject) {
      try {
        null = SupportMenuInflater.this.mContext.getClassLoader().loadClass(param1String).getConstructor(param1ArrayOfClass);
        null.setAccessible(true);
        return (T)null.newInstance(param1ArrayOfObject);
      } catch (Exception exception) {
        Log.w("SupportMenuInflater", "Cannot instantiate class: " + param1String, exception);
        return null;
      } 
    }
    
    private void setItem(MenuItem param1MenuItem) {
      boolean bool2;
      MenuItem menuItem = param1MenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      if (this.itemCheckable >= 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      menuItem.setCheckable(bool2).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
      if (this.itemShowAsAction >= 0)
        MenuItemCompat.setShowAsAction(param1MenuItem, this.itemShowAsAction); 
      if (this.itemListenerMethodName != null) {
        if (SupportMenuInflater.this.mContext.isRestricted())
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context"); 
        param1MenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
      } 
      if (param1MenuItem instanceof MenuItemImpl)
        MenuItemImpl menuItemImpl = (MenuItemImpl)param1MenuItem; 
      if (this.itemCheckable >= 2)
        if (param1MenuItem instanceof MenuItemImpl) {
          ((MenuItemImpl)param1MenuItem).setExclusiveCheckable(true);
        } else if (param1MenuItem instanceof MenuItemWrapperICS) {
          ((MenuItemWrapperICS)param1MenuItem).setExclusiveCheckable(true);
        }  
      boolean bool1 = false;
      if (this.itemActionViewClassName != null) {
        MenuItemCompat.setActionView(param1MenuItem, newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
        bool1 = true;
      } 
      if (this.itemActionViewLayout > 0)
        if (!bool1) {
          MenuItemCompat.setActionView(param1MenuItem, this.itemActionViewLayout);
        } else {
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }  
      if (this.itemActionProvider != null)
        MenuItemCompat.setActionProvider(param1MenuItem, this.itemActionProvider); 
    }
    
    public void addItem() {
      this.itemAdded = true;
      setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem() {
      this.itemAdded = true;
      SubMenu subMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      setItem(subMenu.getItem());
      return subMenu;
    }
    
    public boolean hasAddedItem() {
      return this.itemAdded;
    }
    
    public void readGroup(AttributeSet param1AttributeSet) {
      TypedArray typedArray = SupportMenuInflater.this.mContext.obtainStyledAttributes(param1AttributeSet, R.styleable.MenuGroup);
      this.groupId = typedArray.getResourceId(R.styleable.MenuGroup_android_id, 0);
      this.groupCategory = typedArray.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
      this.groupOrder = typedArray.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
      this.groupCheckable = typedArray.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
      this.groupVisible = typedArray.getBoolean(R.styleable.MenuGroup_android_visible, true);
      this.groupEnabled = typedArray.getBoolean(R.styleable.MenuGroup_android_enabled, true);
      typedArray.recycle();
    }
    
    public void readItem(AttributeSet param1AttributeSet) {
      boolean bool;
      TypedArray typedArray = SupportMenuInflater.this.mContext.obtainStyledAttributes(param1AttributeSet, R.styleable.MenuItem);
      this.itemId = typedArray.getResourceId(R.styleable.MenuItem_android_id, 0);
      this.itemCategoryOrder = 0xFFFF0000 & typedArray.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) | 0xFFFF & typedArray.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder);
      this.itemTitle = typedArray.getText(R.styleable.MenuItem_android_title);
      this.itemTitleCondensed = typedArray.getText(R.styleable.MenuItem_android_titleCondensed);
      this.itemIconResId = typedArray.getResourceId(R.styleable.MenuItem_android_icon, 0);
      this.itemAlphabeticShortcut = getShortcut(typedArray.getString(R.styleable.MenuItem_android_alphabeticShortcut));
      this.itemNumericShortcut = getShortcut(typedArray.getString(R.styleable.MenuItem_android_numericShortcut));
      if (typedArray.hasValue(R.styleable.MenuItem_android_checkable)) {
        if (typedArray.getBoolean(R.styleable.MenuItem_android_checkable, false)) {
          bool = true;
        } else {
          bool = false;
        } 
        this.itemCheckable = bool;
      } else {
        this.itemCheckable = this.groupCheckable;
      } 
      this.itemChecked = typedArray.getBoolean(R.styleable.MenuItem_android_checked, false);
      this.itemVisible = typedArray.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
      this.itemEnabled = typedArray.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
      this.itemShowAsAction = typedArray.getInt(R.styleable.MenuItem_showAsAction, -1);
      this.itemListenerMethodName = typedArray.getString(R.styleable.MenuItem_android_onClick);
      this.itemActionViewLayout = typedArray.getResourceId(R.styleable.MenuItem_actionLayout, 0);
      this.itemActionViewClassName = typedArray.getString(R.styleable.MenuItem_actionViewClass);
      this.itemActionProviderClassName = typedArray.getString(R.styleable.MenuItem_actionProviderClass);
      if (this.itemActionProviderClassName != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
        this.itemActionProvider = newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
      } else {
        if (bool)
          Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified."); 
        this.itemActionProvider = null;
      } 
      typedArray.recycle();
      this.itemAdded = false;
    }
    
    public void resetGroup() {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\view\SupportMenuInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */