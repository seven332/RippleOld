/*
 * Copyright (C) 2015 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.rippleold;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import com.hippo.hotspot.HotspotTouchHelper;

public final class RippleSalon {

    private static final int RIPPLE_MATERIAL_DARK = 0x4dffffff;
    private static final int RIPPLE_MATERIAL_LIGHT = 0x1f000000;

    public static void addRipple(View c, boolean dark) {
        ColorStateList color = ColorStateList.valueOf(
                dark ? RIPPLE_MATERIAL_DARK : RIPPLE_MATERIAL_LIGHT);
        addRipple(c, color);
    }

    public static void addRipple(View v, ColorStateList color) {
        Drawable bg = v.getBackground();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (bg instanceof RippleDrawable) {
                return;
            }
        } else {
            if (bg instanceof android.graphics.drawable.RippleDrawable) {
                return;
            }
        }
        addRipple(v, color, v.getBackground());
    }

    @SuppressWarnings("deprecation")
    public static void addRipple(View v, ColorStateList color, Drawable content) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            RippleDrawable rippleDrawable = new RippleDrawable(color, content);
            HotspotTouchHelper.setHotspotTouchHelper(v, new HotspotTouchHelper(rippleDrawable));
            v.setBackgroundDrawable(rippleDrawable);
        } else {
            android.graphics.drawable.RippleDrawable rippleDrawable =
                    new android.graphics.drawable.RippleDrawable(color, content, new ColorDrawable(Color.BLACK));
            v.setBackground(rippleDrawable);
        }
    }

    public static Drawable generateRippleDrawable(boolean dark) {
        return generateRippleDrawable(dark, null);
    }

    public static Drawable generateRippleDrawable(ColorStateList color) {
        return generateRippleDrawable(color, null);
    }

    public static Drawable generateRippleDrawable(boolean dark, Drawable content) {
        ColorStateList color = ColorStateList.valueOf(
                dark ? RIPPLE_MATERIAL_DARK : RIPPLE_MATERIAL_LIGHT);
        return generateRippleDrawable(color, content);
    }

    public static Drawable generateRippleDrawable(ColorStateList color, Drawable content) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return new RippleDrawable(color, content);
        } else {
            return new android.graphics.drawable.RippleDrawable(color, content, new ColorDrawable(Color.BLACK));
        }
    }
}
