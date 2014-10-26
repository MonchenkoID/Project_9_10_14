package com.github.monchenkoid.project_9_10_14.processing;

import com.github.monchenkoid.project_9_10_14.bo.Note;

import org.json.JSONObject;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class NoteArrayProcessor extends WrapperArrayProcessor<Note> {

    @Override
    protected Note createObject(JSONObject jsonObject) {
        return new Note(jsonObject);
    }

}