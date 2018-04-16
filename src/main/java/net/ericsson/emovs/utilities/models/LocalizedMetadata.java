package net.ericsson.emovs.utilities.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Joao Coelho on 2017-11-07.
 */

public class LocalizedMetadata implements Serializable {
    public HashMap<String, String> titles;
    public HashMap<String, String> descriptions;
    public HashMap<String, ArrayList<EmpImage>> images;

    public LocalizedMetadata() {
        titles = new HashMap<>();
        images = new HashMap<>();
        descriptions = new HashMap<>();
    }

    public String getDescriptions(String locale) {
        if (this.descriptions.containsKey(locale) == false) {
            return null;
        }
        return this.descriptions.get(locale);
    }

    public String getTitleQuick() {
        if (this.titles.size() == 0 || !this.titles.values().iterator().hasNext()) {
            return null;
        }
        return this.titles.values().iterator().next();
    }

    public String[] getTitleLocales() {
        if (this.titles.size() == 0 || !this.titles.values().iterator().hasNext()) {
            return null;
        }
        return this.titles.keySet().toArray(new String[this.titles.size()]);
    }

    public String getTitle(String locale) {
        if (this.titles.containsKey(locale) == false) {
            return getTitleQuick();
        }
        return this.titles.get(locale);
    }

    public String[] getImageLocales() {
        if (this.images.size() == 0 || !this.images.values().iterator().hasNext()) {
            return null;
        }
        return this.images.keySet().toArray(new String[this.images.size()]);
    }

    public EmpImage getImageQuick() {
        if (this.images.size() == 0) {
            return null;
        }
        for (ArrayList<EmpImage> images : this.images.values()) {
            if (images == null || images.size() == 0) {
                continue;
            }
            return images.get(0);
        }
        return null;
    }

    public EmpImage getImage(String _locale, String filterType) {
        String locale = _locale;
        if (this.images.containsKey(locale) == false) {
            String[] locales = getImageLocales();
            if (locales == null) {
                return null;
            }
            locale = locales[0];
        }
        for (EmpImage image : this.images.get(locale)) {
            if (image.type.equals(filterType)) {
                return image;
            }
        }
        return getImageQuick();
    }

    public EmpImage getImage(String _locale, EmpImage.Orientation filterOrientation) {
        String locale = _locale;
        if (this.images.containsKey(locale) == false) {
            String[] locales = getImageLocales();
            if (locales == null) {
                return null;
            }
            locale = locales[0];
        }
        for (EmpImage image : this.images.get(locale)) {
            if (image.orientation == filterOrientation) {
                return image;
            }
        }
        return getImageQuick();
    }

    public EmpImage getImage(String _locale, EmpImage.Orientation filterOrientation, String filterType) {
        String locale = _locale;
        if (this.images.containsKey(locale) == false) {
            String[] locales = getImageLocales();
            if (locales == null) {
                return null;
            }
            locale = locales[0];
        }
        for (EmpImage image : this.images.get(locale)) {
            if (image.orientation == filterOrientation && filterType.equals(image.type)) {
                return image;
            }
        }
        return getImageQuick();
    }
}
