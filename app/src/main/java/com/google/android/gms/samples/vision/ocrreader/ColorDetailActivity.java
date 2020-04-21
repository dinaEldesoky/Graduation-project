package com.google.android.gms.samples.vision.ocrreader;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import com.google.android.gms.samples.vision.ocrreader.R;
import com.google.android.gms.samples.vision.ocrreader.data.ColorItem;


import com.google.android.gms.samples.vision.ocrreader.data.ColorItems;


public class ColorDetailActivity extends AppCompatActivity  {
    /**
     * A key for passing the global visible rect of the clicked color preview clicked.
     */
    private static final String EXTRA_START_BOUNDS = "ColorDetailActivity.Extras.EXTRA_START_BOUNDS";
}
