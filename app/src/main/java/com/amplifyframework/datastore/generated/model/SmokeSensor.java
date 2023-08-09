package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the SmokeSensor type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "SmokeSensors", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class SmokeSensor implements Model {
  public static final QueryField ID = field("SmokeSensor", "id");
  public static final QueryField TIMESTAMP = field("SmokeSensor", "timestamp");
  public static final QueryField VALUE = field("SmokeSensor", "value");
  public static final QueryField UNIT = field("SmokeSensor", "unit");
  public static final QueryField NOTES = field("SmokeSensor", "notes");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String timestamp;
  private final @ModelField(targetType="Int", isRequired = true) Integer value;
  private final @ModelField(targetType="String", isRequired = true) String unit;
  private final @ModelField(targetType="String", isRequired = true) String notes;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getTimestamp() {
      return timestamp;
  }
  
  public Integer getValue() {
      return value;
  }
  
  public String getUnit() {
      return unit;
  }
  
  public String getNotes() {
      return notes;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private SmokeSensor(String id, String timestamp, Integer value, String unit, String notes) {
    this.id = id;
    this.timestamp = timestamp;
    this.value = value;
    this.unit = unit;
    this.notes = notes;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SmokeSensor smokeSensor = (SmokeSensor) obj;
      return ObjectsCompat.equals(getId(), smokeSensor.getId()) &&
              ObjectsCompat.equals(getTimestamp(), smokeSensor.getTimestamp()) &&
              ObjectsCompat.equals(getValue(), smokeSensor.getValue()) &&
              ObjectsCompat.equals(getUnit(), smokeSensor.getUnit()) &&
              ObjectsCompat.equals(getNotes(), smokeSensor.getNotes()) &&
              ObjectsCompat.equals(getCreatedAt(), smokeSensor.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), smokeSensor.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTimestamp())
      .append(getValue())
      .append(getUnit())
      .append(getNotes())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("SmokeSensor {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("timestamp=" + String.valueOf(getTimestamp()) + ", ")
      .append("value=" + String.valueOf(getValue()) + ", ")
      .append("unit=" + String.valueOf(getUnit()) + ", ")
      .append("notes=" + String.valueOf(getNotes()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static TimestampStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static SmokeSensor justId(String id) {
    return new SmokeSensor(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      timestamp,
      value,
      unit,
      notes);
  }
  public interface TimestampStep {
    ValueStep timestamp(String timestamp);
  }
  

  public interface ValueStep {
    UnitStep value(Integer value);
  }
  

  public interface UnitStep {
    NotesStep unit(String unit);
  }
  

  public interface NotesStep {
    BuildStep notes(String notes);
  }
  

  public interface BuildStep {
    SmokeSensor build();
    BuildStep id(String id);
  }
  

  public static class Builder implements TimestampStep, ValueStep, UnitStep, NotesStep, BuildStep {
    private String id;
    private String timestamp;
    private Integer value;
    private String unit;
    private String notes;
    @Override
     public SmokeSensor build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new SmokeSensor(
          id,
          timestamp,
          value,
          unit,
          notes);
    }
    
    @Override
     public ValueStep timestamp(String timestamp) {
        Objects.requireNonNull(timestamp);
        this.timestamp = timestamp;
        return this;
    }
    
    @Override
     public UnitStep value(Integer value) {
        Objects.requireNonNull(value);
        this.value = value;
        return this;
    }
    
    @Override
     public NotesStep unit(String unit) {
        Objects.requireNonNull(unit);
        this.unit = unit;
        return this;
    }
    
    @Override
     public BuildStep notes(String notes) {
        Objects.requireNonNull(notes);
        this.notes = notes;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String timestamp, Integer value, String unit, String notes) {
      super.id(id);
      super.timestamp(timestamp)
        .value(value)
        .unit(unit)
        .notes(notes);
    }
    
    @Override
     public CopyOfBuilder timestamp(String timestamp) {
      return (CopyOfBuilder) super.timestamp(timestamp);
    }
    
    @Override
     public CopyOfBuilder value(Integer value) {
      return (CopyOfBuilder) super.value(value);
    }
    
    @Override
     public CopyOfBuilder unit(String unit) {
      return (CopyOfBuilder) super.unit(unit);
    }
    
    @Override
     public CopyOfBuilder notes(String notes) {
      return (CopyOfBuilder) super.notes(notes);
    }
  }
  
}
