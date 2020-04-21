package com.google.android.gms.samples.vision.ocrreader.data;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
public class ColorItem implements Parcelable {
    /**
     * The id of the color.
     */
    protected  long mId;

    /**
     * An int representing the value of the color.
     */
    protected int mColor;

    /**
     * A human readable string representation of the RGB value of the color.
     */
    protected transient String mRgbString;

    /**
     * A long representing the creation time of the color. (In milliseconds).
     */
    protected  long mCreationTime;

    /**
     * Create a new {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem } with an id and a color.
     *
     * @param id    the id of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem }. Should be unique.
     * @param color the color value.
     */
    public ColorItem(long id, int color) {
        mId = id;
        mColor = color;
        mCreationTime = System.currentTimeMillis();
    }
    /**
     * Create a new {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem} from a {@link android.os.Parcel}.
     * <p/>
     * Used by the parcelable creator.
     * {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     *
     * @param in the {@link android.os.Parcel}.
     */
    private ColorItem(Parcel in) {
        this.mId = in.readLong();
        this.mColor = in.readInt();
        this.mCreationTime = in.readLong();
    }

    /**
     * Create a new {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem} with a color.
     * <p/>
     * The {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem#mId} is set to the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem#mCreationTime}.
     *
     * @param color the color value.
     */
    public ColorItem(int color) {
        mId = mCreationTime = System.currentTimeMillis();
        mColor = color;
    }
    /**
     * Get the id of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     *
     * @return the id of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     */
    public long getId() {
        return mId;
    }

    /**
     * Get the value of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     *
     * @return an integer representing the color value of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     */
    public int getColor() {
        return mColor;
    }
    /**
     * Set the color valur of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     *
     * @param color an integer representing the new color value of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     */
    public void setColor(int color) {
        if (mColor != color) {
            mColor = color;
        }
    }
    /**
     * Get the creation time of the {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem}.
     *
     * @return a long representing the creation time in milliseconds.
     */
    public long getCreationTime() {
        return mCreationTime;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mId);
        dest.writeInt(this.mColor);
        dest.writeLong(this.mCreationTime);

    }

    /**
     * A {@link android.os.Parcelable.Creator} for creating {@link com.google.android.gms.samples.vision.ocrreader.data.ColorItem} from {@link android.os.Parcel}.
     */
    public static final Creator<ColorItem> CREATOR = new Creator<ColorItem>() {
        public ColorItem createFromParcel(Parcel source) {
            return new ColorItem(source);
        }

        public ColorItem[] newArray(int size) {
            return new ColorItem[size];
        }
    };
}
