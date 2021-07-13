# redisson quarkus remote service poc

### calling remote service

1.You need to add dynamic-proxy.json and reflection-config.json files in quarkus.native.additional-build-args setting.

> -H:DynamicProxyConfigurationResources=dynamic-proxy.json,-H:ReflectionConfigurationFiles=reflection-config.json

dynamic-proxy.json:

`[
["<Remote Service interface name>"]
]`

reflection-config.json:

`[{
"name":"<Remote Service interface name>", "allDeclaredMethods":true }]`
2. compile to native
> package -Pnative -Dquarkus.native.container-build=true
3. register the remote interface from within another quarkus app like this:
    `redisson.getRemoteService().get(DummySpec.class, 15, TimeUnit.SECONDS);`
4. call the remote service