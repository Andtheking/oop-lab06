# Use lists, maps, and measure their performance

1. Observe, compile, and execute `TestPerformance`. It estimates the time required to run an operation in Java.
```bash
 ~/oop-lab06/62-use-lists-and-maps  exercises +2 ?1  java -cp build/classes/java/main/ it.unibo.collections.TestPerformance                                                  1 ✘  root@lab22-07-07  11:26:43 
Error: Could not find or load main class it.unibo.collections.TestPerformance
Caused by: java.lang.ClassNotFoundException: it.unibo.collections.TestPerformance
 ~/oop-lab06/62-use-lists-and-maps  exercises +2 ?1  chmod +x gradlew                                                                                                        1 ✘  root@lab22-07-07  11:27:03 
 ~/oop-lab06/62-use-lists-and-maps  exercises +2 !1 ?1  ./gradlew build                                                                                                        ✔  root@lab22-07-07  11:27:12 
Starting a Gradle Daemon, 2 incompatible and 2 stopped Daemons could not be reused, use --status for details

BUILD SUCCESSFUL in 4s
2 actionable tasks: 2 executed
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.1.0/userguide/configuration_cache_enabling.html
 ~/oop-lab06/62-use-lists-and-maps  exercises +2 !1 ?2  java -cp build/classes/java/main/ it.unibo.collections.TestPerformance                                            ✔  5s  root@lab22-07-07  11:27:26 
Converting 1000000 ints to String and inserting them in a Set took 216280052ns (216ms)

```

2. Follow the instructions in `UseListsAndMaps`.
