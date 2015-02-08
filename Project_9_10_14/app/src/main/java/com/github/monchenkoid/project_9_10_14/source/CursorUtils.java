package com.github.monchenkoid.project_9_10_14.source;

import android.database.Cursor;

/**
 * CursorUtils
 * Version information
 * 08.01.2015
 * Created by Dzmitry Slutskiy.
 */
public class CursorUtils {

    private CursorUtils() {/*   code    */}

    public static int getInt(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex < 0) {
            return 0;
        }
        return cursor.getInt(columnIndex);
    }

    public static long getLong(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex < 0) {
            return 0l;
        }
        return cursor.getLong(columnIndex);
    }

    public static String getString(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex < 0) {
            return "";
        }
        String result = cursor.getString(columnIndex);
        return result == null ? "" : result;
    }

    public static void closeCursor(Cursor cursor) {
        if (cursor != null && ! cursor.isClosed()) {
            cursor.close();
        }
    }
}
