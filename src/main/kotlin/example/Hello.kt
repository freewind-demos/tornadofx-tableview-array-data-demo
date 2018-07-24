package example

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections.observableArrayList
import javafx.scene.control.TableColumn
import tornadofx.*


private val data = observableArrayList(
        arrayOf("AAA", "111"),
        arrayOf("BBB", "222"),
        arrayOf("CCC", "333")
)

class HelloWorld : View() {
    override val root = tableview<Array<String>>(data) {
        column("name") { cellDataFeatures: TableColumn.CellDataFeatures<Array<String>, String> -> SimpleStringProperty(cellDataFeatures.value[0]) }
        column("value") { cellDataFeatures: TableColumn.CellDataFeatures<Array<String>, String> -> SimpleStringProperty(cellDataFeatures.value[1]) }
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