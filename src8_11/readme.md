#### 测试

```bash
1> ./javac --release 8 /home/lyle/IdeaProjects/l_a_m_b_d_a/src/com/lyle/java_8_11/Tester.java
   
2> ./javac --release 11 /home/lyle/IdeaProjects/l_a_m_b_d_a/src8_11/com/lyle/java_8_11/Tester.java
   
3> ./jar -c -f /home/lyle/lyle.jar -C /home/lyle/IdeaProjects/l_a_m_b_d_a/src . --release 11 -C /home/lyle/IdeaProjects/l_a_m_b_d_a/src8_11 .
   
4> ./java -cp /home/lyle/lyle.jar com.lyle.java_8_11.Tester

5>   java -cp /home/lyle/lyle.jar com.lyle.java_8_11.Tester
```