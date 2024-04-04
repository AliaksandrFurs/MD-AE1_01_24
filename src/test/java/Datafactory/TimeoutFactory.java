package Datafactory;

import com.epam.tat.module4.Timeout;

public class TimeoutFactory {

    private static Timeout timeout;

    private TimeoutFactory (){};

    public static Timeout getTimeout(){
        if(timeout == null){
            return new Timeout();
        }else return timeout;
    };
}
