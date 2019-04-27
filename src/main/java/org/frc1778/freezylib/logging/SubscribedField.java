package org.frc1778.freezylib.logging;

public class SubscribedField extends Field {

  private String value;

  public SubscribedField(String name, String unit, Class<?> type) {
    setName(name);
    setUnit(unit);
    this.value = String.valueOf(value);
    setType(type);
  }

  public SubscribedField(String name, Units unit, Class<?> type) {
    this(name, unit.toString(), type);
  }

  public <T> void pushValue(T value) {
    this.value = String.valueOf(value);
  }

  @Override
  public String getValue() {
    return value;
  }
}
