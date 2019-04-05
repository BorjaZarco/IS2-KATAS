package watch;

import java.awt.*;

public class WatchPresenter implements Watch.Observer {
    private final Watch watch;
    private final WatchDisplay watchDisplay;

    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watch.add(this);
        this.watchDisplay = watchDisplay;
    }

    @Override
    public void update() {
        refresh();
    }

    private void refresh () {
        watchDisplay.paint(pointsOf(watch));
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointOf(watch.getSeconds(), 150);
        points[1] = pointOf(watch.getMinutes(), 120);
        points[2] = pointOf(watch.getHours(), 90);
        return points;
    }

    private Point pointOf(double angle, int length) {
        return new Point(toInt(length*Math.cos(angle)), toInt(length * Math.sin(angle)));
    }

    private int toInt(double value) {
        return (int) value;
    }
}
