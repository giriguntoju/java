package com.jsoniter.fuzzy;

import com.jsoniter.CodegenAccess;
import com.jsoniter.JsonIterator;
import com.jsoniter.spi.Decoder;

import java.io.IOException;


public class MaybeStringDecoder implements Decoder {

    private String type;

    public MaybeStringDecoder(String type){
        this.type = type;
    }
    @Override
    public Object decode(JsonIterator iter) throws IOException {
        if(type.equals("Double")){
            byte c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                CodegenAccess.unreadByte(iter);
                return iter.readDouble();
            }
            double val = iter.readDouble();
            c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                throw iter.reportError("StringDoubleDecoder", "expect \", but found: " + (char) c);
            }
            return val;
        }

        if(type.equals("Double")){
            byte c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                CodegenAccess.unreadByte(iter);
                return iter.readFloat();
            }
            float val = iter.readFloat();
            c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                throw iter.reportError("StringFloatDecoder", "expect \", but found: " + (char) c);
            }
            return val;
        }

        if(type.equals("int")){
            byte c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                CodegenAccess.unreadByte(iter);
                return iter.readInt();
            }
            int val = iter.readInt();
            c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                throw iter.reportError("StringIntDecoder", "expect \", but found: " + (char) c);
            }
            return val;
        }

        if(type.equals("Long")){
            byte c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                CodegenAccess.unreadByte(iter);
                return iter.readLong();
            }
            long val = iter.readLong();
            c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                throw iter.reportError("StringLongDecoder", "expect \", but found: " + (char) c);
            }
            return val;
        }

        if(type.equals("short")){
            byte c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                CodegenAccess.unreadByte(iter);
                return iter.readShort();
            }
            short val = iter.readShort();
            c = CodegenAccess.nextToken(iter);
            if (c != '"') {
                throw iter.reportError("StringShortDecoder", "expect \", but found: " + (char) c);
            }
            return val;
        }
        return null;
    }
}
