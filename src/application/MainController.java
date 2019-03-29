package application;



import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.rabbitmq.client.Channel;

public class MainController implements Initializable {

	private static final String STYLE_SUCCESS = "-fx-text-fill: green;";
	private static final String STYLE_ERROR = "-fx-text-fill: red;";
	ArrayList<String> listForMainChoiceBox;
	List<String> listForODEODChoiceBox;
	Map<String, CommandClassNew> commandFormatMap;

	@FXML
	ChoiceBox<String> od_eod_choiceBox;
	@FXML
	ChoiceBox<String> mainchoiceBox;
	ChoiceBox<String> prop1_choiceBox;

	Label label2;
	Label label3;
	Label label4;

	TextField feild1;
	TextField feild2;
	TextField feild3;
	TextField feild4;
	DatePicker cobDatePicker;

	@FXML
	TextField serverAddressFeild;

	@FXML
	TextField userNameFeild;

	@FXML
	TextField vHostFeild;

	@FXML
	TextArea cArea;

	@FXML
	Button generateButton;
	@FXML
	Button sendButton;

	@FXML
	GridPane gridPane;

	@FXML
	PasswordField passwordFeild;

	@FXML
	TextArea errorArea;

	@FXML
	TextArea errorAreaGen;
	
	@FXML
	RadioButton radioB_cxl;
	
	@FXML
	RadioButton radioB_tpt;
	
	ToggleGroup radioGroup = new ToggleGroup();
	
		
	CommandClassNew cAtPresend;

	public CommandClassNew getcAtPresend() {
		return cAtPresend;
	}

	public void setcAtPresend(CommandClassNew cAtPresend) {
		this.cAtPresend = cAtPresend;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		init();
		radioB_cxl.setToggleGroup(radioGroup);
		radioB_tpt.setToggleGroup(radioGroup);
		
		mainchoiceBox.getItems().addAll(listForMainChoiceBox);
		mainchoiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String a = mainchoiceBox.getSelectionModel().getSelectedItem();
				mainChoiceBoxSelected(a);
			}
		});

		od_eod_choiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				makeCompleteLayout();

			}
		});

		serverAddressFeild.setText(Constants.DEFAULT_HOST);
		passwordFeild.setText(Constants.DEFAULT_PASSWORD);
		
		userNameFeild.setText(Constants.DEFAULT_USERNAME);
		RadioButton app = (RadioButton) radioGroup.getSelectedToggle();
		radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton r = (RadioButton) newValue;
				String systemName = r.getText();
				String vhost = "";
				if (systemName.equals("CXL")) {
				vhost = Constants.DEFAULT_CXL_vHOST;
				}else {
					vhost = Constants.DEFAULT_TPT_vHOST;
				}
				vHostFeild.setText(vhost);
			}
		});
		
	}

	private void makeCompleteLayout() {

		
		String x = mainchoiceBox.getValue();
		String y = od_eod_choiceBox.getValue();

		if (x != null && y != null) {
			List<Node> nodeList = new ArrayList<>();
			CommandClassNew c = commandFormatMap.get(x + y);
			gridPane.getChildren().clear();
			if (c != null) {
				setcAtPresend(c);
				if (c.getProp1DisplayNames() != null && !c.getProp1DisplayNames().isEmpty()) {

					prop1_choiceBox = new ChoiceBox<>();
					feild1 = new TextField();

					nodeList.add(prop1_choiceBox);
					nodeList.add(feild1);

					prop1_choiceBox.getItems().clear();
					prop1_choiceBox.getItems().addAll(c.getProp1DisplayNames());
					prop1_choiceBox.setValue(c.getProp1DisplayNames().get(0));
				} else {
					prop1_choiceBox = null;
				}

				if (c.isCobDate()) {
					label2 = new Label(Constants.COB_DATE_DISPLAY_NAME);
					// feild2 = new TextField();
					cobDatePicker = new DatePicker();
					nodeList.add(label2);
					// nodeList.add(feild2);
					nodeList.add(cobDatePicker);
				} else {
					cobDatePicker = null;
				}

				if (c.isMktSnapCd()) {
					label3 = new Label(Constants.MKT_S_CD_DISPLAY_NAME);
					feild3 = new TextField();
					nodeList.add(label3);
					nodeList.add(feild3);

				} else {
					feild3 = null;
				}
				if (c.isEventType()) {
					label4 = new Label(Constants.EVENT_TYPE_DISPLAY_NAME);
					feild4 = new TextField();
					nodeList.add(label4);
					nodeList.add(feild4);
				} else {
					feild4 = null;
				}

				int j = 0;
				for (int i = 0; i < nodeList.size() / 2; i++) {
					gridPane.add(nodeList.get(j), 0, i);
					gridPane.add(nodeList.get(j + 1), 1, i);
					j = j + 2;

				}
				generateButton.setOpacity(1);

			}

		}

	}

	public void mainChoiceBoxSelected(String selectedValue) {

		listForODEODChoiceBox = new ArrayList<>();
		listForODEODChoiceBox.add(Constants.ON_DEMAND);
		switch (selectedValue) {
		case Constants.POSITION:
		case Constants.CASHFLOW:
			listForODEODChoiceBox.add(Constants.ON_DEMAND_EOD);
			listForODEODChoiceBox.add(Constants.DYNAMIC_POLLING);
			listForODEODChoiceBox.add(Constants.EOD);
			break;

		default:
			break;
		}

		od_eod_choiceBox.getItems().clear();
		od_eod_choiceBox.getItems().addAll(listForODEODChoiceBox);
		od_eod_choiceBox.setValue(listForODEODChoiceBox.get(0));

	}

	public void generateButtonCallback() {

		try {
			String prop1 = null;
			String value1 = null;
			String cobDateString = null;
			String mktS = null;
			String eventType = null;

			if (prop1_choiceBox != null) {
				prop1 = prop1_choiceBox.getValue();
				value1 = feild1.getText();
			}

			if (cobDatePicker != null) {
				LocalDate cobDateInDateFormat = cobDatePicker.getValue();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				cobDateString = cobDateInDateFormat.format(formatter);
			}

			if (label3 != null) {
				mktS = feild3.getText().trim();
			}
			if (label4 != null) {
				eventType = feild4.getText().trim();

			}

			String type = getType(od_eod_choiceBox.getValue(), mainchoiceBox.getValue());
			String command = cAtPresend.generateCommandStructure(type, prop1, value1, cobDateString, mktS, eventType);

			//command = format(command, false);
			//command = formatXML(toXmlDocument(command));
			cArea.setText(command);
			//sendButton.setDisable(true);
		} catch (Exception e) {
			errorAreaGen.setStyle(STYLE_ERROR);
			errorAreaGen.setText(e.toString());
		}

	}

	public String qMaker(String system, String EODorOD) {
		
		//tpt_adaptor_eod_parameters_q
		String q = system + "_adaptor_" + EODorOD + "_parameters_q";
		return q.toLowerCase();
		
		
	}
	
	public void sendButtonCallback() {

		try {
			
			RadioButton app = (RadioButton) radioGroup.getSelectedToggle();
			String txt = app.getText();
			String mode = od_eod_choiceBox.getValue();
			//String QUEUE_NAME = qMaker(txt, mode);
			String QUEUE_NAME = "test_q";
			
			String host = !serverAddressFeild.getText().trim().equals("") ? serverAddressFeild.getText().trim(): Constants.DEFAULT_HOST;
			String username = !userNameFeild.getText().trim().equals("") ? userNameFeild.getText().trim() : Constants.DEFAULT_USERNAME;
			String password = !passwordFeild.getText().trim().equals("") ? passwordFeild.getText().trim() : Constants.DEFAULT_PASSWORD;
			String vhost;
			if (txt.equals("CXL")) {
				vhost = !vHostFeild.getText().trim().equals("") ? vHostFeild.getText().trim(): Constants.DEFAULT_CXL_vHOST;
			}else {
				vhost = !vHostFeild.getText().trim().equals("") ? vHostFeild.getText().trim(): Constants.DEFAULT_TPT_vHOST;
			}
			
			
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(host);
			factory.setUsername(username);
			factory.setPassword(password);
			factory.setVirtualHost(vhost);
			
			
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			String message = cArea.getText();
			if (message!=null && !message.equals(""))
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			else {
				errorArea.setVisible(true);
				errorArea.setStyle(STYLE_ERROR);
				errorArea.setText("Can not send empty msg");
			}
			errorArea.setVisible(true);
			errorArea.setStyle(STYLE_SUCCESS);
			errorArea.setText("Send Succesfully to: " + QUEUE_NAME);
			
			
//			Queue.DeclareOk response = channel.queueDeclarePassive("test");
//			// returns the number of messages in Ready state in the queue
//			response.getMessageCount();
//			// returns the number of consumers the queue has
//			//response.getConsumerCount();
//			System.out.println("Message count in test: "+ response.getMessageCount());
			
			
			
			
			
			
			channel.close();
			connection.close();
		} catch (Exception e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

	public void init() {

		errorArea.setVisible(false);
		errorArea.setEditable(false);
		errorArea.setCenterShape(true);

		errorAreaGen.setVisible(false);
		errorAreaGen.setEditable(false);
		errorAreaGen.setCenterShape(true);
		
		//sendButton.setDisable(true);

		listForMainChoiceBox = new ArrayList<>();
		listForMainChoiceBox.add(Constants.TRADE);
		listForMainChoiceBox.add(Constants.CASHFLOW);
		listForMainChoiceBox.add(Constants.POSITION);

		commandFormatMap = new HashMap<>();

		List<String> prop1DisplayNamesCashflow = new ArrayList<>();
		prop1DisplayNamesCashflow.add("trade_num");
		prop1DisplayNamesCashflow.add("cashflow_num");

		CommandClassNew cashflowOD = new CommandClassNew(Constants.CASHFLOW + Constants.ON_DEMAND, "",prop1DisplayNamesCashflow, false, false, false, 0);
		CommandClassNew cashflowODEOD = new CommandClassNew(Constants.CASHFLOW + Constants.ON_DEMAND_EOD, "",prop1DisplayNamesCashflow, true, false, false, 1);
		CommandClassNew cashflowDP = new CommandClassNew(Constants.CASHFLOW + Constants.DYNAMIC_POLLING, "",prop1DisplayNamesCashflow, false, false, true, 0);
		CommandClassNew cashflowEOD = new CommandClassNew(Constants.CASHFLOW + Constants.EOD, "", null, true, false,false, 0);

		commandFormatMap.put(cashflowOD.getKey(), cashflowOD);
		commandFormatMap.put(cashflowODEOD.getKey(), cashflowODEOD);
		commandFormatMap.put(cashflowDP.getKey(), cashflowDP);
		commandFormatMap.put(cashflowEOD.getKey(), cashflowEOD);

		CommandClassNew TradeEOD = new CommandClassNew(Constants.TRADE + Constants.ON_DEMAND, "",prop1DisplayNamesCashflow, true, true, true, 0);
		commandFormatMap.put(TradeEOD.getKey(), TradeEOD);
		
		List<String> prop1DisplayNamesPositionEOD = new ArrayList<>();
		CommandClassNew positionEOD = new CommandClassNew(Constants.POSITION + Constants.EOD, "", prop1DisplayNamesPositionEOD, true, false,false, 0);
		commandFormatMap.put(positionEOD.getKey(), positionEOD);
	
	}

	private String getType(String mode, String module) {
		String type = null;

		switch (mode) {
		case Constants.ON_DEMAND:
		case Constants.DYNAMIC_POLLING:
		case Constants.ON_DEMAND_EOD:
			type = "RealTime" + module + "Extraction";
			break;
		case Constants.EOD:
			type = "EOD" + module + "Extraction";
			break;
		default:
			break;
		}

		return type;
	}

	
//	private static String formatXML(Document document) throws TransformerException {
//	    TransformerFactory transformerFactory = TransformerFactory
//	            .newInstance();
//	    Transformer transformer = transformerFactory.newTransformer();
//	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//	    transformer.setOutputProperty(
//	            "{http://xml.apache.org/xslt}indent-amount", "2");
//	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//	    DOMSource source = new DOMSource(document);
//	    StringWriter strWriter = new StringWriter();
//	    StreamResult result = new StreamResult(strWriter);
//	 
//	    transformer.transform(source, result);
//	 
//	    return strWriter.getBuffer().toString();
//	 
//	}
	
//	private static Document toXmlDocument(String str) throws ParserConfigurationException, SAXException, IOException {
// 
//        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
//                .newInstance();
//        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//        Document document = docBuilder.parse(new InputSource(new StringReader(
//                str)));
// 
//        return document;
//    }
	
//	 public static String format(String xml, Boolean ommitXmlDeclaration) throws IOException, SAXException, ParserConfigurationException {
//         
//	        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//	        Document doc = db.parse(new InputSource(new StringReader(xml)));
//	          
//	        OutputFormat format = new OutputFormat(doc);
//	        format.setIndenting(true);
//	        format.setIndent(2);
//	        format.setOmitXMLDeclaration(ommitXmlDeclaration);
//	        format.setLineWidth(Integer.MAX_VALUE);
//	        Writer outxml = new StringWriter();
//	        XMLSerializer serializer = new XMLSerializer(outxml, format);
//	        serializer.serialize(doc);
//	          
//	        return outxml.toString();
//	          
//	        }
}
