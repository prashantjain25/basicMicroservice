package com.generic.engine.basicMicroservice.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generic.engine.basicMicroservice.error.PlatformError;

public abstract class AbstractResponse {
    private static final long serialVersionUID = -6069853481816914183L;
    private List<PlatformError> errors = new ArrayList(0);
    private int status;
    private HashMap<String, Object> metadata = new HashMap();

    public AbstractResponse() {
    }

    public AbstractResponse(int status, List<PlatformError> errors) {
      this.status = status;
      this.setErrors(errors);
    }

    public AbstractResponse(int status, List<PlatformError> errors, HashMap<String, Object> metadata, String baseUri) {
      this.status = status;
      this.setErrors(errors);
      this.metadata = metadata;
      this.metadata.put("baseUri", baseUri);
    }

    public Map<String, Object> getMetadata() {
      return this.metadata;
    }

    public final void setMetadata(HashMap<String, Object> metadata) {
      this.metadata = metadata;
    }

    public final List<PlatformError> getErrors() {
      return this.errors;
    }

    public final void setErrors(List<PlatformError> errors) {
      if (errors == null) {
        this.errors = new ArrayList();
      } else {
        ArrayList errorsCopy = new ArrayList(errors);
        this.errors = errorsCopy;
      }

    }

    public final int getStatus() {
      return this.status;
    }

    public void setStatus(int status) {
      this.status = status;
    }
}
