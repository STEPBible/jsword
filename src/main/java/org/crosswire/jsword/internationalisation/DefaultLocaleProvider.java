package org.crosswire.jsword.internationalisation;

import java.util.Locale;

/**
 * A default Locale provider simply returns Locale.getDefault()
 */
public class DefaultLocaleProvider implements LocaleProvider {

    /* (non-Javadoc)
     * @see org.crosswire.jsword.internationalisation.LocaleProvider#getUserLocale()
     */
    public Locale getUserLocale() {
        //Default locale are cached by the underlying java implementation, so no need to cache here.
        return Locale.getDefault();
    }
}
