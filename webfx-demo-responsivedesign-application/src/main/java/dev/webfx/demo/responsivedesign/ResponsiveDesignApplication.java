package dev.webfx.demo.responsivedesign;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Bruno Salmon
 */
public class ResponsiveDesignApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new SplitPane(createMostlyFluidPane(0), createMostlyFluidPane(100)), 850, 450));
        primaryStage.setTitle("Responsive Design");
        primaryStage.show();
    }

    private static Pane createMostlyFluidPane(double hueShift) {
        Region a1 = createArea(Color.rgb(0, 52, 118), hueShift);
        Region a2 = createArea(Color.rgb(0, 98, 210), hueShift);
        Region a3 = createArea(Color.rgb(180, 210, 247), hueShift);
        Region a4 = createArea(Color.rgb(213, 223, 239), hueShift);
        Region a5 = createArea(Color.rgb(223, 225, 229), hueShift);
        return new Pane(a1, a2, a3, a4, a5) {
            @Override
            protected void layoutChildren() {
                double width = getWidth(), x1, y1, w1, h1, x2, y2, w2, h2, x3, y3, w3, h3, x4, y4, w4, h4, x5, y5, w5, h5;
                if (width >= 800) {
                    x1 = (width - 800) / 2;  y1 = 0;         w1 = 0.6  * 800;    h1 = 150;
                    x2 = x1 + w1;            y2 = 0;         w2 = 0.4  * 800;    h2 = 150;
                    x3 = x1;                 y3 = y1 + h1;   w3 = 0.33 * 800;    h3 = 150;
                    x4 = x3 + w3;            y4 = y3;        w4 = 0.33 * 800;    h4 = 150;
                    x5 = x4 + w4;            y5 = y3;        w5 = 0.34 * 800;    h5 = 150;
                } else if (width > 600) {
                    x1 = 0;                  y1 = 0;         w1 = width;         h1 = 150;
                    x2 = 0;                  y2 = y1 + h1;   w2 = 0.5 * width;   h2 = 150;
                    x3 = width / 2;          y3 = y2;        w3 = 0.5 * width;   h3 = 150;
                    x4 = 0;                  y4 = y3 + h3;   w4 = 0.5 * width;   h4 = 150;
                    x5 = width / 2;          y5 = y4;        w5 = 0.5 * width;   h5 = 150;
                } else {
                    x1 = 0;                  y1 = 0;         w1 = width;         h1 = 150;
                    x2 = 0;                  y2 = y1 + h1;   w2 = width;         h2 = 150;
                    x3 = 0;                  y3 = y2 + h2;   w3 = width;         h3 = 150;
                    x4 = 0;                  y4 = y3 + h3;   w4 = width;         h4 = 150;
                    x5 = 0;                  y5 = y4 + h4;   w5 = width;         h5 = 150;
                }
                layoutInArea(a1, x1, y1, w1, h1, 0, HPos.LEFT, VPos.TOP);
                layoutInArea(a2, x2, y2, w2, h2, 0, HPos.LEFT, VPos.TOP);
                layoutInArea(a3, x3, y3, w3, h3, 0, HPos.LEFT, VPos.TOP);
                layoutInArea(a4, x4, y4, w4, h4, 0, HPos.LEFT, VPos.TOP);
                layoutInArea(a5, x5, y5, w5, h5, 0, HPos.LEFT, VPos.TOP);
            }

            @Override
            protected double computePrefHeight(double width) {
                if (width == -1)
                    width = getWidth();
                return width >= 800 ? 300 : width > 600 ? 450 : 750;
            }
        };
    }

    private static Region createArea(Color color, double hueShift) {
        Region area = new Region();
        area.setBackground(new Background(new BackgroundFill(color.deriveColor(hueShift, 1, 1, 1), null, null)));
        return area;
    }
}
