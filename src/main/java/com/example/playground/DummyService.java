package com.example.playground;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DummyService implements DummySpec {
  @Override
  public String getInfo() {
    return "Hello world";
  }
}
