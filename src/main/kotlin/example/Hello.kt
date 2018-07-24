package example

import javafx.collections.FXCollections.observableArrayList
import tornadofx.*

private val data = observableArrayList(
        arrayOf("AAA", "111"),
        arrayOf("BBB", "222"),
        arrayOf("CCC", "333")
)

class HelloWorld : View() {
    override val root = tableview<Array<String>>(data) {
        column<Array<String>, String>("name") { it.value[0].toProperty() }
        column<Array<String>, String>("value") { it.value[1].toProperty() }

        // simpler than following:
        // column("name") { cellDataFeatures: TableColumn.CellDataFeatures<Array<String>, String> -> SimpleStringProperty(cellDataFeatures.value[0]) }
        // column("value") { cellDataFeatures: TableColumn.CellDataFeatures<Array<String>, String> -> SimpleStringProperty(cellDataFeatures.value[1]) }
    }
}

class HelloWorldStyle : Stylesheet() {
    init {
        root {
            prefWidth = 600.px
            prefHeight = 400.px
        }
    }
}

class HelloWorldApp : App(HelloWorld::class, HelloWorldStyle::class)

fun main(args: Array<String>) {
    launch<HelloWorldApp>()
}