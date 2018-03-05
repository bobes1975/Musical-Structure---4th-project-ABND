package com.example.android.project_04_nd_musicalstructure_classicalmusic;

/**
 * Created by Bobeš on 02-Mar-18.
 */

public class Category {

    /**
     * Constant value that represents no image was provided for category
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * name of the category
     */
    private String mNameCategory;

    /**
     * Id for proper picture
     */
    private int mImageCategory = NO_IMAGE_PROVIDED;

    /**
     * Create new Composer Object
     *
     * @param nameCategory    is name of music category
     * @param imageResourceId is ID for proper image
     */
    public Category(String nameCategory, int imageResourceId) {
        mNameCategory = nameCategory;
        mImageCategory = imageResourceId;
    }

    public Category(String nameCategory) {
        mNameCategory = nameCategory;
    }

    /**
     * get 1st name of composer
     */
    public String getNameCategory() {
        return mNameCategory;
    }

    /**
     * get 1image ID of composer
     */
    public Integer getImageResourceId() {
        return mImageCategory;
    }

    /**
     * returns whether ot not there is an image for composer
     */
    public boolean hasImage() {
        return mImageCategory != NO_IMAGE_PROVIDED;
    }
}

