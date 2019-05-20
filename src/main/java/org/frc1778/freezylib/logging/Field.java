package org.frc1778.freezylib.logging;

import com.google.gson.annotations.Expose;
import org.frc1778.freezylib.util.Measurement;

public abstract class Field {

  @Expose private String name;
  @Expose private String unit;
  @Expose private String type;

  public void setName(String name) {
    this.name = name;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public void setUnit(Measurement.Base unit) {
    this.unit = unit.getSymbol();
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
