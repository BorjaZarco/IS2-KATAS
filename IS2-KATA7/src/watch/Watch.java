package watch;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    private final List<Observer> observers = new ArrayList<>();
    private static final double SecondStep = Math.PI * 2 / 60;
    private static final double MinuteStep = SecondStep / 60;
    private static final double HourStep = MinuteStep / 12;

    private double seconds = Math.PI / 2;
    private double minutes = Math.PI / 2;
    private double hours = Math.PI / 2;


    public Watch() {
        Timer timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                updateObservers();
            }
        };
    }

    private void step() {
        seconds = normalize(seconds - SecondStep);
        minutes = normalize(minutes - MinuteStep);
        hours = normalize(hours - HourStep);
    }

    private double normalize(double angle) {
        return (angle - Math.PI * 2) % (Math.PI * 2);
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public interface Observer {
        public void update();
    }
    private void updateObservers() {
        for (Observer observer : observers )
            observer.update();
    }
}
