package com.example.android.project_04_nd_musicalstructure_classicalmusic;

public class Composition {

    /**
     * Constant value that represents no image was provided for this composer
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * composition name
     */

    private String mComposition;
    /**
     * name of ot the composer
     */

    private String mNameComposer;

    /**
     * surname of ot the composer
     */

    private String mSurnameComposer;

    /**
     * Id for proper picture
     */
    private int mImageComposer = NO_IMAGE_PROVIDED;

    /**
     * Create new Composer Object
     *
     * @param composition     is name of composition
     * @param nameComposer    is name of music composer
     * @param surnameComposer    is name of music composer
     * @param imageResourceId is ID for proper image
     */
    public Composition(String composition, String nameComposer, String surnameComposer,  int imageResourceId) {
        mComposition = composition;
        mNameComposer = nameComposer;
        mSurnameComposer = surnameComposer;
        mImageComposer = imageResourceId;
    }

    public Composition(String composition, String nameComposer) {

        mComposition = composition;
        mNameComposer = nameComposer;
    }

    /**
     * get 1st name of composer
     */
    public String getSurnameComposer() {
        return mSurnameComposer;
    }

    /**
     * get 1st name of composer
     */
    public String getNameComposer() {
        return mNameComposer;
    }

    /**
     * get surname of composition
     */
    public String getComposition() {
        return mComposition;
    }

    /**
     * get 1image ID of composer
     */
    public Integer getImageResourceId() {
        return mImageComposer;
    }


    /**
     * returns whether ot not there is an image for composer
     */
    public boolean hasImage() {

        return mImageComposer != NO_IMAGE_PROVIDED;
    }
}