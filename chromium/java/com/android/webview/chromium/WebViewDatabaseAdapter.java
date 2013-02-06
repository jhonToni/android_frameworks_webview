/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.android.webview.chromium;

import android.content.Context;
import android.webkit.WebViewDatabase;

import org.chromium.android_webview.HttpAuthDatabase;

/**
 * Chromium implementation of WebViewDatabase -- forwards calls to the
 * chromium internal implementation.
 */
final class WebViewDatabaseAdapter extends WebViewDatabase {

    private Context mContext;

    public WebViewDatabaseAdapter(Context context) {
        mContext = context;
    }

    @Override
    public boolean hasUsernamePassword() {
        // This is a deprecated API: intentional no-op.
        return false;
    }

    @Override
    public void clearUsernamePassword() {
        // This is a deprecated API: intentional no-op.
    }

    @Override
    public boolean hasHttpAuthUsernamePassword() {
        return HttpAuthDatabase.getInstance(mContext).hasHttpAuthUsernamePassword();
    }

    @Override
    public void clearHttpAuthUsernamePassword() {
        HttpAuthDatabase.getInstance(mContext).clearHttpAuthUsernamePassword();
    }

    @Override
    public boolean hasFormData() {
        UnimplementedWebViewApi.invoke();
        return false;
    }

    @Override
    public void clearFormData() {
        UnimplementedWebViewApi.invoke();
    }
}
