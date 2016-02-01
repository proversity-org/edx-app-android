package org.proversity.edx.mobile.model.course;

import org.proversity.edx.mobile.model.db.DownloadEntry;
import org.proversity.edx.mobile.module.storage.IStorage;

/**
 * Created by hanning on 5/20/15.
 */
public interface HasDownloadEntry {
    DownloadEntry getDownloadEntry(IStorage storage);
    long getSize();
}
