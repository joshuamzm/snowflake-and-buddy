# snowflake-and-buddy

Minimal project setup to demonstrate class resolution error between Snowflake JDBC and Buddy libraries.

# Compile project

Execute the following command:

```
clojure -X:uberjar
```

# Run project

```
java -jar target/acme.jar
```

# Reported error

```
> java -jar .\target\acme.jar
Exception in thread "main" java.lang.NoClassDefFoundError: net/snowflake/client/jdbc/internal/org/bouncycastle/crypto/CipherParameters (wrong name: org/bouncycastle/crypto/CipherParameters)
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1012)
        at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:150)
        at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:862)
        at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:760)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:681)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:639)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520)
        at java.base/java.lang.Class.forName0(Native Method)
        at java.base/java.lang.Class.forName(Class.java:467)
        at clojure.lang.RT.classForName(RT.java:2212)
        at clojure.lang.RT.classForName(RT.java:2221)
        at buddy.core.mac__init.__init0(Unknown Source)
        at buddy.core.mac__init.<clinit>(Unknown Source)
        at java.base/java.lang.Class.forName0(Native Method)
        at java.base/java.lang.Class.forName(Class.java:467)
        at clojure.lang.RT.classForName(RT.java:2212)
        at clojure.lang.RT.classForName(RT.java:2221)
        at clojure.lang.RT.loadClassForName(RT.java:2240)
        at clojure.lang.RT.load(RT.java:449)
        at clojure.lang.RT.load(RT.java:424)
        at clojure.core$load$fn__6856.invoke(core.clj:6115)
        at clojure.core$load.invokeStatic(core.clj:6114)
        at clojure.core$load.doInvoke(core.clj:6098)
        at clojure.lang.RestFn.invoke(RestFn.java:408)
        at clojure.core$load_one.invokeStatic(core.clj:5897)
        at clojure.core$load_one.invoke(core.clj:5892)
        at clojure.core$load_lib$fn__6796.invoke(core.clj:5937)
        at clojure.core$load_lib.invokeStatic(core.clj:5936)
        at clojure.core$load_lib.doInvoke(core.clj:5917)
        at clojure.lang.RestFn.applyTo(RestFn.java:142)
        at clojure.core$apply.invokeStatic(core.clj:669)
        at clojure.core$load_libs.invokeStatic(core.clj:5974)
        at clojure.core$load_libs.doInvoke(core.clj:5958)
        at clojure.lang.RestFn.applyTo(RestFn.java:137)
        at clojure.core$apply.invokeStatic(core.clj:669)
        at clojure.core$require.invokeStatic(core.clj:5996)
        at clojure.core$require.doInvoke(core.clj:5996)
        at clojure.lang.RestFn.invoke(RestFn.java:408)
        at org.acme.main$loading__6737__auto____138.invoke(main.clj:1)
        at org.acme.main__init.load(Unknown Source)
        at org.acme.main__init.<clinit>(Unknown Source)
        at java.base/java.lang.Class.forName0(Native Method)
        at java.base/java.lang.Class.forName(Class.java:467)
        at clojure.lang.RT.classForName(RT.java:2212)
        at clojure.lang.RT.classForName(RT.java:2221)
        at clojure.lang.RT.loadClassForName(RT.java:2240)
        at clojure.lang.RT.load(RT.java:449)
        at clojure.lang.RT.load(RT.java:424)
        at clojure.core$load$fn__6856.invoke(core.clj:6115)
        at clojure.core$load.invokeStatic(core.clj:6114)
        at clojure.core$load.doInvoke(core.clj:6098)
        at clojure.lang.RestFn.invoke(RestFn.java:408)
        at clojure.lang.Var.invoke(Var.java:384)
        at clojure.lang.Util.loadWithClass(Util.java:251)
        at org.acme.main.<clinit>(Unknown Source)
```