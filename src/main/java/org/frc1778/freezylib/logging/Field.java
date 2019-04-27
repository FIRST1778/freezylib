package org.frc1778.freezylib.logging;

import com.google.gson.annotations.Expose;

public abstract class Field {

  @Expose private String name;
  @Expose private String unit;
  @Expose private String type;

  public enum Units {
    UNITLESS("ul"),

    // Time
    HOUR("h"),
    MINUTE("min"),
    SECOND("s"),
    MILLISECOND("ms"),
    NANOSECOND("ns"),
    HERTZ("Hz"),
    // Distance
    METRE("m"),
    CENTIMETRE("cm"),
    FOOT("ft"),
    INCH("in"),
    // Angle
    RADIAN("rad"),
    DEGREE("°"),
    // Electricity
    VOLT("V"),
    OHM("Ω"),
    AMPERE("A");

    private final String unit;

    private Units(String representation) {
      unit = representation;
    }

    @Override
    public String toString() {
      return unit;
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public void setUnit(Units unit) {
    this.unit = unit.toString();
  }

  public void setType(Class<?> type) {
    this.type = type.getName();
  }

  public String getName() {
    return name;
  }

  public String getUnit() {
    return unit;
  }

  public String getType() {
    return type;
  }

  public abstract String getValue();
}
