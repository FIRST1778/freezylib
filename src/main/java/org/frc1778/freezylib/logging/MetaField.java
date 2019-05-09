package org.frc1778.freezylib.logging;

import com.google.gson.annotations.Expose;

public class MetaField extends Field {

  @Expose private String value;

  public <T> MetaField(String name, String unit, T value) {
    setName(name);
    setUnit(unit);
    this.value = String.valueOf(value);
    setType(((Object) value).getClass());
  }

  public <T> MetaField(String name, Units unit, T value) {
    this(name, unit.toString(), value);
  }

  @Override
  public String getValue() {
    return value;
  }
}