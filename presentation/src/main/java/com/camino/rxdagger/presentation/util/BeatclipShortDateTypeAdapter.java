package com.camino.rxdagger.presentation.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by robert on 26.02.16.
 */
public class BeatclipShortDateTypeAdapter extends TypeAdapter<Date> {

    private final DateFormat iso8601LongFormat = buildIso8601ShortFormat();

    private static DateFormat buildIso8601ShortFormat() {
        DateFormat iso8601LongFormat = new SimpleDateFormat("yyyy-MM-dd");
        return iso8601LongFormat;
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        return deserializeToDate(in.nextString());
    }

    private synchronized Date deserializeToDate(String json) {

        try {
            return iso8601LongFormat.parse(json);
        } catch (ParseException e) {
            throw new RuntimeException(json, e);
        }
    }

    @Override
    public synchronized void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        String dateFormatAsString = iso8601LongFormat.format(value);
        out.value(dateFormatAsString);
    }
}
