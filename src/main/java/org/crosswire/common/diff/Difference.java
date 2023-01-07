package org.crosswire.common.diff;

/**
 * 
 * Represents a single difference, consisting of an EditType and associated
 * text.
 */
public class Difference {
    public Difference(EditType edit, String text) {
        this.editType = edit;
        this.text = text;
    }

    /**
     * @return the EditType
     */
    public EditType getEditType() {
        return editType;
    }

    /**
     * @param newEditType
     *            the EditType to set
     */
    public void setEditType(EditType newEditType) {
        editType = newEditType;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param newText
     *            the text to set
     */
    public void setText(String newText) {
        text = newText;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param newIndex
     *            the index to set
     */
    public void setIndex(int newIndex) {
        index = newIndex;
    }

    /**
     * @param addText
     *            the text to set
     */
    public void appendText(String addText) {
        text += addText;
    }

    /**
     * @param addText
     *            the text to set
     */
    public void appendText(char addText) {
        text += addText;
    }

    /**
     * @param addText
     *            the text to set
     */
    public void prependText(String addText) {
        text = addText + text;
    }

    /**
     * @param addText
     *            the text to set
     */
    public void prependText(char addText) {
        text = addText + text;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return editType.toString() + ':' + text;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 31 * editType.hashCode() + text.hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Difference other = (Difference) obj;

        return editType.equals(other.editType) && text.equals(other.text);
    }

    /**
     * The edit to perform
     */
    private EditType editType;
    private String text;
    private int index;

}
