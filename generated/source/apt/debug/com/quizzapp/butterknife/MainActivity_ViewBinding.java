// Generated code from Butter Knife. Do not modify!
package com.quizzapp.butterknife;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mRadioGroup1 = Utils.findRequiredViewAsType(source, R.id.radiogroup1, "field 'mRadioGroup1'", RadioGroup.class);
    target.mRadioGroup2 = Utils.findRequiredViewAsType(source, R.id.radiogroup2, "field 'mRadioGroup2'", RadioGroup.class);
    target.mRadioGroup3 = Utils.findRequiredViewAsType(source, R.id.radiogroup3, "field 'mRadioGroup3'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRadioGroup1 = null;
    target.mRadioGroup2 = null;
    target.mRadioGroup3 = null;
  }
}
