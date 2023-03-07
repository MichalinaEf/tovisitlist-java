package io.file;

import model.ToVisitList;

public interface FileManager {
    ToVisitList importData();
    void exportData(ToVisitList toVisitList);
}
