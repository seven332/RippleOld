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

// Get most code from android.util.MathUtils
public final class MathUtils {

    public static float lerp(float start, float stop, float amount) {
        return start + (stop - start) * amount;
    }

    /**
     * Returns the input value x clamped to the range [min, max].
     *
     * @param x
     * @param min
     * @param max
     * @return
     */
    public static int clamp(int x, int min, int max) {
        if (x > max) return max;
        if (x < min) return min;
        return x;
    }

    /**
     * Returns the input value x clamped to the range [min, max].
     *
     * @param x
     * @param min
     * @param max
     * @return
     */
    public static float clamp(float x, float min, float max) {
        if (x > max) return max;
        if (x < min) return min;
        return x;
    }
}
