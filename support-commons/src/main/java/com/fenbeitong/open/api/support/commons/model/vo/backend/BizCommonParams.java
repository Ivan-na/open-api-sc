package com.fenbeitong.open.api.support.commons.model.vo.backend;

import com.fenbeitong.open.api.support.commons.model.vo.CommonParams;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * BizCommonParams
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午2:09.
 **/
@Setter
@Getter
@ToString
public class BizCommonParams<T> extends CommonParams<T> {
    private String requestId;
    private T data;


    @SuppressWarnings("rawtypes")
    public static BizCommonParams fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(BizCommonParams.class, clazz);
        return gson.fromJson(json, objectType);

    }

    @SuppressWarnings("rawtypes")
    public static BizCommonParams fromJsonWithLowerCase(String json, Class clazz) {
        Gson gson = new Gson();
        gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type objectType = type(BizCommonParams.class, clazz);
        return gson.fromJson(json, objectType);

    }

    @SuppressWarnings("rawtypes")
    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            @Override
            public Type getRawType() {
                return raw;
            }

            @Override
            public Type[] getActualTypeArguments() {
                return args;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(BizCommonParams.class, clazz);
        return gson.toJson(this, objectType);
    }

    public String toJsonWithLowerCase(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(BizCommonParams.class, clazz);
        gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        return gson.toJson(this, objectType);
    }
}
