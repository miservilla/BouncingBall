import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;


public class BouncingBall extends Application
{
    @Override
    public void start(Stage stage)
    {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 600, 600);
        scene.setFill(Color.CADETBLUE);

        Circle ball = new Circle(50, Color.BLUE);
        ball.relocate(0, 0);
        canvas.getChildren().add(ball);

        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10),
                new EventHandler<>()
                {
                    double dx = 7; //Sets step on x (or velocity).
                    double dy = 3; //Sets step on y.

                    @Override
                    public void handle(ActionEvent t)
                    {
                        //Moves the ball.
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        Bounds bounds = canvas.getBoundsInLocal();

                        if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                               ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()))
                        {
                            dx = -dx;
                        }

                        if (ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius()) ||
                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius())))
                        {
                            dy = -dy;
                        }

                    }
                }));


                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }


}
