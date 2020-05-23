package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
  private static final int ALPHA = 43;
  
  public static final int BASELINE = 5;
  
  private static final int BASELINE_TO_BASELINE = 1;
  
  public static final int BOTTOM = 4;
  
  private static final int BOTTOM_MARGIN = 2;
  
  private static final int BOTTOM_TO_BOTTOM = 3;
  
  private static final int BOTTOM_TO_TOP = 4;
  
  public static final int CHAIN_PACKED = 2;
  
  public static final int CHAIN_SPREAD = 0;
  
  public static final int CHAIN_SPREAD_INSIDE = 1;
  
  private static final boolean DEBUG = false;
  
  private static final int DIMENSION_RATIO = 5;
  
  private static final int EDITOR_ABSOLUTE_X = 6;
  
  private static final int EDITOR_ABSOLUTE_Y = 7;
  
  private static final int ELEVATION = 44;
  
  public static final int END = 7;
  
  private static final int END_MARGIN = 8;
  
  private static final int END_TO_END = 9;
  
  private static final int END_TO_START = 10;
  
  public static final int GONE = 8;
  
  private static final int GONE_BOTTOM_MARGIN = 11;
  
  private static final int GONE_END_MARGIN = 12;
  
  private static final int GONE_LEFT_MARGIN = 13;
  
  private static final int GONE_RIGHT_MARGIN = 14;
  
  private static final int GONE_START_MARGIN = 15;
  
  private static final int GONE_TOP_MARGIN = 16;
  
  private static final int GUIDE_BEGIN = 17;
  
  private static final int GUIDE_END = 18;
  
  private static final int GUIDE_PERCENT = 19;
  
  private static final int HEIGHT_DEFAULT = 55;
  
  private static final int HEIGHT_MAX = 57;
  
  private static final int HEIGHT_MIN = 59;
  
  public static final int HORIZONTAL = 0;
  
  private static final int HORIZONTAL_BIAS = 20;
  
  public static final int HORIZONTAL_GUIDELINE = 0;
  
  private static final int HORIZONTAL_STYLE = 41;
  
  private static final int HORIZONTAL_WEIGHT = 39;
  
  public static final int INVISIBLE = 4;
  
  private static final int LAYOUT_HEIGHT = 21;
  
  private static final int LAYOUT_VISIBILITY = 22;
  
  private static final int LAYOUT_WIDTH = 23;
  
  public static final int LEFT = 1;
  
  private static final int LEFT_MARGIN = 24;
  
  private static final int LEFT_TO_LEFT = 25;
  
  private static final int LEFT_TO_RIGHT = 26;
  
  public static final int MATCH_CONSTRAINT = 0;
  
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  
  private static final int ORIENTATION = 27;
  
  public static final int PARENT_ID = 0;
  
  public static final int RIGHT = 2;
  
  private static final int RIGHT_MARGIN = 28;
  
  private static final int RIGHT_TO_LEFT = 29;
  
  private static final int RIGHT_TO_RIGHT = 30;
  
  private static final int ROTATION_X = 45;
  
  private static final int ROTATION_Y = 46;
  
  private static final int SCALE_X = 47;
  
  private static final int SCALE_Y = 48;
  
  public static final int START = 6;
  
  private static final int START_MARGIN = 31;
  
  private static final int START_TO_END = 32;
  
  private static final int START_TO_START = 33;
  
  private static final String TAG = "ConstraintSet";
  
  public static final int TOP = 3;
  
  private static final int TOP_MARGIN = 34;
  
  private static final int TOP_TO_BOTTOM = 35;
  
  private static final int TOP_TO_TOP = 36;
  
  private static final int TRANSFORM_PIVOT_X = 49;
  
  private static final int TRANSFORM_PIVOT_Y = 50;
  
  private static final int TRANSLATION_X = 51;
  
  private static final int TRANSLATION_Y = 52;
  
  private static final int TRANSLATION_Z = 53;
  
  public static final int UNSET = -1;
  
  private static final int UNUSED = 60;
  
  public static final int VERTICAL = 1;
  
  private static final int VERTICAL_BIAS = 37;
  
  public static final int VERTICAL_GUIDELINE = 1;
  
  private static final int VERTICAL_STYLE = 42;
  
  private static final int VERTICAL_WEIGHT = 40;
  
  private static final int VIEW_ID = 38;
  
  private static final int[] VISIBILITY_FLAGS = new int[] { 0, 4, 8 };
  
  public static final int VISIBLE = 0;
  
  private static final int WIDTH_DEFAULT = 54;
  
  private static final int WIDTH_MAX = 56;
  
  private static final int WIDTH_MIN = 58;
  
  public static final int WRAP_CONTENT = -2;
  
  private static SparseIntArray mapToConstant = new SparseIntArray();
  
  private HashMap<Integer, Constraint> mConstraints = new HashMap<Integer, Constraint>();
  
  static {
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    mapToConstant.append(R.styleable.ConstraintSet_android_orientation, 27);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_width, 23);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_height, 21);
    mapToConstant.append(R.styleable.ConstraintSet_android_visibility, 22);
    mapToConstant.append(R.styleable.ConstraintSet_android_alpha, 43);
    mapToConstant.append(R.styleable.ConstraintSet_android_elevation, 44);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationX, 45);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationY, 46);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleX, 47);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleY, 48);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationX, 51);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationY, 52);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationZ, 53);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    mapToConstant.append(R.styleable.ConstraintSet_android_id, 38);
  }
  
  private void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5, int paramInt6, int paramInt7) {
    if (paramArrayOfint.length < 2)
      throw new IllegalArgumentException("must have 2 or more widgets in a chain"); 
    if (paramArrayOffloat != null && paramArrayOffloat.length != paramArrayOfint.length)
      throw new IllegalArgumentException("must have 2 or more widgets in a chain"); 
    if (paramArrayOffloat != null)
      (get(paramArrayOfint[0])).verticalWeight = paramArrayOffloat[0]; 
    (get(paramArrayOfint[0])).horizontalChainStyle = paramInt5;
    connect(paramArrayOfint[0], paramInt6, paramInt1, paramInt2, -1);
    for (paramInt1 = 1; paramInt1 < paramArrayOfint.length; paramInt1++) {
      paramInt2 = paramArrayOfint[paramInt1];
      connect(paramArrayOfint[paramInt1], paramInt6, paramArrayOfint[paramInt1 - 1], paramInt7, -1);
      connect(paramArrayOfint[paramInt1 - 1], paramInt7, paramArrayOfint[paramInt1], paramInt6, -1);
      if (paramArrayOffloat != null)
        (get(paramArrayOfint[paramInt1])).horizontalWeight = paramArrayOffloat[paramInt1]; 
    } 
    connect(paramArrayOfint[paramArrayOfint.length - 1], paramInt7, paramInt3, paramInt4, -1);
  }
  
  private Constraint fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet) {
    Constraint constraint = new Constraint();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    populateConstraint(constraint, typedArray);
    typedArray.recycle();
    return constraint;
  }
  
  private Constraint get(int paramInt) {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt)))
      this.mConstraints.put(Integer.valueOf(paramInt), new Constraint()); 
    return this.mConstraints.get(Integer.valueOf(paramInt));
  }
  
  private static int lookupID(TypedArray paramTypedArray, int paramInt1, int paramInt2) {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1)
      paramInt2 = paramTypedArray.getInt(paramInt1, -1); 
    return paramInt2;
  }
  
  private void populateConstraint(Constraint paramConstraint, TypedArray paramTypedArray) {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j) {
      int k = paramTypedArray.getIndex(i);
      switch (mapToConstant.get(k)) {
        case 25:
          paramConstraint.leftToLeft = lookupID(paramTypedArray, k, paramConstraint.leftToLeft);
          i++;
          break;
        case 26:
          paramConstraint.leftToRight = lookupID(paramTypedArray, k, paramConstraint.leftToRight);
          i++;
          break;
        case 29:
          paramConstraint.rightToLeft = lookupID(paramTypedArray, k, paramConstraint.rightToLeft);
          i++;
          break;
        case 30:
          paramConstraint.rightToRight = lookupID(paramTypedArray, k, paramConstraint.rightToRight);
          i++;
          break;
        case 36:
          paramConstraint.topToTop = lookupID(paramTypedArray, k, paramConstraint.topToTop);
          i++;
          break;
        case 35:
          paramConstraint.topToBottom = lookupID(paramTypedArray, k, paramConstraint.topToBottom);
          i++;
          break;
        case 4:
          paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.bottomToTop);
          i++;
          break;
        case 3:
          paramConstraint.bottomToBottom = lookupID(paramTypedArray, k, paramConstraint.bottomToBottom);
          i++;
          break;
        case 1:
          paramConstraint.baselineToBaseline = lookupID(paramTypedArray, k, paramConstraint.baselineToBaseline);
          i++;
          break;
        case 6:
          paramConstraint.editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteX);
          i++;
          break;
        case 7:
          paramConstraint.editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteY);
          i++;
          break;
        case 17:
          paramConstraint.guideBegin = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideBegin);
          i++;
          break;
        case 18:
          paramConstraint.guideEnd = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideEnd);
          i++;
          break;
        case 19:
          paramConstraint.guidePercent = paramTypedArray.getFloat(k, paramConstraint.guidePercent);
          i++;
          break;
        case 27:
          paramConstraint.orientation = paramTypedArray.getInt(k, paramConstraint.orientation);
          i++;
          break;
        case 32:
          paramConstraint.startToEnd = lookupID(paramTypedArray, k, paramConstraint.startToEnd);
          i++;
          break;
        case 33:
          paramConstraint.startToStart = lookupID(paramTypedArray, k, paramConstraint.startToStart);
          i++;
          break;
        case 10:
          paramConstraint.endToStart = lookupID(paramTypedArray, k, paramConstraint.endToStart);
          i++;
          break;
        case 9:
          paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.endToEnd);
          i++;
          break;
        case 13:
          paramConstraint.goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneLeftMargin);
          i++;
          break;
        case 16:
          paramConstraint.goneTopMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneTopMargin);
          i++;
          break;
        case 14:
          paramConstraint.goneRightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneRightMargin);
          i++;
          break;
        case 11:
          paramConstraint.goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneBottomMargin);
          i++;
          break;
        case 15:
          paramConstraint.goneStartMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneStartMargin);
          i++;
          break;
        case 12:
          paramConstraint.goneEndMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneEndMargin);
          i++;
          break;
        case 20:
          paramConstraint.horizontalBias = paramTypedArray.getFloat(k, paramConstraint.horizontalBias);
          i++;
          break;
        case 37:
          paramConstraint.verticalBias = paramTypedArray.getFloat(k, paramConstraint.verticalBias);
          i++;
          break;
        case 24:
          paramConstraint.leftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.leftMargin);
          i++;
          break;
        case 28:
          paramConstraint.rightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.rightMargin);
          i++;
          break;
        case 31:
          paramConstraint.startMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.startMargin);
          i++;
          break;
        case 8:
          paramConstraint.endMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.endMargin);
          i++;
          break;
        case 34:
          paramConstraint.topMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.topMargin);
          i++;
          break;
        case 2:
          paramConstraint.bottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.bottomMargin);
          i++;
          break;
        case 23:
          paramConstraint.mWidth = paramTypedArray.getLayoutDimension(k, paramConstraint.mWidth);
          i++;
          break;
        case 21:
          paramConstraint.mHeight = paramTypedArray.getLayoutDimension(k, paramConstraint.mHeight);
          i++;
          break;
        case 22:
          paramConstraint.visibility = paramTypedArray.getInt(k, paramConstraint.visibility);
          paramConstraint.visibility = VISIBILITY_FLAGS[paramConstraint.visibility];
          i++;
          break;
        case 43:
          paramConstraint.alpha = paramTypedArray.getFloat(k, paramConstraint.alpha);
          i++;
          break;
        case 44:
          paramConstraint.applyElevation = true;
          paramConstraint.elevation = paramTypedArray.getFloat(k, paramConstraint.elevation);
          i++;
          break;
        case 45:
          paramConstraint.rotationX = paramTypedArray.getFloat(k, paramConstraint.rotationX);
          i++;
          break;
        case 46:
          paramConstraint.rotationY = paramTypedArray.getFloat(k, paramConstraint.rotationY);
          i++;
          break;
        case 47:
          paramConstraint.scaleX = paramTypedArray.getFloat(k, paramConstraint.scaleX);
          i++;
          break;
        case 48:
          paramConstraint.scaleY = paramTypedArray.getFloat(k, paramConstraint.scaleY);
          i++;
          break;
        case 49:
          paramConstraint.transformPivotX = paramTypedArray.getFloat(k, paramConstraint.transformPivotX);
          i++;
          break;
        case 50:
          paramConstraint.transformPivotY = paramTypedArray.getFloat(k, paramConstraint.transformPivotY);
          i++;
          break;
        case 51:
          paramConstraint.translationX = paramTypedArray.getFloat(k, paramConstraint.translationX);
          i++;
          break;
        case 52:
          paramConstraint.translationY = paramTypedArray.getFloat(k, paramConstraint.translationY);
          i++;
          break;
        case 53:
          paramConstraint.translationZ = paramTypedArray.getFloat(k, paramConstraint.translationZ);
          i++;
          break;
        case 40:
          paramConstraint.verticalWeight = paramTypedArray.getFloat(k, paramConstraint.verticalWeight);
          i++;
          break;
        case 39:
          paramConstraint.horizontalWeight = paramTypedArray.getFloat(k, paramConstraint.horizontalWeight);
          i++;
          break;
        case 42:
          paramConstraint.verticalChainStyle = paramTypedArray.getInt(k, paramConstraint.verticalChainStyle);
          i++;
          break;
        case 41:
          paramConstraint.horizontalChainStyle = paramTypedArray.getInt(k, paramConstraint.horizontalChainStyle);
          i++;
          break;
        case 38:
          paramConstraint.mViewId = paramTypedArray.getResourceId(k, paramConstraint.mViewId);
          i++;
          break;
        case 5:
          paramConstraint.dimensionRatio = paramTypedArray.getString(k);
          i++;
          break;
        case 60:
          Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(k) + "   " + mapToConstant.get(k));
          i++;
          break;
      } 
    } 
  }
  
  private String sideToString(int paramInt) {
    switch (paramInt) {
      default:
        return "undefined";
      case 1:
        return "left";
      case 2:
        return "right";
      case 3:
        return "top";
      case 4:
        return "bottom";
      case 5:
        return "baseline";
      case 6:
        return "start";
      case 7:
        break;
    } 
    return "end";
  }
  
  public void addToHorizontalChain(int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    if (paramInt2 == 0) {
      b = 1;
    } else {
      b = 2;
    } 
    connect(paramInt1, 1, paramInt2, b, 0);
    if (paramInt3 == 0) {
      b = 2;
    } else {
      b = 1;
    } 
    connect(paramInt1, 2, paramInt3, b, 0);
    if (paramInt2 != 0)
      connect(paramInt2, 2, paramInt1, 1, 0); 
    if (paramInt3 != 0)
      connect(paramInt3, 1, paramInt1, 2, 0); 
  }
  
  public void addToHorizontalChainRTL(int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    if (paramInt2 == 0) {
      b = 6;
    } else {
      b = 7;
    } 
    connect(paramInt1, 6, paramInt2, b, 0);
    if (paramInt3 == 0) {
      b = 7;
    } else {
      b = 6;
    } 
    connect(paramInt1, 7, paramInt3, b, 0);
    if (paramInt2 != 0)
      connect(paramInt2, 7, paramInt1, 6, 0); 
    if (paramInt3 != 0)
      connect(paramInt3, 6, paramInt1, 7, 0); 
  }
  
  public void addToVerticalChain(int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    if (paramInt2 == 0) {
      b = 3;
    } else {
      b = 4;
    } 
    connect(paramInt1, 3, paramInt2, b, 0);
    if (paramInt3 == 0) {
      b = 4;
    } else {
      b = 3;
    } 
    connect(paramInt1, 4, paramInt3, b, 0);
    if (paramInt2 != 0)
      connect(paramInt2, 4, paramInt1, 3, 0); 
    if (paramInt2 != 0)
      connect(paramInt3, 3, paramInt1, 4, 0); 
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout) {
    applyToInternal(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet((ConstraintSet)null);
  }
  
  void applyToInternal(ConstraintLayout paramConstraintLayout) {
    int j = paramConstraintLayout.getChildCount();
    HashSet hashSet = new HashSet(this.mConstraints.keySet());
    for (int i = 0; i < j; i++) {
      View view = paramConstraintLayout.getChildAt(i);
      int k = view.getId();
      if (this.mConstraints.containsKey(Integer.valueOf(k))) {
        hashSet.remove(Integer.valueOf(k));
        Constraint constraint = this.mConstraints.get(Integer.valueOf(k));
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();
        constraint.applyTo(layoutParams);
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        view.setVisibility(constraint.visibility);
        if (Build.VERSION.SDK_INT >= 17) {
          view.setAlpha(constraint.alpha);
          view.setRotationX(constraint.rotationX);
          view.setRotationY(constraint.rotationY);
          view.setScaleX(constraint.scaleX);
          view.setScaleY(constraint.scaleY);
          view.setPivotX(constraint.transformPivotX);
          view.setPivotY(constraint.transformPivotY);
          view.setTranslationX(constraint.translationX);
          view.setTranslationY(constraint.translationY);
          if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(constraint.translationZ);
            if (constraint.applyElevation)
              view.setElevation(constraint.elevation); 
          } 
        } 
      } 
    } 
    for (Integer integer : hashSet) {
      Constraint constraint = this.mConstraints.get(integer);
      if (constraint.mIsGuideline) {
        Guideline guideline = new Guideline(paramConstraintLayout.getContext());
        guideline.setId(integer.intValue());
        ConstraintLayout.LayoutParams layoutParams = paramConstraintLayout.generateDefaultLayoutParams();
        constraint.applyTo(layoutParams);
        paramConstraintLayout.addView(guideline, (ViewGroup.LayoutParams)layoutParams);
      } 
    } 
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    if (paramInt4 < 0)
      throw new IllegalArgumentException("margin must be > 0"); 
    if (paramInt7 < 0)
      throw new IllegalArgumentException("margin must be > 0"); 
    if (paramFloat <= 0.0F || paramFloat > 1.0F)
      throw new IllegalArgumentException("bias must be between 0 and 1 inclusive"); 
    if (paramInt3 == 1 || paramInt3 == 2) {
      connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
      ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
      return;
    } 
    if (paramInt3 == 6 || paramInt3 == 7) {
      connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
      ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
      return;
    } 
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      center(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    } 
    center(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      center(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    } 
    center(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerVertically(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      center(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    } 
    center(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void clear(int paramInt) {
    this.mConstraints.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2) {
    Constraint constraint;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      constraint = this.mConstraints.get(Integer.valueOf(paramInt1));
      switch (paramInt2) {
        default:
          throw new IllegalArgumentException("unknown constraint");
        case 1:
          constraint.leftToRight = -1;
          constraint.leftToLeft = -1;
          constraint.leftMargin = -1;
          constraint.goneLeftMargin = -1;
          return;
        case 2:
          constraint.rightToRight = -1;
          constraint.rightToLeft = -1;
          constraint.rightMargin = -1;
          constraint.goneRightMargin = -1;
          return;
        case 3:
          constraint.topToBottom = -1;
          constraint.topToTop = -1;
          constraint.topMargin = -1;
          constraint.goneTopMargin = -1;
          return;
        case 4:
          constraint.bottomToTop = -1;
          constraint.bottomToBottom = -1;
          constraint.bottomMargin = -1;
          constraint.goneBottomMargin = -1;
          return;
        case 5:
          constraint.baselineToBaseline = -1;
          return;
        case 6:
          constraint.startToEnd = -1;
          constraint.startToStart = -1;
          constraint.startMargin = -1;
          constraint.goneStartMargin = -1;
          return;
        case 7:
          break;
      } 
    } else {
      return;
    } 
    constraint.endToStart = -1;
    constraint.endToEnd = -1;
    constraint.endMargin = -1;
    constraint.goneEndMargin = -1;
  }
  
  public void clone(Context paramContext, int paramInt) {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout) {
    int j = paramConstraintLayout.getChildCount();
    this.mConstraints.clear();
    for (int i = 0; i < j; i++) {
      View view = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();
      int k = view.getId();
      if (!this.mConstraints.containsKey(Integer.valueOf(k)))
        this.mConstraints.put(Integer.valueOf(k), new Constraint()); 
      Constraint constraint = this.mConstraints.get(Integer.valueOf(k));
      constraint.fillFrom(k, layoutParams);
      constraint.visibility = view.getVisibility();
      if (Build.VERSION.SDK_INT >= 17) {
        constraint.alpha = view.getAlpha();
        constraint.rotationX = view.getRotationX();
        constraint.rotationY = view.getRotationY();
        constraint.scaleX = view.getScaleX();
        constraint.scaleY = view.getScaleY();
        constraint.transformPivotX = view.getPivotX();
        constraint.transformPivotY = view.getPivotY();
        constraint.translationX = view.getTranslationX();
        constraint.translationY = view.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21) {
          constraint.translationZ = view.getTranslationZ();
          if (constraint.applyElevation)
            constraint.elevation = view.getElevation(); 
        } 
      } 
    } 
  }
  
  public void clone(ConstraintSet paramConstraintSet) {
    this.mConstraints.clear();
    for (Integer integer : paramConstraintSet.mConstraints.keySet())
      this.mConstraints.put(integer, ((Constraint)paramConstraintSet.mConstraints.get(integer)).clone()); 
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1)))
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint()); 
    Constraint constraint = this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2) {
      default:
        throw new IllegalArgumentException(sideToString(paramInt2) + " to " + sideToString(paramInt4) + " unknown");
      case 1:
        if (paramInt4 == 1) {
          constraint.leftToLeft = paramInt3;
          constraint.leftToRight = -1;
          return;
        } 
        if (paramInt4 == 2) {
          constraint.leftToRight = paramInt3;
          constraint.leftToLeft = -1;
          return;
        } 
        throw new IllegalArgumentException("left to " + sideToString(paramInt4) + " undefined");
      case 2:
        if (paramInt4 == 1) {
          constraint.rightToLeft = paramInt3;
          constraint.rightToRight = -1;
          return;
        } 
        if (paramInt4 == 2) {
          constraint.rightToRight = paramInt3;
          constraint.rightToLeft = -1;
          return;
        } 
        throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
      case 3:
        if (paramInt4 == 3) {
          constraint.topToTop = paramInt3;
          constraint.topToBottom = -1;
          constraint.baselineToBaseline = -1;
          return;
        } 
        if (paramInt4 == 4) {
          constraint.topToBottom = paramInt3;
          constraint.topToTop = -1;
          constraint.baselineToBaseline = -1;
          return;
        } 
        throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
      case 4:
        if (paramInt4 == 4) {
          constraint.bottomToBottom = paramInt3;
          constraint.bottomToTop = -1;
          constraint.baselineToBaseline = -1;
          return;
        } 
        if (paramInt4 == 3) {
          constraint.bottomToTop = paramInt3;
          constraint.bottomToBottom = -1;
          constraint.baselineToBaseline = -1;
          return;
        } 
        throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
      case 5:
        if (paramInt4 == 5) {
          constraint.baselineToBaseline = paramInt3;
          constraint.bottomToBottom = -1;
          constraint.bottomToTop = -1;
          constraint.topToTop = -1;
          constraint.topToBottom = -1;
          return;
        } 
        throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
      case 6:
        if (paramInt4 == 6) {
          constraint.startToStart = paramInt3;
          constraint.startToEnd = -1;
          return;
        } 
        if (paramInt4 == 7) {
          constraint.startToEnd = paramInt3;
          constraint.startToStart = -1;
          return;
        } 
        throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
      case 7:
        break;
    } 
    if (paramInt4 == 7) {
      constraint.endToEnd = paramInt3;
      constraint.endToStart = -1;
      return;
    } 
    if (paramInt4 == 6) {
      constraint.endToStart = paramInt3;
      constraint.endToEnd = -1;
      return;
    } 
    throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1)))
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint()); 
    Constraint constraint = this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2) {
      default:
        throw new IllegalArgumentException(sideToString(paramInt2) + " to " + sideToString(paramInt4) + " unknown");
      case 1:
        if (paramInt4 == 1) {
          constraint.leftToLeft = paramInt3;
          constraint.leftToRight = -1;
        } else if (paramInt4 == 2) {
          constraint.leftToRight = paramInt3;
          constraint.leftToLeft = -1;
        } else {
          throw new IllegalArgumentException("Left to " + sideToString(paramInt4) + " undefined");
        } 
        constraint.leftMargin = paramInt5;
        return;
      case 2:
        if (paramInt4 == 1) {
          constraint.rightToLeft = paramInt3;
          constraint.rightToRight = -1;
        } else if (paramInt4 == 2) {
          constraint.rightToRight = paramInt3;
          constraint.rightToLeft = -1;
        } else {
          throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
        } 
        constraint.rightMargin = paramInt5;
        return;
      case 3:
        if (paramInt4 == 3) {
          constraint.topToTop = paramInt3;
          constraint.topToBottom = -1;
          constraint.baselineToBaseline = -1;
        } else if (paramInt4 == 4) {
          constraint.topToBottom = paramInt3;
          constraint.topToTop = -1;
          constraint.baselineToBaseline = -1;
        } else {
          throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
        } 
        constraint.topMargin = paramInt5;
        return;
      case 4:
        if (paramInt4 == 4) {
          constraint.bottomToBottom = paramInt3;
          constraint.bottomToTop = -1;
          constraint.baselineToBaseline = -1;
        } else if (paramInt4 == 3) {
          constraint.bottomToTop = paramInt3;
          constraint.bottomToBottom = -1;
          constraint.baselineToBaseline = -1;
        } else {
          throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
        } 
        constraint.bottomMargin = paramInt5;
        return;
      case 5:
        if (paramInt4 == 5) {
          constraint.baselineToBaseline = paramInt3;
          constraint.bottomToBottom = -1;
          constraint.bottomToTop = -1;
          constraint.topToTop = -1;
          constraint.topToBottom = -1;
          return;
        } 
        throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
      case 6:
        if (paramInt4 == 6) {
          constraint.startToStart = paramInt3;
          constraint.startToEnd = -1;
        } else if (paramInt4 == 7) {
          constraint.startToEnd = paramInt3;
          constraint.startToStart = -1;
        } else {
          throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
        } 
        constraint.startMargin = paramInt5;
        return;
      case 7:
        break;
    } 
    if (paramInt4 == 7) {
      constraint.endToEnd = paramInt3;
      constraint.endToStart = -1;
    } else if (paramInt4 == 6) {
      constraint.endToStart = paramInt3;
      constraint.endToEnd = -1;
    } else {
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    } 
    constraint.endMargin = paramInt5;
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2) {
    (get(paramInt1)).heightDefault = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2) {
    (get(paramInt1)).widthDefault = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2) {
    (get(paramInt1)).mHeight = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2) {
    (get(paramInt1)).heightMax = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2) {
    (get(paramInt1)).widthMax = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2) {
    (get(paramInt1)).heightMin = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2) {
    (get(paramInt1)).widthMin = paramInt2;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2) {
    (get(paramInt1)).mWidth = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2) {
    Constraint constraint = get(paramInt1);
    constraint.mIsGuideline = true;
    constraint.orientation = paramInt2;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5) {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramArrayOffloat, paramInt5, 1, 2);
  }
  
  public void createHorizontalChainRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5) {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramArrayOffloat, paramInt5, 6, 7);
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5) {
    if (paramArrayOfint.length < 2)
      throw new IllegalArgumentException("must have 2 or more widgets in a chain"); 
    if (paramArrayOffloat != null && paramArrayOffloat.length != paramArrayOfint.length)
      throw new IllegalArgumentException("must have 2 or more widgets in a chain"); 
    if (paramArrayOffloat != null)
      (get(paramArrayOfint[0])).verticalWeight = paramArrayOffloat[0]; 
    (get(paramArrayOfint[0])).verticalChainStyle = paramInt5;
    connect(paramArrayOfint[0], 3, paramInt1, paramInt2, 0);
    for (paramInt1 = 1; paramInt1 < paramArrayOfint.length; paramInt1++) {
      paramInt2 = paramArrayOfint[paramInt1];
      connect(paramArrayOfint[paramInt1], 3, paramArrayOfint[paramInt1 - 1], 4, 0);
      connect(paramArrayOfint[paramInt1 - 1], 4, paramArrayOfint[paramInt1], 3, 0);
      if (paramArrayOffloat != null)
        (get(paramArrayOfint[paramInt1])).verticalWeight = paramArrayOffloat[paramInt1]; 
    } 
    connect(paramArrayOfint[paramArrayOfint.length - 1], 4, paramInt3, paramInt4, 0);
  }
  
  public boolean getApplyElevation(int paramInt) {
    return (get(paramInt)).applyElevation;
  }
  
  public void load(Context paramContext, int paramInt) {
    XmlResourceParser xmlResourceParser = paramContext.getResources().getXml(paramInt);
    try {
      paramInt = xmlResourceParser.getEventType();
    } catch (XmlPullParserException xmlPullParserException) {
      xmlPullParserException.printStackTrace();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
    while (true) {
      if (paramInt != 1) {
        String str;
        Constraint constraint;
        switch (paramInt) {
          case 1:
            paramInt = xmlResourceParser.next();
            break;
          case 0:
            xmlResourceParser.getName();
          case 2:
            str = xmlResourceParser.getName();
            constraint = fillFromAttributeList((Context)iOException, Xml.asAttributeSet((XmlPullParser)xmlResourceParser));
            if (str.equalsIgnoreCase("Guideline"))
              constraint.mIsGuideline = true; 
            this.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
          case 3:
            paramInt = xmlResourceParser.next();
            break;
        } 
        continue;
      } 
      return;
    } 
  }
  
  public void removeFromHorizontalChain(int paramInt) {
    int i;
    Constraint constraint;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      constraint = this.mConstraints.get(Integer.valueOf(paramInt));
      i = constraint.leftToRight;
      int m = constraint.rightToLeft;
      if (i != -1 || m != -1) {
        if (i != -1 && m != -1) {
          connect(i, 2, m, 1, 0);
          connect(m, 1, i, 2, 0);
        } else if (i != -1 || m != -1) {
          if (constraint.rightToRight != -1) {
            connect(i, 2, constraint.rightToRight, 2, 0);
          } else if (constraint.leftToLeft != -1) {
            connect(m, 1, constraint.leftToLeft, 1, 0);
          } 
        } 
        clear(paramInt, 1);
        clear(paramInt, 2);
        return;
      } 
    } else {
      return;
    } 
    int j = constraint.startToEnd;
    int k = constraint.endToStart;
    if (j != -1 || k != -1)
      if (j != -1 && k != -1) {
        connect(j, 7, k, 6, 0);
        connect(k, 6, i, 7, 0);
      } else if (i != -1 || k != -1) {
        if (constraint.rightToRight != -1) {
          connect(i, 7, constraint.rightToRight, 7, 0);
        } else if (constraint.leftToLeft != -1) {
          connect(k, 6, constraint.leftToLeft, 6, 0);
        } 
      }  
    clear(paramInt, 6);
    clear(paramInt, 7);
  }
  
  public void removeFromVerticalChain(int paramInt) {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      Constraint constraint = this.mConstraints.get(Integer.valueOf(paramInt));
      int i = constraint.topToBottom;
      int j = constraint.bottomToTop;
      if (i != -1 || j != -1)
        if (i != -1 && j != -1) {
          connect(i, 4, j, 3, 0);
          connect(j, 3, i, 4, 0);
        } else if (i != -1 || j != -1) {
          if (constraint.bottomToBottom != -1) {
            connect(i, 4, constraint.bottomToBottom, 4, 0);
          } else if (constraint.topToTop != -1) {
            connect(j, 3, constraint.topToTop, 3, 0);
          } 
        }  
    } 
    clear(paramInt, 3);
    clear(paramInt, 4);
  }
  
  public void setAlpha(int paramInt, float paramFloat) {
    (get(paramInt)).alpha = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean) {
    (get(paramInt)).applyElevation = paramBoolean;
  }
  
  public void setDimensionRatio(int paramInt, String paramString) {
    (get(paramInt)).dimensionRatio = paramString;
  }
  
  public void setElevation(int paramInt, float paramFloat) {
    (get(paramInt)).elevation = paramFloat;
    (get(paramInt)).applyElevation = true;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3) {
    Constraint constraint = get(paramInt1);
    switch (paramInt2) {
      default:
        throw new IllegalArgumentException("unknown constraint");
      case 1:
        constraint.goneLeftMargin = paramInt3;
        return;
      case 2:
        constraint.goneRightMargin = paramInt3;
        return;
      case 3:
        constraint.goneTopMargin = paramInt3;
        return;
      case 4:
        constraint.goneBottomMargin = paramInt3;
        return;
      case 5:
        throw new IllegalArgumentException("baseline does not support margins");
      case 6:
        constraint.goneStartMargin = paramInt3;
        return;
      case 7:
        break;
    } 
    constraint.goneEndMargin = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2) {
    (get(paramInt1)).guideBegin = paramInt2;
    (get(paramInt1)).guideEnd = -1;
    (get(paramInt1)).guidePercent = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2) {
    (get(paramInt1)).guideEnd = paramInt2;
    (get(paramInt1)).guideBegin = -1;
    (get(paramInt1)).guidePercent = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat) {
    (get(paramInt)).guidePercent = paramFloat;
    (get(paramInt)).guideEnd = -1;
    (get(paramInt)).guideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat) {
    (get(paramInt)).horizontalBias = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2) {
    (get(paramInt1)).horizontalChainStyle = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat) {
    (get(paramInt)).horizontalWeight = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3) {
    Constraint constraint = get(paramInt1);
    switch (paramInt2) {
      default:
        throw new IllegalArgumentException("unknown constraint");
      case 1:
        constraint.leftMargin = paramInt3;
        return;
      case 2:
        constraint.rightMargin = paramInt3;
        return;
      case 3:
        constraint.topMargin = paramInt3;
        return;
      case 4:
        constraint.bottomMargin = paramInt3;
        return;
      case 5:
        throw new IllegalArgumentException("baseline does not support margins");
      case 6:
        constraint.startMargin = paramInt3;
        return;
      case 7:
        break;
    } 
    constraint.endMargin = paramInt3;
  }
  
  public void setRotationX(int paramInt, float paramFloat) {
    (get(paramInt)).rotationX = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat) {
    (get(paramInt)).rotationY = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat) {
    (get(paramInt)).scaleX = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat) {
    (get(paramInt)).scaleY = paramFloat;
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2) {
    Constraint constraint = get(paramInt);
    constraint.transformPivotY = paramFloat2;
    constraint.transformPivotX = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat) {
    (get(paramInt)).transformPivotX = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat) {
    (get(paramInt)).transformPivotY = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2) {
    Constraint constraint = get(paramInt);
    constraint.translationX = paramFloat1;
    constraint.translationY = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat) {
    (get(paramInt)).translationX = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat) {
    (get(paramInt)).translationY = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat) {
    (get(paramInt)).translationZ = paramFloat;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat) {
    (get(paramInt)).verticalBias = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2) {
    (get(paramInt1)).verticalChainStyle = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat) {
    (get(paramInt)).verticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2) {
    (get(paramInt1)).visibility = paramInt2;
  }
  
  private static class Constraint {
    static final int UNSET = -1;
    
    public float alpha = 1.0F;
    
    public boolean applyElevation = false;
    
    public int baselineToBaseline = -1;
    
    public int bottomMargin = -1;
    
    public int bottomToBottom = -1;
    
    public int bottomToTop = -1;
    
    public String dimensionRatio = null;
    
    public int editorAbsoluteX = -1;
    
    public int editorAbsoluteY = -1;
    
    public float elevation = 0.0F;
    
    public int endMargin = -1;
    
    public int endToEnd = -1;
    
    public int endToStart = -1;
    
    public int goneBottomMargin = -1;
    
    public int goneEndMargin = -1;
    
    public int goneLeftMargin = -1;
    
    public int goneRightMargin = -1;
    
    public int goneStartMargin = -1;
    
    public int goneTopMargin = -1;
    
    public int guideBegin = -1;
    
    public int guideEnd = -1;
    
    public float guidePercent = -1.0F;
    
    public int heightDefault = -1;
    
    public int heightMax = -1;
    
    public int heightMin = -1;
    
    public float horizontalBias = 0.5F;
    
    public int horizontalChainStyle = 0;
    
    public float horizontalWeight = 0.0F;
    
    public int leftMargin = -1;
    
    public int leftToLeft = -1;
    
    public int leftToRight = -1;
    
    public int mHeight;
    
    boolean mIsGuideline = false;
    
    int mViewId;
    
    public int mWidth;
    
    public int orientation = -1;
    
    public int rightMargin = -1;
    
    public int rightToLeft = -1;
    
    public int rightToRight = -1;
    
    public float rotationX = 0.0F;
    
    public float rotationY = 0.0F;
    
    public float scaleX = 1.0F;
    
    public float scaleY = 1.0F;
    
    public int startMargin = -1;
    
    public int startToEnd = -1;
    
    public int startToStart = -1;
    
    public int topMargin = -1;
    
    public int topToBottom = -1;
    
    public int topToTop = -1;
    
    public float transformPivotX = 0.0F;
    
    public float transformPivotY = 0.0F;
    
    public float translationX = 0.0F;
    
    public float translationY = 0.0F;
    
    public float translationZ = 0.0F;
    
    public float verticalBias = 0.5F;
    
    public int verticalChainStyle = 0;
    
    public float verticalWeight = 0.0F;
    
    public int visibility = 0;
    
    public int widthDefault = -1;
    
    public int widthMax = -1;
    
    public int widthMin = -1;
    
    private Constraint() {}
    
    private void fillFrom(int param1Int, ConstraintLayout.LayoutParams param1LayoutParams) {
      this.mViewId = param1Int;
      this.leftToLeft = param1LayoutParams.leftToLeft;
      this.leftToRight = param1LayoutParams.leftToRight;
      this.rightToLeft = param1LayoutParams.rightToLeft;
      this.rightToRight = param1LayoutParams.rightToRight;
      this.topToTop = param1LayoutParams.topToTop;
      this.topToBottom = param1LayoutParams.topToBottom;
      this.bottomToTop = param1LayoutParams.bottomToTop;
      this.bottomToBottom = param1LayoutParams.bottomToBottom;
      this.baselineToBaseline = param1LayoutParams.baselineToBaseline;
      this.startToEnd = param1LayoutParams.startToEnd;
      this.startToStart = param1LayoutParams.startToStart;
      this.endToStart = param1LayoutParams.endToStart;
      this.endToEnd = param1LayoutParams.endToEnd;
      this.horizontalBias = param1LayoutParams.horizontalBias;
      this.verticalBias = param1LayoutParams.verticalBias;
      this.dimensionRatio = param1LayoutParams.dimensionRatio;
      this.editorAbsoluteX = param1LayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = param1LayoutParams.editorAbsoluteY;
      this.orientation = param1LayoutParams.orientation;
      this.guidePercent = param1LayoutParams.guidePercent;
      this.guideBegin = param1LayoutParams.guideBegin;
      this.guideEnd = param1LayoutParams.guideEnd;
      this.mWidth = param1LayoutParams.width;
      this.mHeight = param1LayoutParams.height;
      this.leftMargin = param1LayoutParams.leftMargin;
      this.rightMargin = param1LayoutParams.rightMargin;
      this.topMargin = param1LayoutParams.topMargin;
      this.bottomMargin = param1LayoutParams.bottomMargin;
      this.verticalWeight = param1LayoutParams.verticalWeight;
      this.horizontalWeight = param1LayoutParams.horizontalWeight;
      this.verticalChainStyle = param1LayoutParams.verticalChainStyle;
      this.horizontalChainStyle = param1LayoutParams.horizontalChainStyle;
      this.widthDefault = param1LayoutParams.matchConstraintDefaultWidth;
      this.heightDefault = param1LayoutParams.matchConstraintDefaultHeight;
      this.widthMax = param1LayoutParams.matchConstraintMaxWidth;
      this.heightMax = param1LayoutParams.matchConstraintMaxHeight;
      this.widthMin = param1LayoutParams.matchConstraintMinWidth;
      this.heightMin = param1LayoutParams.matchConstraintMinHeight;
      if (Build.VERSION.SDK_INT >= 17) {
        this.endMargin = param1LayoutParams.getMarginEnd();
        this.startMargin = param1LayoutParams.getMarginStart();
      } 
    }
    
    public void applyTo(ConstraintLayout.LayoutParams param1LayoutParams) {
      param1LayoutParams.leftToLeft = this.leftToLeft;
      param1LayoutParams.leftToRight = this.leftToRight;
      param1LayoutParams.rightToLeft = this.rightToLeft;
      param1LayoutParams.rightToRight = this.rightToRight;
      param1LayoutParams.topToTop = this.topToTop;
      param1LayoutParams.topToBottom = this.topToBottom;
      param1LayoutParams.bottomToTop = this.bottomToTop;
      param1LayoutParams.bottomToBottom = this.bottomToBottom;
      param1LayoutParams.baselineToBaseline = this.baselineToBaseline;
      param1LayoutParams.startToEnd = this.startToEnd;
      param1LayoutParams.startToStart = this.startToStart;
      param1LayoutParams.endToStart = this.endToStart;
      param1LayoutParams.endToEnd = this.endToEnd;
      param1LayoutParams.leftMargin = this.leftMargin;
      param1LayoutParams.rightMargin = this.rightMargin;
      param1LayoutParams.topMargin = this.topMargin;
      param1LayoutParams.bottomMargin = this.bottomMargin;
      param1LayoutParams.goneStartMargin = this.goneStartMargin;
      param1LayoutParams.goneEndMargin = this.goneEndMargin;
      param1LayoutParams.horizontalBias = this.horizontalBias;
      param1LayoutParams.verticalBias = this.verticalBias;
      param1LayoutParams.dimensionRatio = this.dimensionRatio;
      param1LayoutParams.editorAbsoluteX = this.editorAbsoluteX;
      param1LayoutParams.editorAbsoluteY = this.editorAbsoluteY;
      param1LayoutParams.verticalWeight = this.verticalWeight;
      param1LayoutParams.horizontalWeight = this.horizontalWeight;
      param1LayoutParams.verticalChainStyle = this.verticalChainStyle;
      param1LayoutParams.horizontalChainStyle = this.horizontalChainStyle;
      param1LayoutParams.matchConstraintDefaultWidth = this.widthDefault;
      param1LayoutParams.matchConstraintDefaultHeight = this.heightDefault;
      param1LayoutParams.matchConstraintMaxWidth = this.widthMax;
      param1LayoutParams.matchConstraintMaxHeight = this.heightMax;
      param1LayoutParams.matchConstraintMinWidth = this.widthMin;
      param1LayoutParams.matchConstraintMinHeight = this.heightMin;
      param1LayoutParams.orientation = this.orientation;
      param1LayoutParams.guidePercent = this.guidePercent;
      param1LayoutParams.guideBegin = this.guideBegin;
      param1LayoutParams.guideEnd = this.guideEnd;
      param1LayoutParams.width = this.mWidth;
      param1LayoutParams.height = this.mHeight;
      if (Build.VERSION.SDK_INT >= 17) {
        param1LayoutParams.setMarginStart(this.startMargin);
        param1LayoutParams.setMarginEnd(this.endMargin);
      } 
      param1LayoutParams.validate();
    }
    
    public Constraint clone() {
      Constraint constraint = new Constraint();
      constraint.mIsGuideline = this.mIsGuideline;
      constraint.mWidth = this.mWidth;
      constraint.mHeight = this.mHeight;
      constraint.guideBegin = this.guideBegin;
      constraint.guideEnd = this.guideEnd;
      constraint.guidePercent = this.guidePercent;
      constraint.leftToLeft = this.leftToLeft;
      constraint.leftToRight = this.leftToRight;
      constraint.rightToLeft = this.rightToLeft;
      constraint.rightToRight = this.rightToRight;
      constraint.topToTop = this.topToTop;
      constraint.topToBottom = this.topToBottom;
      constraint.bottomToTop = this.bottomToTop;
      constraint.bottomToBottom = this.bottomToBottom;
      constraint.baselineToBaseline = this.baselineToBaseline;
      constraint.startToEnd = this.startToEnd;
      constraint.startToStart = this.startToStart;
      constraint.endToStart = this.endToStart;
      constraint.endToEnd = this.endToEnd;
      constraint.horizontalBias = this.horizontalBias;
      constraint.verticalBias = this.verticalBias;
      constraint.dimensionRatio = this.dimensionRatio;
      constraint.editorAbsoluteX = this.editorAbsoluteX;
      constraint.editorAbsoluteY = this.editorAbsoluteY;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.orientation = this.orientation;
      constraint.leftMargin = this.leftMargin;
      constraint.rightMargin = this.rightMargin;
      constraint.topMargin = this.topMargin;
      constraint.bottomMargin = this.bottomMargin;
      constraint.endMargin = this.endMargin;
      constraint.startMargin = this.startMargin;
      constraint.visibility = this.visibility;
      constraint.goneLeftMargin = this.goneLeftMargin;
      constraint.goneTopMargin = this.goneTopMargin;
      constraint.goneRightMargin = this.goneRightMargin;
      constraint.goneBottomMargin = this.goneBottomMargin;
      constraint.goneEndMargin = this.goneEndMargin;
      constraint.goneStartMargin = this.goneStartMargin;
      constraint.verticalWeight = this.verticalWeight;
      constraint.horizontalWeight = this.horizontalWeight;
      constraint.horizontalChainStyle = this.horizontalChainStyle;
      constraint.verticalChainStyle = this.verticalChainStyle;
      constraint.alpha = this.alpha;
      constraint.applyElevation = this.applyElevation;
      constraint.elevation = this.elevation;
      constraint.rotationX = this.rotationX;
      constraint.rotationY = this.rotationY;
      constraint.scaleX = this.scaleX;
      constraint.scaleY = this.scaleY;
      constraint.transformPivotX = this.transformPivotX;
      constraint.transformPivotY = this.transformPivotY;
      constraint.translationX = this.translationX;
      constraint.translationY = this.translationY;
      constraint.translationZ = this.translationZ;
      constraint.widthDefault = this.widthDefault;
      constraint.heightDefault = this.heightDefault;
      constraint.widthMax = this.widthMax;
      constraint.heightMax = this.heightMax;
      constraint.widthMin = this.widthMin;
      constraint.heightMin = this.heightMin;
      return constraint;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\constraint\ConstraintSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */