package Spring.lesson4.Task2.Aspects;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import static java.lang.System.out;
public class MyLogger {
    private ApplicationContext applicationContext;

    public void afterRun(JoinPoint joinPoint, Object result){
        out.println(joinPoint.getSignature().getName() + "method of " + joinPoint.getTarget().toString() + " was invoked");
        out.println("Result of method execution : " + result);
        out.println("***********************************");
        out.println("* Log : success method invocation *");
        out.println("***********************************");
    }

    public void afterThrowing(Exception ex){
        out.println("***********************************");
        out.println("*********** Log : error ***********");
        out.println("Exception : " + ex.getMessage());
        out.println("***********************************");
    }
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
