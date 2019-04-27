package org.frc1778.freezylib.logging;

import java.util.function.Supplier;

public class PolledField extends Field {

  private Supplier<String> supplier;
  private String value;

  public <T> PolledField(String name, String unit, Supplier<T> supplier) {
    setName(name);
    setUnit(unit);
    setType(supplier.get().getClass());
    this.supplier =
        new Supplier<String>() {
          @Override
          public String get() {
            return String.valueOf(supplier.get());
          }
        };
  }

  public <T> PolledField(String name, Units unit, Supplier<T> supplier) {
    this(name, unit.toString(), supplier);
  }

  public void pollSupplier() {
    value = String.valueOf(supplier.get());
  }

  @Override
  public String getValue() {
    return value;
  }
}
