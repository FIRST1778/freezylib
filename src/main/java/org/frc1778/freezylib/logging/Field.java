package org.frc1778.freezylib.logging;

/** Field */
public abstract class Field {

  public abstract String getName();

  public abstract String getFormat();

  public abstract String getValue();

  @Override
  public abstract String toString();
}
