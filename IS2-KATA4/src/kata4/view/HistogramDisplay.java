package kata4.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import javax.swing.*;
import java.awt.*;
import kata4.model.Histogram;

public class HistogramDisplay extends ApplicationFrame {
    private final Histogram <String> histogram;
    
    public HistogramDisplay ( Histogram<String> histogram ) {
        super("Histograma");
        this.histogram = histogram;
        setContentPane( createPanel() );
        pack();
        execute();
    }

    
    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));

        return chartPanel;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for ( String key : histogram.keySet()) {
            dataSet.addValue(
                    histogram.get(key),
                    "",
                    key
            );
        }

        return dataSet;
    }


    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createBarChart(
                "Histograma JFreeChart",
                "Dominios email",
                "Nº de emails",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled
        );
    }

    private void execute () {
        setVisible(true);
    }
}
