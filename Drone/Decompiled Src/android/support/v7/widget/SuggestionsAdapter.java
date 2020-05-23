package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
  private static final boolean DBG = false;
  
  static final int INVALID_INDEX = -1;
  
  private static final String LOG_TAG = "SuggestionsAdapter";
  
  private static final int QUERY_LIMIT = 50;
  
  static final int REFINE_ALL = 2;
  
  static final int REFINE_BY_ENTRY = 1;
  
  static final int REFINE_NONE = 0;
  
  private boolean mClosed = false;
  
  private final int mCommitIconResId;
  
  private int mFlagsCol = -1;
  
  private int mIconName1Col = -1;
  
  private int mIconName2Col = -1;
  
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
  
  private final Context mProviderContext;
  
  private int mQueryRefinement = 1;
  
  private final SearchManager mSearchManager = (SearchManager)this.mContext.getSystemService("search");
  
  private final SearchView mSearchView;
  
  private final SearchableInfo mSearchable;
  
  private int mText1Col = -1;
  
  private int mText2Col = -1;
  
  private int mText2UrlCol = -1;
  
  private ColorStateList mUrlColor;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap) {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.mSearchView = paramSearchView;
    this.mSearchable = paramSearchableInfo;
    this.mCommitIconResId = paramSearchView.getSuggestionCommitIconResId();
    this.mProviderContext = paramContext;
    this.mOutsideDrawablesCache = paramWeakHashMap;
  }
  
  private Drawable checkIconCache(String paramString) {
    Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(paramString);
    return (constantState == null) ? null : constantState.newDrawable();
  }
  
  private CharSequence formatUrl(CharSequence paramCharSequence) {
    if (this.mUrlColor == null) {
      TypedValue typedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
      this.mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
    } 
    SpannableString spannableString = new SpannableString(paramCharSequence);
    spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, paramCharSequence.length(), 33);
    return (CharSequence)spannableString;
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName) {
    int i;
    ActivityInfo activityInfo;
    PackageManager packageManager = this.mContext.getPackageManager();
    try {
      activityInfo = packageManager.getActivityInfo(paramComponentName, 128);
      i = activityInfo.getIconResource();
      if (i == 0)
        return null; 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.w("SuggestionsAdapter", nameNotFoundException.toString());
      return null;
    } 
    Drawable drawable2 = packageManager.getDrawable(nameNotFoundException.getPackageName(), i, activityInfo.applicationInfo);
    Drawable drawable1 = drawable2;
    if (drawable2 == null) {
      Log.w("SuggestionsAdapter", "Invalid icon resource " + i + " for " + nameNotFoundException.flattenToShortString());
      return null;
    } 
    return drawable1;
  }
  
  private Drawable getActivityIconWithCache(ComponentName paramComponentName) {
    String str = paramComponentName.flattenToShortString();
    if (this.mOutsideDrawablesCache.containsKey(str)) {
      constantState = this.mOutsideDrawablesCache.get(str);
      return (constantState == null) ? null : constantState.newDrawable(this.mProviderContext.getResources());
    } 
    Drawable drawable = getActivityIcon((ComponentName)constantState);
    if (drawable == null) {
      constantState = null;
      this.mOutsideDrawablesCache.put(str, constantState);
      return drawable;
    } 
    Drawable.ConstantState constantState = drawable.getConstantState();
    this.mOutsideDrawablesCache.put(str, constantState);
    return drawable;
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString) {
    return getStringOrNull(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private Drawable getDefaultIcon1(Cursor paramCursor) {
    Drawable drawable = getActivityIconWithCache(this.mSearchable.getSearchActivity());
    return (drawable != null) ? drawable : this.mContext.getPackageManager().getDefaultActivityIcon();
  }
  
  private Drawable getDrawable(Uri paramUri) {
    Exception exception;
    try {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (bool)
        try {
          return getDrawableFromResourceUri(paramUri);
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          throw new FileNotFoundException("Resource does not exist: " + paramUri);
        }  
    } catch (FileNotFoundException null) {
      Log.w("SuggestionsAdapter", "Icon not found: " + paramUri + ", " + iOException.getMessage());
      return null;
    } 
    InputStream inputStream = this.mProviderContext.getContentResolver().openInputStream(paramUri);
    if (inputStream == null)
      throw new FileNotFoundException("Failed to open " + paramUri); 
    try {
      Drawable drawable = Drawable.createFromStream(inputStream, null);
    } finally {
      exception = null;
    } 
    throw exception;
  }
  
  private Drawable getDrawableFromResourceValue(String paramString) {
    if (paramString == null || paramString.length() == 0 || "0".equals(paramString))
      return null; 
    try {
      int i = Integer.parseInt(paramString);
      String str = "android.resource://" + this.mProviderContext.getPackageName() + "/" + i;
      Drawable drawable2 = checkIconCache(str);
      Drawable drawable1 = drawable2;
      if (drawable2 == null) {
        drawable1 = ContextCompat.getDrawable(this.mProviderContext, i);
        storeInIconCache(str, drawable1);
        return drawable1;
      } 
      return drawable1;
    } catch (NumberFormatException numberFormatException) {
      Drawable drawable2 = checkIconCache(paramString);
      Drawable drawable1 = drawable2;
      if (drawable2 == null) {
        drawable1 = getDrawable(Uri.parse(paramString));
        storeInIconCache(paramString, drawable1);
        return drawable1;
      } 
      return drawable1;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      Log.w("SuggestionsAdapter", "Icon resource not found: " + paramString);
      return null;
    } 
  }
  
  private Drawable getIcon1(Cursor paramCursor) {
    if (this.mIconName1Col == -1)
      return null; 
    Drawable drawable2 = getDrawableFromResourceValue(paramCursor.getString(this.mIconName1Col));
    Drawable drawable1 = drawable2;
    return (drawable2 == null) ? getDefaultIcon1(paramCursor) : drawable1;
  }
  
  private Drawable getIcon2(Cursor paramCursor) {
    return (this.mIconName2Col == -1) ? null : getDrawableFromResourceValue(paramCursor.getString(this.mIconName2Col));
  }
  
  private static String getStringOrNull(Cursor paramCursor, int paramInt) {
    if (paramInt == -1)
      return null; 
    try {
      return paramCursor.getString(paramInt);
    } catch (Exception exception) {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", exception);
      return null;
    } 
  }
  
  private void setViewDrawable(ImageView paramImageView, Drawable paramDrawable, int paramInt) {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      paramImageView.setVisibility(paramInt);
      return;
    } 
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void setViewText(TextView paramTextView, CharSequence paramCharSequence) {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {
      paramTextView.setVisibility(8);
      return;
    } 
    paramTextView.setVisibility(0);
  }
  
  private void storeInIconCache(String paramString, Drawable paramDrawable) {
    if (paramDrawable != null)
      this.mOutsideDrawablesCache.put(paramString, paramDrawable.getConstantState()); 
  }
  
  private void updateSpinnerState(Cursor paramCursor) {
    if (paramCursor != null) {
      Bundle bundle = paramCursor.getExtras();
    } else {
      paramCursor = null;
    } 
    if (paramCursor == null || paramCursor.getBoolean("in_progress"));
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor) {
    ChildViewCache childViewCache = (ChildViewCache)paramView.getTag();
    int i = 0;
    if (this.mFlagsCol != -1)
      i = paramCursor.getInt(this.mFlagsCol); 
    if (childViewCache.mText1 != null) {
      String str = getStringOrNull(paramCursor, this.mText1Col);
      setViewText(childViewCache.mText1, str);
    } 
    if (childViewCache.mText2 != null) {
      String str = getStringOrNull(paramCursor, this.mText2UrlCol);
      if (str != null) {
        CharSequence charSequence = formatUrl(str);
      } else {
        str = getStringOrNull(paramCursor, this.mText2Col);
      } 
      if (TextUtils.isEmpty(str)) {
        if (childViewCache.mText1 != null) {
          childViewCache.mText1.setSingleLine(false);
          childViewCache.mText1.setMaxLines(2);
        } 
      } else if (childViewCache.mText1 != null) {
        childViewCache.mText1.setSingleLine(true);
        childViewCache.mText1.setMaxLines(1);
      } 
      setViewText(childViewCache.mText2, str);
    } 
    if (childViewCache.mIcon1 != null)
      setViewDrawable(childViewCache.mIcon1, getIcon1(paramCursor), 4); 
    if (childViewCache.mIcon2 != null)
      setViewDrawable(childViewCache.mIcon2, getIcon2(paramCursor), 8); 
    if (this.mQueryRefinement == 2 || (this.mQueryRefinement == 1 && (i & 0x1) != 0)) {
      childViewCache.mIconRefine.setVisibility(0);
      childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
      childViewCache.mIconRefine.setOnClickListener(this);
      return;
    } 
    childViewCache.mIconRefine.setVisibility(8);
  }
  
  public void changeCursor(Cursor paramCursor) {
    if (this.mClosed) {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null)
        paramCursor.close(); 
      return;
    } 
    try {
      super.changeCursor(paramCursor);
      if (paramCursor != null) {
        this.mText1Col = paramCursor.getColumnIndex("suggest_text_1");
        this.mText2Col = paramCursor.getColumnIndex("suggest_text_2");
        this.mText2UrlCol = paramCursor.getColumnIndex("suggest_text_2_url");
        this.mIconName1Col = paramCursor.getColumnIndex("suggest_icon_1");
        this.mIconName2Col = paramCursor.getColumnIndex("suggest_icon_2");
        this.mFlagsCol = paramCursor.getColumnIndex("suggest_flags");
        return;
      } 
      return;
    } catch (Exception exception) {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", exception);
      return;
    } 
  }
  
  public void close() {
    changeCursor((Cursor)null);
    this.mClosed = true;
  }
  
  public CharSequence convertToString(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    String str2 = getColumnString(paramCursor, "suggest_intent_query");
    String str1 = str2;
    if (str2 == null) {
      if (this.mSearchable.shouldRewriteQueryFromData()) {
        str1 = getColumnString(paramCursor, "suggest_intent_data");
        if (str1 != null)
          return str1; 
      } 
      if (this.mSearchable.shouldRewriteQueryFromText()) {
        String str = getColumnString(paramCursor, "suggest_text_1");
        if (str != null)
          return str; 
      } 
      return null;
    } 
    return str1;
  }
  
  Drawable getDrawableFromResourceUri(Uri paramUri) throws FileNotFoundException {
    Resources resources;
    List<String> list;
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str))
      throw new FileNotFoundException("No authority: " + paramUri); 
    try {
      resources = this.mContext.getPackageManager().getResourcesForApplication(str);
      list = paramUri.getPathSegments();
      if (list == null)
        throw new FileNotFoundException("No path: " + paramUri); 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new FileNotFoundException("No package found for authority: " + paramUri);
    } 
    int i = list.size();
    if (i == 1) {
      try {
        i = Integer.parseInt(list.get(0));
        if (i == 0)
          throw new FileNotFoundException("No resource found for: " + paramUri); 
      } catch (NumberFormatException numberFormatException) {
        throw new FileNotFoundException("Single path segment is not a resource ID: " + paramUri);
      } 
    } else {
      if (i == 2) {
        i = resources.getIdentifier(list.get(1), list.get(0), (String)numberFormatException);
      } else {
        throw new FileNotFoundException("More than two path segments: " + paramUri);
      } 
      if (i == 0)
        throw new FileNotFoundException("No resource found for: " + paramUri); 
    } 
    return resources.getDrawable(i);
  }
  
  public int getQueryRefinement() {
    return this.mQueryRefinement;
  }
  
  Cursor getSearchManagerSuggestions(SearchableInfo paramSearchableInfo, String paramString, int paramInt) {
    if (paramSearchableInfo != null) {
      String str = paramSearchableInfo.getSuggestAuthority();
      if (str != null) {
        String[] arrayOfString;
        Uri.Builder builder = (new Uri.Builder()).scheme("content").authority(str).query("").fragment("");
        String str1 = paramSearchableInfo.getSuggestPath();
        if (str1 != null)
          builder.appendEncodedPath(str1); 
        builder.appendPath("search_suggest_query");
        str1 = paramSearchableInfo.getSuggestSelection();
        paramSearchableInfo = null;
        if (str1 != null) {
          arrayOfString = new String[1];
          arrayOfString[0] = paramString;
        } else {
          builder.appendPath(paramString);
        } 
        if (paramInt > 0)
          builder.appendQueryParameter("limit", String.valueOf(paramInt)); 
        Uri uri = builder.build();
        return this.mContext.getContentResolver().query(uri, null, str1, arrayOfString, null);
      } 
    } 
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    try {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
    } catch (RuntimeException runtimeException) {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeException);
      View view = newView(this.mContext, this.mCursor, paramViewGroup);
      paramView = view;
    } 
    return paramView;
  }
  
  public boolean hasStableIds() {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) {
    View view = super.newView(paramContext, paramCursor, paramViewGroup);
    view.setTag(new ChildViewCache(view));
    ((ImageView)view.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
    return view;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
    updateSpinnerState(getCursor());
  }
  
  public void notifyDataSetInvalidated() {
    super.notifyDataSetInvalidated();
    updateSpinnerState(getCursor());
  }
  
  public void onClick(View paramView) {
    Object object = paramView.getTag();
    if (object instanceof CharSequence)
      this.mSearchView.onQueryRefine((CharSequence)object); 
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence) {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    } else {
      paramCharSequence = paramCharSequence.toString();
    } 
    if (this.mSearchView.getVisibility() == 0 && this.mSearchView.getWindowVisibility() == 0)
      try {
        Cursor cursor = getSearchManagerSuggestions(this.mSearchable, (String)paramCharSequence, 50);
        if (cursor != null) {
          cursor.getCount();
          return cursor;
        } 
      } catch (RuntimeException runtimeException) {
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", runtimeException);
        return null;
      }  
    return null;
  }
  
  public void setQueryRefinement(int paramInt) {
    this.mQueryRefinement = paramInt;
  }
  
  private static final class ChildViewCache {
    public final ImageView mIcon1;
    
    public final ImageView mIcon2;
    
    public final ImageView mIconRefine;
    
    public final TextView mText1;
    
    public final TextView mText2;
    
    public ChildViewCache(View param1View) {
      this.mText1 = (TextView)param1View.findViewById(16908308);
      this.mText2 = (TextView)param1View.findViewById(16908309);
      this.mIcon1 = (ImageView)param1View.findViewById(16908295);
      this.mIcon2 = (ImageView)param1View.findViewById(16908296);
      this.mIconRefine = (ImageView)param1View.findViewById(R.id.edit_query);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v7\widget\SuggestionsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */