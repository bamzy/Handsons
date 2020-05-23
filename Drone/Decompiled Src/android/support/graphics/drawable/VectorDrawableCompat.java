package android.support.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
  private static final boolean DBG_VECTOR_DRAWABLE = false;
  
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  
  private static final int LINECAP_BUTT = 0;
  
  private static final int LINECAP_ROUND = 1;
  
  private static final int LINECAP_SQUARE = 2;
  
  private static final int LINEJOIN_BEVEL = 2;
  
  private static final int LINEJOIN_MITER = 0;
  
  private static final int LINEJOIN_ROUND = 1;
  
  static final String LOGTAG = "VectorDrawableCompat";
  
  private static final int MAX_CACHED_BITMAP_SIZE = 2048;
  
  private static final String SHAPE_CLIP_PATH = "clip-path";
  
  private static final String SHAPE_GROUP = "group";
  
  private static final String SHAPE_PATH = "path";
  
  private static final String SHAPE_VECTOR = "vector";
  
  private boolean mAllowCaching = true;
  
  private Drawable.ConstantState mCachedConstantStateDelegate;
  
  private ColorFilter mColorFilter;
  
  private boolean mMutated;
  
  private PorterDuffColorFilter mTintFilter;
  
  private final Rect mTmpBounds = new Rect();
  
  private final float[] mTmpFloats = new float[9];
  
  private final Matrix mTmpMatrix = new Matrix();
  
  private VectorDrawableCompatState mVectorState = new VectorDrawableCompatState();
  
  VectorDrawableCompat() {}
  
  VectorDrawableCompat(@NonNull VectorDrawableCompatState paramVectorDrawableCompatState) {
    this.mTintFilter = updateTintFilter(this.mTintFilter, paramVectorDrawableCompatState.mTint, paramVectorDrawableCompatState.mTintMode);
  }
  
  static int applyAlpha(int paramInt, float paramFloat) {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  @SuppressLint({"NewApi"})
  @Nullable
  public static VectorDrawableCompat create(@NonNull Resources paramResources, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme) {
    if (Build.VERSION.SDK_INT >= 24) {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      vectorDrawableCompat.mCachedConstantStateDelegate = new VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
      return vectorDrawableCompat;
    } 
    try {
      XmlResourceParser xmlResourceParser = paramResources.getXml(paramInt);
      AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
      do {
        paramInt = xmlResourceParser.next();
      } while (paramInt != 2 && paramInt != 1);
      if (paramInt != 2)
        throw new XmlPullParserException("No start tag found"); 
      return createFromXmlInner(paramResources, (XmlPullParser)xmlResourceParser, attributeSet, paramTheme);
    } catch (XmlPullParserException xmlPullParserException) {
      Log.e("VectorDrawableCompat", "parser error", (Throwable)xmlPullParserException);
    } catch (IOException iOException) {
      Log.e("VectorDrawableCompat", "parser error", iOException);
    } 
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
    vectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return vectorDrawableCompat;
  }
  
  private void inflateInternal(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
    VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
    boolean bool = true;
    Stack<VGroup> stack = new Stack();
    stack.push(vPathRenderer.mRootGroup);
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while (i != 1 && (paramXmlPullParser.getDepth() >= j + 1 || i != 3)) {
      boolean bool1;
      if (i == 2) {
        VFullPath vFullPath;
        String str = paramXmlPullParser.getName();
        VGroup vGroup = stack.peek();
        if ("path".equals(str)) {
          vFullPath = new VFullPath();
          vFullPath.inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          vGroup.mChildren.add(vFullPath);
          if (vFullPath.getPathName() != null)
            vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath); 
          bool1 = false;
          vectorDrawableCompatState.mChangingConfigurations |= vFullPath.mChangingConfigurations;
        } else {
          VClipPath vClipPath;
          if ("clip-path".equals(vFullPath)) {
            vClipPath = new VClipPath();
            vClipPath.inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
            vGroup.mChildren.add(vClipPath);
            if (vClipPath.getPathName() != null)
              vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath); 
            vectorDrawableCompatState.mChangingConfigurations |= vClipPath.mChangingConfigurations;
            bool1 = bool;
          } else {
            bool1 = bool;
            if ("group".equals(vClipPath)) {
              VGroup vGroup1 = new VGroup();
              vGroup1.inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
              vGroup.mChildren.add(vGroup1);
              stack.push(vGroup1);
              if (vGroup1.getGroupName() != null)
                vPathRenderer.mVGTargetsMap.put(vGroup1.getGroupName(), vGroup1); 
              vectorDrawableCompatState.mChangingConfigurations |= vGroup1.mChangingConfigurations;
              bool1 = bool;
            } 
          } 
        } 
      } else {
        bool1 = bool;
        if (i == 3) {
          bool1 = bool;
          if ("group".equals(paramXmlPullParser.getName())) {
            stack.pop();
            bool1 = bool;
          } 
        } 
      } 
      i = paramXmlPullParser.next();
      bool = bool1;
    } 
    if (bool) {
      StringBuffer stringBuffer = new StringBuffer();
      if (stringBuffer.length() > 0)
        stringBuffer.append(" or "); 
      stringBuffer.append("path");
      throw new XmlPullParserException("no " + stringBuffer + " defined");
    } 
  }
  
  @SuppressLint({"NewApi"})
  private boolean needMirroring() {
    boolean bool = true;
    if (Build.VERSION.SDK_INT < 17)
      return false; 
    if (!isAutoMirrored() || getLayoutDirection() != 1)
      bool = false; 
    return bool;
  }
  
  private static PorterDuff.Mode parseTintModeCompat(int paramInt, PorterDuff.Mode paramMode) {
    switch (paramInt) {
      default:
        return paramMode;
      case 3:
        return PorterDuff.Mode.SRC_OVER;
      case 5:
        return PorterDuff.Mode.SRC_IN;
      case 9:
        return PorterDuff.Mode.SRC_ATOP;
      case 14:
        return PorterDuff.Mode.MULTIPLY;
      case 15:
        return PorterDuff.Mode.SCREEN;
      case 16:
        break;
    } 
    if (Build.VERSION.SDK_INT >= 11)
      return PorterDuff.Mode.ADD; 
  }
  
  private void printGroupTree(VGroup paramVGroup, int paramInt) {
    String str = "";
    int i;
    for (i = 0; i < paramInt; i++)
      str = str + "    "; 
    Log.v("VectorDrawableCompat", str + "current group is :" + paramVGroup.getGroupName() + " rotation is " + paramVGroup.mRotate);
    Log.v("VectorDrawableCompat", str + "matrix is :" + paramVGroup.getLocalMatrix().toString());
    for (i = 0; i < paramVGroup.mChildren.size(); i++) {
      str = (String)paramVGroup.mChildren.get(i);
      if (str instanceof VGroup) {
        printGroupTree((VGroup)str, paramInt + 1);
      } else {
        ((VPath)str).printVPath(paramInt + 1);
      } 
    } 
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser) throws XmlPullParserException {
    VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
    VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
    vectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList colorStateList = paramTypedArray.getColorStateList(1);
    if (colorStateList != null)
      vectorDrawableCompatState.mTint = colorStateList; 
    vectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.mAutoMirrored);
    vPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, vPathRenderer.mViewportWidth);
    vPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, vPathRenderer.mViewportHeight);
    if (vPathRenderer.mViewportWidth <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0"); 
    if (vPathRenderer.mViewportHeight <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0"); 
    vPathRenderer.mBaseWidth = paramTypedArray.getDimension(3, vPathRenderer.mBaseWidth);
    vPathRenderer.mBaseHeight = paramTypedArray.getDimension(2, vPathRenderer.mBaseHeight);
    if (vPathRenderer.mBaseWidth <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires width > 0"); 
    if (vPathRenderer.mBaseHeight <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires height > 0"); 
    vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
    String str = paramTypedArray.getString(0);
    if (str != null) {
      vPathRenderer.mRootName = str;
      vPathRenderer.mVGTargetsMap.put(str, vPathRenderer);
    } 
  }
  
  public boolean canApplyTheme() {
    if (this.mDelegateDrawable != null)
      DrawableCompat.canApplyTheme(this.mDelegateDrawable); 
    return false;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.draw(paramCanvas);
      return;
    } 
    copyBounds(this.mTmpBounds);
    if (this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
      ColorFilter colorFilter;
      if (this.mColorFilter == null) {
        PorterDuffColorFilter porterDuffColorFilter = this.mTintFilter;
      } else {
        colorFilter = this.mColorFilter;
      } 
      paramCanvas.getMatrix(this.mTmpMatrix);
      this.mTmpMatrix.getValues(this.mTmpFloats);
      float f1 = Math.abs(this.mTmpFloats[0]);
      float f2 = Math.abs(this.mTmpFloats[4]);
      float f4 = Math.abs(this.mTmpFloats[1]);
      float f3 = Math.abs(this.mTmpFloats[3]);
      if (f4 != 0.0F || f3 != 0.0F) {
        f1 = 1.0F;
        f2 = 1.0F;
      } 
      int i = (int)(this.mTmpBounds.width() * f1);
      int j = (int)(this.mTmpBounds.height() * f2);
      i = Math.min(2048, i);
      j = Math.min(2048, j);
      if (i > 0 && j > 0) {
        int k = paramCanvas.save();
        paramCanvas.translate(this.mTmpBounds.left, this.mTmpBounds.top);
        if (needMirroring()) {
          paramCanvas.translate(this.mTmpBounds.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        } 
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(i, j);
        if (!this.mAllowCaching) {
          this.mVectorState.updateCachedBitmap(i, j);
        } else if (!this.mVectorState.canReuseCache()) {
          this.mVectorState.updateCachedBitmap(i, j);
          this.mVectorState.updateCacheStates();
        } 
        this.mVectorState.drawCachedBitmapWithRootAlpha(paramCanvas, colorFilter, this.mTmpBounds);
        paramCanvas.restoreToCount(k);
        return;
      } 
    } 
  }
  
  public int getAlpha() {
    return (this.mDelegateDrawable != null) ? DrawableCompat.getAlpha(this.mDelegateDrawable) : this.mVectorState.mVPathRenderer.getRootAlpha();
  }
  
  public int getChangingConfigurations() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getChangingConfigurations() : (super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations());
  }
  
  public Drawable.ConstantState getConstantState() {
    if (this.mDelegateDrawable != null)
      return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState()); 
    this.mVectorState.mChangingConfigurations = getChangingConfigurations();
    return this.mVectorState;
  }
  
  public int getIntrinsicHeight() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getIntrinsicHeight() : (int)this.mVectorState.mVPathRenderer.mBaseHeight;
  }
  
  public int getIntrinsicWidth() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getIntrinsicWidth() : (int)this.mVectorState.mVPathRenderer.mBaseWidth;
  }
  
  public int getOpacity() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getOpacity() : -3;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public float getPixelSize() {
    if ((this.mVectorState == null && this.mVectorState.mVPathRenderer == null) || this.mVectorState.mVPathRenderer.mBaseWidth == 0.0F || this.mVectorState.mVPathRenderer.mBaseHeight == 0.0F || this.mVectorState.mVPathRenderer.mViewportHeight == 0.0F || this.mVectorState.mVPathRenderer.mViewportWidth == 0.0F)
      return 1.0F; 
    float f1 = this.mVectorState.mVPathRenderer.mBaseWidth;
    float f2 = this.mVectorState.mVPathRenderer.mBaseHeight;
    float f3 = this.mVectorState.mVPathRenderer.mViewportWidth;
    float f4 = this.mVectorState.mVPathRenderer.mViewportHeight;
    return Math.min(f3 / f1, f4 / f2);
  }
  
  Object getTargetByName(String paramString) {
    return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(paramString);
  }
  
  @SuppressLint({"NewApi"})
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) throws XmlPullParserException, IOException {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    } 
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, (Resources.Theme)null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.inflate(this.mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
    vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
    TypedArray typedArray = obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawableTypeArray);
    updateStateFromTypedArray(typedArray, paramXmlPullParser);
    typedArray.recycle();
    vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
    vectorDrawableCompatState.mCacheDirty = true;
    inflateInternal(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
  }
  
  public void invalidateSelf() {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.invalidateSelf();
      return;
    } 
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored() {
    return (this.mDelegateDrawable != null) ? DrawableCompat.isAutoMirrored(this.mDelegateDrawable) : this.mVectorState.mAutoMirrored;
  }
  
  public boolean isStateful() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.isStateful() : ((super.isStateful() || (this.mVectorState != null && this.mVectorState.mTint != null && this.mVectorState.mTint.isStateful())));
  }
  
  public Drawable mutate() {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.mutate();
      return this;
    } 
    if (!this.mMutated && super.mutate() == this) {
      this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
      this.mMutated = true;
      return this;
    } 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.setBounds(paramRect); 
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setState(paramArrayOfint); 
    VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
    if (vectorDrawableCompatState.mTint != null && vectorDrawableCompatState.mTintMode != null) {
      this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
      invalidateSelf();
      return true;
    } 
    return false;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    } 
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  void setAllowCaching(boolean paramBoolean) {
    this.mAllowCaching = paramBoolean;
  }
  
  public void setAlpha(int paramInt) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setAlpha(paramInt);
      return;
    } 
    if (this.mVectorState.mVPathRenderer.getRootAlpha() != paramInt) {
      this.mVectorState.mVPathRenderer.setRootAlpha(paramInt);
      invalidateSelf();
      return;
    } 
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setAutoMirrored(this.mDelegateDrawable, paramBoolean);
      return;
    } 
    this.mVectorState.mAutoMirrored = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    } 
    this.mColorFilter = paramColorFilter;
    invalidateSelf();
  }
  
  @SuppressLint({"NewApi"})
  public void setTint(int paramInt) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTint(this.mDelegateDrawable, paramInt);
      return;
    } 
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintList(this.mDelegateDrawable, paramColorStateList);
      return;
    } 
    VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
    if (vectorDrawableCompatState.mTint != paramColorStateList) {
      vectorDrawableCompatState.mTint = paramColorStateList;
      this.mTintFilter = updateTintFilter(this.mTintFilter, paramColorStateList, vectorDrawableCompatState.mTintMode);
      invalidateSelf();
      return;
    } 
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintMode(this.mDelegateDrawable, paramMode);
      return;
    } 
    VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
    if (vectorDrawableCompatState.mTintMode != paramMode) {
      vectorDrawableCompatState.mTintMode = paramMode;
      this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, paramMode);
      invalidateSelf();
      return;
    } 
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2) : super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.unscheduleSelf(paramRunnable);
      return;
    } 
    super.unscheduleSelf(paramRunnable);
  }
  
  PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode) {
    return (paramColorStateList == null || paramMode == null) ? null : new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  private static class VClipPath extends VPath {
    public VClipPath() {}
    
    public VClipPath(VClipPath param1VClipPath) {
      super(param1VClipPath);
    }
    
    private void updateStateFromTypedArray(TypedArray param1TypedArray) {
      String str2 = param1TypedArray.getString(0);
      if (str2 != null)
        this.mPathName = str2; 
      String str1 = param1TypedArray.getString(1);
      if (str1 != null)
        this.mNodes = PathParser.createNodesFromPathData(str1); 
    }
    
    public void inflate(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      if (!TypedArrayUtils.hasAttribute(param1XmlPullParser, "pathData"))
        return; 
      TypedArray typedArray = VectorDrawableCommon.obtainAttributes(param1Resources, param1Theme, param1AttributeSet, AndroidResources.styleable_VectorDrawableClipPath);
      updateStateFromTypedArray(typedArray);
      typedArray.recycle();
    }
    
    public boolean isClipPath() {
      return true;
    }
  }
  
  private static class VFullPath extends VPath {
    float mFillAlpha = 1.0F;
    
    int mFillColor = 0;
    
    int mFillRule;
    
    float mStrokeAlpha = 1.0F;
    
    int mStrokeColor = 0;
    
    Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
    
    Paint.Join mStrokeLineJoin = Paint.Join.MITER;
    
    float mStrokeMiterlimit = 4.0F;
    
    float mStrokeWidth = 0.0F;
    
    private int[] mThemeAttrs;
    
    float mTrimPathEnd = 1.0F;
    
    float mTrimPathOffset = 0.0F;
    
    float mTrimPathStart = 0.0F;
    
    public VFullPath() {}
    
    public VFullPath(VFullPath param1VFullPath) {
      super(param1VFullPath);
      this.mThemeAttrs = param1VFullPath.mThemeAttrs;
      this.mStrokeColor = param1VFullPath.mStrokeColor;
      this.mStrokeWidth = param1VFullPath.mStrokeWidth;
      this.mStrokeAlpha = param1VFullPath.mStrokeAlpha;
      this.mFillColor = param1VFullPath.mFillColor;
      this.mFillRule = param1VFullPath.mFillRule;
      this.mFillAlpha = param1VFullPath.mFillAlpha;
      this.mTrimPathStart = param1VFullPath.mTrimPathStart;
      this.mTrimPathEnd = param1VFullPath.mTrimPathEnd;
      this.mTrimPathOffset = param1VFullPath.mTrimPathOffset;
      this.mStrokeLineCap = param1VFullPath.mStrokeLineCap;
      this.mStrokeLineJoin = param1VFullPath.mStrokeLineJoin;
      this.mStrokeMiterlimit = param1VFullPath.mStrokeMiterlimit;
    }
    
    private Paint.Cap getStrokeLineCap(int param1Int, Paint.Cap param1Cap) {
      switch (param1Int) {
        default:
          return param1Cap;
        case 0:
          return Paint.Cap.BUTT;
        case 1:
          return Paint.Cap.ROUND;
        case 2:
          break;
      } 
      return Paint.Cap.SQUARE;
    }
    
    private Paint.Join getStrokeLineJoin(int param1Int, Paint.Join param1Join) {
      switch (param1Int) {
        default:
          return param1Join;
        case 0:
          return Paint.Join.MITER;
        case 1:
          return Paint.Join.ROUND;
        case 2:
          break;
      } 
      return Paint.Join.BEVEL;
    }
    
    private void updateStateFromTypedArray(TypedArray param1TypedArray, XmlPullParser param1XmlPullParser) {
      this.mThemeAttrs = null;
      if (!TypedArrayUtils.hasAttribute(param1XmlPullParser, "pathData"))
        return; 
      String str = param1TypedArray.getString(0);
      if (str != null)
        this.mPathName = str; 
      str = param1TypedArray.getString(2);
      if (str != null)
        this.mNodes = PathParser.createNodesFromPathData(str); 
      this.mFillColor = TypedArrayUtils.getNamedColor(param1TypedArray, param1XmlPullParser, "fillColor", 1, this.mFillColor);
      this.mFillAlpha = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "fillAlpha", 12, this.mFillAlpha);
      this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(param1TypedArray, param1XmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
      this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(param1TypedArray, param1XmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
      this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
      this.mStrokeColor = TypedArrayUtils.getNamedColor(param1TypedArray, param1XmlPullParser, "strokeColor", 3, this.mStrokeColor);
      this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
      this.mStrokeWidth = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
      this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
      this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
      this.mTrimPathStart = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
    }
    
    public void applyTheme(Resources.Theme param1Theme) {
      if (this.mThemeAttrs == null);
    }
    
    public boolean canApplyTheme() {
      return (this.mThemeAttrs != null);
    }
    
    float getFillAlpha() {
      return this.mFillAlpha;
    }
    
    int getFillColor() {
      return this.mFillColor;
    }
    
    float getStrokeAlpha() {
      return this.mStrokeAlpha;
    }
    
    int getStrokeColor() {
      return this.mStrokeColor;
    }
    
    float getStrokeWidth() {
      return this.mStrokeWidth;
    }
    
    float getTrimPathEnd() {
      return this.mTrimPathEnd;
    }
    
    float getTrimPathOffset() {
      return this.mTrimPathOffset;
    }
    
    float getTrimPathStart() {
      return this.mTrimPathStart;
    }
    
    public void inflate(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      TypedArray typedArray = VectorDrawableCommon.obtainAttributes(param1Resources, param1Theme, param1AttributeSet, AndroidResources.styleable_VectorDrawablePath);
      updateStateFromTypedArray(typedArray, param1XmlPullParser);
      typedArray.recycle();
    }
    
    void setFillAlpha(float param1Float) {
      this.mFillAlpha = param1Float;
    }
    
    void setFillColor(int param1Int) {
      this.mFillColor = param1Int;
    }
    
    void setStrokeAlpha(float param1Float) {
      this.mStrokeAlpha = param1Float;
    }
    
    void setStrokeColor(int param1Int) {
      this.mStrokeColor = param1Int;
    }
    
    void setStrokeWidth(float param1Float) {
      this.mStrokeWidth = param1Float;
    }
    
    void setTrimPathEnd(float param1Float) {
      this.mTrimPathEnd = param1Float;
    }
    
    void setTrimPathOffset(float param1Float) {
      this.mTrimPathOffset = param1Float;
    }
    
    void setTrimPathStart(float param1Float) {
      this.mTrimPathStart = param1Float;
    }
  }
  
  private static class VGroup {
    int mChangingConfigurations;
    
    final ArrayList<Object> mChildren = new ArrayList();
    
    private String mGroupName = null;
    
    private final Matrix mLocalMatrix = new Matrix();
    
    private float mPivotX = 0.0F;
    
    private float mPivotY = 0.0F;
    
    float mRotate = 0.0F;
    
    private float mScaleX = 1.0F;
    
    private float mScaleY = 1.0F;
    
    private final Matrix mStackedMatrix = new Matrix();
    
    private int[] mThemeAttrs;
    
    private float mTranslateX = 0.0F;
    
    private float mTranslateY = 0.0F;
    
    public VGroup() {}
    
    public VGroup(VGroup param1VGroup, ArrayMap<String, Object> param1ArrayMap) {
      this.mRotate = param1VGroup.mRotate;
      this.mPivotX = param1VGroup.mPivotX;
      this.mPivotY = param1VGroup.mPivotY;
      this.mScaleX = param1VGroup.mScaleX;
      this.mScaleY = param1VGroup.mScaleY;
      this.mTranslateX = param1VGroup.mTranslateX;
      this.mTranslateY = param1VGroup.mTranslateY;
      this.mThemeAttrs = param1VGroup.mThemeAttrs;
      this.mGroupName = param1VGroup.mGroupName;
      this.mChangingConfigurations = param1VGroup.mChangingConfigurations;
      if (this.mGroupName != null)
        param1ArrayMap.put(this.mGroupName, this); 
      this.mLocalMatrix.set(param1VGroup.mLocalMatrix);
      ArrayList<Object> arrayList = param1VGroup.mChildren;
      for (int i = 0; i < arrayList.size(); i++) {
        param1VGroup = (VGroup)arrayList.get(i);
        if (param1VGroup instanceof VGroup) {
          param1VGroup = param1VGroup;
          this.mChildren.add(new VGroup(param1VGroup, param1ArrayMap));
        } else {
          VectorDrawableCompat.VFullPath vFullPath;
          VectorDrawableCompat.VClipPath vClipPath;
          if (param1VGroup instanceof VectorDrawableCompat.VFullPath) {
            vFullPath = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)param1VGroup);
          } else if (vFullPath instanceof VectorDrawableCompat.VClipPath) {
            vClipPath = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)vFullPath);
          } else {
            throw new IllegalStateException("Unknown object in the tree!");
          } 
          this.mChildren.add(vClipPath);
          if (vClipPath.mPathName != null)
            param1ArrayMap.put(vClipPath.mPathName, vClipPath); 
        } 
      } 
    }
    
    private void updateLocalMatrix() {
      this.mLocalMatrix.reset();
      this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
      this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
      this.mLocalMatrix.postRotate(this.mRotate, 0.0F, 0.0F);
      this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
    }
    
    private void updateStateFromTypedArray(TypedArray param1TypedArray, XmlPullParser param1XmlPullParser) {
      this.mThemeAttrs = null;
      this.mRotate = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "rotation", 5, this.mRotate);
      this.mPivotX = param1TypedArray.getFloat(1, this.mPivotX);
      this.mPivotY = param1TypedArray.getFloat(2, this.mPivotY);
      this.mScaleX = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "scaleX", 3, this.mScaleX);
      this.mScaleY = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "scaleY", 4, this.mScaleY);
      this.mTranslateX = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "translateX", 6, this.mTranslateX);
      this.mTranslateY = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "translateY", 7, this.mTranslateY);
      String str = param1TypedArray.getString(0);
      if (str != null)
        this.mGroupName = str; 
      updateLocalMatrix();
    }
    
    public String getGroupName() {
      return this.mGroupName;
    }
    
    public Matrix getLocalMatrix() {
      return this.mLocalMatrix;
    }
    
    public float getPivotX() {
      return this.mPivotX;
    }
    
    public float getPivotY() {
      return this.mPivotY;
    }
    
    public float getRotation() {
      return this.mRotate;
    }
    
    public float getScaleX() {
      return this.mScaleX;
    }
    
    public float getScaleY() {
      return this.mScaleY;
    }
    
    public float getTranslateX() {
      return this.mTranslateX;
    }
    
    public float getTranslateY() {
      return this.mTranslateY;
    }
    
    public void inflate(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      TypedArray typedArray = VectorDrawableCommon.obtainAttributes(param1Resources, param1Theme, param1AttributeSet, AndroidResources.styleable_VectorDrawableGroup);
      updateStateFromTypedArray(typedArray, param1XmlPullParser);
      typedArray.recycle();
    }
    
    public void setPivotX(float param1Float) {
      if (param1Float != this.mPivotX) {
        this.mPivotX = param1Float;
        updateLocalMatrix();
      } 
    }
    
    public void setPivotY(float param1Float) {
      if (param1Float != this.mPivotY) {
        this.mPivotY = param1Float;
        updateLocalMatrix();
      } 
    }
    
    public void setRotation(float param1Float) {
      if (param1Float != this.mRotate) {
        this.mRotate = param1Float;
        updateLocalMatrix();
      } 
    }
    
    public void setScaleX(float param1Float) {
      if (param1Float != this.mScaleX) {
        this.mScaleX = param1Float;
        updateLocalMatrix();
      } 
    }
    
    public void setScaleY(float param1Float) {
      if (param1Float != this.mScaleY) {
        this.mScaleY = param1Float;
        updateLocalMatrix();
      } 
    }
    
    public void setTranslateX(float param1Float) {
      if (param1Float != this.mTranslateX) {
        this.mTranslateX = param1Float;
        updateLocalMatrix();
      } 
    }
    
    public void setTranslateY(float param1Float) {
      if (param1Float != this.mTranslateY) {
        this.mTranslateY = param1Float;
        updateLocalMatrix();
      } 
    }
  }
  
  private static class VPath {
    int mChangingConfigurations;
    
    protected PathParser.PathDataNode[] mNodes = null;
    
    String mPathName;
    
    public VPath() {}
    
    public VPath(VPath param1VPath) {
      this.mPathName = param1VPath.mPathName;
      this.mChangingConfigurations = param1VPath.mChangingConfigurations;
      this.mNodes = PathParser.deepCopyNodes(param1VPath.mNodes);
    }
    
    public String NodesToString(PathParser.PathDataNode[] param1ArrayOfPathDataNode) {
      String str = " ";
      for (int i = 0; i < param1ArrayOfPathDataNode.length; i++) {
        str = str + (param1ArrayOfPathDataNode[i]).type + ":";
        float[] arrayOfFloat = (param1ArrayOfPathDataNode[i]).params;
        for (int j = 0; j < arrayOfFloat.length; j++)
          str = str + arrayOfFloat[j] + ","; 
      } 
      return str;
    }
    
    public void applyTheme(Resources.Theme param1Theme) {}
    
    public boolean canApplyTheme() {
      return false;
    }
    
    public PathParser.PathDataNode[] getPathData() {
      return this.mNodes;
    }
    
    public String getPathName() {
      return this.mPathName;
    }
    
    public boolean isClipPath() {
      return false;
    }
    
    public void printVPath(int param1Int) {
      String str = "";
      for (int i = 0; i < param1Int; i++)
        str = str + "    "; 
      Log.v("VectorDrawableCompat", str + "current path is :" + this.mPathName + " pathData is " + NodesToString(this.mNodes));
    }
    
    public void setPathData(PathParser.PathDataNode[] param1ArrayOfPathDataNode) {
      if (!PathParser.canMorph(this.mNodes, param1ArrayOfPathDataNode)) {
        this.mNodes = PathParser.deepCopyNodes(param1ArrayOfPathDataNode);
        return;
      } 
      PathParser.updateNodes(this.mNodes, param1ArrayOfPathDataNode);
    }
    
    public void toPath(Path param1Path) {
      param1Path.reset();
      if (this.mNodes != null)
        PathParser.PathDataNode.nodesToPath(this.mNodes, param1Path); 
    }
  }
  
  private static class VPathRenderer {
    private static final Matrix IDENTITY_MATRIX = new Matrix();
    
    float mBaseHeight = 0.0F;
    
    float mBaseWidth = 0.0F;
    
    private int mChangingConfigurations;
    
    private Paint mFillPaint;
    
    private final Matrix mFinalPathMatrix = new Matrix();
    
    private final Path mPath = new Path();
    
    private PathMeasure mPathMeasure;
    
    private final Path mRenderPath = new Path();
    
    int mRootAlpha = 255;
    
    final VectorDrawableCompat.VGroup mRootGroup = new VectorDrawableCompat.VGroup();
    
    String mRootName = null;
    
    private Paint mStrokePaint;
    
    final ArrayMap<String, Object> mVGTargetsMap = new ArrayMap();
    
    float mViewportHeight = 0.0F;
    
    float mViewportWidth = 0.0F;
    
    public VPathRenderer() {}
    
    public VPathRenderer(VPathRenderer param1VPathRenderer) {
      this.mBaseWidth = param1VPathRenderer.mBaseWidth;
      this.mBaseHeight = param1VPathRenderer.mBaseHeight;
      this.mViewportWidth = param1VPathRenderer.mViewportWidth;
      this.mViewportHeight = param1VPathRenderer.mViewportHeight;
      this.mChangingConfigurations = param1VPathRenderer.mChangingConfigurations;
      this.mRootAlpha = param1VPathRenderer.mRootAlpha;
      this.mRootName = param1VPathRenderer.mRootName;
      if (param1VPathRenderer.mRootName != null)
        this.mVGTargetsMap.put(param1VPathRenderer.mRootName, this); 
    }
    
    private static float cross(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
      return param1Float1 * param1Float4 - param1Float2 * param1Float3;
    }
    
    private void drawGroupTree(VectorDrawableCompat.VGroup param1VGroup, Matrix param1Matrix, Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      param1VGroup.mStackedMatrix.set(param1Matrix);
      param1VGroup.mStackedMatrix.preConcat(param1VGroup.mLocalMatrix);
      param1Canvas.save();
      for (int i = 0; i < param1VGroup.mChildren.size(); i++) {
        param1Matrix = (Matrix)param1VGroup.mChildren.get(i);
        if (param1Matrix instanceof VectorDrawableCompat.VGroup) {
          drawGroupTree((VectorDrawableCompat.VGroup)param1Matrix, param1VGroup.mStackedMatrix, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
        } else if (param1Matrix instanceof VectorDrawableCompat.VPath) {
          drawPath(param1VGroup, (VectorDrawableCompat.VPath)param1Matrix, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
        } 
      } 
      param1Canvas.restore();
    }
    
    private void drawPath(VectorDrawableCompat.VGroup param1VGroup, VectorDrawableCompat.VPath param1VPath, Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      float f2 = param1Int1 / this.mViewportWidth;
      float f3 = param1Int2 / this.mViewportHeight;
      float f1 = Math.min(f2, f3);
      Matrix matrix = param1VGroup.mStackedMatrix;
      this.mFinalPathMatrix.set(matrix);
      this.mFinalPathMatrix.postScale(f2, f3);
      f2 = getMatrixScale(matrix);
      if (f2 != 0.0F) {
        param1VPath.toPath(this.mPath);
        Path path = this.mPath;
        this.mRenderPath.reset();
        if (param1VPath.isClipPath()) {
          this.mRenderPath.addPath(path, this.mFinalPathMatrix);
          param1Canvas.clipPath(this.mRenderPath);
          return;
        } 
        VectorDrawableCompat.VFullPath vFullPath = (VectorDrawableCompat.VFullPath)param1VPath;
        if (vFullPath.mTrimPathStart != 0.0F || vFullPath.mTrimPathEnd != 1.0F) {
          float f6 = vFullPath.mTrimPathStart;
          float f7 = vFullPath.mTrimPathOffset;
          float f4 = vFullPath.mTrimPathEnd;
          float f5 = vFullPath.mTrimPathOffset;
          if (this.mPathMeasure == null)
            this.mPathMeasure = new PathMeasure(); 
          this.mPathMeasure.setPath(this.mPath, false);
          f3 = this.mPathMeasure.getLength();
          f6 = (f6 + f7) % 1.0F * f3;
          f4 = (f4 + f5) % 1.0F * f3;
          path.reset();
          if (f6 > f4) {
            this.mPathMeasure.getSegment(f6, f3, path, true);
            this.mPathMeasure.getSegment(0.0F, f4, path, true);
          } else {
            this.mPathMeasure.getSegment(f6, f4, path, true);
          } 
          path.rLineTo(0.0F, 0.0F);
        } 
        this.mRenderPath.addPath(path, this.mFinalPathMatrix);
        if (vFullPath.mFillColor != 0) {
          if (this.mFillPaint == null) {
            this.mFillPaint = new Paint();
            this.mFillPaint.setStyle(Paint.Style.FILL);
            this.mFillPaint.setAntiAlias(true);
          } 
          Paint paint = this.mFillPaint;
          paint.setColor(VectorDrawableCompat.applyAlpha(vFullPath.mFillColor, vFullPath.mFillAlpha));
          paint.setColorFilter(param1ColorFilter);
          param1Canvas.drawPath(this.mRenderPath, paint);
        } 
        if (vFullPath.mStrokeColor != 0) {
          if (this.mStrokePaint == null) {
            this.mStrokePaint = new Paint();
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setAntiAlias(true);
          } 
          Paint paint = this.mStrokePaint;
          if (vFullPath.mStrokeLineJoin != null)
            paint.setStrokeJoin(vFullPath.mStrokeLineJoin); 
          if (vFullPath.mStrokeLineCap != null)
            paint.setStrokeCap(vFullPath.mStrokeLineCap); 
          paint.setStrokeMiter(vFullPath.mStrokeMiterlimit);
          paint.setColor(VectorDrawableCompat.applyAlpha(vFullPath.mStrokeColor, vFullPath.mStrokeAlpha));
          paint.setColorFilter(param1ColorFilter);
          paint.setStrokeWidth(vFullPath.mStrokeWidth * f1 * f2);
          param1Canvas.drawPath(this.mRenderPath, paint);
          return;
        } 
      } 
    }
    
    private float getMatrixScale(Matrix param1Matrix) {
      float[] arrayOfFloat = new float[4];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 1.0F;
      arrayOfFloat[2] = 1.0F;
      arrayOfFloat[3] = 0.0F;
      param1Matrix.mapVectors(arrayOfFloat);
      float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f3 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f2 = cross(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f3 = Math.max(f1, f3);
      f1 = 0.0F;
      if (f3 > 0.0F)
        f1 = Math.abs(f2) / f3; 
      return f1;
    }
    
    public void draw(Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
    }
    
    public float getAlpha() {
      return getRootAlpha() / 255.0F;
    }
    
    public int getRootAlpha() {
      return this.mRootAlpha;
    }
    
    public void setAlpha(float param1Float) {
      setRootAlpha((int)(255.0F * param1Float));
    }
    
    public void setRootAlpha(int param1Int) {
      this.mRootAlpha = param1Int;
    }
  }
  
  private static class VectorDrawableCompatState extends Drawable.ConstantState {
    boolean mAutoMirrored;
    
    boolean mCacheDirty;
    
    boolean mCachedAutoMirrored;
    
    Bitmap mCachedBitmap;
    
    int mCachedRootAlpha;
    
    int[] mCachedThemeAttrs;
    
    ColorStateList mCachedTint;
    
    PorterDuff.Mode mCachedTintMode;
    
    int mChangingConfigurations;
    
    Paint mTempPaint;
    
    ColorStateList mTint = null;
    
    PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
    
    VectorDrawableCompat.VPathRenderer mVPathRenderer;
    
    public VectorDrawableCompatState() {
      this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
    }
    
    public VectorDrawableCompatState(VectorDrawableCompatState param1VectorDrawableCompatState) {
      if (param1VectorDrawableCompatState != null) {
        this.mChangingConfigurations = param1VectorDrawableCompatState.mChangingConfigurations;
        this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer(param1VectorDrawableCompatState.mVPathRenderer);
        if (param1VectorDrawableCompatState.mVPathRenderer.mFillPaint != null)
          VectorDrawableCompat.VPathRenderer.access$002(this.mVPathRenderer, new Paint(param1VectorDrawableCompatState.mVPathRenderer.mFillPaint)); 
        if (param1VectorDrawableCompatState.mVPathRenderer.mStrokePaint != null)
          VectorDrawableCompat.VPathRenderer.access$102(this.mVPathRenderer, new Paint(param1VectorDrawableCompatState.mVPathRenderer.mStrokePaint)); 
        this.mTint = param1VectorDrawableCompatState.mTint;
        this.mTintMode = param1VectorDrawableCompatState.mTintMode;
        this.mAutoMirrored = param1VectorDrawableCompatState.mAutoMirrored;
      } 
    }
    
    public boolean canReuseBitmap(int param1Int1, int param1Int2) {
      return (param1Int1 == this.mCachedBitmap.getWidth() && param1Int2 == this.mCachedBitmap.getHeight());
    }
    
    public boolean canReuseCache() {
      return (!this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha());
    }
    
    public void createCachedBitmapIfNeeded(int param1Int1, int param1Int2) {
      if (this.mCachedBitmap == null || !canReuseBitmap(param1Int1, param1Int2)) {
        this.mCachedBitmap = Bitmap.createBitmap(param1Int1, param1Int2, Bitmap.Config.ARGB_8888);
        this.mCacheDirty = true;
      } 
    }
    
    public void drawCachedBitmapWithRootAlpha(Canvas param1Canvas, ColorFilter param1ColorFilter, Rect param1Rect) {
      Paint paint = getPaint(param1ColorFilter);
      param1Canvas.drawBitmap(this.mCachedBitmap, null, param1Rect, paint);
    }
    
    public int getChangingConfigurations() {
      return this.mChangingConfigurations;
    }
    
    public Paint getPaint(ColorFilter param1ColorFilter) {
      if (!hasTranslucentRoot() && param1ColorFilter == null)
        return null; 
      if (this.mTempPaint == null) {
        this.mTempPaint = new Paint();
        this.mTempPaint.setFilterBitmap(true);
      } 
      this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
      this.mTempPaint.setColorFilter(param1ColorFilter);
      return this.mTempPaint;
    }
    
    public boolean hasTranslucentRoot() {
      return (this.mVPathRenderer.getRootAlpha() < 255);
    }
    
    public Drawable newDrawable() {
      return new VectorDrawableCompat(this);
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      return new VectorDrawableCompat(this);
    }
    
    public void updateCacheStates() {
      this.mCachedTint = this.mTint;
      this.mCachedTintMode = this.mTintMode;
      this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
      this.mCachedAutoMirrored = this.mAutoMirrored;
      this.mCacheDirty = false;
    }
    
    public void updateCachedBitmap(int param1Int1, int param1Int2) {
      this.mCachedBitmap.eraseColor(0);
      Canvas canvas = new Canvas(this.mCachedBitmap);
      this.mVPathRenderer.draw(canvas, param1Int1, param1Int2, null);
    }
  }
  
  private static class VectorDrawableDelegateState extends Drawable.ConstantState {
    private final Drawable.ConstantState mDelegateState;
    
    public VectorDrawableDelegateState(Drawable.ConstantState param1ConstantState) {
      this.mDelegateState = param1ConstantState;
    }
    
    public boolean canApplyTheme() {
      return this.mDelegateState.canApplyTheme();
    }
    
    public int getChangingConfigurations() {
      return this.mDelegateState.getChangingConfigurations();
    }
    
    public Drawable newDrawable() {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable();
      return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(param1Resources);
      return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources param1Resources, Resources.Theme param1Theme) {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(param1Resources, param1Theme);
      return vectorDrawableCompat;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */