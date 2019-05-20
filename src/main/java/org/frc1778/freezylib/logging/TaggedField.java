package org.frc1778.freezylib.logging;

import org.frc1778.freezylib.util.Measurement;

public class TaggedField extends Field {

  private String value;
  private boolean isNewValue;

  public TaggedField(String name, String unit, Class<?> type) {
    setName(name);
    setUnit(unit);
    this.value = String.valueOf(value);
    setType(type);
  }

  public TaggedField(String name, Measurement.Base unit, Class<?> type) {
    this(name, unit.getSymbol(), type);
  }

  public <T> void updateTag(T value) {
    this.value = String.valueOf(value);
    isNewValue = true;
  }

  @Override
  public String getValue() {
    String out = isNewValue ? value : "";
    isNewValue = false;
    return out;
  }
}
