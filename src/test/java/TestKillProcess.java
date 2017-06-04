import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class TestKillProcess{

  @Test
  public void test1(){
    List<Integer> pid = new ArrayList<Integer>();
    pid.add(1);
    pid.add(9);
    pid.add(3);
    pid.add(10);
    pid.add(5);
    pid.add(4);
    List<Integer> ppid = new ArrayList<Integer>();
    ppid.add(4);
    ppid.add(4);
    ppid.add(0);
    ppid.add(5);
    ppid.add(3);
    ppid.add(5);
    KillProcess kp = new KillProcess();
    System.out.println(kp.killProcess(pid, ppid, 5));
  }

  @Test
  public void test2(){
    List<Integer> pid = new ArrayList<Integer>();
    pid.add(1);
    pid.add(9);
    pid.add(3);
    pid.add(10);
    pid.add(5);
    pid.add(4);
    List<Integer> ppid = new ArrayList<Integer>();
    ppid.add(4);
    ppid.add(4);
    ppid.add(0);
    ppid.add(5);
    ppid.add(3);
    ppid.add(5);
    KillProcess kp = new KillProcess();
    System.out.println(kp.killProcess(pid, ppid, 0));
  }

  @Test
  public void test3(){
    List<Integer> pid = new ArrayList<Integer>();
    List<Integer> ppid = new ArrayList<Integer>();
    ppid.add(0);
    KillProcess kp = new KillProcess();
    System.out.println(kp.killProcess(pid, ppid, 0));
  }

}
