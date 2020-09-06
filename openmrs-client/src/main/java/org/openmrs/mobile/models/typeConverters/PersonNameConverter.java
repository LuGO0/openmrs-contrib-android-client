/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */


package org.openmrs.mobile.models.typeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.openmrs.mobile.models.PersonName;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

public class PersonNameConverter {

    @TypeConverter
    public static List<PersonName> fromString(String value) {
        Type listType = new TypeToken<List<PersonName>>() {}.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
        Gson gson = builder.create();
        List<PersonName> personNames =gson.fromJson(value,listType);
        return personNames;

    }

    @TypeConverter
    public static String listToString(List<PersonName> list) {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
        Gson gson = builder.create();
        return gson.toJson(list);
    }
}
