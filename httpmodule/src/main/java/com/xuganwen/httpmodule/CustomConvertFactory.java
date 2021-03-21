package com.xuganwen.httpmodule;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import io.reactivex.rxjava3.annotations.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 文件描述: 自定义的json转换器，使用GSON
 * 作者: 徐干稳
 * 创建日期: 2020/07/20 19:17
 * 版本 1.0
 */
public class CustomConvertFactory extends Converter.Factory {

    private Gson gson;

    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private CustomConvertFactory(Gson gson) {
        this.gson = gson;
    }

    protected static CustomConvertFactory create() {
        return new CustomConvertFactory(new Gson());

    }

    public @Nullable Converter<ResponseBody, ?> responseBodyConverter(
            Type type, Annotation[] annotations, Retrofit retrofit) {
        final TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new Converter<ResponseBody, Object>() {
            @Override
            public Object convert(ResponseBody value) throws IOException {
                /*JsonReader jsonReader = gson.newJsonReader(value.charStream());
                try {
                    Object result = adapter.read(jsonReader);
                    if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                        throw new JsonIOException("JSON document was not fully consumed.");
                    }
                    return result;
                } finally {
                    value.close();
                }*/

                String temp = new String(value.bytes(), "utf-8");
                try{
                    return adapter.fromJson(temp);
                }catch (IOException e){

                        throw new IllegalArgumentException("未知异常。。。。");
                }
            }
        };
    }

    public @Nullable Converter<?, RequestBody> requestBodyConverter(
            Type type,
            Annotation[] parameterAnnotations,
            Annotation[] methodAnnotations,
            Retrofit retrofit) {
        final TypeAdapter<Object> adapter = (TypeAdapter<Object>) gson.getAdapter(TypeToken.get(type));
        return new Converter<Object, RequestBody>() {
            @Override
            public RequestBody convert(Object value) throws IOException {
                Buffer buffer = new Buffer();
                Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
                JsonWriter jsonWriter = gson.newJsonWriter(writer);
                adapter.write(jsonWriter, value);
                jsonWriter.close();
                return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
            }
        };
    }
}
