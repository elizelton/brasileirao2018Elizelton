package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import javafx.scene.layout.AnchorPane;
import model.Aluno;
import model.Matricula;
import utility.XPopOver;

/**
 * FXML Controller class
 *
 * @author elizelton.santos
 */
public class BoletimController implements Initializable {

    private AlunoController controllerPai;
    public Matricula matricula;
//    private List<Matricula> matriculas = new ArrayList<>();

    public Aluno aluno;

    @FXML
    public TableView<Matricula> tblViewBoletim;

    @FXML
    private Label lblNomeAluno;
    @FXML
    private Button btnConfirma;
    @FXML
    private AnchorPane anchorPane;

    public void setCadastroController(AlunoController controllerPai) {
        this.controllerPai = controllerPai;
        aluno = controllerPai.aluno;
        lblNomeAluno.setText(controllerPai.aluno.getNome());
        tblViewBoletim.setItems(FXCollections.observableArrayList(controllerPai.aluno.getMatriculas()));
    }

    @FXML
    private void showDisciplinasAluno() {
        String cena = "/fxml/CRUDBoletim.fxml";
        XPopOver popOver = new XPopOver(cena, String.format("Editar Disciplina - Boletim Acadêmico: %s", aluno.getNome()), null);
        CRUDBoletimController controllerFilho = popOver.getLoader().getController();
        controllerFilho.setCadastroController(this);
    }

    @FXML
    private void btnFecharClick() {
        anchorPane.getScene().getWindow().hide();
    }

    @FXML
    public void tblVwDisciplinaClick(Event event) {
        MouseEvent me = null;
        if (event.getEventType() == MOUSE_CLICKED && tblViewBoletim.getSelectionModel().getSelectedItem() != null) {
            me = (MouseEvent) event;
            if (me.getClickCount() == 2) {
                matricula = tblViewBoletim.getSelectionModel().getSelectedItem();
                showDisciplinasAluno();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblViewBoletim.setRowFactory(tableView
                -> {
            TableRow<Matricula> row = new TableRow<>();

            row.itemProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        if (newValue != null
                        && newValue.getStatus().contains("Reprovado")) {
                            row.getStyleClass().add("alunoReprovado");
                        } else {
                            row.getStyleClass().remove("alunoReprovado");
                        }
                    });
            return row;
        });
    }

}
