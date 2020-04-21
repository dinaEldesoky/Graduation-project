package com.google.android.gms.samples.vision.ocrreader;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.samples.vision.ocrreader.R;
import com.google.android.gms.samples.vision.ocrreader.View.CameraColorPickerPreview;
import com.google.android.gms.samples.vision.ocrreader.data.ColorItems;

public abstract class ColorPickerBaseActivity extends AppCompatActivity implements CameraColorPickerPreview.OnColorSelectedListener,View.OnClickListener{
    /**
     * A simple {@link android.widget.FrameLayout} that contains the preview.
     */
    //(5)
    protected FrameLayout mPreviewContainer;
    /**
     * An instance of the {@link android.hardware.Camera} used for displaying the preview.
     */
    //(3)
    protected Camera mCamera;
    /**
     * The {@link com.google.android.gms.samples.vision.ocrreader.View.CameraColorPickerPreview} used for the preview
     */
    //(6)
    protected CameraColorPickerPreview mCameraPreview;



    /**
     * The color selected by the user.
     * <p/>
     * The user "selects" a color by pointing a color with the camera.
     */
    //(7)
    protected int mSelectedColor;

    /**
     * The last picked color.
     * <p/>
     * The user "picks" a color by clicking the preview.
     */
    //(8)
    protected int mLastPickedColor;



    /**
     * A simple {@link android.view.View} used for showing the selected color.
     */
    //(10)
    protected View mPointerRing;

    /** the intent {@link android.content.Intent#getAction action} that led to this activity. */
    protected String action = null;
    /** <a href="http://www.openintents.org/action/org-openintents-action-pick-color/">
     * see openintents.org</a> */
    //(12)
    public static final String OI_COLOR_PICKER = "org.openintents.action.PICK_COLOR";
    public static final String OI_COLOR_DATA = "org.openintents.extra.COLOR";

    private static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
        } catch (Exception e) {
           // Log.e(TAG, e.getMessage());
        }
        return c;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        Intent intent = getIntent();
        if (intent != null)
            action = intent.getAction();
    }
    @Override
    public void onColorSelected(int color) {
        mSelectedColor = color;
        mPointerRing.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }
    /**
     * Check if the device's camera supports flash.
     *
     * @return Returns true if the device's camera supports flash, false otherwise.
     */
    protected boolean isFlashSupported() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }
    @Override
    public void onClick(View v) {

            if (OI_COLOR_PICKER.equals(action)) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(OI_COLOR_DATA, mLastPickedColor);
                setResult(RESULT_OK, returnIntent);
                finish();
                return;
            }

        }

    protected void initViews(){
        mPreviewContainer = (FrameLayout) findViewById(R.id.activity_color_picker_preview_container);
      //  mPointerRing = findViewById(R.id.activity_color_picker_pointer_ring);
        mLastPickedColor = ColorItems.getLastPickedColor(this);

}

}
