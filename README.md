# kafka-binder-reproducer

## Test the bindings properties

Test the bindings property `start-offset` properties with the value `earliest`, default value is `latest`.

```yml
spring:
  cloud:
    stream:
      kafka:
        bindings:
          consumer-in-0:
            consumer:
              start-offset: earliest
```

Build executable.
```shell
gradle clean nativeCompile
```

Run the native application.

```shell
build\native\nativeCompile\kafka-binder-reproducer.exe
```

Rerun the executable, the consuming message behavior will not be changed, the application will not consume the earliest message.