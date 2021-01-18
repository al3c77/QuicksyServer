package de.gultsch.xmpp.addr.adapter.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import rocks.xmpp.addr.Jid;

import java.lang.reflect.Type;

public class JidDeserializer implements JsonDeserializer<Jid> {

    public Jid deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String jid = jsonElement.getAsString();
        return Jid.ofEscaped(jid);
    }
}