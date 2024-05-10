### Hexlet tests and linter status:
[![Actions Status](https://github.com/ynb4gang/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ynb4gang/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/c24f7f672b43608735f8/maintainability)](https://codeclimate.com/github/ynb4gang/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/c24f7f672b43608735f8/test_coverage)](https://codeclimate.com/github/ynb4gang/java-project-78/test_coverage)
[![Github Actions](https://github.com/ynb4gang/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/ynb4gang/java-project-78/actions/workflows/main.yml)
# Java Validator

This project is a simple validator for validating strings, numbers, and Map objects in Java.

## Installation

To use this validator in your project, simply copy the files `Validator.java`, `BaseSchema.java`, `StringSchema.java`, `NumberSchema.java` and `MapSchema.java` to your source code directory.

## Usage Examples

### String Validation

```java
Validator v = new Validator();
StringSchema schema = v.string();

schema.required();
schema.minLength(5);
schema.contains("example");

System.out.println(schema.isValid("example")); // true
System.out.println(schema.isValid("hello")); // false
```
### Number Validation
```java
Validator v = new Validator();
NumberSchema schema = v.number();

schema.required();
schema.positive();
schema.range(1, 100);

System.out.println(schema.isValid(50)); // true
System.out.println(schema.isValid(-5)); // false
```
### Map Object Validation
```java
Validator v = new Validator();
MapSchema schema = v.map();

Map<String, BaseSchema<String>> shapeSchemas = new HashMap<>();
shapeSchemas.put("name", v.string().required());
shapeSchemas.put("age", v.number().required().positive());

schema.required();
schema.shape(shapeSchemas);

Map<String, String> person = new HashMap<>();
person.put("name", "John");
person.put("age", "30");

System.out.println(schema.isValid(person)); // true
```
