package solution;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;

public class DragSquares extends Application{

    private boolean isBlueSelected = false;
    private boolean isRedSelected = false;
    private boolean dragging = false;
    private double redOriginX = 240;
    private double redOriginY = 285;
    private double blueOriginX = 330;
    private double blueOriginY = 285;
    Canvas canvas = new Canvas(600, 600);
    GraphicsContext gContext = canvas.getGraphicsContext2D();


    public void start(Stage stage)throws Exception{
        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        drawCanvas();

        stage.show();

        canvas.setOnMousePressed(evt -> {
            selectBox(evt);
            drawCanvas();
        });
        canvas.setOnMouseReleased(this::unselectBox);
        canvas.setOnMouseDragged(evt->{
            dragBox(evt);
            drawCanvas();
        });
        scene.setOnKeyPressed(this::redrawCanvas);


    }

    public void drawCanvas (){

        gContext.setFill(Color.BISQUE);
        gContext.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        gContext.setFill(Color.MAROON);
        gContext.fillRect(redOriginX, redOriginY, 30, 30);

        gContext.setFill(Color.CADETBLUE);
        gContext.fillRect(blueOriginX,blueOriginY,30, 30);
    }

    public void selectBox(MouseEvent evt){
        if(dragging){
            return;
        }
        double evtX = evt.getX();
        double evtY = evt.getY();

        if(evtX>blueOriginX && evtX<(blueOriginX+30) && evtY>blueOriginY && evtY<(blueOriginY+30)){
            isBlueSelected = true;
        }else if(evtX>redOriginX && evtX<(redOriginX+30) && evtY>redOriginY && evtY<(redOriginY+30)){
            isRedSelected = true;
        }
        else{
            isRedSelected = false;
            isBlueSelected = false;
        }
    }

    public void unselectBox (MouseEvent evt){
        isBlueSelected = false;
        isRedSelected = false;
        dragging = false;
    }

    public void dragBox(MouseEvent evt){
        dragging = true;
        if(isRedSelected){
            redOriginX = evt.getX();
            redOriginY = evt.getY();
        }else if (isBlueSelected){
            blueOriginY = evt.getY();
            blueOriginX = evt.getX();
        }else{
            return;
        }
    }

    public void redrawCanvas(KeyEvent evt){
        KeyCode key = evt.getCode();
        if(key == KeyCode.ESCAPE){
            isBlueSelected = false;
            isRedSelected = false;
            dragging = false;
            redOriginX = 240;
            redOriginY = 285;
            blueOriginX = 330;
            blueOriginY = 285;
            drawCanvas();
        }else{
            return;
        }
    }

    public static void main (String[] Args){
        launch(Args);
    }
}
