/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.kaisquare.node.thrift;

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
 * Device Information
 * (1) deviceId - device id
 * (2) frameRate - frame rate of sub stream
 * (3) kupChannelId - corresponding channel id of this device id on KUP
 */
public class DeviceStatus implements org.apache.thrift.TBase<DeviceStatus, DeviceStatus._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DeviceStatus");

  private static final org.apache.thrift.protocol.TField DEVICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField FRAME_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("frameRate", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField KUP_CHANNEL_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("kupChannelId", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DeviceStatusStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DeviceStatusTupleSchemeFactory());
  }

  public long deviceId; // required
  public double frameRate; // required
  public int kupChannelId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEVICE_ID((short)1, "deviceId"),
    FRAME_RATE((short)2, "frameRate"),
    KUP_CHANNEL_ID((short)3, "kupChannelId");

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
        case 1: // DEVICE_ID
          return DEVICE_ID;
        case 2: // FRAME_RATE
          return FRAME_RATE;
        case 3: // KUP_CHANNEL_ID
          return KUP_CHANNEL_ID;
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
  private static final int __DEVICEID_ISSET_ID = 0;
  private static final int __FRAMERATE_ISSET_ID = 1;
  private static final int __KUPCHANNELID_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DEVICE_ID, new org.apache.thrift.meta_data.FieldMetaData("deviceId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.FRAME_RATE, new org.apache.thrift.meta_data.FieldMetaData("frameRate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.KUP_CHANNEL_ID, new org.apache.thrift.meta_data.FieldMetaData("kupChannelId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DeviceStatus.class, metaDataMap);
  }

  public DeviceStatus() {
  }

  public DeviceStatus(
    long deviceId,
    double frameRate,
    int kupChannelId)
  {
    this();
    this.deviceId = deviceId;
    setDeviceIdIsSet(true);
    this.frameRate = frameRate;
    setFrameRateIsSet(true);
    this.kupChannelId = kupChannelId;
    setKupChannelIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DeviceStatus(DeviceStatus other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.deviceId = other.deviceId;
    this.frameRate = other.frameRate;
    this.kupChannelId = other.kupChannelId;
  }

  public DeviceStatus deepCopy() {
    return new DeviceStatus(this);
  }

  @Override
  public void clear() {
    setDeviceIdIsSet(false);
    this.deviceId = 0;
    setFrameRateIsSet(false);
    this.frameRate = 0.0;
    setKupChannelIdIsSet(false);
    this.kupChannelId = 0;
  }

  public long getDeviceId() {
    return this.deviceId;
  }

  public DeviceStatus setDeviceId(long deviceId) {
    this.deviceId = deviceId;
    setDeviceIdIsSet(true);
    return this;
  }

  public void unsetDeviceId() {
    __isset_bit_vector.clear(__DEVICEID_ISSET_ID);
  }

  /** Returns true if field deviceId is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceId() {
    return __isset_bit_vector.get(__DEVICEID_ISSET_ID);
  }

  public void setDeviceIdIsSet(boolean value) {
    __isset_bit_vector.set(__DEVICEID_ISSET_ID, value);
  }

  public double getFrameRate() {
    return this.frameRate;
  }

  public DeviceStatus setFrameRate(double frameRate) {
    this.frameRate = frameRate;
    setFrameRateIsSet(true);
    return this;
  }

  public void unsetFrameRate() {
    __isset_bit_vector.clear(__FRAMERATE_ISSET_ID);
  }

  /** Returns true if field frameRate is set (has been assigned a value) and false otherwise */
  public boolean isSetFrameRate() {
    return __isset_bit_vector.get(__FRAMERATE_ISSET_ID);
  }

  public void setFrameRateIsSet(boolean value) {
    __isset_bit_vector.set(__FRAMERATE_ISSET_ID, value);
  }

  public int getKupChannelId() {
    return this.kupChannelId;
  }

  public DeviceStatus setKupChannelId(int kupChannelId) {
    this.kupChannelId = kupChannelId;
    setKupChannelIdIsSet(true);
    return this;
  }

  public void unsetKupChannelId() {
    __isset_bit_vector.clear(__KUPCHANNELID_ISSET_ID);
  }

  /** Returns true if field kupChannelId is set (has been assigned a value) and false otherwise */
  public boolean isSetKupChannelId() {
    return __isset_bit_vector.get(__KUPCHANNELID_ISSET_ID);
  }

  public void setKupChannelIdIsSet(boolean value) {
    __isset_bit_vector.set(__KUPCHANNELID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DEVICE_ID:
      if (value == null) {
        unsetDeviceId();
      } else {
        setDeviceId((Long)value);
      }
      break;

    case FRAME_RATE:
      if (value == null) {
        unsetFrameRate();
      } else {
        setFrameRate((Double)value);
      }
      break;

    case KUP_CHANNEL_ID:
      if (value == null) {
        unsetKupChannelId();
      } else {
        setKupChannelId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DEVICE_ID:
      return Long.valueOf(getDeviceId());

    case FRAME_RATE:
      return Double.valueOf(getFrameRate());

    case KUP_CHANNEL_ID:
      return Integer.valueOf(getKupChannelId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DEVICE_ID:
      return isSetDeviceId();
    case FRAME_RATE:
      return isSetFrameRate();
    case KUP_CHANNEL_ID:
      return isSetKupChannelId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DeviceStatus)
      return this.equals((DeviceStatus)that);
    return false;
  }

  public boolean equals(DeviceStatus that) {
    if (that == null)
      return false;

    boolean this_present_deviceId = true;
    boolean that_present_deviceId = true;
    if (this_present_deviceId || that_present_deviceId) {
      if (!(this_present_deviceId && that_present_deviceId))
        return false;
      if (this.deviceId != that.deviceId)
        return false;
    }

    boolean this_present_frameRate = true;
    boolean that_present_frameRate = true;
    if (this_present_frameRate || that_present_frameRate) {
      if (!(this_present_frameRate && that_present_frameRate))
        return false;
      if (this.frameRate != that.frameRate)
        return false;
    }

    boolean this_present_kupChannelId = true;
    boolean that_present_kupChannelId = true;
    if (this_present_kupChannelId || that_present_kupChannelId) {
      if (!(this_present_kupChannelId && that_present_kupChannelId))
        return false;
      if (this.kupChannelId != that.kupChannelId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(DeviceStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    DeviceStatus typedOther = (DeviceStatus)other;

    lastComparison = Boolean.valueOf(isSetDeviceId()).compareTo(typedOther.isSetDeviceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceId, typedOther.deviceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFrameRate()).compareTo(typedOther.isSetFrameRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFrameRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.frameRate, typedOther.frameRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetKupChannelId()).compareTo(typedOther.isSetKupChannelId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKupChannelId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.kupChannelId, typedOther.kupChannelId);
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
    StringBuilder sb = new StringBuilder("DeviceStatus(");
    boolean first = true;

    sb.append("deviceId:");
    sb.append(this.deviceId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("frameRate:");
    sb.append(this.frameRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("kupChannelId:");
    sb.append(this.kupChannelId);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DeviceStatusStandardSchemeFactory implements SchemeFactory {
    public DeviceStatusStandardScheme getScheme() {
      return new DeviceStatusStandardScheme();
    }
  }

  private static class DeviceStatusStandardScheme extends StandardScheme<DeviceStatus> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DeviceStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEVICE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.deviceId = iprot.readI64();
              struct.setDeviceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FRAME_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.frameRate = iprot.readDouble();
              struct.setFrameRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // KUP_CHANNEL_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.kupChannelId = iprot.readI32();
              struct.setKupChannelIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DeviceStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(DEVICE_ID_FIELD_DESC);
      oprot.writeI64(struct.deviceId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(FRAME_RATE_FIELD_DESC);
      oprot.writeDouble(struct.frameRate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(KUP_CHANNEL_ID_FIELD_DESC);
      oprot.writeI32(struct.kupChannelId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DeviceStatusTupleSchemeFactory implements SchemeFactory {
    public DeviceStatusTupleScheme getScheme() {
      return new DeviceStatusTupleScheme();
    }
  }

  private static class DeviceStatusTupleScheme extends TupleScheme<DeviceStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DeviceStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDeviceId()) {
        optionals.set(0);
      }
      if (struct.isSetFrameRate()) {
        optionals.set(1);
      }
      if (struct.isSetKupChannelId()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDeviceId()) {
        oprot.writeI64(struct.deviceId);
      }
      if (struct.isSetFrameRate()) {
        oprot.writeDouble(struct.frameRate);
      }
      if (struct.isSetKupChannelId()) {
        oprot.writeI32(struct.kupChannelId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DeviceStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.deviceId = iprot.readI64();
        struct.setDeviceIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.frameRate = iprot.readDouble();
        struct.setFrameRateIsSet(true);
      }
      if (incoming.get(2)) {
        struct.kupChannelId = iprot.readI32();
        struct.setKupChannelIdIsSet(true);
      }
    }
  }

}

