/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.kaisquare.core.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Indoor map information
 * (1) mapId - ID of the indoor map
 * (2) map - Map file content (binary data)
 */
public class IndoorMapInfo implements org.apache.thrift.TBase<IndoorMapInfo, IndoorMapInfo._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("IndoorMapInfo");

  private static final org.apache.thrift.protocol.TField MAP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("mapId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField MAP_BLOB_FIELD_DESC = new org.apache.thrift.protocol.TField("mapBlob", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new IndoorMapInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new IndoorMapInfoTupleSchemeFactory());
  }

  public String mapId; // required
  public ByteBuffer mapBlob; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MAP_ID((short)1, "mapId"),
    MAP_BLOB((short)2, "mapBlob");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MAP_ID
          return MAP_ID;
        case 2: // MAP_BLOB
          return MAP_BLOB;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MAP_ID, new org.apache.thrift.meta_data.FieldMetaData("mapId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MAP_BLOB, new org.apache.thrift.meta_data.FieldMetaData("mapBlob", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(IndoorMapInfo.class, metaDataMap);
  }

  public IndoorMapInfo() {
  }

  public IndoorMapInfo(
    String mapId,
    ByteBuffer mapBlob)
  {
    this();
    this.mapId = mapId;
    this.mapBlob = mapBlob;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public IndoorMapInfo(IndoorMapInfo other) {
    if (other.isSetMapId()) {
      this.mapId = other.mapId;
    }
    if (other.isSetMapBlob()) {
      this.mapBlob = org.apache.thrift.TBaseHelper.copyBinary(other.mapBlob);
;
    }
  }

  public IndoorMapInfo deepCopy() {
    return new IndoorMapInfo(this);
  }

  @Override
  public void clear() {
    this.mapId = null;
    this.mapBlob = null;
  }

  public String getMapId() {
    return this.mapId;
  }

  public IndoorMapInfo setMapId(String mapId) {
    this.mapId = mapId;
    return this;
  }

  public void unsetMapId() {
    this.mapId = null;
  }

  /** Returns true if field mapId is set (has been assigned a value) and false otherwise */
  public boolean isSetMapId() {
    return this.mapId != null;
  }

  public void setMapIdIsSet(boolean value) {
    if (!value) {
      this.mapId = null;
    }
  }

  public byte[] getMapBlob() {
    setMapBlob(org.apache.thrift.TBaseHelper.rightSize(mapBlob));
    return mapBlob == null ? null : mapBlob.array();
  }

  public ByteBuffer bufferForMapBlob() {
    return mapBlob;
  }

  public IndoorMapInfo setMapBlob(byte[] mapBlob) {
    setMapBlob(mapBlob == null ? (ByteBuffer)null : ByteBuffer.wrap(mapBlob));
    return this;
  }

  public IndoorMapInfo setMapBlob(ByteBuffer mapBlob) {
    this.mapBlob = mapBlob;
    return this;
  }

  public void unsetMapBlob() {
    this.mapBlob = null;
  }

  /** Returns true if field mapBlob is set (has been assigned a value) and false otherwise */
  public boolean isSetMapBlob() {
    return this.mapBlob != null;
  }

  public void setMapBlobIsSet(boolean value) {
    if (!value) {
      this.mapBlob = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MAP_ID:
      if (value == null) {
        unsetMapId();
      } else {
        setMapId((String)value);
      }
      break;

    case MAP_BLOB:
      if (value == null) {
        unsetMapBlob();
      } else {
        setMapBlob((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MAP_ID:
      return getMapId();

    case MAP_BLOB:
      return getMapBlob();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MAP_ID:
      return isSetMapId();
    case MAP_BLOB:
      return isSetMapBlob();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof IndoorMapInfo)
      return this.equals((IndoorMapInfo)that);
    return false;
  }

  public boolean equals(IndoorMapInfo that) {
    if (that == null)
      return false;

    boolean this_present_mapId = true && this.isSetMapId();
    boolean that_present_mapId = true && that.isSetMapId();
    if (this_present_mapId || that_present_mapId) {
      if (!(this_present_mapId && that_present_mapId))
        return false;
      if (!this.mapId.equals(that.mapId))
        return false;
    }

    boolean this_present_mapBlob = true && this.isSetMapBlob();
    boolean that_present_mapBlob = true && that.isSetMapBlob();
    if (this_present_mapBlob || that_present_mapBlob) {
      if (!(this_present_mapBlob && that_present_mapBlob))
        return false;
      if (!this.mapBlob.equals(that.mapBlob))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(IndoorMapInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    IndoorMapInfo typedOther = (IndoorMapInfo)other;

    lastComparison = Boolean.valueOf(isSetMapId()).compareTo(typedOther.isSetMapId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMapId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mapId, typedOther.mapId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMapBlob()).compareTo(typedOther.isSetMapBlob());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMapBlob()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mapBlob, typedOther.mapBlob);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("IndoorMapInfo(");
    boolean first = true;

    sb.append("mapId:");
    if (this.mapId == null) {
      sb.append("null");
    } else {
      sb.append(this.mapId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("mapBlob:");
    if (this.mapBlob == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.mapBlob, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class IndoorMapInfoStandardSchemeFactory implements SchemeFactory {
    public IndoorMapInfoStandardScheme getScheme() {
      return new IndoorMapInfoStandardScheme();
    }
  }

  private static class IndoorMapInfoStandardScheme extends StandardScheme<IndoorMapInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, IndoorMapInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MAP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mapId = iprot.readString();
              struct.setMapIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MAP_BLOB
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mapBlob = iprot.readBinary();
              struct.setMapBlobIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, IndoorMapInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.mapId != null) {
        oprot.writeFieldBegin(MAP_ID_FIELD_DESC);
        oprot.writeString(struct.mapId);
        oprot.writeFieldEnd();
      }
      if (struct.mapBlob != null) {
        oprot.writeFieldBegin(MAP_BLOB_FIELD_DESC);
        oprot.writeBinary(struct.mapBlob);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IndoorMapInfoTupleSchemeFactory implements SchemeFactory {
    public IndoorMapInfoTupleScheme getScheme() {
      return new IndoorMapInfoTupleScheme();
    }
  }

  private static class IndoorMapInfoTupleScheme extends TupleScheme<IndoorMapInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, IndoorMapInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetMapId()) {
        optionals.set(0);
      }
      if (struct.isSetMapBlob()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetMapId()) {
        oprot.writeString(struct.mapId);
      }
      if (struct.isSetMapBlob()) {
        oprot.writeBinary(struct.mapBlob);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, IndoorMapInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.mapId = iprot.readString();
        struct.setMapIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.mapBlob = iprot.readBinary();
        struct.setMapBlobIsSet(true);
      }
    }
  }

}

